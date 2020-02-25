package org.architect.wxs.simplefactorypattern;

/**
 * {@link}
 *
 * @author wangxiaoshuai on 2020/2/2
 * @javadoc ：简单工厂
 */
public class CourseFactory {
    public static ICourse createCourse(Class<? extends ICourse> clazz){
        try {
            if(clazz!=null){
                return clazz.newInstance();
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }


}
