package org.architect.wxs.visitorpattern;

import java.util.Random;

/**
 * {@link}
 *
 * @author wangxiaoshuai on 2020/3/23
 * @javadoc ：
 */
public class Manager extends Employee{
    public Manager(String name) {
        super(name);
    }

    public void accept(Ivisitor visitor) {
        visitor.visit(this);
    }

    public int getProducts(){
        return new Random().nextInt(10);
    }
}
