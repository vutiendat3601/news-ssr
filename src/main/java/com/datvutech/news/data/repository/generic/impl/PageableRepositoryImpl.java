package com.datvutech.news.data.repository.generic.impl;

import java.util.List;

import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.datvutech.news.data.entity.type.AbstractEntity;
import com.datvutech.news.data.pagination.PageResponse;
import com.datvutech.news.data.pagination.Pageable;
import com.datvutech.news.data.repository.generic.PageableRepository;
import com.datvutech.news.data.sort.Sorter;

public class PageableRepositoryImpl<T extends AbstractEntity>
        extends GenericRepositoryImpl<T>
        implements PageableRepository<T> {

    public PageableRepositoryImpl(Class<T> typeClass) {
        super(typeClass);
    }

    @Override
    public PageResponse<T> findAll(Pageable page) {
        Session session = sessionFactory.getCurrentSession();
        PageResponse<T> pageResponse = new PageResponse<>();
        StringBuilder sql = new StringBuilder("FROM " + typeClass.getSimpleName());
        long count = 0;
        Sorter sorter = page.getSorter();
        if (sorter != null) {
            sql.append(" ORDER BY " + sorter.getSortBy());
            sql.append(" " + sorter.getSortType());
        }
        Query<T> query = session.createQuery(sql.toString(), typeClass);
        ScrollableResults cursor = query.scroll();
        cursor.last();
        count = cursor.getRowNumber() + 1;
        cursor.close();
        List<T> result = query.setFirstResult(page.getOffset())
                .setMaxResults(page.getLimit())
                .getResultList();
        pageResponse.setCount(count);
        pageResponse.setResult(result);
        return pageResponse;
    }
}
