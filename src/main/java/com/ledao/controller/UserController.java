package com.ledao.controller;

import com.ledao.entity.User;
import com.ledao.service.UserService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author LeDao
 * @company
 * @create 2021-06-27 11:05
 */
@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    /**
     * 验证用户名密码是否正确
     *
     * @param userName
     * @return
     */
    @RequestMapping("/login")
    public Map<String, Object> login(String userName, String password, String type) {
        Map<String, Object> resultMap = new HashMap<>(16);
        User user = userService.findByUserName(userName);
        //用户名存在
        if (user != null) {
            //密码正确
            if (password.equals(user.getPassword())) {
                //选择的身份正确
                if (user.getType().equals(type)) {
                    resultMap.put("status", 1);
                    resultMap.put("userId", user.getId());
                } else {
                    resultMap.put("status", 0);
                }
            } else {
                resultMap.put("status", 0);
            }
        } else {
            resultMap.put("status", 0);
        }
        return resultMap;
    }

    /**
     * 修改密码
     *
     * @param userName
     * @param password
     * @return
     */
    @RequestMapping("/modifyPassword")
    public Map<String, Object> modifyPassword(String userName, String password) {
        Map<String, Object> resultMap = new HashMap<>(16);
        User user = userService.findByUserName(userName);
        user.setPassword(password);
        userService.update(user);
        resultMap.put("status", 1);
        return resultMap;
    }

    /**
     * @param userName
     * @return
     */
    @RequestMapping("/findByUserName")
    public Map<String, Object> findByUserName(String userName) {
        Map<String, Object> resultMap = new HashMap<>(16);
        User user = userService.findByUserName(userName);
        if (user == null) {
            resultMap.put("success", true);
        } else {
            resultMap.put("success", false);
        }
        return resultMap;
    }

    /**
     * 添加用户
     *
     * @param user
     * @return
     */
    @RequestMapping("/add")
    public Map<String, Object> add(User user) {
        Map<String, Object> resultMap = new HashMap<>(16);
        userService.add(user);
        resultMap.put("success", true);
        return resultMap;
    }
}
