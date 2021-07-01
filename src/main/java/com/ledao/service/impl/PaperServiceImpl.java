package com.ledao.service.impl;

import com.ledao.entity.Paper;
import com.ledao.mapper.PaperMapper;
import com.ledao.service.PaperService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 试卷Service实现类
 *
 * @author LeDao
 * @company
 * @create 2021-06-30 20:54
 */
@Service("paperService")
public class PaperServiceImpl implements PaperService {

    @Resource
    private PaperMapper paperMapper;

    @Override
    public Integer add(Paper paper) {
        return paperMapper.add(paper);
    }

    @Override
    public Paper findByUserIdLastOne(Integer userId) {
        return paperMapper.findByUserIdLastOne(userId);
    }

    @Override
    public Integer update(Paper paper) {
        return paperMapper.update(paper);
    }
}
