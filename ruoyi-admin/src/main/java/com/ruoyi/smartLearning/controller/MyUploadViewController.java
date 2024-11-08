package com.ruoyi.smartLearning.controller;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.smartLearning.domain.LearningResources;
import com.ruoyi.smartLearning.service.ILearningResourcesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 前台文件上传与展示功能
 */
@RestController
@RequestMapping("/smartLearning/myUploadView")
public class MyUploadViewController extends BaseController {

    @Autowired
    private ILearningResourcesService learningResourcesService;

    /**
     * 查询所有当前用户的上传文件
     */
    @GetMapping("/list")
    public AjaxResult list() {
        Long userId = getUserId();
        LearningResources learningResources = new LearningResources();
        learningResources.setUserId(userId);
        List<LearningResources> learningResourcesList = learningResourcesService.selectLearningResourcesList(learningResources);
        return AjaxResult.success(learningResourcesList);
    }
    /**
     * 查询除开当前用户的共享资料
     */
    @GetMapping("/listShare")
    public AjaxResult listShare() {
        Long userId = getUserId();
        LearningResources learningResources = new LearningResources();
        learningResources.setUserId(userId);
        List<LearningResources> learningResourcesList = learningResourcesService.selectLearningResourcesListShare(learningResources);
        return AjaxResult.success(learningResourcesList);
    }
}
