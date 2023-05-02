package com.example.blog.service.impl;

import com.example.blog.mapper.ArticleMapper;
import com.example.blog.model.dto.ArticleDTO;
import com.example.blog.model.map.ArticleAndDetailMap;
import com.example.blog.model.po.ArticleDetailPO;
import com.example.blog.model.po.ArticlePO;
import com.example.blog.service.ArticleService;
import com.example.blog.settings.ArticleSettings;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class ArticleServiceImpl implements ArticleService {
    private final ArticleMapper articleMapper;
    private final ArticleSettings articleSettings;
    private static final Logger log = LoggerFactory.getLogger(ArticleServiceImpl.class);
//    public ArticleServiceImpl(ArticleMapper articleMapper) {
//        this.articleMapper = articleMapper;
//    }

    @Override
    public List<ArticlePO> queryTopArticle() {
        Integer lowRead = articleSettings.getLowRead();
        Integer topRead = articleSettings.getTopRead();

        return articleMapper.topSortByReadCount(lowRead, topRead);
    }

    // 發布文章（article ，article_detail）
    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean addArticle(ArticleDTO dto) {
        // 文章
        ArticlePO articlePO = new ArticlePO();
        articlePO.setTitle(dto.getTitle());
        articlePO.setSummary(dto.getSummary());
        articlePO.setCreateTime(LocalDateTime.now());
        articlePO.setUpdateTime(LocalDateTime.now());
        articlePO.setReadCount(new Random().nextInt(200));
        articlePO.setUserId(new Random().nextInt(5000));
        int addArticle = articleMapper.insertArticle(articlePO);

        // 文章內容
        ArticleDetailPO articleDetailPO = new ArticleDetailPO();
        articleDetailPO.setArticleId(articlePO.getId());
        articleDetailPO.setContent(dto.getContent());
        int addDetail = articleMapper.insertArticleDetail(articleDetailPO);

        log.info("addArticle: {}, addDetail: {}", addArticle, addDetail);
        return (addArticle + addDetail) == 2;
    }

    @Override
    public ArticleDTO queryByArticleId(Integer id) {
        // 文章屬性，內容
        ArticleAndDetailMap mapper = articleMapper.selectArticleAndDetail(id);
        // 轉為dto
        ArticleDTO dto = new ArticleDTO();
        dto.setTitle(mapper.getTitle());
        dto.setContent(mapper.getContent());
        dto.setSummary(mapper.getSummary());
        dto.setId(mapper.getId());
        return dto;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean modifyArticle(ArticleDTO dto) {
        // 修改文章屬性
        ArticlePO po= new ArticlePO();
        po.setTitle(dto.getTitle());
        po.setSummary(dto.getSummary());
        po.setUpdateTime(LocalDateTime.now());
        po.setId(dto.getId());
        int article = articleMapper.updateArticle(po);

        // 修改文章內容
        ArticleDetailPO detailPO = new ArticleDetailPO();
        detailPO.setArticleId(dto.getId());
        detailPO.setContent(dto.getContent());
        int detail = articleMapper.updateArticleDetail(detailPO);

        return (article + detail) == 2;
    }

    // 刪除文章屬性，內容
    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean removeArticle(List<Integer> idList) {
        int article = articleMapper.deleteArticle(idList);
        int detail = articleMapper.deleteDetail(idList);
        return article == detail;
    }

    @Override
    public String queryTop20Content(Integer id) {
        ArticleDetailPO detailPO = articleMapper.selectArticleDetailByArticleId(id);
        String content = "無內容";
        if (detailPO != null) {
            content = content.substring(0, 20);
        }
        return content;
    }

}
