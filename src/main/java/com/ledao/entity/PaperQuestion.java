package com.ledao.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 试卷试题实体
 *
 * @author LeDao
 * @company
 * @create 2021-06-30 21:19
 */
@Data
public class PaperQuestion {

    /**
     * 编号
     */
    private Integer id;
    /**
     * 试题编号
     */
    private Integer questionId;
    /**
     * 试题实体
     */
    private Question question;
    /**
     * 该实体答案选项集合
     */
    private List<Answer> answerList = new ArrayList<>();
    /**
     * 考生的答案
     */
    private String answer;
    /**
     * 试卷编号
     */
    private Integer paperId;
    /**
     * 得分
     */
    private Integer score;
    /**
     * 科目名称
     */
    private String courseName;
    /**
     * 正确答案序号(单选题使用)
     */
    private Integer trueAnswerNum;
    /**
     * 正确答案字符串(填空题使用)
     */
    private String trueAnswerStr;
}
