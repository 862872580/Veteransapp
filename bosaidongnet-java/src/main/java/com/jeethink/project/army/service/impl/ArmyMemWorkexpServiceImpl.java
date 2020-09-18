package com.jeethink.project.army.service.impl;

import java.util.List;
import com.jeethink.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jeethink.project.army.mapper.ArmyMemWorkexpMapper;
import com.jeethink.project.army.domain.ArmyMemWorkexp;
import com.jeethink.project.army.service.IArmyMemWorkexpService;

/**
 * 工作经历Service业务层处理
 * 
 * @author miao
 * @date 2020-09-18
 */
@Service
public class ArmyMemWorkexpServiceImpl implements IArmyMemWorkexpService {
    @Autowired
    private ArmyMemWorkexpMapper armyMemWorkexpMapper;

    /**
     * 查询工作经历
     * 
     * @param workexpId 工作经历ID
     * @return 工作经历
     */
    @Override
    public ArmyMemWorkexp selectArmyMemWorkexpById(Long workexpId) {
        return armyMemWorkexpMapper.selectArmyMemWorkexpById(workexpId);
    }

    /**
     * 查询工作经历列表
     * 
     * @param armyMemWorkexp 工作经历
     * @return 工作经历
     */
    @Override
    public List<ArmyMemWorkexp> selectArmyMemWorkexpList(ArmyMemWorkexp armyMemWorkexp) {
        return armyMemWorkexpMapper.selectArmyMemWorkexpList(armyMemWorkexp);
    }

    /**
     * 新增工作经历
     * 
     * @param armyMemWorkexp 工作经历
     * @return 结果
     */
    @Override
    public int insertArmyMemWorkexp(ArmyMemWorkexp armyMemWorkexp) {
        armyMemWorkexp.setCreateTime(DateUtils.getNowDate());
        return armyMemWorkexpMapper.insertArmyMemWorkexp(armyMemWorkexp);
    }

    /**
     * 修改工作经历
     * 
     * @param armyMemWorkexp 工作经历
     * @return 结果
     */
    @Override
    public int updateArmyMemWorkexp(ArmyMemWorkexp armyMemWorkexp) {
        armyMemWorkexp.setUpdateTime(DateUtils.getNowDate());
        return armyMemWorkexpMapper.updateArmyMemWorkexp(armyMemWorkexp);
    }

    /**
     * 批量删除工作经历
     * 
     * @param workexpIds 需要删除的工作经历ID
     * @return 结果
     */
    @Override
    public int deleteArmyMemWorkexpByIds(Long[] workexpIds) {
        return armyMemWorkexpMapper.deleteArmyMemWorkexpByIds(workexpIds);
    }

    /**
     * 删除工作经历信息
     * 
     * @param workexpId 工作经历ID
     * @return 结果
     */
    @Override
    public int deleteArmyMemWorkexpById(Long workexpId) {
        return armyMemWorkexpMapper.deleteArmyMemWorkexpById(workexpId);
    }
}
