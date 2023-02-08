package com.datvutech.news.data.repository.generic;

import java.util.List;

public interface GenericRepository<T> {

    List<T> findAll();

    long countAll();

    void insert(T entity);

    void update(T entity);

    void delete(T entity);
}
