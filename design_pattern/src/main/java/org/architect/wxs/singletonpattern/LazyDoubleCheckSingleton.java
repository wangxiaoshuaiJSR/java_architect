package org.architect.wxs.singletonpattern;

/**
 * {@link}
 *
 * @author wangxiaoshuai on 2020/2/26
 * @javadoc ：性能不错了，线程安全了
 * 缺点：程序的可读性难度加大，代码不够优雅
 */
public class LazyDoubleCheckSingleton {

    private static LazyDoubleCheckSingleton instance;

    private LazyDoubleCheckSingleton() {
    }

    public static LazyDoubleCheckSingleton getInstance() {
        if (instance == null) {
            synchronized (LazyDoubleCheckSingleton.class) {
                if (instance == null) {
                    instance = new LazyDoubleCheckSingleton();
                }
            }
        }
        return instance;
    }
}
