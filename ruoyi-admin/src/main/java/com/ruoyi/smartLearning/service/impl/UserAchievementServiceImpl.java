package com.ruoyi.smartLearning.service.impl;

import java.util.Date;
import java.util.List;

import com.ruoyi.smartLearning.domain.*;
import com.ruoyi.smartLearning.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.smartLearning.service.IUserAchievementService;
import org.springframework.transaction.annotation.Transactional;

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

    @Autowired
    private LearningProgressMapper learningProgressMapper;

    @Autowired
    private LearningPlansMapper learningPlansMapper;

    @Autowired
    private TasksMapper tasksMapper;

    @Autowired
    private AchievementConditionsMapper achievementConditionsMapper;

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

    @Override
//    @Transactional
    public void isAchievement(Long userId) {
        //计算用户的总学习时间（查询用户进度表中的spent值，根据userid，并累加）

        //查询学习进度
        LearningProgress learningProgress = new LearningProgress();
        learningProgress.setUserId(userId);
        List<LearningProgress> learningProgresses = learningProgressMapper.selectLearningProgressList(learningProgress);

        //累加学习时间（提取learningProgresses每个中的hoursSpent值并累加）
        Long totalHoursSpent = 0L;
        for (LearningProgress progress : learningProgresses) {
            totalHoursSpent += progress.getHoursSpent();
        }

        //获取用户创建的计划总数
        LearningPlans learningPlans = new LearningPlans();
        learningPlans.setUserId(userId);
        List<LearningPlans> learningPlansList = learningPlansMapper.selectLearningPlansList(learningPlans);
        int totalPlans = learningPlansList.size();

        int totalTasks = 0;
        //遍历learningPlansList中的id
        for (LearningPlans plans : learningPlansList) {
            //获取每个计划里的任务完成数量
            Tasks tasks = new Tasks();
            tasks.setPlanId(plans.getId());
            //2表示已完成
            tasks.setStatus(2L);
            List<Tasks> tasksList = tasksMapper.selectTasksList(tasks);
            totalTasks += tasksList.size();

        }

        //打印信息
        System.out.println("=====================================================================");
        System.out.println("当前用户id：" + userId);
        System.out.println("总学习时间：" + totalHoursSpent);
        System.out.println("计划总数：" + totalPlans);
        System.out.println("任务完成数：" + totalTasks);
        System.out.println("=====================================================================");

        //开始判断

        //获取所有成就信息
        List<AchievementConditions> achievementConditions = achievementConditionsMapper.selectAchievementConditionsList(new AchievementConditions());

        //遍历成就信息
        for (AchievementConditions achievementCondition : achievementConditions) {
            //获取成就类型：学习时间0、计划总数2、任务完成数1
            Long targetType = achievementCondition.getTargetType();
            //判断成就是否完成
            //学习时间判断
            if (targetType == 0) {
                //获取成就需要要达到的学习时间
                Long targetValue = achievementCondition.getTargetValue();
                if (totalHoursSpent >= targetValue) {
                    //成就完成则，将当前成就存入用户成就表
                    UserAchievement userAchievement = new UserAchievement();
                    userAchievement.setUserId(userId);
                    userAchievement.setAchievementId(achievementCondition.getId());
                    userAchievement.setAchievementTime(new Date());
                    userAchievementMapper.insertUserAchievement(userAchievement);
                }
            }
            //计划总数判断
            else if (targetType == 2) {
                //获取成就需要要达到的计划总数
                Long targetValue = achievementCondition.getTargetValue();
                if (totalPlans >= targetValue) {
                    //成就完成则，将当前成就存入用户成就表
                    UserAchievement userAchievement = new UserAchievement();
                    userAchievement.setUserId(userId);
                    userAchievement.setAchievementId(achievementCondition.getId());
                    userAchievement.setAchievementTime(new Date());
                    userAchievementMapper.insertUserAchievement(userAchievement);
                }
            }
            //任务完成数判断
            else {
                //获取成就需要要达到的任务完成数
                Long targetValue = achievementCondition.getTargetValue();
                if (totalTasks >= targetValue) {
                    //成就完成则，将当前成就存入用户成就表
                    UserAchievement userAchievement = new UserAchievement();
                    userAchievement.setUserId(userId);
                    userAchievement.setAchievementId(achievementCondition.getId());
                    userAchievement.setAchievementTime(new Date());
                    userAchievementMapper.insertUserAchievement(userAchievement);
                }
            }
        }
    }
}
