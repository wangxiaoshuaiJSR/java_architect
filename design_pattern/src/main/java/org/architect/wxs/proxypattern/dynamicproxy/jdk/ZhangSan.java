package org.architect.wxs.proxypattern.dynamicproxy.jdk;

import org.architect.wxs.proxypattern.staticproxy.IPerson;

/**
 * {@link}
 *
 * @author wangxiaoshuai on 2020/3/1
 * @javadoc ：
 */
public class ZhangSan implements IPerson {
    public void findLove() {
        System.out.println("肤白貌美大长腿");
    }

    public void buyInsure() {
        System.out.println("买保险");
    }
}
