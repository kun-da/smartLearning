package com.ruoyi.smartLearning.service;

import java.util.HashMap;
import java.util.List;
import com.ruoyi.smartLearning.domain.AchievementConditions;

/**
 * 成就配置Service接口
 *
 * @author 虞嘉欣
 * @date 2024-11-05
 */
public interface IAchievementConditionsService
{
    /**
     * 查询成就配置
     *
     * @param id 成就配置主键
     * @return 成就配置
     */
    public AchievementConditions selectAchievementConditionsById(Long id);

    /**
     * 查询成就配置列表
     *
     * @param achievementConditions 成就配置
     * @return 成就配置集合
     */
    public List<AchievementConditions> selectAchievementConditionsList(AchievementConditions achievementConditions);

    /**
     * 新增成就配置
     *
     * @param achievementConditions 成就配置
     * @return 结果
     */
    public int insertAchievementConditions(AchievementConditions achievementConditions);

    /**
     * 修改成就配置
     *
     * @param achievementConditions 成就配置
     * @return 结果
     */
    public int updateAchievementConditions(AchievementConditions achievementConditions);

    /**
     * 批量删除成就配置
     *
     * @param ids 需要删除的成就配置主键集合
     * @return 结果
     */
    public int deleteAchievementConditionsByIds(Long[] ids);

    /**
     * 删除成就配置信息
     *
     * @param id 成就配置主键
     * @return 结果
     */
    public int deleteAchievementConditionsById(Long id);

    HashMap<String, Object> showMyAchievements(Long userId);
}
