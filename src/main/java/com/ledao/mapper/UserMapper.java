package com.ledao.mapper;

import com.ledao.entity.User;

import java.util.List;
import java.util.Map;

/**
 * 用户Mapper接口
 *
 * @author LeDao
 * @company
 * @create 2021-06-27 10:45
 */
public interface UserMapper {

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

    /**
     * 添加用户
     *
     * @param user
     * @return
     */
    Integer add(User user);

    /**
     * 根据条件获取用户
     *
     * @param map
     * @return
     */
    List<User> list(Map<String, Object> map);

    /**
     * 获取记录数
     *
     * @param map
     * @return
     */
    Long getCount(Map<String, Object> map);
}
