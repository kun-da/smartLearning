package com.ruoyi.smartLearning.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.smartLearning.domain.LearningPlans;
import com.ruoyi.smartLearning.service.ILearningPlansService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 学习计划Controller
 * 
 * @author ruoyi
 * @date 2024-10-21
 */
@RestController
@RequestMapping("/smartLearning/plans")
public class LearningPlansController extends BaseController
{
    @Autowired
    private ILearningPlansService learningPlansService;

    /**
     * 查询学习计划列表
     */
    @PreAuthorize("@ss.hasPermi('smartLearning:plans:list')")
    @GetMapping("/list")
    public TableDataInfo list(LearningPlans learningPlans)
    {
        startPage();
        List<LearningPlans> list = learningPlansService.selectLearningPlansList(learningPlans);
        return getDataTable(list);
    }

    /**
     * 导出学习计划列表
     */
    @PreAuthorize("@ss.hasPermi('smartLearning:plans:export')")
    @Log(title = "学习计划", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, LearningPlans learningPlans)
    {
        List<LearningPlans> list = learningPlansService.selectLearningPlansList(learningPlans);
        ExcelUtil<LearningPlans> util = new ExcelUtil<LearningPlans>(LearningPlans.class);
        util.exportExcel(response, list, "学习计划数据");
    }

    /**
     * 获取学习计划详细信息
     */
    @PreAuthorize("@ss.hasPermi('smartLearning:plans:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(learningPlansService.selectLearningPlansById(id));
    }

    /**
     * 新增学习计划
     */
    @PreAuthorize("@ss.hasPermi('smartLearning:plans:add')")
    @Log(title = "学习计划", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody LearningPlans learningPlans)
    {
        return toAjax(learningPlansService.insertLearningPlans(learningPlans));
    }

    /**
     * 修改学习计划
     */
    @PreAuthorize("@ss.hasPermi('smartLearning:plans:edit')")
    @Log(title = "学习计划", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody LearningPlans learningPlans)
    {
        return toAjax(learningPlansService.updateLearningPlans(learningPlans));
    }

    /**
     * 删除学习计划
     */
    @PreAuthorize("@ss.hasPermi('smartLearning:plans:remove')")
    @Log(title = "学习计划", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(learningPlansService.deleteLearningPlansByIds(ids));
    }
}
