package com.dwj.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import lombok.Data;

@ExcelTarget("card")
@Data
public class Card {
    @Excel(name="身份证号码",orderNum = "100")
    private String no;
    @Excel(name="家庭地址",orderNum = "101")
    private String address;
}
