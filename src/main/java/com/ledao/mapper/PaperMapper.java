package com.ledao.mapper;

import com.ledao.entity.Paper;

/**
 * 试卷Mapper接口
 *
 * @author LeDao
 * @company
 * @create 2021-06-30 20:49
 */
public interface PaperMapper {

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
}
