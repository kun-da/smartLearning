package com.ruoyi.smartLearning.service;

import java.util.List;
import com.ruoyi.smartLearning.domain.Achievements;

/**
 * 成就Service接口
 * 
 * @author 虞嘉欣
 * @date 2024-10-21
 */
public interface IAchievementsService 
{
    /**
     * 查询成就
     * 
     * @param id 成就主键
     * @return 成就
     */
    public Achievements selectAchievementsById(Long id);

    /**
     * 查询成就列表
     * 
     * @param achievements 成就
     * @return 成就集合
     */
    public List<Achievements> selectAchievementsList(Achievements achievements);

    /**
     * 新增成就
     * 
     * @param achievements 成就
     * @return 结果
     */
    public int insertAchievements(Achievements achievements);

    /**
     * 修改成就
     * 
     * @param achievements 成就
     * @return 结果
     */
    public int updateAchievements(Achievements achievements);

    /**
     * 批量删除成就
     * 
     * @param ids 需要删除的成就主键集合
     * @return 结果
     */
    public int deleteAchievementsByIds(Long[] ids);

    /**
     * 删除成就信息
     * 
     * @param id 成就主键
     * @return 结果
     */
    public int deleteAchievementsById(Long id);
}
