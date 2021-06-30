package com.ledao.service;

import com.ledao.entity.PaperQuestion;

import java.util.List;

/**
 * 试卷试题Service接口
 *
 * @author LeDao
 * @company
 * @create 2021-06-30 21:29
 */
public interface PaperQuestionService {

    /**
     * 添加试卷试题
     *
     * @param paperQuestion
     * @return
     */
    Integer add(PaperQuestion paperQuestion);

    /**
     * 根据试卷id和科目名称获取试卷试题
     *
     * @param paperId
     * @param courseName
     * @return
     */
    List<PaperQuestion> getListByPaperIdAndCourseName(Integer paperId, String courseName);

    /**
     * 修改试卷试题
     *
     * @param paperQuestion
     * @return
     */
    Integer update(PaperQuestion paperQuestion);
}
