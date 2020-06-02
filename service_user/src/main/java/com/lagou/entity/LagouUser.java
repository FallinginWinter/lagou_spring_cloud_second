package com.lagou.entity;

import java.io.Serializable;

/**
 * (LagouUser)实体类
 *
 * @author makejava
 * @since 2020-05-26 22:47:13
 */
public class LagouUser implements Serializable {
    private static final long serialVersionUID = -35238350352497764L;
    
    private Long id;
    
    private String email;
    
    private String password;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}