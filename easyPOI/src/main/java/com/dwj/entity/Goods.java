package com.dwj.entity;

import cn.afterturn.easypoi.excel.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Data
@ExcelTarget("goods")
public class Goods implements Serializable {

    @Excel(name = "编号")
    private Integer goodsId;
    //orderNum默认为0，数值越大该列越靠前，需要注意的是该值是String类型
    @Excel(name = "商品名称", orderNum = "1")
    private String goodsName;
    @Excel(name = "商品价格", orderNum = "3", suffix = "元")
    private BigDecimal goodsPrice;
    @Excel(name = "商品数量", orderNum = "2")
    private Integer goodsNumber;
    @Excel(name = "商品重量")
    private Integer goodsWeight;
    @Excel(name = "类型ID")
    private Integer catId;
    @Excel(name = "商品详情介绍")
    private String goodsIntroduce;
    //replace中的 _ 的前一部分表示替换成的值，后一部分表示需要替换的值
    @Excel(name = "热卖数量", replace = {"激活_1000"})
    private Integer hotNumber;

    //测试导出数组
    @ExcelIgnore
    private List<String> hobby;
    @Excel(name = "爱好" ,width = 50.0)
    private String hobbys;

    //测试导出单个对象
    @ExcelEntity
    private Card card;

    //测试一对多导出
    @ExcelCollection(name="订单列表")
    private List<Order> orderList;

    //测试图片导出
    //type默认为1，为文本导出，2则为图片导出，imageType默认也为1，根据图片路径导出，2为根据图片的二级制数组导出
    @Excel(name="图片",type = 2,width = 20,imageType = 1)
    private String photo;

    public String getHobbys() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < hobby.size(); i++) {
            sb.append(hobby.get(i) + "-");
        }
        return sb.toString();
    }

}
