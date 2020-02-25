package org.architect.wxs.factorymethodpatten;

import org.architect.wxs.simplefactorypattern.ICourse;

/**
 * {@link}
 *
 * @author wangxiaoshuai on 2020/2/25
 * @javadoc ：工厂方法模式
 */
public class Test {
    public static void main(String[] args) {
        ICourseFactory factory = new PythosCourseFactory();
        ICourse course = factory.create();
        course.record();
    }
}
