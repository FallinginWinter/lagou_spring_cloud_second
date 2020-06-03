package com.lagou.entity;

import java.io.Serializable;

/**
 * (LagouAuthCode)实体类
 *
 * @author makejava
 * @since 2020-05-25 20:34:40
 */
public class LagouAuthCode implements Serializable {
    private static final long serialVersionUID = 263866638499179984L;
    /**
    * 自增主键
    */
    private Integer id;
    /**
    * 邮箱地址
    */
    private String email;
    /**
    * 验证码
    */
    private String code;
    /**
    * 创建时间
    */
    private long createtime;
    /**
    * 过期时间
    */
    private long expiretime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public long getCreatetime() {
        return createtime;
    }

    public void setCreatetime(long createtime) {
        this.createtime = createtime;
    }

    public long getExpiretime() {
        return expiretime;
    }

    public void setExpiretime(long expiretime) {
        this.expiretime = expiretime;
    }

}