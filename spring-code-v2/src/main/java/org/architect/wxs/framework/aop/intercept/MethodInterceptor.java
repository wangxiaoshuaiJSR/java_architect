package org.architect.wxs.framework.aop.intercept;

/**
 * {@link}
 *
 * @author wangxiaoshuai on 2020/4/15
 * @javadoc ：
 */
public interface MethodInterceptor {

    Object invoke(MethodInvocation methodInvocation) throws Throwable;
}
