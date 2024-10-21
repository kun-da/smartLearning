package com.ruoyi.smartLearning.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.smartLearning.mapper.AchievementsMapper;
import com.ruoyi.smartLearning.domain.Achievements;
import com.ruoyi.smartLearning.service.IAchievementsService;

/**
 * 成就Service业务层处理
 * 
 * @author 虞嘉欣
 * @date 2024-10-21
 */
@Service
public class AchievementsServiceImpl implements IAchievementsService 
{
    @Autowired
    private AchievementsMapper achievementsMapper;

    /**
     * 查询成就
     * 
     * @param id 成就主键
     * @return 成就
     */
    @Override
    public Achievements selectAchievementsById(Long id)
    {
        return achievementsMapper.selectAchievementsById(id);
    }

    /**
     * 查询成就列表
     * 
     * @param achievements 成就
     * @return 成就
     */
    @Override
    public List<Achievements> selectAchievementsList(Achievements achievements)
    {
        return achievementsMapper.selectAchievementsList(achievements);
    }

    /**
     * 新增成就
     * 
     * @param achievements 成就
     * @return 结果
     */
    @Override
    public int insertAchievements(Achievements achievements)
    {
        return achievementsMapper.insertAchievements(achievements);
    }

    /**
     * 修改成就
     * 
     * @param achievements 成就
     * @return 结果
     */
    @Override
    public int updateAchievements(Achievements achievements)
    {
        return achievementsMapper.updateAchievements(achievements);
    }

    /**
     * 批量删除成就
     * 
     * @param ids 需要删除的成就主键
     * @return 结果
     */
    @Override
    public int deleteAchievementsByIds(Long[] ids)
    {
        return achievementsMapper.deleteAchievementsByIds(ids);
    }

    /**
     * 删除成就信息
     * 
     * @param id 成就主键
     * @return 结果
     */
    @Override
    public int deleteAchievementsById(Long id)
    {
        return achievementsMapper.deleteAchievementsById(id);
    }
}
