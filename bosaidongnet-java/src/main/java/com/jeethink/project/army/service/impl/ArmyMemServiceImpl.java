package com.jeethink.project.army.service.impl;

import java.util.List;
import com.jeethink.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jeethink.project.army.mapper.ArmyMemMapper;
import com.jeethink.project.army.domain.ArmyMem;
import com.jeethink.project.army.service.IArmyMemService;

/**
 * 用户Service业务层处理
 * 
 * @author miao
 * @date 2020-09-18
 */
@Service
public class ArmyMemServiceImpl implements IArmyMemService {
    @Autowired
    private ArmyMemMapper armyMemMapper;

    /**
     * 查询用户
     * 
     * @param memId 用户ID
     * @return 用户
     */
    @Override
    public ArmyMem selectArmyMemById(String memId) {
        return armyMemMapper.selectArmyMemById(memId);
    }

    /**
     * 查询用户列表
     * 
     * @param armyMem 用户
     * @return 用户
     */
    @Override
    public List<ArmyMem> selectArmyMemList(ArmyMem armyMem) {
        return armyMemMapper.selectArmyMemList(armyMem);
    }

    /**
     * 新增用户
     * 
     * @param armyMem 用户
     * @return 结果
     */
    @Override
    public int insertArmyMem(ArmyMem armyMem) {
        armyMem.setCreateTime(DateUtils.getNowDate());
        return armyMemMapper.insertArmyMem(armyMem);
    }

    /**
     * 修改用户
     * 
     * @param armyMem 用户
     * @return 结果
     */
    @Override
    public int updateArmyMem(ArmyMem armyMem) {
        armyMem.setUpdateTime(DateUtils.getNowDate());
        return armyMemMapper.updateArmyMem(armyMem);
    }

    /**
     * 批量删除用户
     * 
     * @param memIds 需要删除的用户ID
     * @return 结果
     */
    @Override
    public int deleteArmyMemByIds(String[] memIds) {
        return armyMemMapper.deleteArmyMemByIds(memIds);
    }

    /**
     * 删除用户信息
     * 
     * @param memId 用户ID
     * @return 结果
     */
    @Override
    public int deleteArmyMemById(String memId) {
        return armyMemMapper.deleteArmyMemById(memId);
    }
}
