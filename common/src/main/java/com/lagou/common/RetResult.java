package com.lagou.common;

import com.alibaba.fastjson.JSON;
import lombok.*;

import java.io.Serializable;

/**
 * @Author: lihaonan
 * @Date: 2020/6/2
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RetResult<T> implements Serializable {

    private int retCode;

    private String retInfo;

    private T result;

    public static final RetResult SUCCESS = new RetResult<>();

    public RetResult(T result) {
        setResult(result);
    }

    public RetResult(int retCode) {
        setRetCode(retCode);
    }

    public RetResult(int retCode, String retInfo) {
        this.retCode = retCode;
        this.retInfo = retInfo;
    }

    public boolean isSuccess() {
        return getRetCode() == 0;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
