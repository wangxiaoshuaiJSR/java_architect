package org.architect.wxs.mediatorpattern;

/**
 * {@link}
 *
 * @author wangxiaoshuai on 2020/3/22
 * @javadoc ：
 */
public class User {
    private String name;

    private ChatRoom chatRoom;

    public User(String name, ChatRoom chatRoom) {
        this.name = name;
        this.chatRoom = chatRoom;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void sendMessage(String msg){
        this.chatRoom.showMsg(this,msg);
    }
}
