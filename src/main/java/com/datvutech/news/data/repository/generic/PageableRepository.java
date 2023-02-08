package com.datvutech.news.data.repository.generic;

import com.datvutech.news.data.pagination.PageResponse;
import com.datvutech.news.data.pagination.Pageable;

public interface PageableRepository<T> extends GenericRepository<T> {
    PageResponse<T> findAll(Pageable page);
}
