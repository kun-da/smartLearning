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
import com.ruoyi.smartLearning.domain.LearningResources;
import com.ruoyi.smartLearning.service.ILearningResourcesService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 学习资料Controller
 * 
 * @author 虞嘉欣
 * @date 2024-10-21
 */
@RestController
@RequestMapping("/smartLearning/resources")
public class LearningResourcesController extends BaseController
{
    @Autowired
    private ILearningResourcesService learningResourcesService;

    /**
     * 查询学习资料列表
     */
    @PreAuthorize("@ss.hasPermi('smartLearning:resources:list')")
    @GetMapping("/list")
    public TableDataInfo list(LearningResources learningResources)
    {
        startPage();
        List<LearningResources> list = learningResourcesService.selectLearningResourcesList(learningResources);
        return getDataTable(list);
    }

    /**
     * 导出学习资料列表
     */
    @PreAuthorize("@ss.hasPermi('smartLearning:resources:export')")
    @Log(title = "学习资料", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, LearningResources learningResources)
    {
        List<LearningResources> list = learningResourcesService.selectLearningResourcesList(learningResources);
        ExcelUtil<LearningResources> util = new ExcelUtil<LearningResources>(LearningResources.class);
        util.exportExcel(response, list, "学习资料数据");
    }

    /**
     * 获取学习资料详细信息
     */
    @PreAuthorize("@ss.hasPermi('smartLearning:resources:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(learningResourcesService.selectLearningResourcesById(id));
    }

    /**
     * 新增学习资料
     */
    @PreAuthorize("@ss.hasPermi('smartLearning:resources:add')")
    @Log(title = "学习资料", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody LearningResources learningResources)
    {
        return toAjax(learningResourcesService.insertLearningResources(learningResources));
    }

    /**
     * 修改学习资料
     */
    @PreAuthorize("@ss.hasPermi('smartLearning:resources:edit')")
    @Log(title = "学习资料", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody LearningResources learningResources)
    {
        return toAjax(learningResourcesService.updateLearningResources(learningResources));
    }

    /**
     * 删除学习资料
     */
    @PreAuthorize("@ss.hasPermi('smartLearning:resources:remove')")
    @Log(title = "学习资料", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(learningResourcesService.deleteLearningResourcesByIds(ids));
    }
}
