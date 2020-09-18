package com.jeethink.project.army.service.impl;

import java.util.List;
import com.jeethink.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jeethink.project.army.mapper.ArmyComMapper;
import com.jeethink.project.army.domain.ArmyCom;
import com.jeethink.project.army.service.IArmyComService;

/**
 * 公司Service业务层处理
 * 
 * @author miao
 * @date 2020-09-18
 */
@Service
public class ArmyComServiceImpl implements IArmyComService {
    @Autowired
    private ArmyComMapper armyComMapper;

    /**
     * 查询公司
     * 
     * @param comId 公司ID
     * @return 公司
     */
    @Override
    public ArmyCom selectArmyComById(Long comId) {
        return armyComMapper.selectArmyComById(comId);
    }

    /**
     * 查询公司列表
     * 
     * @param armyCom 公司
     * @return 公司
     */
    @Override
    public List<ArmyCom> selectArmyComList(ArmyCom armyCom) {
        return armyComMapper.selectArmyComList(armyCom);
    }

    /**
     * 新增公司
     * 
     * @param armyCom 公司
     * @return 结果
     */
    @Override
    public int insertArmyCom(ArmyCom armyCom) {
        armyCom.setCreateTime(DateUtils.getNowDate());
        return armyComMapper.insertArmyCom(armyCom);
    }

    /**
     * 修改公司
     * 
     * @param armyCom 公司
     * @return 结果
     */
    @Override
    public int updateArmyCom(ArmyCom armyCom) {
        armyCom.setUpdateTime(DateUtils.getNowDate());
        return armyComMapper.updateArmyCom(armyCom);
    }

    /**
     * 批量删除公司
     * 
     * @param comIds 需要删除的公司ID
     * @return 结果
     */
    @Override
    public int deleteArmyComByIds(Long[] comIds) {
        return armyComMapper.deleteArmyComByIds(comIds);
    }

    /**
     * 删除公司信息
     * 
     * @param comId 公司ID
     * @return 结果
     */
    @Override
    public int deleteArmyComById(Long comId) {
        return armyComMapper.deleteArmyComById(comId);
    }
}
