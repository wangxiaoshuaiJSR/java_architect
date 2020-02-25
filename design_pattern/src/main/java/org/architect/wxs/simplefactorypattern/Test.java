package org.architect.wxs.simplefactorypattern;

/**
 * {@link CourseFactory}
 * @author wangxiaoshuai on 2020/2/25
 * @javadoc ：简单工厂模式
 */
public class Test {

    public static void main(String[] args) {
        ICourse course = CourseFactory.createCourse(JavaCourse.class);
        course.record();

        ICourse courseP = CourseFactory.createCourse(PythonCourse.class);
        courseP.record();

    }
}
