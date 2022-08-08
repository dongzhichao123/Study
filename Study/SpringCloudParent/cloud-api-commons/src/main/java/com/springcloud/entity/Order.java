package com.springcloud.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class Order {
    @ExcelProperty("序号")
    private int id;

}
