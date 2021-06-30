package com.ledao.entity;

import lombok.Data;

/**
 * 答案实体
 *
 * @author LeDao
 * @company
 * @create 2021-06-28 21:14
 */
@Data
public class Answer {

    /**
     * 编号
     */
    private Integer id;
    /**
     * 内容
     */
    private String content;
    /**
     * 所属试题id
     */
    private Integer questionId;
    /**
     * 是否是正确答案 0代表错误答案 1代表正确答案
     */
    private Integer isTrue;
}
