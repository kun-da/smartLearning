package com.ruoyi.smartLearning.service;

import java.util.List;
import com.ruoyi.smartLearning.domain.Notifications;

/**
 * 学习通知Service接口
 * 
 * @author 虞嘉欣
 * @date 2024-10-21
 */
public interface INotificationsService 
{
    /**
     * 查询学习通知
     * 
     * @param id 学习通知主键
     * @return 学习通知
     */
    public Notifications selectNotificationsById(Long id);

    /**
     * 查询学习通知列表
     * 
     * @param notifications 学习通知
     * @return 学习通知集合
     */
    public List<Notifications> selectNotificationsList(Notifications notifications);

    /**
     * 新增学习通知
     * 
     * @param notifications 学习通知
     * @return 结果
     */
    public int insertNotifications(Notifications notifications);

    /**
     * 修改学习通知
     * 
     * @param notifications 学习通知
     * @return 结果
     */
    public int updateNotifications(Notifications notifications);

    /**
     * 批量删除学习通知
     * 
     * @param ids 需要删除的学习通知主键集合
     * @return 结果
     */
    public int deleteNotificationsByIds(Long[] ids);

    /**
     * 删除学习通知信息
     * 
     * @param id 学习通知主键
     * @return 结果
     */
    public int deleteNotificationsById(Long id);
}
