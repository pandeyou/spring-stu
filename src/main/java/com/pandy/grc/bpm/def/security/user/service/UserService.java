/*
 * Copyright 2013-2018 Smartdot Technologies Co., Ltd. All rights reserved.
 * SMARTDOT PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 */
package com.pandy.grc.bpm.def.security.user.service;

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
    public com.pandy.grc.bpm.def.security.user.vo.User addUser(com.pandy.grc.bpm.def.security.user.vo.User user);
    
    /**
     * 
     * @return
     */
    public com.pandy.grc.bpm.def.security.user.vo.User findUserById(long id);
    
    /**
     * 
     * @param id
     */
    public void removeUserById(long id);
    
    /**
     * 
     * @param user
     */
    public void removeUser(com.pandy.grc.bpm.def.security.user.vo.User user);
    
    /**
     * 
     * @return
     */
    public void updateUser(com.pandy.grc.bpm.def.security.user.vo.User user);
    
    
}

