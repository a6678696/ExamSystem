package com.ledao.service.impl;

import com.ledao.entity.Course;
import com.ledao.mapper.CourseMapper;
import com.ledao.service.CourseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 课程Service实现类
 *
 * @author LeDao
 * @company
 * @create 2021-06-28 19:12
 */
@Service("courseService")
public class CourseServiceImpl implements CourseService {

    @Resource
    private CourseMapper courseMapper;

    @Override
    public List<Course> getAllCourse() {
        return courseMapper.getAllCourse();
    }

    @Override
    public Course findById(Integer id) {
        return courseMapper.findById(id);
    }
}
