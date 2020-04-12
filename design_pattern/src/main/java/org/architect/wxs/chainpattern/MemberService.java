package org.architect.wxs.chainpattern;

/**
 * {@link}
 *
 * @author wangxiaoshuai on 2020/3/16
 * @javadoc ：责任链模式
 */
public class MemberService {
    public void login(){
       Handler.Builder builder = new Handler.Builder();
       builder.addHandler(new ValidateHandler())
               .addHandler(new LoginHandler())
               .addHandler(new AuthHandler());

       builder.build().doHandler(new Member());

    }
}
