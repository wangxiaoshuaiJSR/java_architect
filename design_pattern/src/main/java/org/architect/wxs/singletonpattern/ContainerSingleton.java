package org.architect.wxs.singletonpattern;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * {@link}
 *
 * @author wangxiaoshuai on 2020/2/26
 * @javadoc ：Spring 创建单例的姿势
 */
public class ContainerSingleton {
    private ContainerSingleton(){}
    private static Map<String,Object> ioc=new ConcurrentHashMap<String,Object>();

    public static Object getInstance(String className){
        Object newInstance = null;
        try {
             if(!ioc.containsKey(className)){
                 newInstance = Class.forName(className).newInstance();
                 ioc.put(className,newInstance);
                 return newInstance;
             }else {
                 return ioc.get(className);
             }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
