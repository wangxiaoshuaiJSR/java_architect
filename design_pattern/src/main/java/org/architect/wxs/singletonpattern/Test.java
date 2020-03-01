package org.architect.wxs.singletonpattern;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * {@link}
 *
 * @author wangxiaoshuai on 2020/2/26
 * @javadoc ：
 */
public class Test {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        EnumSingleton instance = EnumSingleton.getInstance();
        instance.setData(new Object());
        System.out.println(instance.getData());
      /*  Class<EnumSingleton> singletonClass = EnumSingleton.class;
        Constructor<EnumSingleton> declaredConstructor = singletonClass.getDeclaredConstructor(String.class,int.class);
        declaredConstructor.setAccessible(true);
        Object object = declaredConstructor.newInstance();
        System.out.println(object);*/
    }
}
