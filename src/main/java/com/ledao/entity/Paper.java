package com.ledao.entity;

import lombok.Data;

import java.util.Date;

/**
 * 试卷实体
 *
 * @author LeDao
 * @company
 * @create 2021-06-30 20:46
 */
@Data
public class Paper {

    /**
     * 编号
     */
    private Integer id;
    /**
     * 考试人编号
     */
    private Integer userId;
    /**
     * 所属科目编号
     */
    private Integer courseId;
    /**
     * 所属科目名称
     */
    private String courseName;
    /**
     * 创建时间
     */
    private Date createDate;
    /**
     * 总分
     */
    private Integer score;
}
