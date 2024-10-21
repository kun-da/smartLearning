package com.ruoyi.smartLearning.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.smartLearning.mapper.LearningProgressMapper;
import com.ruoyi.smartLearning.domain.LearningProgress;
import com.ruoyi.smartLearning.service.ILearningProgressService;

/**
 * 学习进度Service业务层处理
 * 
 * @author 虞嘉欣
 * @date 2024-10-21
 */
@Service
public class LearningProgressServiceImpl implements ILearningProgressService 
{
    @Autowired
    private LearningProgressMapper learningProgressMapper;

    /**
     * 查询学习进度
     * 
     * @param id 学习进度主键
     * @return 学习进度
     */
    @Override
    public LearningProgress selectLearningProgressById(Long id)
    {
        return learningProgressMapper.selectLearningProgressById(id);
    }

    /**
     * 查询学习进度列表
     * 
     * @param learningProgress 学习进度
     * @return 学习进度
     */
    @Override
    public List<LearningProgress> selectLearningProgressList(LearningProgress learningProgress)
    {
        return learningProgressMapper.selectLearningProgressList(learningProgress);
    }

    /**
     * 新增学习进度
     * 
     * @param learningProgress 学习进度
     * @return 结果
     */
    @Override
    public int insertLearningProgress(LearningProgress learningProgress)
    {
        return learningProgressMapper.insertLearningProgress(learningProgress);
    }

    /**
     * 修改学习进度
     * 
     * @param learningProgress 学习进度
     * @return 结果
     */
    @Override
    public int updateLearningProgress(LearningProgress learningProgress)
    {
        return learningProgressMapper.updateLearningProgress(learningProgress);
    }

    /**
     * 批量删除学习进度
     * 
     * @param ids 需要删除的学习进度主键
     * @return 结果
     */
    @Override
    public int deleteLearningProgressByIds(Long[] ids)
    {
        return learningProgressMapper.deleteLearningProgressByIds(ids);
    }

    /**
     * 删除学习进度信息
     * 
     * @param id 学习进度主键
     * @return 结果
     */
    @Override
    public int deleteLearningProgressById(Long id)
    {
        return learningProgressMapper.deleteLearningProgressById(id);
    }
}
