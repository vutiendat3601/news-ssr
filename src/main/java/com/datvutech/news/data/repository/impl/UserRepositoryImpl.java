package com.datvutech.news.data.repository.impl;

import org.springframework.stereotype.Repository;

import com.datvutech.news.data.entity.User;
import com.datvutech.news.data.repository.UserRepository;
import com.datvutech.news.data.repository.generic.impl.PageableRepositoryImpl;

@Repository
public class UserRepositoryImpl
        extends PageableRepositoryImpl<User> implements UserRepository {
    public UserRepositoryImpl() {
        super(User.class);
    }
}
