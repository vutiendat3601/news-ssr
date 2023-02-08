package com.datvutech.news.data.pagination;

import com.datvutech.news.data.sort.Sorter;

public interface Pageable {

    int getPage();

    int getLimit();

    int getOffset();

    Sorter getSorter();
}
