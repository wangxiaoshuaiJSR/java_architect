package org.architect.wxs.prototypepattern.deep;

import java.io.*;
import java.util.List;

/**
 * {@link}
 *
 * @author wangxiaoshuai on 2020/3/1
 * @javadoc ：浅克隆不支持引用类型
 */
public class CreatePrototypeClone implements Cloneable,Serializable {
    public CreatePrototypeClone clone(){
        try {
            return (CreatePrototypeClone) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

    //深度clone
    public CreatePrototypeClone deepClone(){
        try{
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(this);

            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());

            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);

            return (CreatePrototypeClone) objectInputStream.readObject();
        }catch (Exception e){

        }
        return null;
    }

    private int age;
    private String name;
    private List<String> hobbies;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    @Override
    public String toString() {
        return "CreatePrototypeClone{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", hobbies=" + hobbies +
                '}';
    }

    /**
     * {@link}
     *
     * @author wangxiaoshuai on 2020/3/1
     * @javadoc ：
     */
    public static class Test {

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
}
