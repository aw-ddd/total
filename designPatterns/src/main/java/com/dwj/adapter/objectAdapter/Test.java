package com.dwj.adapter.objectAdapter;

public class Test {
    public static void main(String[] args) {
        Adapter adapter = new Adapter();
        Target objectAdapter = new ObjectAdapter(adapter);
        objectAdapter.request();
    }
}
