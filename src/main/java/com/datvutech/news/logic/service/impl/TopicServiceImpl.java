package com.datvutech.news.logic.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.datvutech.news.app.util.mapper.TopicMapper;
import com.datvutech.news.data.entity.Topic;
import com.datvutech.news.data.repository.TopicRepository;
import com.datvutech.news.logic.dto.TopicDto;
import com.datvutech.news.logic.service.TopicService;

@Service
public class TopicServiceImpl implements TopicService {

    @Autowired
    private TopicRepository topicRepo;

    @Autowired
    private TopicMapper topicMapper;

    @Override
    public List<TopicDto> getAllParentTopics() {
        List<Topic> topics = topicRepo.findAllParentTopics();
        List<TopicDto> topicDtos = new ArrayList<>();
        topics.forEach(t -> {
            TopicDto topicDto = topicMapper.topicEntityToDto(t);
            topicDtos.add(topicDto);
        });
        return topicDtos;
    }

    @Override
    public List<TopicDto> getAllChildTopics(String parentCode) {
        List<Topic> topics = topicRepo.findAllChildTopics(parentCode);
        List<TopicDto> topicDtos = new ArrayList<>();
        topics.forEach(t -> {
            TopicDto topicDto = topicMapper.topicEntityToDto(t);
            topicDtos.add(topicDto);
        });
        return topicDtos;
    }

}
