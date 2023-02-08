package com.datvutech.news.app.util.mapper;

import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.datvutech.news.data.entity.Article;
import com.datvutech.news.logic.dto.ArticleDto;

@Component
public class ArticleMapper extends AbstractMapper {

    @Autowired
    private DateTimeFormatter dateTimeFormatter;

    public ArticleDto articleEntityToDto(Article article) {
        ArticleDto articleDto = mapper.map(article, ArticleDto.class);
        articleDto.setFormatedCreatedDate(dateTimeFormatter.format(article.getCreatedDate().toLocalDateTime()));
        return articleDto;
    }
    public Article articleDtoToEntity(ArticleDto articleDto) {
        Article article = mapper.map(articleDto, Article.class);
        return article;
    }
}
