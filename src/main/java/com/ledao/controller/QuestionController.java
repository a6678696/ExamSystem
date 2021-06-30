package com.ledao.controller;

import com.ledao.entity.Answer;
import com.ledao.entity.PageBean;
import com.ledao.entity.Question;
import com.ledao.service.AnswerService;
import com.ledao.service.CourseService;
import com.ledao.service.QuestionService;
import com.ledao.service.UserService;
import com.ledao.util.StringUtil;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 试题Controller层
 *
 * @author LeDao
 * @company
 * @create 2021-06-28 20:48
 */
@CrossOrigin
@RestController
@RequestMapping("/question")
public class QuestionController {

    @Resource
    private QuestionService questionService;

    @Resource
    private AnswerService answerService;

    @Resource
    private CourseService courseService;

    @Resource
    private UserService userService;

    /**
     * 添加或修改单选题
     *
     * @param question
     * @return
     */
    @RequestMapping("/addQuestionSingle")
    public Map<String, Object> addQuestionSingle(Question question) {
        Map<String, Object> resultMap = new HashMap<>(16);
        if (question.getId() == null) {
            questionService.add(question);
        }
        Integer newQuestionId = questionService.findNew().getId();
        String[] answers = question.getAnswer().split("<<----->>");
        //正确答案对应答案数组的下标
        int trueAnswerIndex = Integer.parseInt(question.getTrueAnswer().substring(2, 3)) - 1;
        for (int i = 0; i < answers.length; i++) {
            Answer answer = new Answer();
            answer.setContent(answers[i]);
            answer.setQuestionId(newQuestionId);
            //当前是正确答案
            if (i == trueAnswerIndex) {
                answer.setIsTrue(1);
            } else {
                answer.setIsTrue(0);
            }
            answerService.add(answer);
        }
        resultMap.put("success", true);
        return resultMap;
    }

    /**
     * 添加填空题
     *
     * @param question
     * @return
     */
    @RequestMapping("/addQuestionFill")
    public Map<String, Object> addQuestionFill(Question question) {
        Map<String, Object> resultMap = new HashMap<>(16);
        if (question.getId() == null) {
            questionService.add(question);
        }
        Integer newQuestionId = questionService.findNew().getId();
        Answer answer = new Answer();
        answer.setContent(question.getAnswer());
        answer.setQuestionId(newQuestionId);
        answer.setIsTrue(1);
        answerService.add(answer);
        resultMap.put("success", true);
        return resultMap;
    }

    /**
     * 获取全部试题
     *
     * @return
     */
    @RequestMapping("/getAllQuestion")
    public Map<String, Object> getAllQuestion(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size) {
        PageBean pageBean = new PageBean(page, size);
        Map<String, Object> resultMap = new HashMap<>(16);
        Map<String, Object> map = new HashMap<>(16);
        map.put("start", pageBean.getStart());
        map.put("size", pageBean.getPageSize());
        List<Question> questionList = questionService.list(map);
        for (Question question : questionList) {
            question.setCourseName(courseService.findById(question.getCourseId()).getName());
        }
        resultMap.put("total", questionService.getCount(map));
        resultMap.put("rows", questionList);
        return resultMap;
    }

    /**
     * 根据科目id和试题描述搜索试题
     *
     * @param question
     * @return
     */
    @RequestMapping("/searchQuestion")
    public Map<String, Object> searchQuestion(Question question, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size) {
        PageBean pageBean = new PageBean(page, size);
        Map<String, Object> resultMap = new HashMap<>(16);
        Map<String, Object> map = new HashMap<>(16);
        map.put("content", StringUtil.formatLike(question.getContent()));
        map.put("courseId", question.getCourseId());
        map.put("userId", question.getUserId());
        map.put("start", pageBean.getStart());
        map.put("size", pageBean.getPageSize());
        List<Question> questionList = questionService.list(map);
        for (Question question1 : questionList) {
            question1.setCourseName(courseService.findById(question1.getCourseId()).getName());
        }
        resultMap.put("total", questionService.getCount(map));
        resultMap.put("rows", questionList);
        return resultMap;
    }

    @RequestMapping("/findById")
    public Map<String, Object> findById(Question question) {
        Map<String, Object> resultMap = new HashMap<>(16);
        Question question2 = questionService.findById(question.getId());
        question2.setCourseName(courseService.findById(question2.getCourseId()).getName());
        question2.setUserName(userService.findById(question2.getUserId()).getUserName());
        resultMap.put("question", question2);
        return resultMap;
    }

    @RequestMapping("/getMyQuestion")
    public Map<String, Object> getMyQuestion(Integer userId, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size) {
        PageBean pageBean = new PageBean(page, size);
        Map<String, Object> resultMap = new HashMap<>(16);
        Map<String, Object> map = new HashMap<>(16);
        map.put("userId", userId);
        map.put("start", pageBean.getStart());
        map.put("size", pageBean.getPageSize());
        List<Question> questionList = questionService.list(map);
        for (Question question : questionList) {
            question.setCourseName(courseService.findById(question.getCourseId()).getName());
        }
        resultMap.put("total", questionService.getCount(map));
        resultMap.put("rows", questionList);
        return resultMap;
    }

    @RequestMapping("/deleteById")
    public Map<String, Object> deleteById(Integer id) {
        Map<String, Object> resultMap = new HashMap<>(16);
        List<Answer> answerList = answerService.getAnswerByQuestionId(id);
        for (Answer answer : answerList) {
            answerService.deleteById(answer.getId());
        }
        questionService.deleteById(id);
        resultMap.put("success", true);
        return resultMap;
    }

    @RequestMapping("/update")
    public Map<String, Object> update(Integer questionId, String content, Integer courseId, String answerString, Integer trueAnswerId) {
        Map<String, Object> resultMap = new HashMap<>(16);
        Question question = questionService.findById(questionId);
        question.setContent(content);
        question.setCourseId(courseId);
        questionService.update(question);
        List<Answer> answerList = answerService.getAnswerByQuestionId(questionId);
        String[] answers = answerString.split("<<----->>");
        for (int i = 0; i < answerList.size(); i++) {
            Answer answer = answerList.get(i);
            answer.setContent(answers[i]);
            if (answer.getId().equals(trueAnswerId)) {
                answer.setIsTrue(1);
            } else {
                answer.setIsTrue(0);
            }
            answerService.update(answer);
        }
        resultMap.put("success", true);
        return resultMap;
    }
}
