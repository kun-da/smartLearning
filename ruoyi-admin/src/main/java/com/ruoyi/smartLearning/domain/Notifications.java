package com.ruoyi.smartLearning.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 学习通知对象 notifications
 * 
 * @author 虞嘉欣
 * @date 2024-10-21
 */
public class Notifications extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 通知ID，主键，自增 */
    private Long id;

    /** 用户ID，用于标识通知的接收者 */
    @Excel(name = "用户ID，用于标识通知的接收者")
    private Long userId;

    /** 通知内容 */
    @Excel(name = "通知内容")
    private String message;

    /** 通知类型（如站内通知、邮件、短信） */
    @Excel(name = "通知类型", readConverterExp = "如=站内通知、邮件、短信")
    private String type;

    /** 通知状态（已发送、未发送） */
    @Excel(name = "通知状态", readConverterExp = "已=发送、未发送")
    private String status;

    /** 通知生成的时间，默认当前时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "通知生成的时间，默认当前时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createdAt;

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
    public void setMessage(String message) 
    {
        this.message = message;
    }

    public String getMessage() 
    {
        return message;
    }
    public void setType(String type) 
    {
        this.type = type;
    }

    public String getType() 
    {
        return type;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }
    public void setCreatedAt(Date createdAt) 
    {
        this.createdAt = createdAt;
    }

    public Date getCreatedAt() 
    {
        return createdAt;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userId", getUserId())
            .append("message", getMessage())
            .append("type", getType())
            .append("status", getStatus())
            .append("createdAt", getCreatedAt())
            .toString();
    }
}
