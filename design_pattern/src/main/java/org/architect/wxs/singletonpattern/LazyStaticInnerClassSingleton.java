package org.architect.wxs.singletonpattern;

/**
 * {@link}
 *
 * @author wangxiaoshuai on 2020/2/26
 * @javadoc ：org.architect.wxs.singletonpattern.LazyStaticInnerClassSingleton
 * org.architect.wxs.singletonpattern.LazyStaticInnerClassSingleton$LazyHolder
 * 优点：优雅，近乎完美，性能高，避免内存浪费
 * 缺点：能够被反射破坏
 */
public class LazyStaticInnerClassSingleton {
    private LazyStaticInnerClassSingleton(){
        if(LazyHolder.instance!=null){
            throw new RuntimeException("非法访问了。。。");
        }
    }

    private static LazyStaticInnerClassSingleton getInstance(){
        return LazyHolder.instance;
    }

    private static class LazyHolder{
        private static final LazyStaticInnerClassSingleton instance
                =new LazyStaticInnerClassSingleton();
    }
}
