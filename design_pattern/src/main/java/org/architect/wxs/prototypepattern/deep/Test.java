package org.architect.wxs.prototypepattern.deep;

import java.util.ArrayList;
import java.util.List;

/**
 * {@link}
 *
 * @author wangxiaoshuai on 2020/3/1
 * @javadoc ：
 */
public class Test {


    public static void main(String[] args) {
        CreatePrototypeClone createPrototypeClone = new CreatePrototypeClone();
        createPrototypeClone.setAge(18);
        createPrototypeClone.setName("wangxiaoshuai");
        List<String> list = new ArrayList<String>();
        list.add("java");
        list.add("python");
        createPrototypeClone.setHobbies(list);

        CreatePrototypeClone clone = createPrototypeClone.deepClone();
        clone.getHobbies().add("go");
        System.out.println(createPrototypeClone);
        System.out.println(clone);
        System.out.println(createPrototypeClone==clone);
    }

}
