package org.architect.wxs.observerpattern;

/**
 * {@link}
 *
 * @author wangxiaoshuai on 2020/3/23
 * @javadoc ：
 */
public class Test {

    public static void main(String[] args) {
        Gper gper = Gper.getInstance();
        Teacher tom = new Teacher("tom");
        Teacher jerry = new Teacher("jerry");

        gper.addObserver(tom);
        gper.addObserver(jerry);

        Question question = new Question("james","不会谈对象");

        gper.publishQuestion(question);
    }
}
