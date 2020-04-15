package org.architect.wxs.framework.aop.aspect;

import org.architect.wxs.framework.aop.intercept.MethodInterceptor;
import org.architect.wxs.framework.aop.intercept.MethodInvocation;

import java.lang.reflect.Method;

/**
 * {@link}
 *
 * @author wangxiaoshuai on 2020/4/15
 * @javadoc ：
 */
public class AfterReturningAdviceInterceptor extends AbstractAspectAdvice implements MethodInterceptor {
    private JoinPoint joinPoint;
    public AfterReturningAdviceInterceptor(Method method, Object instance) {
        super(method,instance);
    }

    public void after(JoinPoint joinPoint,Object returnValue) throws Throwable {
        super.invokeAdviceMethod(joinPoint,returnValue,null);
    }

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        Object proceed = methodInvocation.proceed();
        joinPoint = methodInvocation;
        after(joinPoint,proceed);
        System.out.println("afterafterafterafterafafterafterterafterafter");
        return proceed;
    }
}
