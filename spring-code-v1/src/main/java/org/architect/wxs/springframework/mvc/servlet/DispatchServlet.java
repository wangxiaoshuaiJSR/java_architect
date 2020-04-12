package org.architect.wxs.springframework.mvc.servlet;

import org.architect.wxs.springframework.mvc.annotation.*;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * {@link}
 *
 * @author wangxiaoshuai on 2020/3/30
 * @javadoc ：
 */
public class DispatchServlet extends HttpServlet {
    //保存application.properties配置文件中的内容
    private Properties contextConfig = new Properties();
    //IOC容器
    Map<String,Object> ioc = new HashMap<String, Object>();

    List<String> classNames = new ArrayList<String>();

    private List<HandlerMapping> handlerMapping = new ArrayList<HandlerMapping>();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            doDispatch(req,resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void doDispatch(HttpServletRequest req, HttpServletResponse resp) throws Exception {

        HandlerMapping handler = getHandler(req);
        if(handler == null){
            resp.getWriter().write("404 not found!!!!");
            return;
        }
        Class<?>[] classTypes = handler.getClassTypes();

        Object[] paramValues = new Object[classTypes.length];

        Map<String,String[]> map = req.getParameterMap();
        for (String key : map.keySet()) {
            String value = Arrays.toString(map.get(key)).
                    replaceAll("\\[|\\]","").replaceAll("\\s",",");
            if(!handler.getParamIndexMap().containsKey(key)){continue;}
            int index = handler.getParamIndexMap().get(key);
            paramValues[index]=convert(classTypes[index],value);
        }

        if(handler.getParamIndexMap().containsKey(HttpServletRequest.class.getName())){
            Integer integer = handler.getParamIndexMap().get(HttpServletRequest.class.getName());
            paramValues[integer]=req;
        }
        if(handler.getParamIndexMap().containsKey(HttpServletResponse.class.getName())){
            Integer integer = handler.getParamIndexMap().get(HttpServletResponse.class.getName());
            paramValues[integer]=resp;
        }

        //前面做的所有的工作都在为这个反射服务，通过反射得到结果
        Object invoke = handler.getMethod().invoke(handler.getController(), paramValues);
        if(invoke==null||invoke instanceof Void){
            return;
        }
        resp.getWriter().write(invoke.toString());
    }
    @Override
    public void init(ServletConfig config) throws ServletException {
        //1.加载配置文件
        doLoadConfig(config.getInitParameter("contextConfigLocation"));

        //2.扫描相关的类
        doScanner(contextConfig.getProperty("scanPackage"));

        //3.初始化扫描得到的类，并且将他们放入到IOC容器中
        doInstance();

        //4.完成依赖注入
        doAutowired();

        //5.初始化HandlerMapping();
        initHandlerMapping();

        System.out.println("Spring framework is inited");
    }

    private void initHandlerMapping() {
        if(ioc.isEmpty()){return;}
        for (String key : ioc.keySet()) {
            Class<?> clazz = ioc.get(key).getClass();
            if(!clazz.isAnnotationPresent(Controller.class)){continue;}
            String baseUri="";
            if(clazz.isAnnotationPresent(RequestMapping.class)){
                baseUri = clazz.getAnnotation(RequestMapping.class).value();
            }
            //注意此处 clazz.getMethods 包含了Object的基本方法，所有clazz.getMethods 最后的size是10
            for (Method method : clazz.getMethods()) {
                String uri="";
                if(method.isAnnotationPresent(RequestMapping.class)){
                    uri = method.getAnnotation(RequestMapping.class).value();
                }
                String regex = ("/" + baseUri +"/" + uri).replaceAll("/+","/");
                Pattern pattern = Pattern.compile(regex);
                handlerMapping.add(new HandlerMapping(pattern,ioc.get(key),method));
                System.out.println(regex+method);
            }
        }
    }

    //url传过来的参数都是String类型的，HTTP是基于字符串协议
    //只需要把String转换为任意类型就好
    private Object convert(Class<?> type,String value){
        //如果是int
        if(Integer.class == type){
            return Integer.valueOf(value);
        }
        else if(Double.class == type){
            return Double.valueOf(value);
        }
        //如果还有double或者其他类型，继续加if
        //这时候，我们应该想到策略模式了
        return value;
    }

    private HandlerMapping getHandler(HttpServletRequest req) {
        if(handlerMapping.isEmpty()){return null;}
        String uri = req.getRequestURI();
        //处理成相对路径
        String contextPath = req.getContextPath();
        uri = uri.replaceAll(contextPath,"").replaceAll("/+","/");

        for (HandlerMapping handler : this.handlerMapping) {
            Matcher matcher = handler.getPattern().matcher(uri);
            if(!matcher.matches()){ continue;}
            return handler;
        }
        return null;
    }

    /**
     * 完成依赖注入
     */
    private void doAutowired() {
       if( ioc.isEmpty()){return;}
        for (String beanName : ioc.keySet()) {
            Field[] fields = ioc.get(beanName).getClass().getDeclaredFields();
            for (Field field : fields) {
                if(!field.isAnnotationPresent(Autowired.class)){continue;}
                Autowired annotation = field.getAnnotation(Autowired.class);
                String value = annotation.value().trim();
                if("".equals(value)){
                    value=toLowerFirstCase(field.getType().getName());
                }
                field.setAccessible(true);
                try {
                    //用反射机制给字段赋值
                    field.set(ioc.get(beanName),ioc.get(value));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     *实例化
     */
    private void doInstance() {
        if(classNames.isEmpty()){return;}
        try {
            for (String className : classNames) {
                 Class<?> clazz = Class.forName(className);
                 if(clazz.isAnnotationPresent(Controller.class)){
                    Object instance = clazz.newInstance();
                     String beanName = toLowerFirstCase(clazz.getSimpleName());
                     ioc.put(beanName,instance);
                 }else if(clazz.isAnnotationPresent(Service.class)){
                     Service annotation = clazz.getAnnotation(Service.class);
                     String beanName = annotation.value();
                     //2、默认类名首字母小写
                     if("".equals(beanName.trim())){
                         beanName = toLowerFirstCase(clazz.getSimpleName());
                     }
                     Object instance = clazz.newInstance();
                     ioc.put(beanName,instance);
                     //3、根据类型自动赋值,投机取巧的方式
                     for (Class<?> i : clazz.getInterfaces()) {
                         if(ioc.containsKey(i.getName())){
                             throw new Exception("The “" + i.getName() + "” is exists!!");
                         }
                         //把接口的类型直接当成key了
                         ioc.put(i.getName(),instance);
                     }
                 }else{
                     continue;
                 }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 首字母转换小写
     * @param className
     * @return
     */
    private String toLowerFirstCase(String className){
        char[] charArray = className.toCharArray();
        charArray[0]+=32;
        return String.valueOf(charArray);
    }

    /**
     * 扫描指定路径下的className放到list中去
     * @param scanPackage
     */
    private void doScanner(String scanPackage) {
        URL url = this.getClass().getClassLoader().getResource(scanPackage.replaceAll("\\.", "/"));
        File file = new File(url.getFile());
        for (File listFile : file.listFiles()) {
            if(listFile.isDirectory()){
                doScanner(scanPackage+"."+listFile.getName());
            }else{
                if(!listFile.getName().endsWith(".class")){
                    continue;
                }
                String className = scanPackage+"."+listFile.getName().replace(".class","");
                classNames.add(className);
            }
        }
    }

    //加载配置文件
    private void doLoadConfig(String initParameter) {
        //直接从类路径下找到spring主配置文件所在的路径
        //并且将其读取出来放到Properties对象中 scanPackage=org.architect.wxs
        InputStream stream = this.getClass().getClassLoader().getResourceAsStream(initParameter);
        try {
            contextConfig.load(stream);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(stream!=null){
                try {
                    stream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
