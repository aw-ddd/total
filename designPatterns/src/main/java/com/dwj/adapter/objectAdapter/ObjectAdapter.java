package com.dwj.adapter.objectAdapter;

//对象适配器类(通过将适配器类注入该对象适配器类的方式，完成方法的调用)
public class ObjectAdapter implements Target{
    private Adapter adapter;

    public ObjectAdapter(Adapter adapter){
        this.adapter = adapter;
    }

    public void request() {
        adapter.specificRequest();
    }
}
