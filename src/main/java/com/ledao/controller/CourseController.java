package com.ledao.controller;

import com.ledao.entity.Course;
import com.ledao.entity.Question;
import com.ledao.service.CourseService;
import com.ledao.service.QuestionService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 课程Controller层
 *
 * @author LeDao
 * @company
 * @create 2021-06-28 19:14
 */
@CrossOrigin
@RestController
@RequestMapping("/course")
public class CourseController {

    @Resource
    private CourseService courseService;

    @Resource
    private QuestionService questionService;

    /**
     * 获取全部课程
     *
     * @return
     */
    @RequestMapping("/getAllCourse")
    public Map<String, Object> getAllCourse() {
        Map<String, Object> resultMap = new HashMap<>(16);
        List<Course> courseList = courseService.getAllCourse();
        resultMap.put("rows", courseList);
        return resultMap;
    }

    @RequestMapping("/getCourseCanTest")
    public Map<String, Object> getCourseCanTest() {
        Map<String, Object> resultMap = new HashMap<>(16);
        List<Course> courseList = courseService.getAllCourse();
        for (int i = 0; i < courseList.size(); i++) {
            List<Question> questionSingleList = questionService.getQuestionByCourseIdAndQuestionType(courseList.get(i).getId(), "单选题");
            List<Question> questionFillList = questionService.getQuestionByCourseIdAndQuestionType(courseList.get(i).getId(), "填空题");
            if (!(questionSingleList.size() >= 15 && questionFillList.size() >= 5)) {
                courseList.remove(courseList.get(i));
                i--;
            }
        }
        resultMap.put("rows", courseList);
        return resultMap;
    }
}
