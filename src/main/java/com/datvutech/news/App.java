package com.datvutech.news;

import java.util.List;

import org.hibernate.dialect.MySQL8Dialect;
import org.hibernate.dialect.MySQLDialect;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.datvutech.news.app.config.RootConfig;
import com.datvutech.news.data.entity.Article;
import com.datvutech.news.data.repository.ArticleRepository;
import com.datvutech.news.data.repository.RegionRepository;
import com.datvutech.news.data.repository.TopicRepository;
import com.datvutech.news.data.repository.UserRepository;
import com.datvutech.news.logic.dto.ArticleDto;
import com.datvutech.news.logic.dto.TopicDto;
import com.datvutech.news.logic.service.ArticleService;
import com.datvutech.news.logic.service.TopicService;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(RootConfig.class);
        // init(app);
        // Repositories
        // ArticleRepository articleRepo = app.getBean(ArticleRepository.class);
        // TopicRepository topicRepo = app.getBean(TopicRepository.class);
        
        // Services
        // ArticleService articleService = app.getBean(ArticleService.class);
        // TopicService topicService = app.getBean(TopicService.class);

        // List<TopicDto> topicDtos = topicService.getAllChildTopics("thoi-su");
        // articleService.deleteArticle("messi-vo-dich-world-cup-o-gan-cuoi-su-nghiep-la-dep-nhat");
        System.out.println("PAUSE");
        app.close();
    }

    protected static void init(AnnotationConfigApplicationContext app) {
        UserRepository userRepo = app.getBean(UserRepository.class);
        TopicRepository topicRepo = app.getBean(TopicRepository.class);
        RegionRepository regionRepo = app.getBean(RegionRepository.class);
        ArticleRepository articleRepo = app.getBean(ArticleRepository.class);

        DummyData.createUser(userRepo);
        DummyData.createTopic(topicRepo);
        DummyData.createRegion(regionRepo);
        DummyData.createArticle(articleRepo);
    }
}
