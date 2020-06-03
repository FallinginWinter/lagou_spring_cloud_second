package com.lagou.common;

import lombok.*;

import java.io.Serializable;

/**
 * @Author: lihaonan
 * @Date: 2020/6/2
 */
@Setter
@Getter
@ToString
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

    public boolean isSuccess() {
        return getRetCode() == 0;
    }

}
