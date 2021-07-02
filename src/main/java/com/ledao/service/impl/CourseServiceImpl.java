package com.ledao.service.impl;

import com.ledao.entity.Course;
import com.ledao.mapper.CourseMapper;
import com.ledao.service.CourseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 科目Service实现类
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

    @Override
    public List<Course> list(Map<String, Object> map) {
        return courseMapper.list(map);
    }

    @Override
    public Long getCount(Map<String, Object> map) {
        return courseMapper.getCount(map);
    }

    @Override
    public Integer add(Course course) {
        return courseMapper.add(course);
    }

    @Override
    public Integer update(Course course) {
        return courseMapper.update(course);
    }

    @Override
    public Integer deleteById(Integer id) {
        return courseMapper.deleteById(id);
    }
}
