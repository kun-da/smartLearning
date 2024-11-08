package com.ruoyi.smartLearning.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.smartLearning.mapper.LearningResourcesMapper;
import com.ruoyi.smartLearning.domain.LearningResources;
import com.ruoyi.smartLearning.service.ILearningResourcesService;

/**
 * 学习资料Service业务层处理
 *
 * @author 虞嘉欣
 * @date 2024-11-08
 */
@Service
public class LearningResourcesServiceImpl implements ILearningResourcesService
{
    @Autowired
    private LearningResourcesMapper learningResourcesMapper;

    /**
     * 查询学习资料
     *
     * @param id 学习资料主键
     * @return 学习资料
     */
    @Override
    public LearningResources selectLearningResourcesById(Long id)
    {
        return learningResourcesMapper.selectLearningResourcesById(id);
    }

    /**
     * 查询学习资料列表
     *
     * @param learningResources 学习资料
     * @return 学习资料
     */
    @Override
    public List<LearningResources> selectLearningResourcesList(LearningResources learningResources)
    {
        return learningResourcesMapper.selectLearningResourcesList(learningResources);
    }

    /**
     * 新增学习资料
     *
     * @param learningResources 学习资料
     * @return 结果
     */
    @Override
    public int insertLearningResources(LearningResources learningResources)
    {
        return learningResourcesMapper.insertLearningResources(learningResources);
    }

    /**
     * 修改学习资料
     *
     * @param learningResources 学习资料
     * @return 结果
     */
    @Override
    public int updateLearningResources(LearningResources learningResources)
    {
        return learningResourcesMapper.updateLearningResources(learningResources);
    }

    /**
     * 批量删除学习资料
     *
     * @param ids 需要删除的学习资料主键
     * @return 结果
     */
    @Override
    public int deleteLearningResourcesByIds(Long[] ids)
    {
        return learningResourcesMapper.deleteLearningResourcesByIds(ids);
    }

    /**
     * 删除学习资料信息
     *
     * @param id 学习资料主键
     * @return 结果
     */
    @Override
    public int deleteLearningResourcesById(Long id)
    {
        return learningResourcesMapper.deleteLearningResourcesById(id);
    }

    @Override
    public List<LearningResources> selectLearningResourcesListShare(LearningResources learningResources) {
        return learningResourcesMapper.selectLearningResourcesListShare(learningResources);
    }
}
