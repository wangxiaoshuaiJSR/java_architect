package org.architect.wxs.framework.aop.support;

import org.architect.wxs.framework.aop.aspect.AfterReturningAdviceInterceptor;
import org.architect.wxs.framework.aop.aspect.AfterThrowingAdviceInterceptor;
import org.architect.wxs.framework.aop.aspect.MethodBeforeAdviceInterceptor;
import org.architect.wxs.framework.aop.config.AopConfig;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * {@link}
 *
 * @author wangxiaoshuai on 2020/4/15
 * @javadoc ：
 */
public class AdvisedSupport {
    private AopConfig aopConfig;

    private Class<?> targetClass;

    private Object target;

    private Pattern pointCutClassPattern;

    private String pointCut;

    private transient Map<Method, List<Object>> methodCache;
    /**
     * 加载AOP配置
     */
    public void parse() {
        String aspectClassName = aopConfig.getAspectClass();
        Pattern pattern = Pattern.compile(pointCut);
        try {
            Class<?> clazz = Class.forName(aspectClassName);
            Map<String,Method> aspectMethodMap = new HashMap<>();
            methodCache = new HashMap<>();
            //aspectClass 切的类的方法
            for (Method method : clazz.getMethods()) {
                aspectMethodMap.put(method.getName(),method);
            }
            for (Method method : targetClass.getMethods()) {
                String methodName = method.toString();
                if(methodName.contains("throws")){
                    methodName = methodName.substring(0,methodName.lastIndexOf("throws")).trim();
                }
                Matcher matcher = pattern.matcher(methodName);
                //方法匹配到了，则加载AOP配置
                if(matcher.matches()){
                    List<Object> advices = new ArrayList<>();
                    if(aopConfig.getAspectBefore()!=null&&!aopConfig.getAspectBefore().equals("")){
                        advices.add(new MethodBeforeAdviceInterceptor(aspectMethodMap.get(aopConfig.getAspectBefore()),clazz.newInstance()));
                    }
                    if(aopConfig.getAspectAfter()!=null&&!aopConfig.getAspectAfter().equals("")){
                        advices.add(new AfterReturningAdviceInterceptor(aspectMethodMap.get(aopConfig.getAspectAfter()),clazz.newInstance()));
                    }
                    if(aopConfig.getAspectAfterThrow()!=null&&!aopConfig.getAspectAfterThrow().equals("")){
                        AfterThrowingAdviceInterceptor afterThrowingAdviceInterceptor = new AfterThrowingAdviceInterceptor(aspectMethodMap.get(aopConfig.getAspectAfterThrow()), clazz.newInstance());
                        afterThrowingAdviceInterceptor.setThrowingName(aopConfig.getAspectAfterThrowingName());
                        advices.add(afterThrowingAdviceInterceptor);
                    }
                    methodCache.put(method,advices);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public AdvisedSupport(AopConfig aopConfig) {
        this.aopConfig = aopConfig;
        pointCut = aopConfig.getPointCut()
                .replaceAll("\\.","\\\\.")
                .replaceAll("\\\\.\\*",".*")
                .replaceAll("\\(","\\\\(")
                .replaceAll("\\)","\\\\)");
        //正则找到需要匹配的类
        String pointCutForClassRegex = pointCut.substring(0,pointCut.lastIndexOf("\\(")-4);
        pointCutClassPattern = Pattern.compile("class "+pointCutForClassRegex.
                substring(pointCutForClassRegex.lastIndexOf(" ")+1));
    }


    public List<Object> getInterceptorsAndDynamicInterceptionAdvice(Method method,Class<?> clazz) throws NoSuchMethodException {
       //传进来的Method是接口的方法，所以下面的objects为空
        List<Object> objects = methodCache.get(method);
        if(objects==null){
            //clazzMethod是真正类里的方法，所以可以拿到增强的类的OBJECT
            Method clazzMethod = clazz.getMethod(method.getName(), method.getParameterTypes());
            objects = methodCache.get(clazzMethod);

            //对代理方法进行一个兼容处理
            this.methodCache.put(clazzMethod,objects);
        }
        return objects;
    }



    public boolean pointCutMatch(){
        return pointCutClassPattern.matcher(this.targetClass.toString()).matches();
    }
    public AopConfig getAopConfig() {
        return aopConfig;
    }

    public void setAopConfig(AopConfig aopConfig) {
        this.aopConfig = aopConfig;
    }

    public Class<?> getTargetClass() {
        return targetClass;
    }

    public void setTargetClass(Class<?> targetClass) {
        this.targetClass = targetClass;
    }

    public Object getTarget() {
        return target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }

    public Pattern getPointCutClassPattern() {
        return pointCutClassPattern;
    }

    public void setPointCutClassPattern(Pattern pointCutClassPattern) {
        this.pointCutClassPattern = pointCutClassPattern;
    }

    public String getPointCut() {
        return pointCut;
    }

    public void setPointCut(String pointCut) {
        this.pointCut = pointCut;
    }

    public Map<Method, List<Object>> getMethodCache() {
        return methodCache;
    }

    public void setMethodCache(Map<Method, List<Object>> methodCache) {
        this.methodCache = methodCache;
    }

}
