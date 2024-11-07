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
 * @date 2024-11-07
 */
public class AchievementConditions extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 配置ID，自增主键 */
    private Long id;

    /** 成就名称 */
    @Excel(name = "成就名称")
    private String name;

    /** 成就描述 */
    @Excel(name = "成就描述")
    private String description;

    /** 达成目标的分类 */
    @Excel(name = "达成目标的分类")
    private Long targetType;

    /** 成就达成的目标值，如学习时间/任务数/计划数 */
    @Excel(name = "成就达成的目标值，如学习时间/任务数/计划数")
    private Long targetValue;

    /** 达成成就后的奖励积分 */
    @Excel(name = "达成成就后的奖励积分")
    private Long rewardPoints;

    /** 成就条件创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "成就条件创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createdAt;

    /** 最后更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "最后更新时间", width = 30, dateFormat = "yyyy-MM-dd")
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
    public void setTargetType(Long targetType)
    {
        this.targetType = targetType;
    }

    public Long getTargetType()
    {
        return targetType;
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
                .append("targetType", getTargetType())
                .append("targetValue", getTargetValue())
                .append("rewardPoints", getRewardPoints())
                .append("createdAt", getCreatedAt())
                .append("updatedAt", getUpdatedAt())
                .toString();
    }
}
