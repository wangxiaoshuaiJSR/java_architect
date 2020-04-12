package org.architect.wxs.observerpattern;

import java.util.Observable;
import java.util.Observer;

/**
 * {@link}
 *
 * @author wangxiaoshuai on 2020/3/23
 * @javadoc ：
 */
public class Teacher implements Observer {
    private String name;

    public Teacher(String name) {
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void update(Observable o, Object arg) {
        Gper gper = (Gper) o;
        Question question= (Question) arg;

        System.out.println(name+"老师"+question.getContent()+question.getName());
    }
}
