package com.ledao.service.impl;

import com.ledao.entity.User;
import com.ledao.mapper.UserMapper;
import com.ledao.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 用户Service实现类
 *
 * @author LeDao
 * @company
 * @create 2021-06-27 11:03
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User findByUserName(String userName) {
        return userMapper.findByUserName(userName);
    }

    @Override
    public Integer update(User user) {
        return userMapper.update(user);
    }

    @Override
    public User findById(Integer id) {
        return userMapper.findById(id);
    }

    @Override
    public Integer add(User user) {
        return userMapper.add(user);
    }

    @Override
    public List<User> list(Map<String, Object> map) {
        return userMapper.list(map);
    }

    @Override
    public Long getCount(Map<String, Object> map) {
        return userMapper.getCount(map);
    }
}
