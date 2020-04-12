package org.architect.wxs.observerpattern;

/**
 * {@link}
 *
 * @author wangxiaoshuai on 2020/3/23
 * @javadoc ：
 */
public class Question {

    private String name;

    private String content;

    public Question(String name, String content) {
        this.name = name;
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
