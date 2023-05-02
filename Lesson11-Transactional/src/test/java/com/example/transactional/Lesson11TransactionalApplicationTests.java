package com.example.transactional;

import com.example.transactional.po.ArticlePO;
import com.example.transactional.service.ArticleService;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Random;

@SpringBootTest
class Lesson11TransactionalApplicationTests {

    @Resource
    private ArticleService articleService;

    @Test
    void testInsertArticle() {
        ArticlePO article = new ArticlePO();
        article.setUpdateTime(LocalDateTime.now());
        article.setCreateTime(LocalDateTime.now());
        article.setTitle("SpringBoot事務管理");
        article.setSummary("基於SpringBoot的註解管理事務,進行事務控制");
        article.setUserId(new Random().nextInt(500));
        article.setReadCount(new Random().nextInt(1000));
        String content = "基於SpringBoot的註解管理事務,進行事務控制。1.聲明式 2.編程式";

        boolean add = articleService.postNewArticle(article, content);
        System.out.println("發布新的文章 : " + add);
    }

    @Test
    void testInsertArticleTrans() {
        ArticlePO article = new ArticlePO();
        article.setUpdateTime(LocalDateTime.now());
        article.setCreateTime(LocalDateTime.now());
        article.setTitle("SpringBoot事務管理");
        article.setSummary("基於SpringBoot的註解管理事務,進行事務控制");
        article.setUserId(new Random().nextInt(500));
        article.setReadCount(0);
        String content = "00000基於SpringBoot的註解管理事務,進行事務控制。1.聲明式 2.編程式";

        boolean add = articleService.postNewArticle(article, content);
        System.out.println("發布新的文章 : " + add);
    }

    @Test
    void testManagerArticle() {
        ArticlePO article = new ArticlePO();
        article.setUpdateTime(LocalDateTime.now());
        article.setCreateTime(LocalDateTime.now());
        article.setTitle("QQQQSpringMVC 開發web應用");
        article.setSummary("QQQ基於MVC架構");
        article.setUserId(new Random().nextInt(500));
        article.setReadCount(0);
        String content = "QQQQWeb開發使用SpringMVC";

//        System.out.println(articleService.getClass().getName());
		boolean add = articleService.managerArticle(article, content);
		System.out.println("發布新的文章 : " + add);
    }

    @Test
    void testAddArticle() {
        ArticlePO article = new ArticlePO();
        article.setUpdateTime(LocalDateTime.now());
        article.setCreateTime(LocalDateTime.now());
        article.setTitle("Spring 事務管理 555");
        article.setSummary("Spring 事務屬性，事務實現 555");
        article.setUserId(new Random().nextInt(2203));
        article.setReadCount(0);
        String content = "Spring 統一事務管理，事務管理器管理本地事務";

        boolean add = articleService.postNewArticleThread(article, content);
        System.out.println("發布新的文章 : " + add);
    }
}
