package com.ruoyi.smartLearning.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.smartLearning.mapper.NotificationsMapper;
import com.ruoyi.smartLearning.domain.Notifications;
import com.ruoyi.smartLearning.service.INotificationsService;

/**
 * 学习通知Service业务层处理
 * 
 * @author 虞嘉欣
 * @date 2024-10-21
 */
@Service
public class NotificationsServiceImpl implements INotificationsService 
{
    @Autowired
    private NotificationsMapper notificationsMapper;

    /**
     * 查询学习通知
     * 
     * @param id 学习通知主键
     * @return 学习通知
     */
    @Override
    public Notifications selectNotificationsById(Long id)
    {
        return notificationsMapper.selectNotificationsById(id);
    }

    /**
     * 查询学习通知列表
     * 
     * @param notifications 学习通知
     * @return 学习通知
     */
    @Override
    public List<Notifications> selectNotificationsList(Notifications notifications)
    {
        return notificationsMapper.selectNotificationsList(notifications);
    }

    /**
     * 新增学习通知
     * 
     * @param notifications 学习通知
     * @return 结果
     */
    @Override
    public int insertNotifications(Notifications notifications)
    {
        return notificationsMapper.insertNotifications(notifications);
    }

    /**
     * 修改学习通知
     * 
     * @param notifications 学习通知
     * @return 结果
     */
    @Override
    public int updateNotifications(Notifications notifications)
    {
        return notificationsMapper.updateNotifications(notifications);
    }

    /**
     * 批量删除学习通知
     * 
     * @param ids 需要删除的学习通知主键
     * @return 结果
     */
    @Override
    public int deleteNotificationsByIds(Long[] ids)
    {
        return notificationsMapper.deleteNotificationsByIds(ids);
    }

    /**
     * 删除学习通知信息
     * 
     * @param id 学习通知主键
     * @return 结果
     */
    @Override
    public int deleteNotificationsById(Long id)
    {
        return notificationsMapper.deleteNotificationsById(id);
    }
}
