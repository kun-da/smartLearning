package com.ruoyi.smartLearning.controller;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.smartLearning.domain.LearningPlans;
import com.ruoyi.smartLearning.service.ILearningPlansService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/smartLearning/taskTimerHall")
//任务展示堂控制层
public class taskTimerHallController extends BaseController {

    @Autowired
    private ILearningPlansService learningPlansService;

    /**
     * 获取（查询）当前时间段的计划
     */
    @GetMapping("/getTaskTimerHall")
    public AjaxResult getTaskTimerHall() {
        List<LearningPlans> learningPlans = learningPlansService.selectLearningPlansByDate();
        return AjaxResult.success(learningPlans);
    }
}
