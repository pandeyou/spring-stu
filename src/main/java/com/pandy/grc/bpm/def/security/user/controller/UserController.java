/*
 * Copyright 2013-2018 Smartdot Technologies Co., Ltd. All rights reserved.
 * SMARTDOT PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 */
package com.pandy.grc.bpm.def.security.user.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    @Transactional
    public com.pandy.grc.bpm.def.security.user.vo.User save(com.pandy.grc.bpm.def.security.user.vo.User user) {
        return userService.addUser(user);
    }
    
    @RequestMapping("/find/{id}")
    @ResponseBody
    @Transactional
    public com.pandy.grc.bpm.def.security.user.vo.User find(@PathVariable Long id) {
        return userService.findUserById(id);
    }
    
    @RequestMapping("/manager")
    public String manager() {
        return "view/user/manager";
    }
    
}

