package com.ruoyi.smartLearning.service;

import java.util.List;
import com.ruoyi.smartLearning.domain.Tasks;

/**
 * 学习任务Service接口
 *
 * @author 虞嘉欣
 * @date 2024-10-21
 */
public interface ITasksService
{
    /**
     * 查询学习任务
     *
     * @param id 学习任务主键
     * @return 学习任务
     */
    public Tasks selectTasksById(Long id);

    /**
     * 查询学习任务列表
     *
     * @param tasks 学习任务
     * @return 学习任务集合
     */
    public List<Tasks> selectTasksList(Tasks tasks);

    /**
     * 新增学习任务
     *
     * @param tasks 学习任务
     * @return 结果
     */
    public int insertTasks(Tasks tasks);

    /**
     * 修改学习任务
     *
     * @param tasks 学习任务
     * @return 结果
     */
    public int updateTasks(Tasks tasks);

    /**
     * 批量删除学习任务
     *
     * @param ids 需要删除的学习任务主键集合
     * @return 结果
     */
    public int deleteTasksByIds(Long[] ids);

    /**
     * 删除学习任务信息
     *
     * @param id 学习任务主键
     * @return 结果
     */
    public int deleteTasksById(Long id);

    int updateTaskStatus(Tasks tasks);

    int updateTaskStatusToComplete(Tasks tasks);
}
