package com.ledao.service.impl;

import com.ledao.entity.Answer;
import com.ledao.mapper.AnswerMapper;
import com.ledao.service.AnswerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 答案Service实现类
 *
 * @author LeDao
 * @company
 * @create 2021-06-28 21:24
 */
@Service("answerService")
public class AnswerServiceImpl implements AnswerService {

    @Resource
    private AnswerMapper answerMapper;

    @Override
    public Integer add(Answer answer) {
        return answerMapper.add(answer);
    }

    @Override
    public List<Answer> getAnswerByQuestionId(Integer questionId) {
        return answerMapper.getAnswerByQuestionId(questionId);
    }

    @Override
    public Integer deleteById(Integer id) {
        return answerMapper.deleteById(id);
    }

    @Override
    public Integer update(Answer answer) {
        return answerMapper.update(answer);
    }
}
