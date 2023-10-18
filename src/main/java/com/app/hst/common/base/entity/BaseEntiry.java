package com.app.hst.common.base.entity;

import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
@Setter
public class BaseEntiry implements Serializable {
    /* 主键 */
    private long id;
    /* 创建时间 */
    private Date createTime;
    /* 更新时间 */
    private Date updateTime;
    /* 有效标识 */
    private Integer del = 0;
    /* 创建者 */
    private long createUser;
    /* 更新者 */
    private long updateUser;

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
    @Column(name = "update_time", columnDefinition="timestamp not null default current_timestamp on update current_timestamp COMMENT '更新日期'", insertable = false, updatable = false)
    public Date getUpdateTime() {
        return updateTime;
    }

    @Basic
    @Column(name = "del", columnDefinition = "int(1) not null default 0 COMMENT '删除标记 0 未删除 1已删除'")
    public Integer getDel() {
        return del;
    }

    @Basic
    @Column(name = "create_user", columnDefinition = "int(11) not null default 0 COMMENT '创建者ID'")
    public long getCreateUser() {
        return createUser;
    }

    @Basic
    @Column(name = "update_user", columnDefinition = "int(11) COMMENT '更新者ID'")
    public long getUpdateUser() {
        return updateUser;
    }
}
