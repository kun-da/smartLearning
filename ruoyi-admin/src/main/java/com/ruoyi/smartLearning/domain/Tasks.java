package com.ruoyi.smartLearning.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 学习任务对象 tasks
 *
 * @author 虞嘉欣
 * @date 2024-10-21
 */
public class Tasks extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 任务ID，主键，自增 */
    private Long id;

    /** 学习计划ID，用于关联到学习计划 */
    @Excel(name = "学习计划ID，用于关联到学习计划")
    private Long planId;

    /** 任务名称 */
    @Excel(name = "任务名称")
    private String taskName;

    /** 任务的详细描述 */
    @Excel(name = "任务的详细描述")
    private String description;

    /** 任务状态（未开始、进行中、已完成） */
    @Excel(name = "任务状态", readConverterExp = "未开始、进行中、已完成")
    private Long status;

    /** 任务的截止日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "任务的截止日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date dueDate;

    /** 任务的总学习时间（小时） */
    @Excel(name = "任务的总学习时间", readConverterExp = "小=时")
    private BigDecimal totalTime;

    /** 任务的创建时间，默认当前时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "任务的创建时间，默认当前时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createdAt;

    /** 任务的最后更新时间，更新时自动修改 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "任务的最后更新时间，更新时自动修改", width = 30, dateFormat = "yyyy-MM-dd")
    private Date updatedAt;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setPlanId(Long planId)
    {
        this.planId = planId;
    }

    public Long getPlanId()
    {
        return planId;
    }
    public void setTaskName(String taskName)
    {
        this.taskName = taskName;
    }

    public String getTaskName()
    {
        return taskName;
    }
    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getDescription()
    {
        return description;
    }
    public void setStatus(Long status)
    {
        this.status = status;
    }

    public Long getStatus()
    {
        return status;
    }
    public void setDueDate(Date dueDate)
    {
        this.dueDate = dueDate;
    }

    public Date getDueDate()
    {
        return dueDate;
    }
    public void setTotalTime(BigDecimal totalTime)
    {
        this.totalTime = totalTime;
    }

    public BigDecimal getTotalTime()
    {
        return totalTime;
    }
    public void setCreatedAt(Date createdAt)
    {
        this.createdAt = createdAt;
    }

    public Date getCreatedAt()
    {
        return createdAt;
    }
    public void setUpdatedAt(Date updatedAt)
    {
        this.updatedAt = updatedAt;
    }

    public Date getUpdatedAt()
    {
        return updatedAt;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("planId", getPlanId())
            .append("taskName", getTaskName())
            .append("description", getDescription())
            .append("status", getStatus())
            .append("dueDate", getDueDate())
            .append("totalTime", getTotalTime())
            .append("createdAt", getCreatedAt())
            .append("updatedAt", getUpdatedAt())
            .toString();
    }
}
