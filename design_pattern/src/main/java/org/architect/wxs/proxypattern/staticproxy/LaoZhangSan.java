package org.architect.wxs.proxypattern.staticproxy;

/**
 * {@link}
 *
 * @author wangxiaoshuai on 2020/3/1
 * @javadoc ：
 */
public class LaoZhangSan implements IPerson {
    private ZhangSan zhangSan;

    public LaoZhangSan(ZhangSan zhangSan) {
        this.zhangSan = zhangSan;
    }

    public void findLove() {
        System.out.println("找找对象");
        zhangSan.findLove();
        System.out.println("搞定");
    }

    public void buyInsure() {

    }
}
