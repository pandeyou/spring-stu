/*
 * Copyright 2013-2018 Smartdot Technologies Co., Ltd. All rights reserved.
 * SMARTDOT PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 */
package com.pandy.grc.bpm.def.security.user.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
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
    public com.pandy.grc.bpm.def.security.user.vo.User addUser(com.pandy.grc.bpm.def.security.user.vo.User user) {
        return wrap(userDao.save(unwrap(user)));
    }

    @Override
    @Cacheable(value = "user", key = "'user_'.concat(#id.toString())")
    public com.pandy.grc.bpm.def.security.user.vo.User findUserById(long id) {
        Optional<User> user = userDao.findById(id);
        return user.map(e -> wrap(e)).orElse(null);
    }

    @Override
    @CacheEvict(value = "user", key = "'user_'.concat(#id.toString())")
	public void removeUserById(long id) {
    	userDao.deleteById(id);
	}

	@Override
	@CacheEvict(value = "user", key = "'user_'.concat(#user.id.toString())")
	public void removeUser(com.pandy.grc.bpm.def.security.user.vo.User user) {
		userDao.delete(unwrap(user));
	}

	@Override
	@CacheEvict(value = "user", key = "'user_'.concat(#user.id.toString())")
	public void updateUser(com.pandy.grc.bpm.def.security.user.vo.User user) {
		userDao.save(unwrap(user));
	}

	private com.pandy.grc.bpm.def.security.user.vo.User wrap(User user){
        com.pandy.grc.bpm.def.security.user.vo.User userVo = new com.pandy.grc.bpm.def.security.user.vo.User();
        userVo.setId(user.getId());
        userVo.setLastname(user.getLastname());
        
        return userVo;
    }
    
    private User unwrap(com.pandy.grc.bpm.def.security.user.vo.User userVo) {
        User user = new User();
        user.setId(userVo.getId());
        user.setLastname(userVo.getLastname());
        
        return user;
    }
}

