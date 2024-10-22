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
import com.ruoyi.smartLearning.domain.Tasks;
import com.ruoyi.smartLearning.service.ITasksService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 学习任务Controller
 *
 * @author 虞嘉欣
 * @date 2024-10-21
 */
@RestController
@RequestMapping("/smartLearning/tasks")
public class TasksController extends BaseController
{
    @Autowired
    private ITasksService tasksService;

    /**
     * 查询学习任务列表
     */
    @PreAuthorize("@ss.hasPermi('smartLearning:tasks:list')")
    @GetMapping("/list")
    public TableDataInfo list(Tasks tasks)
    {
        startPage();
        List<Tasks> list = tasksService.selectTasksList(tasks);
        return getDataTable(list);
    }

    /**
     * 导出学习任务列表
     */
    @PreAuthorize("@ss.hasPermi('smartLearning:tasks:export')")
    @Log(title = "学习任务", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Tasks tasks)
    {
        List<Tasks> list = tasksService.selectTasksList(tasks);
        ExcelUtil<Tasks> util = new ExcelUtil<Tasks>(Tasks.class);
        util.exportExcel(response, list, "学习任务数据");
    }

    /**
     * 获取学习任务详细信息
     */
    @PreAuthorize("@ss.hasPermi('smartLearning:tasks:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(tasksService.selectTasksById(id));
    }

    /**
     * 新增学习任务
     */
    @PreAuthorize("@ss.hasPermi('smartLearning:tasks:add')")
    @Log(title = "学习任务", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Tasks tasks)
    {
        return toAjax(tasksService.insertTasks(tasks));
    }

    /**
     * 修改学习任务
     */
    @PreAuthorize("@ss.hasPermi('smartLearning:tasks:edit')")
    @Log(title = "学习任务", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Tasks tasks)
    {
        return toAjax(tasksService.updateTasks(tasks));
    }

    /**
     * 删除学习任务
     */
    @PreAuthorize("@ss.hasPermi('smartLearning:tasks:remove')")
    @Log(title = "学习任务", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tasksService.deleteTasksByIds(ids));
    }
}
