package com.ledao.controller;

import com.ledao.entity.Course;
import com.ledao.entity.PageBean;
import com.ledao.entity.Question;
import com.ledao.service.CourseService;
import com.ledao.service.QuestionService;
import com.ledao.util.StringUtil;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 科目Controller层
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
     * 获取全部科目
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

    /**
     * 分页分条件获取科目
     *
     * @param course
     * @param page
     * @param size
     * @return
     */
    @RequestMapping("/list")
    public Map<String, Object> list(Course course, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size) {
        PageBean pageBean = new PageBean(page, size);
        Map<String, Object> resultMap = new HashMap<>(16);
        Map<String, Object> map = new HashMap<>(16);
        map.put("name", StringUtil.formatLike(course.getName()));
        map.put("start", pageBean.getStart());
        map.put("size", pageBean.getPageSize());
        List<Course> courseList = courseService.list(map);
        for (Course course1 : courseList) {
            Map<String, Object> map2 = new HashMap<>(16);
            map2.put("courseId", course1.getId());
            course1.setNum(questionService.list(map2).size());
        }
        resultMap.put("courseList", courseList);
        resultMap.put("total", courseService.getCount(map));
        return resultMap;
    }

    /**
     * 添加科目
     *
     * @param course
     * @return
     */
    @RequestMapping("/add")
    public Map<String, Object> add(Course course) {
        Map<String, Object> resultMap = new HashMap<>(16);
        courseService.add(course);
        resultMap.put("success", true);
        return resultMap;
    }

    /**
     * 根据id删除科目
     *
     * @param id
     * @return
     */
    @RequestMapping("/delete")
    public Map<String, Object> delete(Integer id) {
        Map<String, Object> resultMap = new HashMap<>(16);
        Map<String, Object> map = new HashMap<>(16);
        map.put("courseId", id);
        List<Question> questionList = questionService.list(map);
        if (questionList.size() == 0) {
            courseService.deleteById(id);
            resultMap.put("success", true);
        } else {
            resultMap.put("success", false);
            resultMap.put("errorInfo", "该科目下有 " + questionList.size() + " 道试题未删除，请删除该科目的所有试题后再删除这个科目吧！！");
        }
        return resultMap;
    }

    /**
     * 根据id获取科目
     *
     * @param id
     * @return
     */
    @RequestMapping("/findById")
    public Map<String, Object> findById(Integer id) {
        Map<String, Object> resultMap = new HashMap<>(16);
        Map<String, Object> map = new HashMap<>(16);
        map.put("courseId", id);
        Course course = courseService.findById(id);
        course.setNum(questionService.list(map).size());
        resultMap.put("course", course);
        return resultMap;
    }

    /**
     * 更新科目
     *
     * @param course
     * @return
     */
    @RequestMapping("/update")
    public Map<String, Object> update(Course course) {
        Map<String, Object> resultMap = new HashMap<>(16);
        courseService.update(course);
        resultMap.put("success", true);
        return resultMap;
    }
}
