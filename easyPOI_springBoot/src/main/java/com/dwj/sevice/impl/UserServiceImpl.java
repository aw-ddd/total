package com.dwj.sevice.impl;

import com.dwj.entity.User;
import com.dwj.mapper.UserMapper;
import com.dwj.sevice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> findAll() {
        List<User> userList = userMapper.selectAll();
        return userList;
    }

    @Override
    public void saveExcel(List<User> userList) {
        if (userList.size() <= 0 || userList == null){
            throw new IllegalArgumentException("参数异常");
        }
        for (User user : userList) {
            User user1 = userMapper.selectByPrimaryKey(user.getId());
            if (user1 != null){
                userMapper.delete(user1);
            }
            userMapper.insertSelective(user);
        }
    }
}
