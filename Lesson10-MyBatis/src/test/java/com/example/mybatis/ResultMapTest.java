package com.example.mybatis;

import com.example.mybatis.mapper.ArticleDao;
import com.example.mybatis.po.ArticlePO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ResultMapTest {

    @Autowired
    private ArticleDao articleDao;

    @Test
    void test01() {
        ArticlePO articlePO = articleDao.selectById(2);
        System.out.println("articlePO = " + articlePO);
    }

    @Test
    void test02() {
        List<ArticlePO> list = articleDao.selectList(2101);
        list.forEach(System.out::println);
    }

    @Test
    void test03() {
        ArticlePO articlePO = articleDao.selectByIdByXml(2);
        System.out.println("articlePO = " + articlePO);
    }
}
