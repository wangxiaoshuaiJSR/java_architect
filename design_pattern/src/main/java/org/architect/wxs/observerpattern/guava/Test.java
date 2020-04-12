package org.architect.wxs.observerpattern.guava;

import com.google.common.eventbus.EventBus;

/**e
 * {@link}
 *
 * @author wangxiaoshuai on 2020/3/23
 * @javadoc ：
 */
public class Test {

    public static void main(String[] args) {
        EventBus eventBus = new EventBus();
        GuavaEvent guavaEvent=new GuavaEvent();
        eventBus.register(guavaEvent);
        eventBus.post("tom");
    }
}
