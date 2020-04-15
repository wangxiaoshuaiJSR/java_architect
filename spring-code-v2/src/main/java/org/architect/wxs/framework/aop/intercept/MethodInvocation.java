package org.architect.wxs.framework.aop.intercept;

import org.architect.wxs.framework.aop.aspect.JoinPoint;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * {@link}
 *
 * @author wangxiaoshuai on 2020/4/15
 * @javadoc ：
 */
public class MethodInvocation implements JoinPoint {
    private Method method;
    private Object target;
    private Object[] arguments;
    private List<Object> interceptorAndDynamicMethodMatchers;
    private Map<String,Object> userAttributes;
    //定义一个索引，从-1开始来记录当前拦截器执行的位置
    private int currentInterceptorIndex = -1;

    public MethodInvocation(Method method, Object target, Object[] arguments, List<Object> interceptorAndDynamicMethodMatchers) {
        this.method = method;
        this.target = target;
        this.arguments = arguments;
        this.interceptorAndDynamicMethodMatchers = interceptorAndDynamicMethodMatchers;
    }

    public Object proceed()throws Throwable{
        if(this.currentInterceptorIndex==this.interceptorAndDynamicMethodMatchers.size()-1){
            //实际业务方法，往里最终调用
            return method.invoke(target,arguments);
        }
        Object interceptor = this.interceptorAndDynamicMethodMatchers.get(++currentInterceptorIndex);
        if(interceptor instanceof MethodInterceptor){
            MethodInterceptor methodInterceptor = (MethodInterceptor) interceptor;
            return methodInterceptor.invoke(this);
        }else {
            return proceed();
        }
    }

    @Override
    public Object getThis() {
        return this.target;
    }

    @Override
    public Object[] getArguments() {
        return this.arguments;
    }

    @Override
    public Method getMethod() {
        return this.method;
    }

    @Override
    public void setUserAttribute(String key, Object value) {
        if(value!=null){
            if(userAttributes==null){
                userAttributes = new HashMap<>();
            }
            userAttributes.put(key,value);
        }else{
            if(userAttributes!=null){
                userAttributes.remove(key);
            }
        }
    }

    @Override
    public Object getUserAttribute(String key) {
        return userAttributes!=null?userAttributes.get(key):null;
    }
}
