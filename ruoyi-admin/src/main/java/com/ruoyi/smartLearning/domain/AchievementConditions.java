package com.ruoyi.smartLearning.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 成就配置对象 achievement_conditions
 * 
 * @author 虞嘉欣
 * @date 2024-11-05
 */
public class AchievementConditions extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 配置ID */
    private Long id;

    /** 成就名称 */
    @Excel(name = "成就名称")
    private String name;

    /** 成就描述 */
    @Excel(name = "成就描述")
    private String description;

    /** 完成目标 */
    @Excel(name = "完成目标")
    private Long targetValue;

    /** 奖励积分 */
    @Excel(name = "奖励积分")
    private Long rewardPoints;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createdAt;

    /** 更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "更新时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date updatedAt;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setDescription(String description) 
    {
        this.description = description;
    }

    public String getDescription() 
    {
        return description;
    }
    public void setTargetValue(Long targetValue) 
    {
        this.targetValue = targetValue;
    }

    public Long getTargetValue() 
    {
        return targetValue;
    }
    public void setRewardPoints(Long rewardPoints) 
    {
        this.rewardPoints = rewardPoints;
    }

    public Long getRewardPoints() 
    {
        return rewardPoints;
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
            .append("name", getName())
            .append("description", getDescription())
            .append("targetValue", getTargetValue())
            .append("rewardPoints", getRewardPoints())
            .append("createdAt", getCreatedAt())
            .append("updatedAt", getUpdatedAt())
            .toString();
    }
}
