package com.dwj.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import lombok.Data;

import javax.persistence.Table;
import java.util.Date;

@Data
@ExcelTarget("user")
@Table(name="user")
public class User {
    @Excel(name = "编号",orderNum = "1")
    private Integer id;
    @Excel(name = "姓名",orderNum = "3")
    private String name;
    @Excel(name = "生日",orderNum = "4")
    private Date bir;
    @Excel(name = "爱好",orderNum = "5")
    private String hobbys;
    @Excel(name = "身份证号",orderNum = "6")
    private String no;
    @Excel(name = "头像",orderNum = "2",type = 2)
    private String photo;
    @Excel(name = "地址",orderNum = "7")
    private String address;
}
