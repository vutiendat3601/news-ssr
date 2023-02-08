package com.datvutech.news.data.repository;

import java.util.List;

import com.datvutech.news.data.entity.Article;
import com.datvutech.news.data.repository.generic.PageableRepository;

public interface ArticleRepository extends PageableRepository<Article> {
    List<Article> findAll(String parentTopic, String childTopic);

    List<Article> findByWriterId(long writerId);
    
    List<Article> findLatestArticles(int limit);

    Article findOne(String parentTopic, String childTopic, String code);

    void hideArticle(String code);

}
