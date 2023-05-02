package com.example.mybatis.mapper;

import com.example.mybatis.po.ArticlePO;
import org.apache.ibatis.annotations.*;

public interface ArticleMapper {

    // 按主鍵查詢
    @Select("""
            SELECT id, user_id, title, summary, read_count, create_time, update_time
            FROM article
            WHERE id = #{articleId}
            """)
    // 查詢結果ResultSet 和 PO對象的屬性映射
    @Results(id = "BaseArticleMap", value = {
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "user_id", property = "userId"),
            @Result(column = "read_count", property = "readCount"),
            @Result(column = "create_time", property = "createTime"),
            @Result(column = "update_time", property = "updateTime")
    })
    ArticlePO selectById(@Param("articleId") Integer id);

    // insert
    @Insert("""
            INSERT INTO article(user_id, title, summary, read_count, create_time, update_time)
            VALUES(#{userId}, #{title}, #{summary}, #{readCount}, #{createTime}, #{updateTime})
            """)
    int insertArticle(ArticlePO po);

    // update
    @Update("""
            UPDATE article SET read_count = #{readCount} WHERE id = #{id}
            """)
    void updateReadCount(Integer id, Integer readCount);

    // delete
    @Delete("""
            DELETE FROM article WHERE id = #{id}
            """)
    void deleteById(Integer id);
}
