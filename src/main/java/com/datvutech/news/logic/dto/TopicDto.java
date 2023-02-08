package com.datvutech.news.logic.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class TopicDto {

    private Long topicId;

    private String name;

    private String code;

    private String description;

    /* Begin: References */
    @JsonIgnore
    private List<TopicDto> childTopics;

    private TopicDto parentTopic;
    /* End: References */

    /* Begin: Bussiness */
    // private Long parentId;
    /* End: Bussiness */
}
