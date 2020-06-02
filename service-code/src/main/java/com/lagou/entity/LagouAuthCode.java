package com.lagou.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (LagouAuthCode)实体类
 *
 * @author makejava
 * @since 2020-05-26 23:04:46
 */
public class LagouAuthCode implements Serializable {
    private static final long serialVersionUID = 734101204079836998L;
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
    private Date createtime;
    /**
    * 过期时间
    */
    private Date expiretime;


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

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getExpiretime() {
        return expiretime;
    }

    public void setExpiretime(Date expiretime) {
        this.expiretime = expiretime;
    }

}