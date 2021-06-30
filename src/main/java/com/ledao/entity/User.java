package com.ledao.entity;

import lombok.Data;

/**
 * 用户实体
 *
 * @author LeDao
 * @company
 * @create 2021-06-27 10:43
 */
@Data
public class User {
    /**
     * 编号
     */
    private Integer id;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 密码
     */
    private String password;
    /**
     * 用户类型
     */
    private String type;

    public User() {
    }

    public User(Integer id, String userName, String password, String type) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.type = type;
    }
}
