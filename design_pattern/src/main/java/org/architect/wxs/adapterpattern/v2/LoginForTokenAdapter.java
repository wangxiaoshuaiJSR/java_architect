package org.architect.wxs.adapterpattern.v2;

import org.architect.wxs.adapterpattern.PassportService;
import org.architect.wxs.adapterpattern.ResultMsg;

/**
 * {@link}
 *
 * @author wangxiaoshuai on 2020/3/16
 * @javadoc ：
 */
public class LoginForTokenAdapter extends AbstractAdapter {
    public boolean support(Object object) {
        return object instanceof LoginForTokenAdapter;
    }

    public ResultMsg login(String id, Object adapter) {
        return super.login("","");
    }
}
