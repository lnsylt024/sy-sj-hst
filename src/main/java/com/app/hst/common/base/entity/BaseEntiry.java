package com.app.hst.common.base.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
public class BaseEntiry implements Serializable {
    /* 主键 */
    private long id;
    /* 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(example = "2020-10-05 23:23:59")
    private Date createTime;
    /* 更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(example = "2020-10-05 23:23:59")
    private Date updateTime;
    /* 有效标识 */
    private Integer del = 0;
    /* 创建者 */
    private String createUser;
    /* 更新者 */
    private String updateUser;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id",columnDefinition = "int(32) COMMENT '主键'",nullable = false)
    public long getId() {
        return id;
    }

    @Basic
    @Column(name = "create_time", columnDefinition="timestamp not null default current_timestamp COMMENT '创建时间' ", insertable = false, updatable = false)
    public Date getCreateTime() {
        return createTime;
    }

    @Basic
    @Column(name = "update_time", columnDefinition="timestamp not null default current_timestamp on update current_timestamp COMMENT '更新日期'", insertable = false)
    public Date getUpdateTime() {
        return updateTime;
    }

    @Basic
    @Column(name = "del", columnDefinition = "tinyint not null default 0 COMMENT '删除标记 0 未删除 1已删除'")
    public Integer getDel() {
        return del;
    }

    @Basic
    @Column(name = "create_user", columnDefinition = "varchar(10) not null COMMENT '创建者ID'")
    public String getCreateUser() {
        return createUser;
    }

    @Basic
    @Column(name = "update_user", columnDefinition = "varchar(10) not null COMMENT '更新者ID'")
    public String getUpdateUser() {
        return updateUser;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public void setDel(Integer del) {
        this.del = del;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }
}
