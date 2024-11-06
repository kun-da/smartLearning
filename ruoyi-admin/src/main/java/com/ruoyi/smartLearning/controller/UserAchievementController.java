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
import com.ruoyi.smartLearning.domain.UserAchievement;
import com.ruoyi.smartLearning.service.IUserAchievementService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 用户成就Controller
 * 
 * @author 虞
 * @date 2024-11-05
 */
@RestController
@RequestMapping("/smartLearning/achievement")
public class UserAchievementController extends BaseController
{
    @Autowired
    private IUserAchievementService userAchievementService;

    /**
     * 查询用户成就列表
     */
    @PreAuthorize("@ss.hasPermi('smartLearning:achievement:list')")
    @GetMapping("/list")
    public TableDataInfo list(UserAchievement userAchievement)
    {
        startPage();
        List<UserAchievement> list = userAchievementService.selectUserAchievementList(userAchievement);
        return getDataTable(list);
    }

    /**
     * 导出用户成就列表
     */
    @PreAuthorize("@ss.hasPermi('smartLearning:achievement:export')")
    @Log(title = "用户成就", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, UserAchievement userAchievement)
    {
        List<UserAchievement> list = userAchievementService.selectUserAchievementList(userAchievement);
        ExcelUtil<UserAchievement> util = new ExcelUtil<UserAchievement>(UserAchievement.class);
        util.exportExcel(response, list, "用户成就数据");
    }

    /**
     * 获取用户成就详细信息
     */
    @PreAuthorize("@ss.hasPermi('smartLearning:achievement:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(userAchievementService.selectUserAchievementById(id));
    }

    /**
     * 新增用户成就
     */
    @PreAuthorize("@ss.hasPermi('smartLearning:achievement:add')")
    @Log(title = "用户成就", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody UserAchievement userAchievement)
    {
        return toAjax(userAchievementService.insertUserAchievement(userAchievement));
    }

    /**
     * 修改用户成就
     */
    @PreAuthorize("@ss.hasPermi('smartLearning:achievement:edit')")
    @Log(title = "用户成就", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody UserAchievement userAchievement)
    {
        return toAjax(userAchievementService.updateUserAchievement(userAchievement));
    }

    /**
     * 删除用户成就
     */
    @PreAuthorize("@ss.hasPermi('smartLearning:achievement:remove')")
    @Log(title = "用户成就", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(userAchievementService.deleteUserAchievementByIds(ids));
    }
}
