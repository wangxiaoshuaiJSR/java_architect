package org.architect.wxs.adapterpattern.v1;

/**
 * {@link}
 *
 * @author wangxiaoshuai on 2020/3/16
 * @javadoc ：
 */
public class Test {

    public static void main(String[] args) {
        PassportForThirdAdapter adapter = new PassportForThirdAdapter();
        adapter.login("wangxiaoshuai","123456");
        adapter.loginForQQ("jhkkhkjh");
    }
}
