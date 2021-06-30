package com.ledao.controller;

import com.ledao.entity.Answer;
import com.ledao.service.AnswerService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 答案Controller层
 *
 * @author LeDao
 * @company
 * @create 2021-06-28 21:25
 */
@CrossOrigin
@RestController
@RequestMapping("/answer")
public class AnswerController {

    @Resource
    private AnswerService answerService;

    /**
     * 添加或修改答案
     *
     * @param answer
     * @return
     */
    @RequestMapping("/save")
    public Map<String, Object> save(Answer answer) {
        Map<String, Object> resultMap = new HashMap<>(16);
        if (answer.getId() == null) {
            answerService.add(answer);
        }
        resultMap.put("success", true);
        return resultMap;
    }

    /**
     * 获取某个试题的答案
     *
     * @param questionId
     * @return
     */
    @RequestMapping("/getAnswerByQuestionId")
    public Map<String, Object> getAnswerByQuestionId(Integer questionId) {
        Map<String, Object> resultMap = new HashMap<>(16);
        List<Answer> answerList = answerService.getAnswerByQuestionId(questionId);
        resultMap.put("rows", answerList);
        return resultMap;
    }
}
