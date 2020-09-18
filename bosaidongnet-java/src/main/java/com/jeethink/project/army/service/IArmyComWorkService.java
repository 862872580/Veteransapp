package com.jeethink.project.army.service;

import java.util.List;
import com.jeethink.project.army.domain.ArmyComWork;

/**
 * 工作Service接口
 * 
 * @author miao
 * @date 2020-09-18
 */
public interface IArmyComWorkService {
    /**
     * 查询工作
     * 
     * @param workId 工作ID
     * @return 工作
     */
    public ArmyComWork selectArmyComWorkById(Long workId);

    /**
     * 查询工作列表
     * 
     * @param armyComWork 工作
     * @return 工作集合
     */
    public List<ArmyComWork> selectArmyComWorkList(ArmyComWork armyComWork);

    /**
     * 新增工作
     * 
     * @param armyComWork 工作
     * @return 结果
     */
    public int insertArmyComWork(ArmyComWork armyComWork);

    /**
     * 修改工作
     * 
     * @param armyComWork 工作
     * @return 结果
     */
    public int updateArmyComWork(ArmyComWork armyComWork);

    /**
     * 批量删除工作
     * 
     * @param workIds 需要删除的工作ID
     * @return 结果
     */
    public int deleteArmyComWorkByIds(Long[] workIds);

    /**
     * 删除工作信息
     * 
     * @param workId 工作ID
     * @return 结果
     */
    public int deleteArmyComWorkById(Long workId);
}
