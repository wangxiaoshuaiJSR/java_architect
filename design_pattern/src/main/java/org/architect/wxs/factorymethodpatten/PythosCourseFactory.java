package org.architect.wxs.factorymethodpatten;

import org.architect.wxs.simplefactorypattern.ICourse;
import org.architect.wxs.simplefactorypattern.JavaCourse;
import org.architect.wxs.simplefactorypattern.PythonCourse;

/**
 * {@link}
 *
 * @author wangxiaoshuai on 2020/2/25
 * @javadoc ：
 */
public class PythosCourseFactory implements ICourseFactory {
    public ICourse create() {
        return new PythonCourse();
    }
}
