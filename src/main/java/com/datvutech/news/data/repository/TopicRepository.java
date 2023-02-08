package com.datvutech.news.data.repository;

import java.util.List;

import com.datvutech.news.data.entity.Topic;
import com.datvutech.news.data.repository.generic.GenericRepository;

public interface TopicRepository extends GenericRepository<Topic> {
    List<Topic> findAllParentTopics();

    List<Topic> findAllChildTopics(String parentCode);

    Topic findOneParent(String code);

    Topic findOne(String parentCode,String code);
}
