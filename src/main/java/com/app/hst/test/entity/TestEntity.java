package com.app.hst.test.entity;

import com.app.hst.common.base.entity.BaseEntiry;

import javax.persistence.Basic;
import javax.persistence.Column;

//@Entity
//@Table(name = "test")
//@Setter
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class TestEntity extends BaseEntiry {
    private String name;

    @Basic
    @Column(name = "name",length = 20)
    public String getName(){
        return name;
    }
}
