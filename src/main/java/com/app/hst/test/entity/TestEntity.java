package com.app.hst.test.entity;

import com.app.hst.common.base.entity.BaseEntiry;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "tbl_test")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class TestEntity extends BaseEntiry implements Serializable {

    private String name;

    private String email;

    @Basic
    @Column(name = "name",length = 20)
    public String getName(){
        return name;
    }

    @Basic
    @Column(name = "email",length = 50)
    public String getEmail(){
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
