package com.datvutech.news.logic.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ArticleDto {
    private Long articleId;

    private String title;

    private String code;

    private String formatedCreatedDate;

    private String shortDescription;

    private String content;

    private String thumbnail;

    /* Begin: References */
    private WriterDto writer;

    private RegionDto region;

    private TopicDto topic;
    /* End: References */

    /* Begin: Bussiness */
    private String parentTopicCode;
    /* End: Bussiness */
}
