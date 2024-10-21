package com.ruoyi.smartLearning.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 成就对象 achievements
 * 
 * @author 虞嘉欣
 * @date 2024-10-21
 */
public class Achievements extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 成就ID，主键，自增 */
    private Long id;

    /** 用户ID，用于标识成就的达成者 */
    @Excel(name = "用户ID，用于标识成就的达成者")
    private Long userId;

    /** 成就描述 */
    @Excel(name = "成就描述")
    private String achievement;

    /** 成就名称 */
    @Excel(name = "成就名称")
    private String achievementName;

    /** 奖励积分 */
    @Excel(name = "奖励积分")
    private Long rewardPoints;

    /** 成就达成的时间，默认当前时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "成就达成的时间，默认当前时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date achievedAt;

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
    public void setAchievement(String achievement) 
    {
        this.achievement = achievement;
    }

    public String getAchievement() 
    {
        return achievement;
    }
    public void setAchievementName(String achievementName) 
    {
        this.achievementName = achievementName;
    }

    public String getAchievementName() 
    {
        return achievementName;
    }
    public void setRewardPoints(Long rewardPoints) 
    {
        this.rewardPoints = rewardPoints;
    }

    public Long getRewardPoints() 
    {
        return rewardPoints;
    }
    public void setAchievedAt(Date achievedAt) 
    {
        this.achievedAt = achievedAt;
    }

    public Date getAchievedAt() 
    {
        return achievedAt;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userId", getUserId())
            .append("achievement", getAchievement())
            .append("achievementName", getAchievementName())
            .append("rewardPoints", getRewardPoints())
            .append("achievedAt", getAchievedAt())
            .toString();
    }
}
