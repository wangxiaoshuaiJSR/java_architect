package org.architect.wxs.mediatorpattern;

/**
 * {@link}
 *
 * @author wangxiaoshuai on 2020/3/22
 * @javadoc ：中介者模式
 */
public class ChatRoom {
    public void showMsg(User user,String msg){
        System.out.println(user.getName()+msg);
    }
}
