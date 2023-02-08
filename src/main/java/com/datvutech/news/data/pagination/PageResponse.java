package com.datvutech.news.data.pagination;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PageResponse<T> {
    private long count;
    private List<T> result;
}
