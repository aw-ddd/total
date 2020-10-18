package com.dwj.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@ExcelTarget("orders")
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Excel(name="订单编号")
    private String no;
    @Excel(name="订单名称")
    private String name;
}
