package org.architect.wxs.mediatorpattern;

/**
 * {@link}
 *
 * @author wangxiaoshuai on 2020/3/22
 * @javadoc ：
 */
public class Test {

    public static void main(String[] args) {
        ChatRoom chatRoom = new ChatRoom();
        User tom = new User("tom",chatRoom);
        User jerry = new User("jerry",chatRoom);


        tom.sendMessage("hello");
        jerry.sendMessage("hi");
    }
}
