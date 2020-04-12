package org.architect.wxs.chainpattern;

/**
 * {@link}
 *
 * @author wangxiaoshuai on 2020/3/16
 * @javadoc ：
 */
public class LoginHandler extends Handler {
    public void doHandler(Member member) {
        System.out.println("登录操作");
        next.doHandler(member);
    }
}
