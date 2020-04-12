package org.architect.wxs.adapterpattern.v2;

import org.architect.wxs.adapterpattern.PassportService;
import org.architect.wxs.adapterpattern.ResultMsg;

/**
 * {@link}
 *
 * @author wangxiaoshuai on 2020/3/16
 * @javadoc ：
 */
public abstract class AbstractAdapter extends PassportService implements ILoginAdapter{
    private ResultMsg loginForRegist(String username, String password){
        if(password==null){
            password="EMPTY";
        }
        super.regist(username,password);
        return super.login(username,password);
    }
}
