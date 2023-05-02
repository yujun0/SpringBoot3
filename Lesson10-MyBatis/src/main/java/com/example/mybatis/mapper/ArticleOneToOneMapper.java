package com.example.mybatis.mapper;

import com.example.mybatis.po.Article;
import com.example.mybatis.po.ArticleDetail;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

public interface ArticleOneToOneMapper {

    // 一對一查詢

    // 查詢文章詳情
    @Select("""
            SELECT id, article_id, content 
            FROM article_detail
            WHERE article_id = #{articleId}
            """)
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "article_id", property = "articleId"),
            @Result(column = "content", property = "content")
    })
    ArticleDetail selectDetail(Integer articleId);

    // 查詢文章屬性、包括詳情
    @Select("""
            SELECT id, user_id, title, summary, read_count, create_time, update_time
            FROM article
            WHERE id = #{id}
            """)
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "user_id", property = "userId"),
            @Result(column = "read_count", property = "readCount"),
            @Result(column = "create_time", property = "createTime"),
            @Result(column = "update_time", property = "updateTime"),
            @Result(column = "id", property = "articleDetail",
                    one = @One(select = "com.example.mybatis.mapper.ArticleOneToOneMapper.selectDetail",
                            fetchType = FetchType.LAZY))
    })
    Article selectAllArticle(Integer id);

}
