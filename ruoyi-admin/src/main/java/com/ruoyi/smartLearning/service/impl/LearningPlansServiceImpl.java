package com.ruoyi.smartLearning.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.smartLearning.mapper.LearningPlansMapper;
import com.ruoyi.smartLearning.domain.LearningPlans;
import com.ruoyi.smartLearning.service.ILearningPlansService;

/**
 * 学习计划Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-10-21
 */
@Service
public class LearningPlansServiceImpl implements ILearningPlansService 
{
    @Autowired
    private LearningPlansMapper learningPlansMapper;

    /**
     * 查询学习计划
     * 
     * @param id 学习计划主键
     * @return 学习计划
     */
    @Override
    public LearningPlans selectLearningPlansById(Long id)
    {
        return learningPlansMapper.selectLearningPlansById(id);
    }

    /**
     * 查询学习计划列表
     * 
     * @param learningPlans 学习计划
     * @return 学习计划
     */
    @Override
    public List<LearningPlans> selectLearningPlansList(LearningPlans learningPlans)
    {
        return learningPlansMapper.selectLearningPlansList(learningPlans);
    }

    /**
     * 新增学习计划
     * 
     * @param learningPlans 学习计划
     * @return 结果
     */
    @Override
    public int insertLearningPlans(LearningPlans learningPlans)
    {
        return learningPlansMapper.insertLearningPlans(learningPlans);
    }

    /**
     * 修改学习计划
     * 
     * @param learningPlans 学习计划
     * @return 结果
     */
    @Override
    public int updateLearningPlans(LearningPlans learningPlans)
    {
        return learningPlansMapper.updateLearningPlans(learningPlans);
    }

    /**
     * 批量删除学习计划
     * 
     * @param ids 需要删除的学习计划主键
     * @return 结果
     */
    @Override
    public int deleteLearningPlansByIds(Long[] ids)
    {
        return learningPlansMapper.deleteLearningPlansByIds(ids);
    }

    /**
     * 删除学习计划信息
     * 
     * @param id 学习计划主键
     * @return 结果
     */
    @Override
    public int deleteLearningPlansById(Long id)
    {
        return learningPlansMapper.deleteLearningPlansById(id);
    }
}
