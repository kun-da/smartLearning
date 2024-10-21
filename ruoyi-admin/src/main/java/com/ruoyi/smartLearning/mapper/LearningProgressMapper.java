package com.ruoyi.smartLearning.mapper;

import java.util.List;
import com.ruoyi.smartLearning.domain.LearningProgress;

/**
 * 学习进度Mapper接口
 * 
 * @author 虞嘉欣
 * @date 2024-10-21
 */
public interface LearningProgressMapper 
{
    /**
     * 查询学习进度
     * 
     * @param id 学习进度主键
     * @return 学习进度
     */
    public LearningProgress selectLearningProgressById(Long id);

    /**
     * 查询学习进度列表
     * 
     * @param learningProgress 学习进度
     * @return 学习进度集合
     */
    public List<LearningProgress> selectLearningProgressList(LearningProgress learningProgress);

    /**
     * 新增学习进度
     * 
     * @param learningProgress 学习进度
     * @return 结果
     */
    public int insertLearningProgress(LearningProgress learningProgress);

    /**
     * 修改学习进度
     * 
     * @param learningProgress 学习进度
     * @return 结果
     */
    public int updateLearningProgress(LearningProgress learningProgress);

    /**
     * 删除学习进度
     * 
     * @param id 学习进度主键
     * @return 结果
     */
    public int deleteLearningProgressById(Long id);

    /**
     * 批量删除学习进度
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteLearningProgressByIds(Long[] ids);
}
