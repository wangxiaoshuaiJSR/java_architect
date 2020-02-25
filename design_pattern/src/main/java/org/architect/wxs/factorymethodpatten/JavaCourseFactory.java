package org.architect.wxs.factorymethodpatten;

import org.architect.wxs.simplefactorypattern.ICourse;
import org.architect.wxs.simplefactorypattern.JavaCourse;

/**
 * {@link}
 *
 * @author wangxiaoshuai on 2020/2/25
 * @javadoc ：
 */
public class JavaCourseFactory implements ICourseFactory {
    public ICourse create() {
        return new JavaCourse();
    }
}
