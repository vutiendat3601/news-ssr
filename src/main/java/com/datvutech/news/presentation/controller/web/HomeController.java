package com.datvutech.news.presentation.controller.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.datvutech.news.logic.dto.ArticleDto;
import com.datvutech.news.logic.dto.TopicDto;
import com.datvutech.news.logic.service.ArticleService;
import com.datvutech.news.logic.service.TopicService;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private TopicService topicService;

    @GetMapping
    public String home(Model model) {
        List<TopicDto> parentTopics = topicService.getAllParentTopics();
        model.addAttribute("parentTopics", parentTopics);
        model.addAttribute("currentTopic", new TopicDto());
        List<ArticleDto> articleDtos = articleService.getLatestArticles(10);

        model.addAttribute("articles", articleDtos);
        return "web/overview";
    }

    @GetMapping({ "{parentTopic}", "{parentTopic}/{childTopic}" })
    public String home(Model model,
            @PathVariable(value = "parentTopic") String parentTopic,
            @PathVariable(value = "childTopic", required = false) String childTopic) {

        List<TopicDto> parentTopics = topicService.getAllParentTopics();
        List<ArticleDto> articleDtos = articleService.getArticles(parentTopic, childTopic);
        Optional<TopicDto> currentTopicOptional = parentTopics
                .stream().filter(t -> t.getCode().equalsIgnoreCase(parentTopic)).findAny();
        TopicDto currentTopic = currentTopicOptional.isPresent() ? currentTopicOptional.get() : null;

        model.addAttribute("parentTopics", parentTopics);
        model.addAttribute("currentTopic", currentTopic);

        model.addAttribute("articles", articleDtos);
        return "web/overview";
    }
}
