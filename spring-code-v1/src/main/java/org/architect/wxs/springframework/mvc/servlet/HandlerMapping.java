package org.architect.wxs.springframework.mvc.servlet;

import org.architect.wxs.springframework.mvc.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * {@link}
 *
 * @author wangxiaoshuai on 2020/3/31
 * @javadoc ：
 */
public class HandlerMapping {
    private Pattern pattern;
    private Object controller;
    private Method method;
    private Class<?>[] classTypes;
    private Map<String,Integer> paramIndexMap;

    public HandlerMapping(Pattern pattern, Object controller, Method method) {
        this.pattern = pattern;
        this.controller = controller;
        this.method = method;
        this.classTypes = method.getParameterTypes();
        this.paramIndexMap = new HashMap<String, Integer>();
        this.putParamIndexMapping(method);
    }

    /**
     * 一个参数可以打多个注解，一个方法可以又多个参数
     * @param method
     */
    private void putParamIndexMapping(Method method){
        Annotation[][] params = method.getParameterAnnotations();
        for (int i = 0; i < params.length ; i ++) {
            for (Annotation annotation : params[i]) {
                if(annotation instanceof RequestParam){
                    String value = ((RequestParam) annotation).value();
                    if(!value.trim().equals("")){
                        paramIndexMap.put(value,i);
                    }
                }
            }
        }
        //提取方法中的request和response参数
        Class<?> [] paramsTypes = method.getParameterTypes();
        for (int i = 0; i < paramsTypes.length ; i ++) {
            Class<?> type = paramsTypes[i];
            if(type == HttpServletRequest.class ||
                    type == HttpServletResponse.class){
                paramIndexMap.put(type.getName(),i);
            }
        }

    }


    public Pattern getPattern() {
        return pattern;
    }

    public void setPattern(Pattern pattern) {
        this.pattern = pattern;
    }

    public Object getController() {
        return controller;
    }

    public void setController(Object controller) {
        this.controller = controller;
    }

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }

    public Class<?>[] getClassTypes() {
        return classTypes;
    }

    public void setClassTypes(Class<?>[] classTypes) {
        this.classTypes = classTypes;
    }

    public Map<String, Integer> getParamIndexMap() {
        return paramIndexMap;
    }

    public void setParamIndexMap(Map<String, Integer> paramIndexMap) {
        this.paramIndexMap = paramIndexMap;
    }

    @Override
    public String toString() {
        return "HandlerMapping{" +
                "pattern=" + pattern +
                ", controller=" + controller +
                ", method=" + method +
                ", classTypes=" + Arrays.toString(classTypes) +
                ", paramIndexMap=" + paramIndexMap +
                '}';
    }
}
