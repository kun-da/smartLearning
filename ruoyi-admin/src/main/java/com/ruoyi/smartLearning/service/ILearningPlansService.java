package com.ruoyi.smartLearning.service;

import java.util.List;
import com.ruoyi.smartLearning.domain.LearningPlans;

/**
 * 学习计划Service接口
 *
 * @author ruoyi
 * @date 2024-10-21
 */
public interface ILearningPlansService
{
    /**
     * 查询学习计划,根据当前日期
     */
    List<LearningPlans> selectLearningPlansByDate(Long userId, String date);
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
     * 批量删除学习计划
     *
     * @param ids 需要删除的学习计划主键集合
     * @return 结果
     */
    public int deleteLearningPlansByIds(Long[] ids);

    /**
     * 删除学习计划信息
     *
     * @param id 学习计划主键
     * @return 结果
     */
    public int deleteLearningPlansById(Long id);
}
