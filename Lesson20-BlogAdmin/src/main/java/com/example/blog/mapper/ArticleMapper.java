package com.example.blog.mapper;

import com.example.blog.model.map.ArticleAndDetailMap;
import com.example.blog.model.po.ArticleDetailPO;
import com.example.blog.model.po.ArticlePO;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ArticleMapper {

    // 查詢首頁需要的文章列表
    @Select("""
            SELECT id, user_id, title, summary, read_count, create_time, update_time
            FROM article
            WHERE read_count >= #{lowRead}
            ORDER BY read_count DESC
            LIMIT #{topRead}
            """)
    @Results(id = "ArticleBaseMap", value = {
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "user_id", property = "userId"),
            @Result(column = "title", property = "title"),
            @Result(column = "summary", property = "summary"),
            @Result(column = "read_count", property = "readCount"),
            @Result(column = "create_time", property = "createTime"),
            @Result(column = "update_time", property = "updateTime")
    })
    List<ArticlePO> topSortByReadCount(Integer lowRead, Integer topRead);

    // 添加article
    @Insert("""
            INSERT INTO article(user_id, title, summary, read_count, create_time, update_time)
            VALUES(#{user_id}, #{title}, #{summary}, #{read_count}, #{create_time}, #{update_time})
            """)
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int insertArticle(ArticlePO articlePO);

    // 文章內容
    @Insert("""
            INSERT INTO article_detail(article_id,content)
            VALUES(#{articleId},#{content})
            """)
    int insertArticleDetail(ArticleDetailPO articleDetailPO);

    // 兩個表的連接
    @Select("""
            SELECT a.id as article_id, title, summary, ad.content 
            FROM article a INNER JOIN article_detail ad 
            ON a.id = ad.article_id
            WHERE a.id = #{id}
            """)
    @Results(id = "ArticleAndDetailMapper", value = {
            @Result(id = true, column = "aticle_id", property = "id"),
            @Result(column = "title", property = "title"),
            @Result(column = "summary", property = "summary"),
            @Result(column = "content", property = "content")})
    ArticleAndDetailMap selectArticleAndDetail(Integer id);

    // 修改文章屬性
    @Update("""
            UPDATE article
            SET title = #{title}, summary = #{summary}, update_time = #{updateTime}
            WHERE id = #{id}
            """)
    int updateArticle(ArticlePO po);

    // 更新文章內容
    @Select("""
            UPDATE article_detail
            SET content = #{content}
            WHERE article_id = #{articleId}
            """)
    int updateArticleDetail(ArticleDetailPO detailPO);

    // 刪除文章
    @Delete("""
            <script>
                DELETE FROM article WHERE id IN
                <foreach item="id" collection="list" open="(" separator="," close=")">
                    #{id}
                </foreach>
            </script>
            """)
    int deleteArticle(List<Integer> idList);

    // 刪除文章內容
    @Delete("""
            <script>
                DELETE FROM article_detail WHERE article_id IN
                <foreach item="id" collection="list" open="(" separator="," close=")">
                    #{id}
                </foreach>
            </script>
            """)
    int deleteDetail(List<Integer> idList);

    @Select("""
            SELECT id, article_id, content
            FROM article_detail
            WHERE article_id = #{articleId}
            """)
    @Results(id = "articleDatailMapper", value = {
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "article_id",property = "articleId"),
            @Result(column = "content",property = "content")
    })
    ArticleDetailPO selectArticleDetailByArticleId(Integer articleId);
}
