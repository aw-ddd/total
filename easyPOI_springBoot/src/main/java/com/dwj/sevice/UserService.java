package com.dwj.sevice;

import com.dwj.entity.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    void saveExcel(List<User> userList);
}
