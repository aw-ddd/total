package com.dwj.prototype.expand;

//圆和正方形的接口
public interface Shape extends Cloneable{
    //克隆
    Object clone();

    //计算面积
    void calculation();
}
