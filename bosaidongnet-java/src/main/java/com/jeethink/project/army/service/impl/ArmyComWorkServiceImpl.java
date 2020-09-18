package com.jeethink.project.army.service.impl;

import java.util.List;
import com.jeethink.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jeethink.project.army.mapper.ArmyComWorkMapper;
import com.jeethink.project.army.domain.ArmyComWork;
import com.jeethink.project.army.service.IArmyComWorkService;

/**
 * 工作Service业务层处理
 * 
 * @author miao
 * @date 2020-09-18
 */
@Service
public class ArmyComWorkServiceImpl implements IArmyComWorkService {
    @Autowired
    private ArmyComWorkMapper armyComWorkMapper;

    /**
     * 查询工作
     * 
     * @param workId 工作ID
     * @return 工作
     */
    @Override
    public ArmyComWork selectArmyComWorkById(Long workId) {
        return armyComWorkMapper.selectArmyComWorkById(workId);
    }

    /**
     * 查询工作列表
     * 
     * @param armyComWork 工作
     * @return 工作
     */
    @Override
    public List<ArmyComWork> selectArmyComWorkList(ArmyComWork armyComWork) {
        return armyComWorkMapper.selectArmyComWorkList(armyComWork);
    }

    /**
     * 新增工作
     * 
     * @param armyComWork 工作
     * @return 结果
     */
    @Override
    public int insertArmyComWork(ArmyComWork armyComWork) {
        armyComWork.setCreateTime(DateUtils.getNowDate());
        return armyComWorkMapper.insertArmyComWork(armyComWork);
    }

    /**
     * 修改工作
     * 
     * @param armyComWork 工作
     * @return 结果
     */
    @Override
    public int updateArmyComWork(ArmyComWork armyComWork) {
        armyComWork.setUpdateTime(DateUtils.getNowDate());
        return armyComWorkMapper.updateArmyComWork(armyComWork);
    }

    /**
     * 批量删除工作
     * 
     * @param workIds 需要删除的工作ID
     * @return 结果
     */
    @Override
    public int deleteArmyComWorkByIds(Long[] workIds) {
        return armyComWorkMapper.deleteArmyComWorkByIds(workIds);
    }

    /**
     * 删除工作信息
     * 
     * @param workId 工作ID
     * @return 结果
     */
    @Override
    public int deleteArmyComWorkById(Long workId) {
        return armyComWorkMapper.deleteArmyComWorkById(workId);
    }
}
