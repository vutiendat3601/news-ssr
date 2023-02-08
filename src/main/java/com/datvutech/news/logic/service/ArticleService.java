package com.datvutech.news.logic.service;

import java.util.List;

import com.datvutech.news.logic.dto.ArticleDto;

public interface ArticleService {
    List<ArticleDto> getArticles(String parentTopic, String childTopic);

    List<ArticleDto> getArticles(long writerId);
    List<ArticleDto> getLatestArticles(int limit);
    ArticleDto getArticle(String parentTopic, String childTopic, String code);

    boolean createArticle(ArticleDto articleDto);

    void deleteArticle(String code);
}
