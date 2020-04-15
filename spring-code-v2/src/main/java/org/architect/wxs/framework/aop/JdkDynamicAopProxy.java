package org.architect.wxs.framework.aop;

import org.architect.wxs.framework.aop.intercept.MethodInvocation;
import org.architect.wxs.framework.aop.support.AdvisedSupport;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;

/**
 * {@link}
 *
 * @author wangxiaoshuai on 2020/4/15
 * @javadoc ：
 */
public class JdkDynamicAopProxy implements AopProxy, InvocationHandler {
    private AdvisedSupport advisedSupport;

    public JdkDynamicAopProxy(AdvisedSupport advisedSupport) {
        this.advisedSupport = advisedSupport;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //根据方法得到该方法应该得到增强的object
        //org.architect.wxs.framework.aop.aspect.AfterReturningAdviceInterceptor
        //org.architect.wxs.framework.aop.aspect.AfterThrowingAdviceInterceptor
        //org.architect.wxs.framework.aop.aspect.MethodBeforeAdviceInterceptor
        List<Object> interceptorsAndDynamicInterceptionAdvice = advisedSupport.getInterceptorsAndDynamicInterceptionAdvice(method, advisedSupport.getTargetClass());
        //method需要增强的方法
        //方法所在的类advisedSupport.getTarget()
        //args 传入的参数
        //interceptorsAndDynamicInterceptionAdvice 增强的object
        MethodInvocation methodInvocation = new MethodInvocation(method,advisedSupport.getTarget(),args,interceptorsAndDynamicInterceptionAdvice);
        //此处进入链式调用，采用责任链模式，一直往里进，进去后再出来
        /**
         *   before->after->afterthrowing->
         *                                   真正执行业务代码
         *   before <-  after <-afterthrowing
         */
        Object proceed = methodInvocation.proceed();
        System.err.println(proceed);
        return proceed;
    }

    @Override
    public Object getProxy() {
        return getProxy(this.getClass().getClassLoader());
    }

    @Override
    public Object getProxy(ClassLoader classLoader) {
        return Proxy.newProxyInstance(classLoader,advisedSupport.getTargetClass().getInterfaces(),this);
    }
}
