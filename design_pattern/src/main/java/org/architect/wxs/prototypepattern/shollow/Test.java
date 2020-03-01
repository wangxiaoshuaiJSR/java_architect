package org.architect.wxs.prototypepattern.shollow;

import java.util.ArrayList;
import java.util.List;

/**
 * {@link}
 *
 * @author wangxiaoshuai on 2020/3/1
 * @javadoc ：
 */
public class Test {

    //浅克隆不支持引用对象克隆
  /*  public static void main(String[] args) {
        CreatePrototypeClone createPrototypeClone = new CreatePrototypeClone();
        createPrototypeClone.setAge(18);
        createPrototypeClone.setName("wangxiaoshuai");
        List<String> list = new ArrayList<String>();
        list.add("java");
        list.add("python");
        createPrototypeClone.setHobbies(list);

        CreatePrototypeClone clone = createPrototypeClone.clone();
        clone.getHobbies().add("go");
        System.out.println(createPrototypeClone);
        System.out.println(clone);
        System.out.println(createPrototypeClone==clone);
    }*/


}
