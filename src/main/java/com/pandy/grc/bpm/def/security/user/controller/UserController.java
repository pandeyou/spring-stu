/*
 * Copyright 2013-2018 Smartdot Technologies Co., Ltd. All rights reserved.
 * SMARTDOT PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 */
package com.pandy.grc.bpm.def.security.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pandy.grc.bpm.def.security.user.entity.User;
import com.pandy.grc.bpm.def.security.user.service.UserService;

/**
 * <p>
 * 
 * @author <a href="mailto:pandy@smartdot.com">xxx</a>
 * @version 1.0, 2018年11月16日
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    
    @RequestMapping("/save")
    @ResponseBody
    public User save() {
        User user = new User();
        user.setLastname("pandy");
        return userService.addUser(user);
    }
    
    @RequestMapping("/find/{id}")
    @ResponseBody
    public User find(@PathVariable Long id) {
        
        return userService.findUserById(id);
    }
}

