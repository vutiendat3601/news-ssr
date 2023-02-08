package com.datvutech.news.data.sort;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class SortBy {
    private String field;
    private SortType sortType;
}
