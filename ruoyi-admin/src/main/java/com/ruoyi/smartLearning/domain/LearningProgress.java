package com.ruoyi.smartLearning.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 学习进度对象 learning_progress
 *
 * @author 虞嘉欣
 * @date 2024-10-21
 */
public class LearningProgress extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 进度ID，主键，自增 */
    private Long id;

    /** 用户ID，用于标识进度的记录者 */
    @Excel(name = "用户ID，用于标识进度的记录者")
    private Long userId;

    /** 学习计划ID，用于关联到学习计划 */
    @Excel(name = "学习计划ID，用于关联到学习计划")
    private Long planId;

    /** 任务ID，用于关联到具体的任务 */
    @Excel(name = "任务ID，用于关联到具体的任务")
    private Long taskId;

    /** 用户在任务上花费的学习时间（小时） */
    @Excel(name = "用户在任务上花费的学习时间", readConverterExp = "小=时")
    private Long hoursSpent;

    /** 学习进度的最后更新时间，更新时自动修改 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "学习进度的最后更新时间，更新时自动修改", width = 30, dateFormat = "yyyy-MM-dd")
    private Date updatedAt;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setUserId(Long userId)
    {
        this.userId = userId;
    }

    public Long getUserId()
    {
        return userId;
    }
    public void setPlanId(Long planId)
    {
        this.planId = planId;
    }

    public Long getPlanId()
    {
        return planId;
    }
    public void setTaskId(Long taskId)
    {
        this.taskId = taskId;
    }

    public Long getTaskId()
    {
        return taskId;
    }
    public void setHoursSpent(Long hoursSpent)
    {
        this.hoursSpent = hoursSpent;
    }

    public Long getHoursSpent()
    {
        return hoursSpent;
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
            .append("userId", getUserId())
            .append("planId", getPlanId())
            .append("taskId", getTaskId())
            .append("hoursSpent", getHoursSpent())
            .append("updatedAt", getUpdatedAt())
            .toString();
    }
}
