package org.architect.wxs.chainpattern;

/**
 * {@link}
 *
 * @author wangxiaoshuai on 2020/3/16
 * @javadoc ：
 */
public class ValidateHandler extends Handler {
    public void doHandler(Member member) {
        if (member!=null){
            System.out.println("校验用户了");
        }
        next.doHandler(member);
    }
}
