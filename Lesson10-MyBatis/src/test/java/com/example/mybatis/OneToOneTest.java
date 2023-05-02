package com.example.mybatis;

import com.example.mybatis.mapper.ArticleOneToOneMapper;
import com.example.mybatis.po.Article;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class OneToOneTest {

    @Resource
    ArticleOneToOneMapper oneMapper;

    @Test
    void testOneToOne() {
        Article article = oneMapper.selectAllArticle(1);
        System.out.println("article: " + article);
    }


}
