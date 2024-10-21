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
import com.ruoyi.smartLearning.domain.Notifications;
import com.ruoyi.smartLearning.service.INotificationsService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 学习通知Controller
 * 
 * @author 虞嘉欣
 * @date 2024-10-21
 */
@RestController
@RequestMapping("/smartLearning/notifications")
public class NotificationsController extends BaseController
{
    @Autowired
    private INotificationsService notificationsService;

    /**
     * 查询学习通知列表
     */
    @PreAuthorize("@ss.hasPermi('smartLearning:notifications:list')")
    @GetMapping("/list")
    public TableDataInfo list(Notifications notifications)
    {
        startPage();
        List<Notifications> list = notificationsService.selectNotificationsList(notifications);
        return getDataTable(list);
    }

    /**
     * 导出学习通知列表
     */
    @PreAuthorize("@ss.hasPermi('smartLearning:notifications:export')")
    @Log(title = "学习通知", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Notifications notifications)
    {
        List<Notifications> list = notificationsService.selectNotificationsList(notifications);
        ExcelUtil<Notifications> util = new ExcelUtil<Notifications>(Notifications.class);
        util.exportExcel(response, list, "学习通知数据");
    }

    /**
     * 获取学习通知详细信息
     */
    @PreAuthorize("@ss.hasPermi('smartLearning:notifications:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(notificationsService.selectNotificationsById(id));
    }

    /**
     * 新增学习通知
     */
    @PreAuthorize("@ss.hasPermi('smartLearning:notifications:add')")
    @Log(title = "学习通知", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Notifications notifications)
    {
        return toAjax(notificationsService.insertNotifications(notifications));
    }

    /**
     * 修改学习通知
     */
    @PreAuthorize("@ss.hasPermi('smartLearning:notifications:edit')")
    @Log(title = "学习通知", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Notifications notifications)
    {
        return toAjax(notificationsService.updateNotifications(notifications));
    }

    /**
     * 删除学习通知
     */
    @PreAuthorize("@ss.hasPermi('smartLearning:notifications:remove')")
    @Log(title = "学习通知", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(notificationsService.deleteNotificationsByIds(ids));
    }
}
