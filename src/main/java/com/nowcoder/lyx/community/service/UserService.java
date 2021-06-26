package com.nowcoder.lyx.community.service;

import com.nowcoder.lyx.community.dao.UserMapper;
import com.nowcoder.lyx.community.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    public User findUserById(int id){
        return userMapper.selectById(id);
    }

}
