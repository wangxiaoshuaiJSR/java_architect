package org.architect.wxs.v2.mapper;

import org.architect.wxs.v2.annotation.Entity;
import org.architect.wxs.v2.annotation.Select;

/**
 * @Author: wangxiaoshuai
 */
@Entity(Blog.class)
public interface BlogMapper {
    /**
     * 根据主键查询文章
     * @param bid
     * @return
     */
    @Select("select * from blog where bid = ?")
    public Blog selectBlogById(Integer bid);

}
