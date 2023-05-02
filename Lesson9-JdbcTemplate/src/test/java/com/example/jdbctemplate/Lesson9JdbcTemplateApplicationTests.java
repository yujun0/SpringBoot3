package com.example.jdbctemplate;

import com.example.jdbctemplate.model.ArticleDetailPO;
import com.example.jdbctemplate.model.ArticleMainPO;
import com.example.jdbctemplate.model.ArticlePO;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.sql.Timestamp;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class Lesson9JdbcTemplateApplicationTests {

    @Resource
    private JdbcTemplate jdbcTemplate;

    @Test
    void testCount() {
        String sql = "SELECT count(*) AS ct FROM article";
        Long count = jdbcTemplate.queryForObject(sql, Long.class);
        System.out.println("文章總數：" + count);
    }

    @Test
    void testQuery() {
        // ? 作為占位符
        String sql = "SELECT * FROM article where id = ?";
        // BeanPropertyRowMapper 將查詢的結果集、列名與屬性名稱匹配，名稱完全匹配或駝峰
        ArticlePO article = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(ArticlePO.class), 2);
        System.out.println("查詢到的文章 = " + article);
    }

    @Test
    void testQueryRowMapper() {
        // 只能查詢出一個紀錄，查詢不出紀錄拋出異常
        String sql = "SELECT * FROM article WHERE id = 2";
        ArticlePO article = jdbcTemplate.queryForObject(sql, (rs, rownum) -> {
            var id = rs.getInt("id");
            var userId = rs.getInt("user_id");
            var title = rs.getString("title");
            var summary = rs.getString("summary");
            var readCount = rs.getInt("read_count");
            var createTime = new Timestamp(rs.getTimestamp("create_time").getTime()).toLocalDateTime();
            var updateTime = new Timestamp(rs.getTimestamp("update_time").getTime()).toLocalDateTime();

            return new ArticlePO(id, userId, title, summary, readCount, createTime, updateTime);
        });
        System.out.println("查詢的文章 = " + article);
    }

    @Test
    void testList() {
        String sql = "SELECT * FROM article ORDER BY id";
        // 一個list成員是一行紀錄，Map是列名和值
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        maps.forEach(item -> {
            item.forEach((key, value) -> {
                System.out.println("字段名稱： " + key + ", 列值: " + value);
            });
            System.out.println("==========================");
        });
    }

    @Test
    void testUpdate() {
        String sql = "UPDATE article SET title = ? WHERE id = ?";
        // 參數是從左往右 第一個，第二個...
        int updated = jdbcTemplate.update(sql, "Java 編程思想", 2);
        System.out.println("更新紀錄：" + updated);
    }

    @Resource
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Test
    void testNameQuery() {
        // :參數名
        String sql = "SELECT COUNT(*) AS ct FROM article WHERE user_id = :uid AND read_count > :num";
        // key是命名參數
        Map<String, Object> param = new HashMap<>();
        param.put("uid", 2101);
        param.put("num", 10);
        Long count = namedParameterJdbcTemplate.queryForObject(sql, param, Long.class);
        System.out.println("用戶被閱讀的文章數量 = " + count);
    }

    @Test
    void testArticleContent() {
        String sql = """
                SELECT m.*, d.id AS detail_id, d.article_id, d.content
                FROM article m JOIN article_detail d
                ON m.id = d.article_id
                WHERE m.id = :id
                """;
        Map<String, Object> param = new HashMap<>();
        param.put("id", 1);

        List<ArticleMainPO> list = namedParameterJdbcTemplate.query(sql, param, (rs, rowNum) -> {
            var id = rs.getInt("id");
            var userId = rs.getInt("user_id");
            var title = rs.getString("title");
            var summary = rs.getString("summary");
            var readCount = rs.getInt("read_count");
            var createTime = new Timestamp(rs.getTimestamp("create_time").getTime()).toLocalDateTime();
            var updateTime = new Timestamp(rs.getTimestamp("update_time").getTime()).toLocalDateTime();

            // 文章詳情
            var detailId = rs.getInt("detail_id");
            var articleId = rs.getInt("article_id");
            var content = rs.getString("content");

            ArticleDetailPO detail = new ArticleDetailPO(detailId, articleId, content);

            return new ArticleMainPO(id, userId, title, summary, readCount,
                    createTime, updateTime, detail);
        });

        list.forEach(m -> {
            System.out.println("m.getId() = " + m.getId());
            System.out.println("m.getArticleDetail() = " + m.getArticleDetail());
        });
    }

}
