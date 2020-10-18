package com.dwj.adapter.classAdapter;

//类适配器类（实现目标接口，同时继承任务类）
public class ClassAdapter extends Adapter implements Target{
    public void request() {
        //适配者接口中提供的方法
        specificRequest();
    }
}
