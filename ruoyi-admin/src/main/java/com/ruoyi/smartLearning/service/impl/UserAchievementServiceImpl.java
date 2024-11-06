package com.ruoyi.smartLearning.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.smartLearning.mapper.UserAchievementMapper;
import com.ruoyi.smartLearning.domain.UserAchievement;
import com.ruoyi.smartLearning.service.IUserAchievementService;

/**
 * 用户成就Service业务层处理
 * 
 * @author 虞
 * @date 2024-11-05
 */
@Service
public class UserAchievementServiceImpl implements IUserAchievementService 
{
    @Autowired
    private UserAchievementMapper userAchievementMapper;

    /**
     * 查询用户成就
     * 
     * @param id 用户成就主键
     * @return 用户成就
     */
    @Override
    public UserAchievement selectUserAchievementById(Long id)
    {
        return userAchievementMapper.selectUserAchievementById(id);
    }

    /**
     * 查询用户成就列表
     * 
     * @param userAchievement 用户成就
     * @return 用户成就
     */
    @Override
    public List<UserAchievement> selectUserAchievementList(UserAchievement userAchievement)
    {
        return userAchievementMapper.selectUserAchievementList(userAchievement);
    }

    /**
     * 新增用户成就
     * 
     * @param userAchievement 用户成就
     * @return 结果
     */
    @Override
    public int insertUserAchievement(UserAchievement userAchievement)
    {
        return userAchievementMapper.insertUserAchievement(userAchievement);
    }

    /**
     * 修改用户成就
     * 
     * @param userAchievement 用户成就
     * @return 结果
     */
    @Override
    public int updateUserAchievement(UserAchievement userAchievement)
    {
        return userAchievementMapper.updateUserAchievement(userAchievement);
    }

    /**
     * 批量删除用户成就
     * 
     * @param ids 需要删除的用户成就主键
     * @return 结果
     */
    @Override
    public int deleteUserAchievementByIds(Long[] ids)
    {
        return userAchievementMapper.deleteUserAchievementByIds(ids);
    }

    /**
     * 删除用户成就信息
     * 
     * @param id 用户成就主键
     * @return 结果
     */
    @Override
    public int deleteUserAchievementById(Long id)
    {
        return userAchievementMapper.deleteUserAchievementById(id);
    }
}
