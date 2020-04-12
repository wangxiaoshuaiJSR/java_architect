package org.architect.wxs.proxypattern.dynamicproxy.jdk;


import org.architect.wxs.proxypattern.staticproxy.IPerson;

/**
 * {@link}
 *
 * @author wangxiaoshuai on 2020/3/1
 * @javadoc ：
 */
public class Test {
    public static void main(String[] args) {
        JDKMeipo jdkMeipo = new JDKMeipo();
        IPerson instance = jdkMeipo.getInstance(new ZhangSan());
        instance.findLove();
        instance.buyInsure();
    }
}
