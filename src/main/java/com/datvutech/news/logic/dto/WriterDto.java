package com.datvutech.news.logic.dto;

import java.util.Set;

import com.datvutech.news.data.entity.User;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class WriterDto {
    private Long writerId;

    private String nickname;

    /* Begin: References */
    private User user;

    private Set<ArticleDto> articles;
    /* End: References */
}
