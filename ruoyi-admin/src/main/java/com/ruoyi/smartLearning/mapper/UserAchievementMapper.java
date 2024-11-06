package com.ruoyi.smartLearning.mapper;

import java.util.List;
import com.ruoyi.smartLearning.domain.UserAchievement;

/**
 * 用户成就Mapper接口
 * 
 * @author 虞
 * @date 2024-11-05
 */
public interface UserAchievementMapper 
{
    /**
     * 查询用户成就
     * 
     * @param id 用户成就主键
     * @return 用户成就
     */
    public UserAchievement selectUserAchievementById(Long id);

    /**
     * 查询用户成就列表
     * 
     * @param userAchievement 用户成就
     * @return 用户成就集合
     */
    public List<UserAchievement> selectUserAchievementList(UserAchievement userAchievement);

    /**
     * 新增用户成就
     * 
     * @param userAchievement 用户成就
     * @return 结果
     */
    public int insertUserAchievement(UserAchievement userAchievement);

    /**
     * 修改用户成就
     * 
     * @param userAchievement 用户成就
     * @return 结果
     */
    public int updateUserAchievement(UserAchievement userAchievement);

    /**
     * 删除用户成就
     * 
     * @param id 用户成就主键
     * @return 结果
     */
    public int deleteUserAchievementById(Long id);

    /**
     * 批量删除用户成就
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteUserAchievementByIds(Long[] ids);
}
