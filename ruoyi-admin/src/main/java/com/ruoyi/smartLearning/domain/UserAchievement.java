package com.ruoyi.smartLearning.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 用户成就对象 user_achievement
 * 
 * @author 虞
 * @date 2024-11-05
 */
public class UserAchievement extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 用户成就id */
    private Long id;

    /** 用户ID */
    @Excel(name = "用户ID")
    private Long userId;

    /** 成就ID */
    @Excel(name = "成就ID")
    private Long achievementId;

    /** 达成时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "达成时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date achievementTime;

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
    public void setAchievementId(Long achievementId) 
    {
        this.achievementId = achievementId;
    }

    public Long getAchievementId() 
    {
        return achievementId;
    }
    public void setAchievementTime(Date achievementTime) 
    {
        this.achievementTime = achievementTime;
    }

    public Date getAchievementTime() 
    {
        return achievementTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userId", getUserId())
            .append("achievementId", getAchievementId())
            .append("achievementTime", getAchievementTime())
            .toString();
    }
}
