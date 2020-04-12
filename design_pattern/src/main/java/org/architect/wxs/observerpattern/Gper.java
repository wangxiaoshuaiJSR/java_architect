package org.architect.wxs.observerpattern;

import java.util.Observable;

/**
 * {@link}
 *
 * @author wangxiaoshuai on 2020/3/23
 * @javadoc ：观察者模式
 */
public class Gper extends Observable {

    private String name="Gper 生态圈";

    private static final Gper gper = new Gper();

    private Gper(){}

    public static Gper getInstance(){
        return gper;
    }

    public void publishQuestion(Question question){
        System.out.println(question.getName()+name+"提了问题");
        setChanged();
        notifyObservers(question);
    }
}
