package com.dwj.singleton.expand;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//有限的多例模式
public class Student {

    private static List<Student> list = new ArrayList<Student>();

    //创建时直接创建2个对象，装入集合中
    static {
        for (int i = 0; i < 2; i++) {
            list.add(new Student());
        }
    }

    //私有构造
    private Student() {}

    //随机获取一个对象
    public static Student getInstance() {
        Random random = new Random();
        int size = list.size();
        int i = random.nextInt(size);
        Student student = list.get(i);
        return student;
    }
}
