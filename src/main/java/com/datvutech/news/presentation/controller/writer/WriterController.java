package com.datvutech.news.presentation.controller.writer;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.datvutech.news.logic.dto.ArticleDto;
import com.datvutech.news.logic.service.ArticleService;

@RequestMapping("/writer")
@Controller
public class WriterController {

    @Autowired
    private ArticleService articleService;

    @GetMapping("/article-creation")
    public String createArticle(Model model) {
        model.addAttribute("articleReq", new ArticleDto());
        model.addAttribute("currentMenu", "article-creation");
        return "writer/article-creation";
    }

    @GetMapping("/all-articles")
    public String showArticle(Model model) {
        List<ArticleDto> articleDtos = articleService.getArticles(1L);
        model.addAttribute("articles", articleDtos);
        model.addAttribute("currentMenu", "article-list");
        return "writer/article-list";
    }

    @GetMapping("/article-deletion/{code}")
    public String deleteArticle(@PathVariable("code") String code) {
        articleService.deleteArticle(code);
        return "redirect:/writer/all-articles";
    }

    @PostMapping("/article-creation")
    public String createArticle(ArticleDto articleReq, HttpServletRequest req) {
        System.out.println("HELLo");
        articleService.createArticle(articleReq);
        return "redirect:/writer/all-articles";
    }

}
