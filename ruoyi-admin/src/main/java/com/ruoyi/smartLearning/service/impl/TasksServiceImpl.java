package com.ruoyi.smartLearning.service.impl;

import java.util.Date;
import java.util.List;

import com.ruoyi.smartLearning.domain.LearningPlans;
import com.ruoyi.smartLearning.mapper.LearningPlansMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.smartLearning.mapper.TasksMapper;
import com.ruoyi.smartLearning.domain.Tasks;
import com.ruoyi.smartLearning.service.ITasksService;
import org.springframework.transaction.annotation.Transactional;

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

    @Autowired
    private LearningPlansMapper learningPlansMapper;


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
        //设置任务初始状态为进行中
        tasks.setStatus(1L);
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

    @Override
    public int updateTaskStatus(Tasks tasks) {
        //判断当前日期是否大于截止日期，如果大于则将任务状态设置为3
        if (tasks.getDueDate().before(new Date())) {
            tasks.setStatus(3L);
            return updateTasks(tasks);
        }
        //判断当前日期是否小于截止日期，如果小于则将任务状态设置为1
        else if( tasks.getStatus() == 3L){
            if( tasks.getDueDate().after(new Date())){
                tasks.setStatus(1L);
                return updateTasks(tasks);
            }
        }
        return 0;
    }

    @Override
    public int updateTaskStatusToComplete(Tasks tasks) {
        tasks.setStatus(2L);
        return updateTasks(tasks);
    }
}
