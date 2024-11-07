package com.ruoyi.smartLearning.controller;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.smartLearning.service.IAchievementConditionsService;
import com.ruoyi.smartLearning.service.IUserAchievementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * 用于展示用户个人成就的视图控制器
 */
@RestController
@RequestMapping("/smartLearning/myAchievementsView")
public class MyAchievementsViewController extends BaseController {

    @Autowired
    private IAchievementConditionsService achievementConditionsService;

    @Autowired
    private IUserAchievementService userAchievementService;


    /**
     * 展示用户个人成就，（查询所有成就，并区分出已完成和未完成）
     */
    @GetMapping("/showMyAchievements")
    public AjaxResult showMyAchievements(){
        Long userId = getUserId();
        //处理具体逻辑,返回map集合，包含所有的成就与用户已完成成就的id数组
        HashMap<String, Object> stringObjectHashMap = achievementConditionsService.showMyAchievements(userId);
        return AjaxResult.success(stringObjectHashMap);
    }

    /**
     * 判断用户是否完成成就（参数用户id），如完成则向用户成就表中添加数据
     */
    @GetMapping("/isAchievement")
    public AjaxResult isAchievement(){
        Long userId = getUserId();
        //处理具体逻辑(有更改返回true，无更改返回false)
        userAchievementService.isAchievement(userId);
        return AjaxResult.success();
    }


}
