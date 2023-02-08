package com.datvutech.news.data.repository.impl;

import java.util.List;
import java.util.Optional;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.datvutech.news.data.entity.Article;
import com.datvutech.news.data.entity.Topic;
import com.datvutech.news.data.repository.ArticleRepository;
import com.datvutech.news.data.repository.generic.impl.PageableRepositoryImpl;

@Repository
public class ArticleRepositoryImpl
        extends PageableRepositoryImpl<Article>
        implements ArticleRepository {

    public ArticleRepositoryImpl() {
        super(Article.class);
    }

    @Override
    public List<Article> findAll(String parentTopic, String childTopic) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "FROM Topic WHERE code = :code AND parentTopic IS NULL";
        List<Topic> topics = session.createQuery(hql, Topic.class)
                .setParameter("code", parentTopic)
                .getResultList();

        List<Article> articles = null;
        if (!topics.isEmpty() && (childTopic != null && !childTopic.isBlank())) {
            Optional<Topic> child = topics.get(0).getChildTopics()
                    .stream().filter(cTopic -> cTopic.getCode().equalsIgnoreCase(childTopic)).findFirst();
            articles = child.isPresent() ? child.get().getArticles() : null;
            if (articles != null) {
                articles.forEach(a -> Hibernate.unproxy(a));
            }
        }
        return articles;
    }

    @Override
    public Article findOne(String parentTopic, String childTopic, String code) {

        Session session = sessionFactory.getCurrentSession();
        String hql = "FROM Topic WHERE code = :code";
        List<Topic> topics = session.createQuery(hql, Topic.class)
                .setParameter("code", childTopic)
                .getResultList();
        Topic child = topics.isEmpty() ? null : topics.get(0);
        if (topics.size() > 1) {
            child = topics.stream().filter(t -> t.getParentTopic().getCode().equalsIgnoreCase(parentTopic)).findAny()
                    .get();
        }
        Article article = child == null ? null
                : child.getArticles().stream().filter(a -> a.getCode().equalsIgnoreCase(code)).findAny().get();
        return article;
    }

    @Override
    public List<Article> findByWriterId(long writerId) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "FROM Article a WHERE a.writer.writerId = :writerId ORDER BY a.articleId DESC";
        List<Article> articles = session.createQuery(hql, Article.class)
                .setParameter("writerId", writerId)
                .getResultList();
        return articles;
    }

    @Override
    public void hideArticle(String code) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "UPDATE Article SET deleted = true WHERE code = :code";
        session.createQuery(hql)
                .setParameter("code", code)
                .executeUpdate();
    }

    @Override
    public List<Article> findLatestArticles(int limit) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "FROM Article a ORDER BY a.createdDate DESC";
        List<Article> articles = session.createQuery(hql, Article.class)
                .setMaxResults(limit)
                .getResultList();
        return articles;
    }
}
