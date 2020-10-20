package com.dwj.composite.normal;

import java.util.ArrayList;

//树枝构件
public class Composite implements Component{
    private ArrayList<Component> list = new ArrayList<Component>();

    public void add(Component component) {
        list.add(component);
    }

    public void remove(Component component) {
        list.remove(component);
    }

    public Component getChild(int i) {
        return list.get(i);
    }

    public void operation() {
        for (Component component : list) {
            component.operation();
        }
    }
}
