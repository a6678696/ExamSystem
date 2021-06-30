package com.ledao.service;

import com.ledao.entity.Answer;

import java.util.List;

/**
 * 答案Service接口
 *
 * @author LeDao
 * @company
 * @create 2021-06-28 21:23
 */
public interface AnswerService {

    /**
     * 添加答案
     *
     * @param answer
     * @return
     */
    Integer add(Answer answer);

    /**
     * 获取某个试题的答案
     *
     * @param questionId
     * @return
     */
    List<Answer> getAnswerByQuestionId(Integer questionId);

    /**
     * 根据id删除某个答案
     *
     * @param id
     * @return
     */
    Integer deleteById(Integer id);

    /**
     * 修改答案
     *
     * @param answer
     * @return
     */
    Integer update(Answer answer);
}
