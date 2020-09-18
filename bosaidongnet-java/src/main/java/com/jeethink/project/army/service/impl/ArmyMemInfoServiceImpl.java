package com.jeethink.project.army.service.impl;

import java.util.List;
import com.jeethink.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jeethink.project.army.mapper.ArmyMemInfoMapper;
import com.jeethink.project.army.domain.ArmyMemInfo;
import com.jeethink.project.army.service.IArmyMemInfoService;

/**
 * 用户详细信息Service业务层处理
 * 
 * @author miao
 * @date 2020-09-18
 */
@Service
public class ArmyMemInfoServiceImpl implements IArmyMemInfoService {
    @Autowired
    private ArmyMemInfoMapper armyMemInfoMapper;

    /**
     * 查询用户详细信息
     * 
     * @param infoId 用户详细信息ID
     * @return 用户详细信息
     */
    @Override
    public ArmyMemInfo selectArmyMemInfoById(Long infoId) {
        return armyMemInfoMapper.selectArmyMemInfoById(infoId);
    }

    /**
     * 查询用户详细信息列表
     * 
     * @param armyMemInfo 用户详细信息
     * @return 用户详细信息
     */
    @Override
    public List<ArmyMemInfo> selectArmyMemInfoList(ArmyMemInfo armyMemInfo) {
        return armyMemInfoMapper.selectArmyMemInfoList(armyMemInfo);
    }

    /**
     * 新增用户详细信息
     * 
     * @param armyMemInfo 用户详细信息
     * @return 结果
     */
    @Override
    public int insertArmyMemInfo(ArmyMemInfo armyMemInfo) {
        armyMemInfo.setCreateTime(DateUtils.getNowDate());
        return armyMemInfoMapper.insertArmyMemInfo(armyMemInfo);
    }

    /**
     * 修改用户详细信息
     * 
     * @param armyMemInfo 用户详细信息
     * @return 结果
     */
    @Override
    public int updateArmyMemInfo(ArmyMemInfo armyMemInfo) {
        armyMemInfo.setUpdateTime(DateUtils.getNowDate());
        return armyMemInfoMapper.updateArmyMemInfo(armyMemInfo);
    }

    /**
     * 批量删除用户详细信息
     * 
     * @param infoIds 需要删除的用户详细信息ID
     * @return 结果
     */
    @Override
    public int deleteArmyMemInfoByIds(Long[] infoIds) {
        return armyMemInfoMapper.deleteArmyMemInfoByIds(infoIds);
    }

    /**
     * 删除用户详细信息信息
     * 
     * @param infoId 用户详细信息ID
     * @return 结果
     */
    @Override
    public int deleteArmyMemInfoById(Long infoId) {
        return armyMemInfoMapper.deleteArmyMemInfoById(infoId);
    }
}
