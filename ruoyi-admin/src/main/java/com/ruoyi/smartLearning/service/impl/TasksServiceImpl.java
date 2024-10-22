package com.ruoyi.smartLearning.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.smartLearning.mapper.TasksMapper;
import com.ruoyi.smartLearning.domain.Tasks;
import com.ruoyi.smartLearning.service.ITasksService;

/**
 * 学习任务Service业务层处理
 *
 * @author 虞嘉欣
 * @date 2024-10-21
 */
@Service
public class TasksServiceImpl implements ITasksService {
    @Autowired
    private TasksMapper tasksMapper;

    /**
     * 查询学习任务
     *
     * @param id 学习任务主键
     * @return 学习任务
     */
    @Override
    public Tasks selectTasksById(Long id) {
        return tasksMapper.selectTasksById(id);
    }

    /**
     * 查询学习任务列表
     *
     * @param tasks 学习任务
     * @return 学习任务
     */
    @Override
    public List<Tasks> selectTasksList(Tasks tasks) {
        return tasksMapper.selectTasksList(tasks);
    }

    /**
     * 新增学习任务
     *
     * @param tasks 学习任务
     * @return 结果
     */
    @Override
    public int insertTasks(Tasks tasks) {
        //判断 截止日期 是否为空，如果为空则设置为当前时间
        if (tasks.getDueDate() == null) {
            tasks.setDueDate(new Date());
        }
        //判断 任务描述 是否为空，如果为空则设置为默认值
        if (tasks.getDescription() == null) {
            tasks.setDescription("什么都没有写呢~~~");
        }
        System.out.println("学习任务模块-新增任务数据：" + tasks);
        return tasksMapper.insertTasks(tasks);
    }

    /**
     * 修改学习任务
     *
     * @param tasks 学习任务
     * @return 结果
     */
    @Override
    public int updateTasks(Tasks tasks) {
        System.out.println("学习任务模块-修改任务数据：" + tasks);
        return tasksMapper.updateTasks(tasks);
    }

    /**
     * 批量删除学习任务
     *
     * @param ids 需要删除的学习任务主键
     * @return 结果
     */
    @Override
    public int deleteTasksByIds(Long[] ids) {
        return tasksMapper.deleteTasksByIds(ids);
    }

    /**
     * 删除学习任务信息
     *
     * @param id 学习任务主键
     * @return 结果
     */
    @Override
    public int deleteTasksById(Long id) {
        return tasksMapper.deleteTasksById(id);
    }
}
