package com.ruoyi.smartLearning.service;

import java.util.List;
import com.ruoyi.smartLearning.domain.LearningResources;

/**
 * 学习资料Service接口
 * 
 * @author 虞嘉欣
 * @date 2024-10-21
 */
public interface ILearningResourcesService 
{
    /**
     * 查询学习资料
     * 
     * @param id 学习资料主键
     * @return 学习资料
     */
    public LearningResources selectLearningResourcesById(Long id);

    /**
     * 查询学习资料列表
     * 
     * @param learningResources 学习资料
     * @return 学习资料集合
     */
    public List<LearningResources> selectLearningResourcesList(LearningResources learningResources);

    /**
     * 新增学习资料
     * 
     * @param learningResources 学习资料
     * @return 结果
     */
    public int insertLearningResources(LearningResources learningResources);

    /**
     * 修改学习资料
     * 
     * @param learningResources 学习资料
     * @return 结果
     */
    public int updateLearningResources(LearningResources learningResources);

    /**
     * 批量删除学习资料
     * 
     * @param ids 需要删除的学习资料主键集合
     * @return 结果
     */
    public int deleteLearningResourcesByIds(Long[] ids);

    /**
     * 删除学习资料信息
     * 
     * @param id 学习资料主键
     * @return 结果
     */
    public int deleteLearningResourcesById(Long id);
}
