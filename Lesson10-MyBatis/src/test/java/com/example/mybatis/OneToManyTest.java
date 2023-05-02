package com.example.mybatis;

import com.example.mybatis.mapper.oneToMany.ArticleCommentMapper;
import com.example.mybatis.po.oneToMany.ArticleEntity;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class OneToManyTest {

    @Resource
    ArticleCommentMapper commentMapper;

    @Test
    void testOneToMany() {
        ArticleEntity articleEntity = commentMapper.selectArticleComments(1);
        System.out.println("articleEntity = " + articleEntity);

    }
}
