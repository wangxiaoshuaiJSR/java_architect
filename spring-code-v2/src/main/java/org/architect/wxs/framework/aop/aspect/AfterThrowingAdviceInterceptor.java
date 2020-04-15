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
public class AfterThrowingAdviceInterceptor extends AbstractAspectAdvice implements MethodInterceptor {
    private String throwingName;

    public String getThrowingName() {
        return throwingName;
    }

    public void setThrowingName(String throwingName) {
        this.throwingName = throwingName;
    }

    public AfterThrowingAdviceInterceptor(Method method, Object newInstance) {
        super(method,newInstance);
    }

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable{
        try {
            return methodInvocation.proceed();
        } catch (Throwable throwable) {
            super.invokeAdviceMethod(methodInvocation,null, throwable.getCause());
            throwable.printStackTrace();
        }
        System.out.println("throwablethrowablethrowablethrowablethrowablethrowablethrowable");
        return null;
    }
}
