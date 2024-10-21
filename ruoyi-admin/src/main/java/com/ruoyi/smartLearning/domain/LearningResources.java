package com.ruoyi.smartLearning.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 学习资料对象 learning_resources
 * 
 * @author 虞嘉欣
 * @date 2024-10-21
 */
public class LearningResources extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 学习资料ID，主键，自增 */
    private Long id;

    /** 用户ID，用于标识资料的上传者 */
    @Excel(name = "用户ID，用于标识资料的上传者")
    private Long userId;

    /** 学习计划ID，用于关联到学习计划 */
    @Excel(name = "学习计划ID，用于关联到学习计划")
    private Long planId;

    /** 文件存储路径 */
    @Excel(name = "文件存储路径")
    private String filePath;

    /** 文件类型（如PDF、视频等） */
    @Excel(name = "文件类型", readConverterExp = "如=PDF、视频等")
    private String fileType;

    /** 文件上传时间，默认当前时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "文件上传时间，默认当前时间", width = 30, dateFormat = "yyyy-MM-dd")
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
    public void setPlanId(Long planId) 
    {
        this.planId = planId;
    }

    public Long getPlanId() 
    {
        return planId;
    }
    public void setFilePath(String filePath) 
    {
        this.filePath = filePath;
    }

    public String getFilePath() 
    {
        return filePath;
    }
    public void setFileType(String fileType) 
    {
        this.fileType = fileType;
    }

    public String getFileType() 
    {
        return fileType;
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
            .append("planId", getPlanId())
            .append("filePath", getFilePath())
            .append("fileType", getFileType())
            .append("createdAt", getCreatedAt())
            .toString();
    }
}
