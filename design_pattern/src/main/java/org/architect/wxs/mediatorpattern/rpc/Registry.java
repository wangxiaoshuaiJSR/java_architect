package org.architect.wxs.mediatorpattern.rpc;

/**
 * {@link}
 *
 * @author wangxiaoshuai on 2020/3/22
 * @javadoc ：中介模式  注册中心
 */
public class Registry {
    public boolean regist(String serviceName,IService service){
        return true;
    }

    public IService getService(){
        return null;
    }
}
