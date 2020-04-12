package org.architect.wxs.observerpattern.guava;

import com.google.common.eventbus.Subscribe;

/**
 * {@link}
 *
 * @author wangxiaoshuai on 2020/3/23
 * @javadoc ：  牛B的观察者模式
 */
public class GuavaEvent {
    @Subscribe
    public void observer(Object str){
        System.out.println("执行observers方法，传参为："+str);
    }
}
