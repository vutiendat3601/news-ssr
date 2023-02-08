package com.datvutech.news.presentation.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.datvutech.news.logic.dto.TopicDto;
import com.datvutech.news.logic.service.TopicService;

@RestController
@RequestMapping("/api/topics")
@CrossOrigin
public class TopicApi {

    @Autowired
    private TopicService topicService;

    @GetMapping("/all-parent")
    public List<TopicDto> getAllParentTopics() {
        List<TopicDto> topicDtos = topicService.getAllParentTopics();
        return topicDtos;
    }

    @GetMapping("/{parent}/all-children")
    public List<TopicDto> getAllChildTopics(@PathVariable("parent") String parent) {
        List<TopicDto> topicDtos = topicService.getAllChildTopics(parent);
        return topicDtos;
    }
}
