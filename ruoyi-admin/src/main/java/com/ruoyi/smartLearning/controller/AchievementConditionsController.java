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
import com.ruoyi.smartLearning.domain.AchievementConditions;
import com.ruoyi.smartLearning.service.IAchievementConditionsService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 成就配置Controller
 * 
 * @author 虞嘉欣
 * @date 2024-11-05
 */
@RestController
@RequestMapping("/smartLearning/conditions")
public class AchievementConditionsController extends BaseController
{
    @Autowired
    private IAchievementConditionsService achievementConditionsService;

    /**
     * 查询成就配置列表
     */
    @PreAuthorize("@ss.hasPermi('smartLearning:conditions:list')")
    @GetMapping("/list")
    public TableDataInfo list(AchievementConditions achievementConditions)
    {
        startPage();
        List<AchievementConditions> list = achievementConditionsService.selectAchievementConditionsList(achievementConditions);
        return getDataTable(list);
    }

    /**
     * 导出成就配置列表
     */
    @PreAuthorize("@ss.hasPermi('smartLearning:conditions:export')")
    @Log(title = "成就配置", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AchievementConditions achievementConditions)
    {
        List<AchievementConditions> list = achievementConditionsService.selectAchievementConditionsList(achievementConditions);
        ExcelUtil<AchievementConditions> util = new ExcelUtil<AchievementConditions>(AchievementConditions.class);
        util.exportExcel(response, list, "成就配置数据");
    }

    /**
     * 获取成就配置详细信息
     */
    @PreAuthorize("@ss.hasPermi('smartLearning:conditions:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(achievementConditionsService.selectAchievementConditionsById(id));
    }

    /**
     * 新增成就配置
     */
    @PreAuthorize("@ss.hasPermi('smartLearning:conditions:add')")
    @Log(title = "成就配置", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AchievementConditions achievementConditions)
    {
        return toAjax(achievementConditionsService.insertAchievementConditions(achievementConditions));
    }

    /**
     * 修改成就配置
     */
    @PreAuthorize("@ss.hasPermi('smartLearning:conditions:edit')")
    @Log(title = "成就配置", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AchievementConditions achievementConditions)
    {
        return toAjax(achievementConditionsService.updateAchievementConditions(achievementConditions));
    }

    /**
     * 删除成就配置
     */
    @PreAuthorize("@ss.hasPermi('smartLearning:conditions:remove')")
    @Log(title = "成就配置", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(achievementConditionsService.deleteAchievementConditionsByIds(ids));
    }
}
