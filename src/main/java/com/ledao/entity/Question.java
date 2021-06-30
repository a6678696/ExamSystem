package com.ledao.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author LeDao
 * @company
 * @create 2021-06-28 20:39
 */
@Data
public class Question {

    /**
     * 编号
     */
    private Integer id;
    /**
     * 试题描述
     */
    private String content;
    /**
     * 所属科目id
     */
    private Integer courseId;
    /**
     * 所属科目名称
     */
    private String courseName;
    /**
     * 添加时间
     */
    private Date addDate;
    /**
     * 题目类型(分为:单选题和填空题)
     */
    private String type;
    /**
     * 发布人id
     */
    private Integer userId;
    /**
     * 发布人用户名
     */
    private String userName;
    /**
     * 答案
     */
    private String answer;
    /**
     * 正确答案
     */
    private String trueAnswer;
}
