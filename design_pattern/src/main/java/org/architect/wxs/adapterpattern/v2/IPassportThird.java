package org.architect.wxs.adapterpattern.v2;

import org.architect.wxs.adapterpattern.ResultMsg;

/**
 * {@link}
 *
 * @author wangxiaoshuai on 2020/3/16
 * @javadoc ：
 */
public interface IPassportThird {

    ResultMsg loginForQQ(String openId);

    ResultMsg loginForWechat(String openId);

    ResultMsg loginForToken(String token);

    ResultMsg loginForPhone(String phoneNo, String code);
}
