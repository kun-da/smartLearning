package com.ruoyi.smartLearning.mapper;

import java.util.List;
import com.ruoyi.smartLearning.domain.LearningPlans;

/**
 * 学习计划Mapper接口
 * 
 * @author ruoyi
 * @date 2024-10-21
 */
public interface LearningPlansMapper 
{
    /**
     * 查询学习计划
     * 
     * @param id 学习计划主键
     * @return 学习计划
     */
    public LearningPlans selectLearningPlansById(Long id);

    /**
     * 查询学习计划列表
     * 
     * @param learningPlans 学习计划
     * @return 学习计划集合
     */
    public List<LearningPlans> selectLearningPlansList(LearningPlans learningPlans);

    /**
     * 新增学习计划
     * 
     * @param learningPlans 学习计划
     * @return 结果
     */
    public int insertLearningPlans(LearningPlans learningPlans);

    /**
     * 修改学习计划
     * 
     * @param learningPlans 学习计划
     * @return 结果
     */
    public int updateLearningPlans(LearningPlans learningPlans);

    /**
     * 删除学习计划
     * 
     * @param id 学习计划主键
     * @return 结果
     */
    public int deleteLearningPlansById(Long id);

    /**
     * 批量删除学习计划
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteLearningPlansByIds(Long[] ids);
}
