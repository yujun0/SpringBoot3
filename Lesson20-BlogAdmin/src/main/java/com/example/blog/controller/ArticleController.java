package com.example.blog.controller;

import cn.hutool.core.bean.BeanUtil;
import com.example.blog.fomatter.IdType;
import com.example.blog.handler.exp.IdTypeException;
import com.example.blog.model.dto.ArticleDTO;
import com.example.blog.model.param.ArticleParam;
import com.example.blog.model.po.ArticlePO;
import com.example.blog.model.vo.ArticleVO;
import com.example.blog.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class ArticleController {

    private final ArticleService articleService;
    private static final Logger log = LoggerFactory.getLogger(ArticleController.class);

    @GetMapping(value = {"/", "/article/hot"})
    private String showHotArticle(Model model) {
        List<ArticlePO> articlePOList = articleService.queryTopArticle();
        // 轉為 Vo .hutool工具類
        List<ArticleVO> articleVOList = BeanUtil.copyToList(articlePOList, ArticleVO.class);
        // 添加數據
        model.addAttribute("articleList", articleVOList);
        // 視圖
        return "/blog/articleList";
    }

    // 發布新文章
    @PostMapping("/article/add")
    public String addArticle(@Validated(ArticleParam.AddArticle.class) ArticleParam param) {
        log.info("start addArticle....");
        // 業務邏輯，調用service
        ArticleDTO dto = new ArticleDTO();
        dto.setContent(param.getContent());
        dto.setSummary(param.getSummary());
        dto.setTitle(param.getTitle());
        boolean b = articleService.addArticle(dto);
        log.info("b: {}", b);
        return "redirect:/article/hot";
    }

    // 查詢文章內容
    @GetMapping("/article/get")
    public String queryById(Integer id, Model model) {
        log.info("id: {}", id);
        if (id != null && id > 0) {
            ArticleDTO dto = articleService.queryByArticleId(id);
            // DTO -> VO
            ArticleVO vo = BeanUtil.copyProperties(dto, ArticleVO.class);
            // 添加數據
            model.addAttribute("article", vo);
            // view
            return "/blog/editArticle";
        } else {
            return "/blog/error/error";
        }
    }

    // 編輯文章
    @PostMapping("/article/edit")
    public String modifyArticle(@Validated(ArticleParam.EditArticle.class) ArticleParam param) {
        ArticleDTO dto = new ArticleDTO();
        dto.setId(param.getId());
        dto.setTitle(param.getTitle());
        dto.setSummary(param.getSummary());
        dto.setContent(param.getContent());
        boolean b = articleService.modifyArticle(dto);
        log.info("b: {}", b);
        return "redirect:/article/hot";
    }

    // 刪除文章 ids=1,6,2
    @PostMapping("/article/remove")
    public String removeArticle(@RequestParam("ids") IdType idType) {
        if (idType == null) {
            throw new IdTypeException("ID為空");
        }
        boolean b = articleService.removeArticle(idType.getIdList());
        log.info("b: {}", b);
        return "redirect:/article/hot";
    }

    @GetMapping("/article/deail/overview")
    @ResponseBody
    public String queryDetail(Integer id) {
        String top20Content = "無id";
        if (id != null && id > 0) {
            top20Content = articleService.queryTop20Content(id);
        }
        log.info("top20Content: {}", top20Content);
        return top20Content;
    }
}
