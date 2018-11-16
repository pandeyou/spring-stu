/*
 * Copyright 2013-2018 Smartdot Technologies Co., Ltd. All rights reserved.
 * SMARTDOT PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 */
package com.pandy.grc.bpm.def.security.user.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pandy.grc.bpm.def.security.user.dao.UserDao;
import com.pandy.grc.bpm.def.security.user.entity.User;
import com.pandy.grc.bpm.def.security.user.service.UserService;

/**
 * <p>
 * 
 * @author <a href="mailto:pandy@smartdot.com">xxx</a>
 * @version 1.0, 2018年11月16日
 */
@Service
public class UserServiceImpl implements UserService{

    private final UserDao userDao;
    
    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }
    
    @Override
    public User addUser(User user) {
        return userDao.save(user);
    }

    @Override
    public User findUserById(Long id) {
        Optional<User> user = userDao.findById(id);
        return user.orElse(null);
    }

}

