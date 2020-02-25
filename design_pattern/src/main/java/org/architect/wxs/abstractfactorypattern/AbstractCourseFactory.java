package org.architect.wxs.abstractfactorypattern;

/**
 * {@link}
 *
 * @author wangxiaoshuai on 2020/2/25
 * @javadoc ：抽象工厂模式
 */
public abstract class AbstractCourseFactory {
    public void init(){
        System.out.println("初始化基础数据方法");
    }

    protected abstract INote createNote();

    protected abstract IVideo createVideo();

}
