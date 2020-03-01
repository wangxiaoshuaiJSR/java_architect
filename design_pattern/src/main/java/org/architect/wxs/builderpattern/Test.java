package org.architect.wxs.builderpattern;

/**
 * {@link}
 *
 * @author wangxiaoshuai on 2020/3/1
 * @javadoc ：
 */
public class Test {
    public static void main(String[] args) {
        CourseBuilder builder = new CourseBuilder();
        builder.addName("java").addPPT("ppt").addHomework("无");
        System.out.println(builder.builder());
    }
}
