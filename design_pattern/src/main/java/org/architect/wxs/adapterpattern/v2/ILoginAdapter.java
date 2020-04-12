package org.architect.wxs.adapterpattern.v2;

import org.architect.wxs.adapterpattern.ResultMsg;

/**
 * {@link}
 *
 * @author wangxiaoshuai on 2020/3/16
 * @javadoc ：
 */
public interface ILoginAdapter {

    boolean support(Object object);

    ResultMsg login(String id,Object adapter);
}
