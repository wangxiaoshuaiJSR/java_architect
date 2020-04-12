package org.architect.wxs.flyweightpattern;

import java.util.Vector;

/**
 * {@link}
 *
 * @author wangxiaoshuai on 2020/3/15
 * @javadoc ：享元模式  为了避免浪费内存，资源重复利用，另外我这里要用Vecotor玩一把
 */
public class ConnectionPool {

    private Vector<User>  pools;

    private int poolSize = 100;

    public ConnectionPool(){
        pools = new Vector<User>(poolSize);
        for(int i=0;i<poolSize;i++){
            User user = new User();
            user.setId(i);
            user.setName("name"+i);
            pools.add(user);
        }

    }

    public User getUser(){
        User user = pools.get(0);
        pools.remove(user);
        return user;
    }

    public void release(User user){
        pools.add(user);
    }

}
