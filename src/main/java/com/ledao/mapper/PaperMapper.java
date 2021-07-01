package com.ledao.mapper;

import com.ledao.entity.Paper;

import java.nio.file.Path;
import java.util.List;

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

    /**
     * 修改试卷
     *
     * @param paper
     * @return
     */
    Integer update(Paper paper);

    /**
     * 根据用户id获取全部试卷
     *
     * @param userId
     * @return
     */
    List<Paper> getListFindByUserId(Integer userId);

    /**
     * 根据id获取试卷
     *
     * @param id
     * @return
     */
    Paper findById(Integer id);
}
