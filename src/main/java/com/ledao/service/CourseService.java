package com.ledao.service;

import com.ledao.entity.Course;

import java.util.List;

/**
 * 课程Service接口
 *
 * @author LeDao
 * @company
 * @create 2021-06-28 19:12
 */
public interface CourseService {

    /**
     * 获取全部科目
     *
     * @return
     */
    List<Course> getAllCourse();

    /**
     * 根据id获取科目
     *
     * @param id
     * @return
     */
    Course findById(Integer id);
}
