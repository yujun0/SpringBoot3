package com.example.transactional.mapper;

import com.example.transactional.po.ArticleDetailPO;
import com.example.transactional.po.ArticlePO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;

public interface ArticleMapper {

    // 添加新的文章屬性 Article
    @Insert("""
            INSERT INTO article(user_id, title, summary, read_count, create_time, update_time)
            VALUES(#{userId}, #{title}, #{summary}, #{readCount}, #{createTime}, #{updateTime})
            """)
    // 可選的配置，得到自動增長的主鍵值
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    int insertArticle(ArticlePO article);

    // 添加文章內容 ArticleDetail
    @Insert("""
            INSERT INTO article_detail(article_id, content) 
            VALUES(#{articleId}, #{content})
            """)
    int insertArticleDetail(ArticleDetailPO detail);

}
