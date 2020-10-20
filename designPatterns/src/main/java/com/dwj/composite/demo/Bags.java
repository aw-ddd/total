package com.dwj.composite.demo;

import java.util.ArrayList;

//袋子（树枝构件）
public class Bags implements Articles {

    //名字
    private String name;

    private ArrayList<Articles> bags = new ArrayList<Articles>();

    public void add(Articles articles){
        bags.add(articles);
    }

    public void remove(Articles articles){
        bags.remove(articles);
    }

    public Articles getChild(int i){
        Articles articles = bags.get(i);
        return articles;
    }

    public float calculation() {
        float a = 0;
        for (Articles bag : bags) {
            a += bag.calculation();
        }
        return a;
    }

    public void show() {
        for (Articles bag : bags) {
            bag.show();
        }
    }
}
