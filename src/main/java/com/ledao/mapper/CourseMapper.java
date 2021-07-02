package com.ledao.mapper;

import com.ledao.entity.Course;

import java.util.List;
import java.util.Map;

/**
 * 科目Mapper接口
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

    /**
     * 分页分条件获取科目
     *
     * @param map
     * @return
     */
    List<Course> list(Map<String, Object> map);

    /**
     * 获取记录数
     *
     * @param map
     * @return
     */
    Long getCount(Map<String, Object> map);

    /**
     * 添加科目
     *
     * @param course
     * @return
     */
    Integer add(Course course);

    /**
     * 修改科目
     *
     * @param course
     * @return
     */
    Integer update(Course course);

    /**
     * 根据id删除科目
     *
     * @param id
     * @return
     */
    Integer deleteById(Integer id);
}
