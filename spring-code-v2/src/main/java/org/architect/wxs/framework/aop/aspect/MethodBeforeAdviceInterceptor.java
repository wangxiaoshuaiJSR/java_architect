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
public class MethodBeforeAdviceInterceptor extends AbstractAspectAdvice implements MethodInterceptor {
    private JoinPoint joinPoint;
    public MethodBeforeAdviceInterceptor(Method method, Object newInstance) {
        super(method,newInstance);
    }

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        this.joinPoint = methodInvocation;
        before(joinPoint);
        Object proceed = methodInvocation.proceed();
        System.err.println(proceed+"beforebeforebeforebeforebeforebeforebefore");
        return proceed;
    }

    private Object before(JoinPoint joinPoint) throws Throwable {
        return super.invokeAdviceMethod(joinPoint,null,null);
    }
}
