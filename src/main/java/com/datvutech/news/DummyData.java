package com.datvutech.news;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import com.datvutech.news.data.entity.Article;
import com.datvutech.news.data.entity.Region;
import com.datvutech.news.data.entity.Topic;
import com.datvutech.news.data.entity.User;
import com.datvutech.news.data.repository.ArticleRepository;
import com.datvutech.news.data.repository.RegionRepository;
import com.datvutech.news.data.repository.TopicRepository;
import com.datvutech.news.data.repository.UserRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DummyData {

    public static void createUser(UserRepository userRepo) {
        URL topicURL = DummyData.class.getClassLoader().getResource("dummy/user.json");
        try {
            Path path = Paths.get(topicURL.toURI());
            BufferedReader br = new BufferedReader(Files.newBufferedReader(path));
            StringBuilder data = new StringBuilder();
            String line = "";
            while ((line = br.readLine()) != null) {
                data.append(line + "\n");
            }
            List<User> users = new ObjectMapper().readValue(data.toString(), new TypeReference<List<User>>() {
            });
            users.forEach(t -> {
                userRepo.insert(t);
            });
            System.out.println(data.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    public static void createTopic(TopicRepository topicRepo) {
        URL topicURL = DummyData.class.getClassLoader().getResource("dummy/topic.json");
        try {
            Path path = Paths.get(topicURL.toURI());
            BufferedReader br = new BufferedReader(Files.newBufferedReader(path));
            StringBuilder data = new StringBuilder();
            String line = "";
            while ((line = br.readLine()) != null) {
                data.append(line + "\n");
            }
            List<Topic> topics = new ObjectMapper().readValue(data.toString(), new TypeReference<List<Topic>>() {
            });
            topics.forEach(t -> {
                topicRepo.insert(t);
            });
            System.out.println(data.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    public static void createRegion(RegionRepository regionRepo) {
        URL topicURL = DummyData.class.getClassLoader().getResource("dummy/region.json");
        try {
            Path path = Paths.get(topicURL.toURI());
            BufferedReader br = new BufferedReader(Files.newBufferedReader(path));
            StringBuilder data = new StringBuilder();
            String line = "";
            while ((line = br.readLine()) != null) {
                data.append(line + "\n");
            }
            List<Region> regions = new ObjectMapper().readValue(data.toString(), new TypeReference<List<Region>>() {
            });
            regions.forEach(t -> {
                regionRepo.insert(t);
            });
            System.out.println(data.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    public static void createArticle(ArticleRepository articleRepo) {
        URL topicURL = DummyData.class.getClassLoader().getResource("dummy/article.json");
        try {
            Path path = Paths.get(topicURL.toURI());
            BufferedReader br = new BufferedReader(Files.newBufferedReader(path));
            StringBuilder data = new StringBuilder();
            String line = "";
            while ((line = br.readLine()) != null) {
                data.append(line + "\n");
            }
            List<Article> articles = new ObjectMapper().readValue(data.toString(), new TypeReference<List<Article>>() {
            });
            articles.forEach(t -> {
                articleRepo.insert(t);
            });
            System.out.println(data.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
