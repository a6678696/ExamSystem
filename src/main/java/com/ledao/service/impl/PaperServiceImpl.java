package com.ledao.service.impl;

import com.ledao.entity.Paper;
import com.ledao.mapper.PaperMapper;
import com.ledao.service.PaperService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

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

    @Override
    public List<Paper> getListFindByUserId(Integer userId) {
        return paperMapper.getListFindByUserId(userId);
    }

    @Override
    public Paper findById(Integer id) {
        return paperMapper.findById(id);
    }

    @Override
    public List<Paper> list(Map<String, Object> map) {
        return paperMapper.list(map);
    }

    @Override
    public Long getCount(Map<String, Object> map) {
        return paperMapper.getCount(map);
    }
}
