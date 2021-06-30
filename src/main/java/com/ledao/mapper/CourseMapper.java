package com.ledao.mapper;

import com.ledao.entity.Course;

import java.util.List;

/**
 * 课程Mapper接口
 *
 * @author LeDao
 * @company
 * @create 2021-06-28 19:07
 */
public interface CourseMapper {

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
