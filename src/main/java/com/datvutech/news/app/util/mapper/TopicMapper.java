package com.datvutech.news.app.util.mapper;

import org.springframework.stereotype.Component;

import com.datvutech.news.data.entity.Topic;
import com.datvutech.news.logic.dto.TopicDto;

@Component
public class TopicMapper extends AbstractMapper {
    public TopicDto topicEntityToDto(Topic topic) {
        TopicDto topicDto = mapper.map(topic, TopicDto.class);
        return topicDto;
    }
}
