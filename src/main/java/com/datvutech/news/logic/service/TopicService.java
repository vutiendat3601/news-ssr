package com.datvutech.news.logic.service;

import java.util.List;

import com.datvutech.news.logic.dto.TopicDto;

public interface TopicService {
    List<TopicDto> getAllParentTopics();

    List<TopicDto> getAllChildTopics(String parentCode);
}
