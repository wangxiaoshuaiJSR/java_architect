package org.architect.wxs.proxypattern.dynamicproxy.cglib;

/**
 * {@link}
 *
 * @author wangxiaoshuai on 2020/3/14
 * @javadoc ：
 */
public class Test {
    public static void main(String[] args) {
        ZhangSan instance = (ZhangSan) new CGlibMeipo().getInstance(ZhangSan.class);
        instance.findLove();
    }
}
