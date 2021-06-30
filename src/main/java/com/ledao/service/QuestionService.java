package com.ledao.service;

import com.ledao.entity.Question;

import java.util.List;
import java.util.Map;

/**
 * 试题Service接口
 *
 * @author LeDao
 * @company
 * @create 2021-06-28 20:46
 */
public interface QuestionService {

    /**
     * 添加试题
     *
     * @param question
     * @return
     */
    Integer add(Question question);

    /**
     * 查找最新添加的试题
     *
     * @return
     */
    Question findNew();

    /**
     * 获取全部试题
     *
     * @return
     */
    List<Question> getAllQuestion();

    /**
     * 根据条件查询试题
     *
     * @param map
     * @return
     */
    List<Question> list(Map<String, Object> map);

    /**
     * 根据id查找试题
     *
     * @param id
     * @return
     */
    Question findById(Integer id);

    /**
     * 获取某个用户发布的试题
     *
     * @param userId
     * @return
     */
    List<Question> getMyQuestion(Integer userId);

    /**
     * 根据id删除试题
     *
     * @param id
     * @return
     */
    Integer deleteById(Integer id);

    /**
     * 修改试题
     *
     * @param question
     * @return
     */
    Integer update(Question question);

    /**
     * 获取记录数
     *
     * @param map
     * @return
     */
    Long getCount(Map<String, Object> map);

    /**
     * 根据科目id和试题类型
     *
     * @param courseId
     * @param questionType
     * @return
     */
    List<Question> getQuestionByCourseIdAndQuestionType(Integer courseId, String questionType);
}
