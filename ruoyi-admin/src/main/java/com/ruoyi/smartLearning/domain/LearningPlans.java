package com.ruoyi.smartLearning.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 学习计划对象 learning_plans
 * 
 * @author ruoyi
 * @date 2024-10-21
 */
public class LearningPlans extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 学习计划ID，主键，自增 */
    private Long id;

    /** 用户ID，用于标识计划的创建者 */
    @Excel(name = "用户ID，用于标识计划的创建者")
    private Long userId;

    /** 学习计划标题 */
    @Excel(name = "学习计划标题")
    private String title;

    /** 学习计划的详细描述 */
    @Excel(name = "学习计划的详细描述")
    private String description;

    /** 学习计划的开始日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "学习计划的开始日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date startDate;

    /** 学习计划的结束日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "学习计划的结束日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date endDate;

    /** 学习计划的创建时间，默认当前时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "学习计划的创建时间，默认当前时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createdAt;

    /** 学习计划的最后更新时间，更新时自动修改 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "学习计划的最后更新时间，更新时自动修改", width = 30, dateFormat = "yyyy-MM-dd")
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
    public void setTitle(String title) 
    {
        this.title = title;
    }

    public String getTitle() 
    {
        return title;
    }
    public void setDescription(String description) 
    {
        this.description = description;
    }

    public String getDescription() 
    {
        return description;
    }
    public void setStartDate(Date startDate) 
    {
        this.startDate = startDate;
    }

    public Date getStartDate() 
    {
        return startDate;
    }
    public void setEndDate(Date endDate) 
    {
        this.endDate = endDate;
    }

    public Date getEndDate() 
    {
        return endDate;
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
            .append("userId", getUserId())
            .append("title", getTitle())
            .append("description", getDescription())
            .append("startDate", getStartDate())
            .append("endDate", getEndDate())
            .append("createdAt", getCreatedAt())
            .append("updatedAt", getUpdatedAt())
            .toString();
    }
}
