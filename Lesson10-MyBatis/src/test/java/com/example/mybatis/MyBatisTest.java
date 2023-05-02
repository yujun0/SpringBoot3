package com.example.mybatis;

import com.example.mybatis.mapper.ArticleMapper;
import com.example.mybatis.po.ArticlePO;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Random;

@SpringBootTest
public class MyBatisTest {

    @Resource
    private ArticleMapper articleMapper;

    @Test
    void testSelect() {
        ArticlePO po = articleMapper.selectById(1);
        System.out.println("ArticlePO = " + po);
    }

    @Test
    void testInsert() {
        ArticlePO articlePO = new ArticlePO();
        articlePO.setTitle("Tomcat Web開發");
        articlePO.setSummary("使用Tomcat服務器，訂製web應用");
        articlePO.setReadCount(19);
        articlePO.setUserId(new Random().nextInt(500));
        articlePO.setCreateTime(LocalDateTime.now());
        articlePO.setUpdateTime(LocalDateTime.now());

        int rows = articleMapper.insertArticle(articlePO);
        System.out.println("rows : " + rows);
    }

    @Test
    void testUpdateReadCount() {
        articleMapper.updateReadCount(3, 28);
    }

    @Test
    void testDelete() {
        articleMapper.deleteById(3);
    }

}
