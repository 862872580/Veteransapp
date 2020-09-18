package com.jeethink.project.army.mapper;

import java.util.List;
import com.jeethink.project.army.domain.ArmyMemWorkaim;

/**
 * 求职意向Mapper接口
 * 
 * @author miao
 * @date 2020-09-18
 */
public interface ArmyMemWorkaimMapper {
    /**
     * 查询求职意向
     * 
     * @param workaimId 求职意向ID
     * @return 求职意向
     */
    public ArmyMemWorkaim selectArmyMemWorkaimById(Long workaimId);

    /**
     * 查询求职意向列表
     * 
     * @param armyMemWorkaim 求职意向
     * @return 求职意向集合
     */
    public List<ArmyMemWorkaim> selectArmyMemWorkaimList(ArmyMemWorkaim armyMemWorkaim);

    /**
     * 新增求职意向
     * 
     * @param armyMemWorkaim 求职意向
     * @return 结果
     */
    public int insertArmyMemWorkaim(ArmyMemWorkaim armyMemWorkaim);

    /**
     * 修改求职意向
     * 
     * @param armyMemWorkaim 求职意向
     * @return 结果
     */
    public int updateArmyMemWorkaim(ArmyMemWorkaim armyMemWorkaim);

    /**
     * 删除求职意向
     * 
     * @param workaimId 求职意向ID
     * @return 结果
     */
    public int deleteArmyMemWorkaimById(Long workaimId);

    /**
     * 批量删除求职意向
     * 
     * @param workaimIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteArmyMemWorkaimByIds(Long[] workaimIds);
}
