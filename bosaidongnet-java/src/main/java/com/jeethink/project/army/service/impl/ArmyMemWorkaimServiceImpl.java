package com.jeethink.project.army.service.impl;

import java.util.List;
import com.jeethink.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jeethink.project.army.mapper.ArmyMemWorkaimMapper;
import com.jeethink.project.army.domain.ArmyMemWorkaim;
import com.jeethink.project.army.service.IArmyMemWorkaimService;

/**
 * 求职意向Service业务层处理
 * 
 * @author miao
 * @date 2020-09-18
 */
@Service
public class ArmyMemWorkaimServiceImpl implements IArmyMemWorkaimService {
    @Autowired
    private ArmyMemWorkaimMapper armyMemWorkaimMapper;

    /**
     * 查询求职意向
     * 
     * @param workaimId 求职意向ID
     * @return 求职意向
     */
    @Override
    public ArmyMemWorkaim selectArmyMemWorkaimById(Long workaimId) {
        return armyMemWorkaimMapper.selectArmyMemWorkaimById(workaimId);
    }

    /**
     * 查询求职意向列表
     * 
     * @param armyMemWorkaim 求职意向
     * @return 求职意向
     */
    @Override
    public List<ArmyMemWorkaim> selectArmyMemWorkaimList(ArmyMemWorkaim armyMemWorkaim) {
        return armyMemWorkaimMapper.selectArmyMemWorkaimList(armyMemWorkaim);
    }

    /**
     * 新增求职意向
     * 
     * @param armyMemWorkaim 求职意向
     * @return 结果
     */
    @Override
    public int insertArmyMemWorkaim(ArmyMemWorkaim armyMemWorkaim) {
        armyMemWorkaim.setCreateTime(DateUtils.getNowDate());
        return armyMemWorkaimMapper.insertArmyMemWorkaim(armyMemWorkaim);
    }

    /**
     * 修改求职意向
     * 
     * @param armyMemWorkaim 求职意向
     * @return 结果
     */
    @Override
    public int updateArmyMemWorkaim(ArmyMemWorkaim armyMemWorkaim) {
        armyMemWorkaim.setUpdateTime(DateUtils.getNowDate());
        return armyMemWorkaimMapper.updateArmyMemWorkaim(armyMemWorkaim);
    }

    /**
     * 批量删除求职意向
     * 
     * @param workaimIds 需要删除的求职意向ID
     * @return 结果
     */
    @Override
    public int deleteArmyMemWorkaimByIds(Long[] workaimIds) {
        return armyMemWorkaimMapper.deleteArmyMemWorkaimByIds(workaimIds);
    }

    /**
     * 删除求职意向信息
     * 
     * @param workaimId 求职意向ID
     * @return 结果
     */
    @Override
    public int deleteArmyMemWorkaimById(Long workaimId) {
        return armyMemWorkaimMapper.deleteArmyMemWorkaimById(workaimId);
    }
}
