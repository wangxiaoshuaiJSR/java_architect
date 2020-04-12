package org.architect.wxs.decoratorpattern;

/**
 * {@link}
 *
 * @author wangxiaoshuai on 2020/3/14
 * @javadoc ：
 */
public class EggDecorator extends BattercakeDecorator {
    public EggDecorator(Battercake battercake) {
        super(battercake);
    }

    protected String getMsg() {
        return super.getMsg()+"鸡蛋";
    }

    protected int getPrice() {
        return super.getPrice()+2;
    }
}
