package com.lagou.common;

import lombok.*;

/**
 * @Author: lihaonan
 * @Date: 2020/6/2
 */
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RetResult<T> {

    private int retCode;

    private String retInfo;

    private T result;

    private static final RetResult SUCCESS = new RetResult<>();

}
