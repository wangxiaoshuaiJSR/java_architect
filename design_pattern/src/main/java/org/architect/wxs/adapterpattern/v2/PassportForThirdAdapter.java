package org.architect.wxs.adapterpattern.v2;

import org.architect.wxs.adapterpattern.ResultMsg;
import org.architect.wxs.adapterpattern.v1.IPassportThird;

/**
 * {@link}
 *
 * @author wangxiaoshuai on 2020/3/16
 * @javadoc ：适配器
 */
public class PassportForThirdAdapter implements IPassportThird {

    public ResultMsg loginForQQ(String openId) {
        return processLogin(openId,LoginForQQAdapter.class);
    }

    public ResultMsg loginForWechat(String openId) {
        return processLogin(openId,LoginForWechatAdapter.class);
    }

    public ResultMsg loginForToken(String token) {
        return processLogin(token,LoginForTokenAdapter.class);
    }

    public ResultMsg loginForPhone(String phoneNo, String code) {
        return processLogin(code,LoginForPhoneAdapter.class);
    }

    private ResultMsg processLogin(String id,Class<? extends ILoginAdapter> clazz){
        try {
            ILoginAdapter loginAdapter = clazz.newInstance();
            if(loginAdapter.support(loginAdapter)){
                return loginAdapter.login(id,loginAdapter);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
