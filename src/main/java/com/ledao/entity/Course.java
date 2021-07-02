package com.ledao.entity;

import lombok.Data;

/**
 * 科目实体
 *
 * @author LeDao
 * @company
 * @create 2021-06-28 19:06
 */
@Data
public class Course {

    /**
     * 编号
     */
    private Integer id;

    /**
     * 名称
     */
    private String name;

    /**
     * 考试时间(分钟)
     */
    private Integer minutes;

    /**
     * 试题数量
     */
    private Integer num;
}
