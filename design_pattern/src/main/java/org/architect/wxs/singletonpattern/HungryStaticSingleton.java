package org.architect.wxs.singletonpattern;

/**
 * {@link}
 *
 * @author wangxiaoshuai on 2020/2/26
 * @javadoc ：
 */
public class HungryStaticSingleton {
    private static final HungryStaticSingleton hungryStaticSingleton;
    static {
        hungryStaticSingleton=new HungryStaticSingleton();
    }
    private HungryStaticSingleton(){ }

    public static HungryStaticSingleton getInstance(){
        return hungryStaticSingleton;
    }
}
