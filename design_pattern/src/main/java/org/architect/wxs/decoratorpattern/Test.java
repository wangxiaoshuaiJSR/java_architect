package org.architect.wxs.decoratorpattern;

/**
 * {@link}
 *
 * @author wangxiaoshuai on 2020/3/14
 * @javadoc ：
 */
public class Test {
    public static void main(String[] args) {
        Battercake battercake=new BaseBattercake();
        System.out.println(battercake.getMsg());
        System.out.println(battercake.getPrice());

        battercake=new EggDecorator(battercake);
        System.out.println(battercake.getMsg());
        System.out.println(battercake.getPrice());
        battercake = new SausageDecorator(battercake);
        System.out.println(battercake.getMsg());
        System.out.println(battercake.getPrice());
    }
}
