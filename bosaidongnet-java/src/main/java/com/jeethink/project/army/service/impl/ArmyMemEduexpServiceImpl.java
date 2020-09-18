package com.jeethink.project.army.service.impl;

import java.util.List;
import com.jeethink.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jeethink.project.army.mapper.ArmyMemEduexpMapper;
import com.jeethink.project.army.domain.ArmyMemEduexp;
import com.jeethink.project.army.service.IArmyMemEduexpService;

/**
 * 教育经历Service业务层处理
 * 
 * @author miao
 * @date 2020-09-18
 */
@Service
public class ArmyMemEduexpServiceImpl implements IArmyMemEduexpService {
    @Autowired
    private ArmyMemEduexpMapper armyMemEduexpMapper;

    /**
     * 查询教育经历
     * 
     * @param eduexpId 教育经历ID
     * @return 教育经历
     */
    @Override
    public ArmyMemEduexp selectArmyMemEduexpById(Long eduexpId) {
        return armyMemEduexpMapper.selectArmyMemEduexpById(eduexpId);
    }

    /**
     * 查询教育经历列表
     * 
     * @param armyMemEduexp 教育经历
     * @return 教育经历
     */
    @Override
    public List<ArmyMemEduexp> selectArmyMemEduexpList(ArmyMemEduexp armyMemEduexp) {
        return armyMemEduexpMapper.selectArmyMemEduexpList(armyMemEduexp);
    }

    /**
     * 新增教育经历
     * 
     * @param armyMemEduexp 教育经历
     * @return 结果
     */
    @Override
    public int insertArmyMemEduexp(ArmyMemEduexp armyMemEduexp) {
        armyMemEduexp.setCreateTime(DateUtils.getNowDate());
        return armyMemEduexpMapper.insertArmyMemEduexp(armyMemEduexp);
    }

    /**
     * 修改教育经历
     * 
     * @param armyMemEduexp 教育经历
     * @return 结果
     */
    @Override
    public int updateArmyMemEduexp(ArmyMemEduexp armyMemEduexp) {
        armyMemEduexp.setUpdateTime(DateUtils.getNowDate());
        return armyMemEduexpMapper.updateArmyMemEduexp(armyMemEduexp);
    }

    /**
     * 批量删除教育经历
     * 
     * @param eduexpIds 需要删除的教育经历ID
     * @return 结果
     */
    @Override
    public int deleteArmyMemEduexpByIds(Long[] eduexpIds) {
        return armyMemEduexpMapper.deleteArmyMemEduexpByIds(eduexpIds);
    }

    /**
     * 删除教育经历信息
     * 
     * @param eduexpId 教育经历ID
     * @return 结果
     */
    @Override
    public int deleteArmyMemEduexpById(Long eduexpId) {
        return armyMemEduexpMapper.deleteArmyMemEduexpById(eduexpId);
    }
}
