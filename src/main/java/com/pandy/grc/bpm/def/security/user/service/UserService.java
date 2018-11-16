/*
 * Copyright 2013-2018 Smartdot Technologies Co., Ltd. All rights reserved.
 * SMARTDOT PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 */
package com.pandy.grc.bpm.def.security.user.service;

import com.pandy.grc.bpm.def.security.user.entity.User;

/**
 * <p>
 * 
 * @author <a href="mailto:pandy@smartdot.com">xxx</a>
 * @version 1.0, 2018年11月16日
 */
public interface UserService {

    /**
     * 
     * @return
     */
    public User addUser(User user);
    
    /**
     * 
     * @return
     */
    public User findUserById(Long id);
}

