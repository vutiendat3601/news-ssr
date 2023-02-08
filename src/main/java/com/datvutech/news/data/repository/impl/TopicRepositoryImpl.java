package com.datvutech.news.data.repository.impl;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.datvutech.news.data.entity.Topic;
import com.datvutech.news.data.repository.TopicRepository;
import com.datvutech.news.data.repository.generic.impl.GenericRepositoryImpl;

@Repository
public class TopicRepositoryImpl
        extends GenericRepositoryImpl<Topic>
        implements TopicRepository {

    public TopicRepositoryImpl() {
        super(Topic.class);
    }

    @Override
    public List<Topic> findAllParentTopics() {

        List<Topic> topics = null;
        Session session = sessionFactory.getCurrentSession();

        String hql = "FROM Topic t WHERE t.parentTopic IS NULL ORDER BY t.createdDate";

        topics = session.createQuery(hql, Topic.class)
                .getResultList();

        return topics;
    }

    @Override
    public List<Topic> findAllChildTopics(String parentCode) {
        List<Topic> topics = null;
        Session session = sessionFactory.getCurrentSession();

        String hql = "FROM Topic t WHERE t.parentTopic.code = :parentCode";

        topics = session.createQuery(hql, Topic.class)
                .setParameter("parentCode", parentCode)
                .getResultList();
        return topics;
    }

    @Override
    public Topic findOneParent(String code) {

        Session session = sessionFactory.getCurrentSession();

        String hql = "FROM Topic t WHERE t.code = :code AND t.parentTopic IS NULL";
        List<Topic> topics = session.createQuery(hql, Topic.class)
                .setParameter("code", code)
                .getResultList();
        return topics.isEmpty() ? null : topics.get(0);
    }

    @Override
    public Topic findOne(String parentCode, String code) {
        Session session = sessionFactory.getCurrentSession();

        String hql = "FROM Topic t WHERE t.code = :code AND t.parentTopic.code = :parentCode";
        List<Topic> topics = session.createQuery(hql, Topic.class)
                .setParameter("code", code)
                .setParameter("parentCode", parentCode)
                .getResultList();
        return topics.isEmpty() ? null : topics.get(0);
    }
}
