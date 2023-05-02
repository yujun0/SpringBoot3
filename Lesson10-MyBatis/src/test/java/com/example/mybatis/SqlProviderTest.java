package com.example.mybatis;

import com.example.mybatis.mapper.ArticleRepository;
import com.example.mybatis.po.ArticlePO;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
public class SqlProviderTest {

    @Resource
    private ArticleRepository dao;

    @Test
    void testSelect() {
        ArticlePO articlePO = dao.selectPrimary(2);
        System.out.println("articlePO: " + articlePO);
    }

    @Test
    void testUpdate() {
        int i = dao.updateTime(2, LocalDateTime.now());
        System.out.println("i : " + i);
    }

    @Test
    void testInsert() {
        ArticlePO po = new ArticlePO();
        po.setTitle("Spring");
        po.setSummary("Spring全新課程");
        po.setUserId(29);
        po.setReadCount(0);
        po.setCreateTime(LocalDateTime.now());
        po.setUpdateTime(LocalDateTime.now());
        int i = dao.insertArticle(po);
        System.out.println("i : " + i);
    }

    @Test
    void testDelete() {
        int i = dao.deleteArticle(10);
        System.out.println("i : " + i);
    }
}