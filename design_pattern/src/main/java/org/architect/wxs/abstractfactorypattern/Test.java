package org.architect.wxs.abstractfactorypattern;

import org.architect.wxs.simplefactorypattern.CourseFactory;

/**
 * {@link}
 *
 * @author wangxiaoshuai on 2020/2/25
 * @javadoc ：抽象工厂模式
 */
public class Test {
    public static void main(String[] args) {
        AbstractCourseFactory courseFactory = new JavaCourseFactory();
        courseFactory.createNote().edit();
        courseFactory.createVideo().record();
    }
}
