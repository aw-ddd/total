package com.dwj.composite.normal;

//抽象构建
public interface Component {
    void add(Component component);
    void remove(Component component);
    Component getChild(int i);
    void operation();
}
