package org.architect.wxs.decoratorpattern;

/**
 * {@link}
 *
 * @author wangxiaoshuai on 2020/3/14
 * @javadoc ：
 */
public class BaseBattercake extends Battercake {
    protected String getMsg() {
        return "兼并";
    }

    protected int getPrice() {
        return 5;
    }
}
