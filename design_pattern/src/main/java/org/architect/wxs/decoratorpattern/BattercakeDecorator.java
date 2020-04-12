package org.architect.wxs.decoratorpattern;

/**
 * {@link}
 *
 * @author wangxiaoshuai on 2020/3/14
 * @javadoc ：
 */
public class BattercakeDecorator extends Battercake {

    private Battercake battercake;

    public BattercakeDecorator(Battercake battercake) {
        this.battercake = battercake;
    }

    protected String getMsg() {
        return this.battercake.getMsg();
    }

    protected int getPrice() {
        return this.battercake.getPrice();
    }
}
