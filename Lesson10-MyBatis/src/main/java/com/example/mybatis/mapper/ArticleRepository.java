package com.example.mybatis.mapper;

import com.example.mybatis.po.ArticlePO;
import com.example.mybatis.provider.SqlProvider;
import org.apache.ibatis.annotations.*;

import java.time.LocalDateTime;

public interface ArticleRepository {

    // 定義@Results
    @Select("")
    @Results(id = "NewBaseArticleMap", value = {
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "user_id", property = "userId"),
            @Result(column = "read_count", property = "readCount"),
            @Result(column = "create_time", property = "createTime"),
            @Result(column = "update_time", property = "updateTime")
    })
    ArticlePO articleMapper();

    // 使用SqlProvider
    @ResultMap("NewBaseArticleMap")
    @SelectProvider(type = SqlProvider.class, method = "selectArticle")
    ArticlePO selectPrimary(Integer id);

    @UpdateProvider(type = SqlProvider.class, method = "updateSql")
    int updateTime(Integer id, LocalDateTime now);

    @InsertProvider(type = SqlProvider.class, method = "insertSql")
    int insertArticle(ArticlePO po);

    @DeleteProvider(type = SqlProvider.class, method = "deleteSql")
    int deleteArticle(Integer id);
}
