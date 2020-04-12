package org.architect.wxs.proxypattern.staticproxy;

/**
 * {@link}
 *
 * @author wangxiaoshuai on 2020/3/1
 * @javadoc ：
 */
public class Test {
    public static void main(String[] args) {
        LaoZhangSan laoZhangSan = new LaoZhangSan(new ZhangSan());
        laoZhangSan.findLove();
    }
}
