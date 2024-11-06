package com.ruoyi.smartLearning.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.smartLearning.mapper.AchievementConditionsMapper;
import com.ruoyi.smartLearning.domain.AchievementConditions;
import com.ruoyi.smartLearning.service.IAchievementConditionsService;

/**
 * 成就配置Service业务层处理
 * 
 * @author 虞嘉欣
 * @date 2024-11-05
 */
@Service
public class AchievementConditionsServiceImpl implements IAchievementConditionsService 
{
    @Autowired
    private AchievementConditionsMapper achievementConditionsMapper;

    /**
     * 查询成就配置
     * 
     * @param id 成就配置主键
     * @return 成就配置
     */
    @Override
    public AchievementConditions selectAchievementConditionsById(Long id)
    {
        return achievementConditionsMapper.selectAchievementConditionsById(id);
    }

    /**
     * 查询成就配置列表
     * 
     * @param achievementConditions 成就配置
     * @return 成就配置
     */
    @Override
    public List<AchievementConditions> selectAchievementConditionsList(AchievementConditions achievementConditions)
    {
        return achievementConditionsMapper.selectAchievementConditionsList(achievementConditions);
    }

    /**
     * 新增成就配置
     * 
     * @param achievementConditions 成就配置
     * @return 结果
     */
    @Override
    public int insertAchievementConditions(AchievementConditions achievementConditions)
    {
        return achievementConditionsMapper.insertAchievementConditions(achievementConditions);
    }

    /**
     * 修改成就配置
     * 
     * @param achievementConditions 成就配置
     * @return 结果
     */
    @Override
    public int updateAchievementConditions(AchievementConditions achievementConditions)
    {
        return achievementConditionsMapper.updateAchievementConditions(achievementConditions);
    }

    /**
     * 批量删除成就配置
     * 
     * @param ids 需要删除的成就配置主键
     * @return 结果
     */
    @Override
    public int deleteAchievementConditionsByIds(Long[] ids)
    {
        return achievementConditionsMapper.deleteAchievementConditionsByIds(ids);
    }

    /**
     * 删除成就配置信息
     * 
     * @param id 成就配置主键
     * @return 结果
     */
    @Override
    public int deleteAchievementConditionsById(Long id)
    {
        return achievementConditionsMapper.deleteAchievementConditionsById(id);
    }
}
