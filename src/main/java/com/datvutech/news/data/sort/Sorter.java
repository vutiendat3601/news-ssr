package com.datvutech.news.data.sort;

import lombok.Getter;

@Getter
public class Sorter {
    private String sortBy;
    private SortType sortType;

    public Sorter(String column) {
        this.sortType = SortType.ASC;
    }

    public Sorter(String column, SortType type) {
        this.sortBy = column;
        this.sortType = type;
    }

}
