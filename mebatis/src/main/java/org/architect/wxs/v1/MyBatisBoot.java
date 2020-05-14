package org.architect.wxs.v1;

import org.architect.wxs.v1.mapper.BlogMapper;

/**
 * @Author: wangxiaoshuai
 */
public class MyBatisBoot {
    public static void main(String[] args) {
        SqlSession sqlSession = new SqlSession(new Configuration(), new Executor());
        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
        blogMapper.selectBlogById(1);
    }
}
