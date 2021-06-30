package com.ledao.service.impl;

import com.ledao.entity.Question;
import com.ledao.mapper.QuestionMapper;
import com.ledao.service.QuestionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 试题Service实现类
 *
 * @author LeDao
 * @company
 * @create 2021-06-28 20:47
 */
@Service("questionService")
public class QuestionServiceImpl implements QuestionService {

    @Resource
    private QuestionMapper questionMapper;

    @Override
    public Integer add(Question question) {
        return questionMapper.add(question);
    }

    @Override
    public Question findNew() {
        return questionMapper.findNew();
    }

    @Override
    public List<Question> getAllQuestion() {
        return questionMapper.getAllQuestion();
    }

    @Override
    public List<Question> list(Map<String, Object> map) {
        return questionMapper.list(map);
    }

    @Override
    public Question findById(Integer id) {
        return questionMapper.findById(id);
    }

    @Override
    public List<Question> getMyQuestion(Integer userId) {
        return questionMapper.getMyQuestion(userId);
    }

    @Override
    public Integer deleteById(Integer id) {
        return questionMapper.deleteById(id);
    }

    @Override
    public Integer update(Question question) {
        return questionMapper.update(question);
    }

    @Override
    public Long getCount(Map<String, Object> map) {
        return questionMapper.getCount(map);
    }

    @Override
    public List<Question> getQuestionByCourseIdAndQuestionType(Integer courseId, String questionType) {
        return questionMapper.getQuestionByCourseIdAndQuestionType(courseId, questionType);
    }
}
