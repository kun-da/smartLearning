package com.ruoyi.smartLearning.controller;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.smartLearning.domain.LearningPlans;
import com.ruoyi.smartLearning.domain.LearningProgress;
import com.ruoyi.smartLearning.domain.Tasks;
import com.ruoyi.smartLearning.service.ILearningPlansService;
import com.ruoyi.smartLearning.service.ILearningProgressService;
import com.ruoyi.smartLearning.service.ITasksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.crypto.Data;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/smartLearning/taskTimerHall")
//任务展示堂控制层
public class taskTimerHallController extends BaseController {

    @Autowired
    private ILearningPlansService learningPlansService;

    @Autowired
    private ITasksService tasksService;

    @Autowired
    private ILearningProgressService learningProgressService;




    /**
     * 获取（查询）计划，根据用户id查询
     */
    @GetMapping("/getTaskTimerHall")
    public AjaxResult getTaskTimerHall() {
        Long userId = getUserId();
        List<LearningPlans> learningPlans = learningPlansService.selectLearningPlansByDate(userId, null);
        return AjaxResult.success(learningPlans);
    }

    /**
     * 查询学习计划，传入日期参数，get
     */
    @GetMapping("/getTaskTimerHallByDate/{date}")
    public AjaxResult getTaskTimerHallByDate(@PathVariable("date") String date) {
        System.out.println("date = " + date);
        Long userId = getUserId();
        List<LearningPlans> learningPlans = learningPlansService.selectLearningPlansByDate(userId,date);
        return AjaxResult.success(learningPlans);
    }


    /**
     * 根据计划id查询学习任务
     */
    @GetMapping("/getTaskTimerByPlanId")
    public AjaxResult getTaskTimerHallByPlanId(Long planId) {
        //将id封转装成对象
        Tasks tasks = new Tasks();
        tasks.setPlanId(planId);
        return AjaxResult.success(tasksService.selectTasksList(tasks));
    }


    /**
     * 查询学习进度，若不存在则创建，传入（参数计划id，任务id，用户id）tasks实体类
     */
    @PostMapping("/getTaskTimerProgress")
    public AjaxResult getTaskTimerProgress(@RequestBody Tasks tasks){
        //获取用户id
        Long userId = getUserId();
        //将用户id等数据封装到LearningProgress实体类中
        LearningProgress learningProgress = new LearningProgress();
        learningProgress.setUserId(userId);
        learningProgress.setPlanId(tasks.getPlanId());
        learningProgress.setTaskId(tasks.getId());
        //根据用户id，计划id，任务id查询学习进度
        List<LearningProgress> learningProgresses = learningProgressService.selectLearningProgressListHall(learningProgress);
        return AjaxResult.success(learningProgresses);
    }

    /**
     * 修改学习进度
     */
    @PutMapping
    public AjaxResult edit(@RequestBody LearningProgress learningProgress)
    {
//        System.out.println("learningProgress = " + learningProgress);
        return toAjax(learningProgressService.updateLearningProgress(learningProgress));
    }

}
