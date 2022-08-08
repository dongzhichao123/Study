package com.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonResult<T> {
    private Integer code;
    private String messsage;
    private T data;

    public CommonResult(Integer code, String messsage) {
        this(code, messsage, null);
    }
}
