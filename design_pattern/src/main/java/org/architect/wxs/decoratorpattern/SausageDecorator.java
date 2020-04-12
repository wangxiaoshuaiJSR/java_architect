package org.architect.wxs.decoratorpattern;

/**
 * {@link}
 *
 * @author wangxiaoshuai on 2020/3/14
 * @javadoc ：
 */
public class SausageDecorator extends BattercakeDecorator {
    public SausageDecorator(Battercake battercake) {
        super(battercake);
    }

    protected String getMsg() {
        return super.getMsg()+"香肠";
    }

    protected int getPrice() {
        return super.getPrice()+2;
    }
}
