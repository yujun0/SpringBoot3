package com.example.mybatis.mapper;

import com.example.mybatis.po.ArticlePO;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ArticleDao {

    // 1. 查詢某個用戶的所有文章
    @Select("""
            SELECT id, user_id, title, summary, read_count, create_time, update_time
            FROM article WHERE user_id=#{userId}
            """)
    @Results(id = "BaseArticleMap", value = {
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "user_id", property = "userId"),
            @Result(column = "read_count", property = "readCount"),
            @Result(column = "create_time", property = "createTime"),
            @Result(column = "update_time", property = "updateTime")
    })
    List<ArticlePO> selectList(Integer userId);

    // 2. 查詢某個文章，使用id
    @Select("""
            SELECT id, user_id, title, summary, read_count, create_time, update_time
            FROM article WHERE id=#{id}
            """)
    // 引用定義好的結果映射，value的值是@Results中的id
    @ResultMap("BaseArticleMap")
    ArticlePO selectById(Integer id);

    // 使用xml中的<resultMap>的id
    @Select("""
            SELECT id, user_id, title, summary, read_count, create_time, update_time
            FROM article WHERE id=#{id}
            """)
    @ResultMap("ArticleBaseMapper")
    ArticlePO selectByIdByXml(Integer id);
}
