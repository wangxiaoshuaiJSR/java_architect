package org.architect.wxs.visitorpattern;

import java.util.Random;

/**
 * {@link}
 *
 * @author wangxiaoshuai on 2020/3/23
 * @javadoc ：
 */
public class Engineer extends Employee{
    public Engineer(String name) {
        super(name);
    }

    public void accept(Ivisitor visitor) {
         visitor.visit(this);
    }

    public int getCodeLines(){
        return new Random().nextInt(100000);
    }
}
