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
import com.ruoyi.smartLearning.domain.LearningProgress;
import com.ruoyi.smartLearning.service.ILearningProgressService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 学习进度Controller
 * 
 * @author 虞嘉欣
 * @date 2024-10-21
 */
@RestController
@RequestMapping("/smartLearning/progress")
public class LearningProgressController extends BaseController
{
    @Autowired
    private ILearningProgressService learningProgressService;

    /**
     * 查询学习进度列表
     */
    @PreAuthorize("@ss.hasPermi('smartLearning:progress:list')")
    @GetMapping("/list")
    public TableDataInfo list(LearningProgress learningProgress)
    {
        startPage();
        List<LearningProgress> list = learningProgressService.selectLearningProgressList(learningProgress);
        return getDataTable(list);
    }

    /**
     * 导出学习进度列表
     */
    @PreAuthorize("@ss.hasPermi('smartLearning:progress:export')")
    @Log(title = "学习进度", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, LearningProgress learningProgress)
    {
        List<LearningProgress> list = learningProgressService.selectLearningProgressList(learningProgress);
        ExcelUtil<LearningProgress> util = new ExcelUtil<LearningProgress>(LearningProgress.class);
        util.exportExcel(response, list, "学习进度数据");
    }

    /**
     * 获取学习进度详细信息
     */
    @PreAuthorize("@ss.hasPermi('smartLearning:progress:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(learningProgressService.selectLearningProgressById(id));
    }

    /**
     * 新增学习进度
     */
    @PreAuthorize("@ss.hasPermi('smartLearning:progress:add')")
    @Log(title = "学习进度", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody LearningProgress learningProgress)
    {
        return toAjax(learningProgressService.insertLearningProgress(learningProgress));
    }

    /**
     * 修改学习进度
     */
    @PreAuthorize("@ss.hasPermi('smartLearning:progress:edit')")
    @Log(title = "学习进度", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody LearningProgress learningProgress)
    {
        return toAjax(learningProgressService.updateLearningProgress(learningProgress));
    }

    /**
     * 删除学习进度
     */
    @PreAuthorize("@ss.hasPermi('smartLearning:progress:remove')")
    @Log(title = "学习进度", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(learningProgressService.deleteLearningProgressByIds(ids));
    }
}
