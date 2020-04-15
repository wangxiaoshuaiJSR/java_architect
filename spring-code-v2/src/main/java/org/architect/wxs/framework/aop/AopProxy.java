package org.architect.wxs.framework.aop;

/**
 * {@link}
 *
 * @author wangxiaoshuai on 2020/4/15
 * @javadoc ：
 */
public interface AopProxy {

    Object getProxy();

    Object getProxy(ClassLoader classLoader);
}
