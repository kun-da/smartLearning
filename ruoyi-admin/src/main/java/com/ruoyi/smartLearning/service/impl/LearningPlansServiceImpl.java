package com.ruoyi.smartLearning.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.smartLearning.mapper.LearningPlansMapper;
import com.ruoyi.smartLearning.domain.LearningPlans;
import com.ruoyi.smartLearning.service.ILearningPlansService;

/**
 * 学习计划Service业务层处理
 *
 * @author ruoyi
 * @date 2024-10-21
 */
@Service
public class LearningPlansServiceImpl implements ILearningPlansService {
    @Autowired
    private LearningPlansMapper learningPlansMapper;

    /**
     * 获取（查询）计划，当前用户
     */
    @Override
    public List<LearningPlans> selectLearningPlansByDate(Long userId, String date) {
        //判断date是否为空
        if (date != null) {
            HashMap<String, Object> stringObjectHashMap = new HashMap<>();
            stringObjectHashMap.put("userId", userId);
            stringObjectHashMap.put("currentDate", date);
            return learningPlansMapper.selectLearningPlansByDate(stringObjectHashMap);
        }
        LearningPlans learningPlan = new LearningPlans();
        learningPlan.setUserId(userId);
        List<LearningPlans> learningPlans = learningPlansMapper.selectLearningPlansList(learningPlan);
        // 判断非空，如果为空则抛出异常
        if (learningPlans == null || learningPlans.isEmpty()) {
            throw new RuntimeException("你还没有学习计划，请先添加学习计划");
        }
        return learningPlans;
    }


    /**
     * 查询学习计划
     *
     * @param id 学习计划主键
     * @return 学习计划
     */
    @Override
    public LearningPlans selectLearningPlansById(Long id) {
        return learningPlansMapper.selectLearningPlansById(id);
    }

    /**
     * 查询学习计划列表
     *
     * @param learningPlans 学习计划
     * @return 学习计划
     */
    @Override
    public List<LearningPlans> selectLearningPlansList(LearningPlans learningPlans) {
        return learningPlansMapper.selectLearningPlansList(learningPlans);
    }

    /**
     * 新增学习计划
     *
     * @param learningPlans 学习计划
     * @return 结果
     */
    @Override
    public int insertLearningPlans(LearningPlans learningPlans) {
        //判断开始时间是否为空，如果为空，则设置为当前时间
        if (learningPlans.getStartDate() == null) {
            learningPlans.setStartDate(new Date());
        }
        //判断结束时间是否大于于开始时间，如果大于，则抛出异常
        if (learningPlans.getEndDate() != null && learningPlans.getEndDate().before(learningPlans.getStartDate())) {
            throw new RuntimeException("结束时间不能早于开始时间");
        }
        System.out.println("学习计划模块-新增计划：" + learningPlans);
        return learningPlansMapper.insertLearningPlans(learningPlans);
    }

    /**
     * 修改学习计划
     *
     * @param learningPlans 学习计划
     * @return 结果
     */
    @Override
    public int updateLearningPlans(LearningPlans learningPlans) {
        return learningPlansMapper.updateLearningPlans(learningPlans);
    }

    /**
     * 批量删除学习计划
     *
     * @param ids 需要删除的学习计划主键
     * @return 结果
     */
    @Override
    public int deleteLearningPlansByIds(Long[] ids) {
        return learningPlansMapper.deleteLearningPlansByIds(ids);
    }

    /**
     * 删除学习计划信息
     *
     * @param id 学习计划主键
     * @return 结果
     */
    @Override
    public int deleteLearningPlansById(Long id) {
        return learningPlansMapper.deleteLearningPlansById(id);
    }
}
