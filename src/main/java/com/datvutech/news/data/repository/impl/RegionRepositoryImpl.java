package com.datvutech.news.data.repository.impl;

import org.springframework.stereotype.Repository;

import com.datvutech.news.data.entity.Region;
import com.datvutech.news.data.repository.RegionRepository;
import com.datvutech.news.data.repository.generic.impl.GenericRepositoryImpl;

@Repository
public class RegionRepositoryImpl extends GenericRepositoryImpl<Region>
        implements RegionRepository {

    protected RegionRepositoryImpl() {
        super(Region.class);
    }

}
