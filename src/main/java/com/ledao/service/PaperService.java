package com.ledao.service;

import com.ledao.entity.Paper;

/**
 * 试卷Service接口
 *
 * @author LeDao
 * @company
 * @create 2021-06-30 20:53
 */
public interface PaperService {

    /**
     * 添加试卷
     *
     * @param paper
     * @return
     */
    Integer add(Paper paper);

    /**
     * 获取某个考生的最新创建的试卷
     *
     * @param userId
     * @return
     */
    Paper findByUserIdLastOne(Integer userId);

    /**
     * 修改试卷
     *
     * @param paper
     * @return
     */
    Integer update(Paper paper);
}
