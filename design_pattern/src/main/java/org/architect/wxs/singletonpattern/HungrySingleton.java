package org.architect.wxs.singletonpattern;

/**
 * {@link}
 *
 * @author wangxiaoshuai on 2020/2/26
 * @javadoc ：缺点：造成内存的浪费  大批量出现的时候不适用
 * 优点： 执行效率高，没有任何的锁
 */
public class HungrySingleton {
    private static final HungrySingleton hungrySingleton=new HungrySingleton();
    private HungrySingleton(){}
    public static HungrySingleton getInstance(){
        return hungrySingleton;
    }
}
