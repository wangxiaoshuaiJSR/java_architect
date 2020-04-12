package org.architect.wxs.adapterpattern.v1;

import org.architect.wxs.adapterpattern.PassportService;
import org.architect.wxs.adapterpattern.ResultMsg;

/**
 * {@link}
 *
 * @author wangxiaoshuai on 2020/3/16
 * @javadoc ：适配器
 */
public class PassportForThirdAdapter extends PassportService implements IPassportThird {
    public ResultMsg loginForQQ(String openId) {
        return loginForRegist(openId,null);
    }

    public ResultMsg loginForWechat(String openId) {
        return loginForRegist(openId,null);
    }

    public ResultMsg loginForToken(String token) {
        return loginForRegist(token,null);
    }

    public ResultMsg loginForPhone(String phoneNo, String code) {
        return loginForRegist(phoneNo,null);
    }

    private ResultMsg loginForRegist(String username,String password){
        if(password==null){
            password="EMPTY";
        }
        super.regist(username,password);
        return super.login(username,password);
    }
}
