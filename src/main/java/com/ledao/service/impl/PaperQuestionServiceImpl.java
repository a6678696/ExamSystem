package com.ledao.service.impl;

import com.ledao.entity.PaperQuestion;
import com.ledao.mapper.PaperQuestionMapper;
import com.ledao.service.PaperQuestionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author LeDao
 * @company
 * @create 2021-06-30 21:30
 */
@Service("paperQuestionService")
public class PaperQuestionServiceImpl implements PaperQuestionService {

    @Resource
    private PaperQuestionMapper paperQuestionMapper;

    @Override
    public Integer add(PaperQuestion paperQuestion) {
        return paperQuestionMapper.add(paperQuestion);
    }

    @Override
    public List<PaperQuestion> getListByPaperIdAndCourseName(Integer paperId, String courseName) {
        return paperQuestionMapper.getListByPaperIdAndCourseName(paperId, courseName);
    }

    @Override
    public Integer update(PaperQuestion paperQuestion) {
        return paperQuestionMapper.update(paperQuestion);
    }
}
