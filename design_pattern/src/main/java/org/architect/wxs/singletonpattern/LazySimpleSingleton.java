package org.architect.wxs.singletonpattern;

/**
 * {@link}
 *
 * @author wangxiaoshuai on 2020/2/26
 * @javadoc ：
 * 优点.节省内存
 * 缺点：线程不安全  加synchronized后，只有一个线程可以访问
 */
public class LazySimpleSingleton {

    private static LazySimpleSingleton instance;

    private LazySimpleSingleton(){}

    public synchronized static LazySimpleSingleton getInstance(){
        if(instance==null){
            instance=new LazySimpleSingleton();
        }
        return instance;
    }
}
