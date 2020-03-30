/*
 * Copyright 2013-2018 Smartdot Technologies Co., Ltd. All rights reserved.
 * SMARTDOT PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 */
package com.pandy.grc.bpm.def.security.user.vo;

import java.io.Serializable;

/**
 * <p>
 * 
 * @author <a href="mailto:pandy@smartdot.com">xxx</a>
 * @version 1.0, 2018年11月16日
 */
public class User implements Serializable{
    /**
     * 
     */
    private static final long serialVersionUID = 7666292859962267486L;

    public User() {
        super();
    }

    public User(Long id, String lastname) {
        super();
        this.id = id;
        this.lastname = lastname;
    }

    Long id;
    
    String lastname;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    
    @Override
    public String toString() {
        return "User [id=" + id + ", lastname=" + lastname + "]";
    }
}

