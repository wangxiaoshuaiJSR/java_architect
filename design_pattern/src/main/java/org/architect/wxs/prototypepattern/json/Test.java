package org.architect.wxs.prototypepattern.json;

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
        CreatePrototypeCloneByJson createPrototypeClone = new CreatePrototypeCloneByJson();
        createPrototypeClone.setAge(18);
        createPrototypeClone.setName("wangxiaoshuai");
        List<String> list = new ArrayList<String>();
        list.add("java");
        list.add("python");
        createPrototypeClone.setHobbies(list);

        CreatePrototypeCloneByJson clone = createPrototypeClone.clone();
        clone.getHobbies().add("go");
        System.out.println(createPrototypeClone);
        System.out.println(clone);
        System.out.println(createPrototypeClone==clone);
    }


}
