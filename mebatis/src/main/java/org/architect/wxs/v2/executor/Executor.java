package org.architect.wxs.v2.executor;

/**
 * @Author: wangxiaoshuai
 */
public interface Executor {
    <T> T query(String statement, Object[] parameter, Class pojo);
}
