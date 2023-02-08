package com.datvutech.news.data.pagination;

import com.datvutech.news.data.sort.Sorter;

public class PageRequest implements Pageable {

    private Sorter sorter;
    private int max;
    private int page;

    private PageRequest() {
    }

    @Override
    public int getPage() {
        return page;
    }

    @Override
    public int getLimit() {
        return max;
    }

    @Override
    public int getOffset() {
        return (page - 1) * max;
    }

    public static Pageable of(int page, int max, Sorter sorter) {
        PageRequest pageRequest = new PageRequest();
        pageRequest.sorter = sorter;
        pageRequest.max = max;
        pageRequest.page = page;
        return pageRequest;
    }

    @Override
    public Sorter getSorter() {
        return sorter;
    }

}
