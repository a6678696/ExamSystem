package com.ledao.service;

import com.ledao.entity.User;

/**
 * 用户Service接口
 *
 * @author LeDao
 * @company
 * @create 2021-06-27 11:02
 */
public interface UserService {

    /**
     * 根据用户名查找用户
     *
     * @param userName
     * @return
     */
    User findByUserName(String userName);

    /**
     * 更新用户
     *
     * @param user
     * @return
     */
    Integer update(User user);

    /**
     * 根据id获取用户
     *
     * @param id
     * @return
     */
    User findById(Integer id);
}
