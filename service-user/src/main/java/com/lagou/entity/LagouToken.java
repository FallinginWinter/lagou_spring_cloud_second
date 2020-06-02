package com.lagou.entity;

import java.io.Serializable;

/**
 * (LagouToken)实体类
 *
 * @author makejava
 * @since 2020-05-26 23:15:12
 */
public class LagouToken implements Serializable {
    private static final long serialVersionUID = -95550162314206567L;
    /**
    * 自增主键 
    */
    private Integer id;
    /**
    * 邮箱地址
    */
    private String email;
    /**
    * 令牌
    */
    private String token;


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

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}