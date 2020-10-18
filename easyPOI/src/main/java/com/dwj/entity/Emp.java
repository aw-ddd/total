package com.dwj.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import lombok.Data;

import java.util.Date;

@Data
@ExcelTarget("emps")
public class Emp {

    @Excel(name="编号")
    private Integer id;
    @Excel(name="姓名")
    private String name;
    @Excel(name="性别",replace = {"男_1","女_0"})
    private Integer sex;
    @Excel(name="生日",format = "yyyy/MM/dd HH:mm:ss")
    private Date bir;
    @Excel(name="住址")
    private String address;
}
