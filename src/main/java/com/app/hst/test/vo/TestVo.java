package com.app.hst.test.vo;

import com.app.hst.common.base.vo.BaseVo;

public class TestVo extends BaseVo {
    private String name;
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
