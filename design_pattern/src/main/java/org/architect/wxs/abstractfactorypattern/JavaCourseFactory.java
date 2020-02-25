package org.architect.wxs.abstractfactorypattern;

/**
 * {@link}
 *
 * @author wangxiaoshuai on 2020/2/25
 * @javadoc ：
 */
public class JavaCourseFactory extends AbstractCourseFactory {
    protected INote createNote() {
        super.init();
        return new JavaNote();
    }

    protected IVideo createVideo() {
        super.init();
        return new JavaVideo();
    }
}
