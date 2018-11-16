/*
 * Copyright 2013-2018 Smartdot Technologies Co., Ltd. All rights reserved.
 * SMARTDOT PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 */
package com.pandy.grc.bpm.app.ba.tree.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * <p>
 * 
 * @author <a href="mailto:pandy@smartdot.com">xxx</a>
 * @version 1.0, 2018年11月16日
 */
@Entity
@Table(name = "BPM_TREE")
public class Tree {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    Long id;

    @Column(name = "LAST_NAME")
    String lastname;
}

