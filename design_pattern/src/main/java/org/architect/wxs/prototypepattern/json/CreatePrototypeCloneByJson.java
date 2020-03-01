package org.architect.wxs.prototypepattern.json;

import com.alibaba.fastjson.JSONObject;
import org.architect.wxs.prototypepattern.shollow.IPrototype;

import java.io.*;
import java.util.List;

/**
 * {@link}
 *
 * @author wangxiaoshuai on 2020/3/1
 * @javadoc ：Json进行clone
 */
public class CreatePrototypeCloneByJson implements IPrototype<CreatePrototypeCloneByJson> {


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


    public CreatePrototypeCloneByJson clone() {
        String json = objectToJson(this);
        CreatePrototypeCloneByJson prototypeCloneByJson = jsonStringToObject(json, CreatePrototypeCloneByJson.class);
        return prototypeCloneByJson;
    }

    public static <T> T jsonStringToObject(String jsonStr,Class<T> obj){
        try{
            return JSONObject.parseObject(jsonStr, obj);
        }catch(Exception e){
            System.out.println("将JSON串{}转换成 指定对象失败:"+jsonStr);
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 对象转JSON
     */
    public static <T> String objectToJson(T obj){
        try{
            String json=JSONObject.toJSONString(obj);
            return json;
        }catch(Exception e){
            System.out.println("将指定对象转成JSON串{}失败:"+obj.toString());
            e.printStackTrace();
        }
        return "";
    }


}
