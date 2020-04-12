package org.architect.wxs.adapterpattern;

/**
 * {@link}
 *
 * @author wangxiaoshuai on 2020/3/16
 * @javadoc ：
 */
public class PassportService {

    public ResultMsg regist(String username,String password){
        return new ResultMsg(200,"success");
    }

    public ResultMsg login(String username,String password){
        return null;
    }
}
