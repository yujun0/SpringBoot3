package com.example.mybatis.mapper.oneToMany;

import com.example.mybatis.po.oneToMany.ArticleEntity;
import com.example.mybatis.po.oneToMany.Comment;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface ArticleCommentMapper {
    // 查詢評論
    @Select("""
            SELECT id, article_id, content FROM comment
            WHERE article_id = #{articleId}
            ORDER BY id
            """)
    @Results(id = "CommentMapper", value = {
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "article_id", property = "articleId"),
            @Result(column = "content", property = "content")
    })
    List<Comment> selectComments(Integer articleId);


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
            @Result(column = "id", property = "comments",
                    many = @Many(select = "com.example.mybatis.mapper.oneToMany.ArticleCommentMapper.selectComments",
                    fetchType = FetchType.LAZY))
    })
    ArticleEntity selectArticleComments(Integer id);
}
