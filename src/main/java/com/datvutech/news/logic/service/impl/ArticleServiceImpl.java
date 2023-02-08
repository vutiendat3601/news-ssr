package com.datvutech.news.logic.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.datvutech.news.app.util.mapper.ArticleMapper;
import com.datvutech.news.data.entity.Article;
import com.datvutech.news.data.entity.Topic;
import com.datvutech.news.data.repository.ArticleRepository;
import com.datvutech.news.data.repository.TopicRepository;
import com.datvutech.news.logic.dto.ArticleDto;
import com.datvutech.news.logic.service.ArticleService;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    @Autowired
    private ArticleRepository articleRepo;

    @Autowired
    private TopicRepository topicRepo;

    @Override
    public List<ArticleDto> getArticles(String parentTopic, String childTopic) {
        List<Article> articles = articleRepo.findAll(parentTopic, childTopic);
        List<ArticleDto> articleDtos = new ArrayList<>();
        if (articles != null) {
            articles.forEach(a -> {
                ArticleDto articleDto = articleMapper.articleEntityToDto(a);
                articleDtos.add(articleDto);
            });
        }
        return articleDtos;
    }

    @Override
    public ArticleDto getArticle(String parentTopic, String childTopic, String code) {
        Article article = articleRepo.findOne(parentTopic, childTopic, code);
        ArticleDto articleDto = articleMapper.articleEntityToDto(article);
        return articleDto;
    }

    @Override
    public boolean createArticle(ArticleDto articleDto) {
        Topic topic = topicRepo.findOne(articleDto.getParentTopicCode(), articleDto.getTopic().getCode());
        Article article = articleMapper.articleDtoToEntity(articleDto);
        article.setTopic(topic);
        articleRepo.insert(article);
        return true;
    }

    @Override
    public List<ArticleDto> getArticles(long writerId) {
        List<Article> articles = articleRepo.findByWriterId(writerId);
        List<ArticleDto> articleDtos = new ArrayList<>();
        articles.forEach(a -> {
            ArticleDto articleDto = articleMapper.articleEntityToDto(a);
            articleDtos.add(articleDto);
        });
        return articleDtos;
    }

    @Override
    public void deleteArticle(String code) {
        articleRepo.hideArticle(code);
    }

    @Override
    public List<ArticleDto> getLatestArticles(int limit) {
        List<Article> articles = articleRepo.findLatestArticles(limit);
        List<ArticleDto> articleDtos = new ArrayList<>();
        if (articles != null) {
            articles.forEach(a -> {
                ArticleDto articleDto = articleMapper.articleEntityToDto(a);
                articleDtos.add(articleDto);
            });
        }
        return articleDtos;
    }

}
