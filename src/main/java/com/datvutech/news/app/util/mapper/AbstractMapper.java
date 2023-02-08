package com.datvutech.news.app.util.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractMapper {
    @Autowired
    protected ModelMapper mapper;
}
