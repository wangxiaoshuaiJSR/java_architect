package org.architect.wxs.v1;

import java.lang.reflect.Proxy;
import java.util.ResourceBundle;

/**
 * @Author: wangxiaoshuai
 */
public class Configuration {
    public static final ResourceBundle sqlMappings;

    static{
        sqlMappings = ResourceBundle.getBundle("v1sql");
    }

    public <T> T getMapper(Class clazz, SqlSession sqlSession) {
        return (T)Proxy.newProxyInstance(this.getClass().getClassLoader(),
                new Class[]{clazz},
                new MapperProxy(sqlSession));
    }


}
