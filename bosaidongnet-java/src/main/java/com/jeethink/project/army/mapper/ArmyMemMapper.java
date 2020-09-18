package com.jeethink.project.army.mapper;

import java.util.List;
import com.jeethink.project.army.domain.ArmyMem;

/**
 * 用户Mapper接口
 * 
 * @author miao
 * @date 2020-09-18
 */
public interface ArmyMemMapper {
    /**
     * 查询用户
     * 
     * @param memId 用户ID
     * @return 用户
     */
    public ArmyMem selectArmyMemById(String memId);

    /**
     * 查询用户列表
     * 
     * @param armyMem 用户
     * @return 用户集合
     */
    public List<ArmyMem> selectArmyMemList(ArmyMem armyMem);

    /**
     * 新增用户
     * 
     * @param armyMem 用户
     * @return 结果
     */
    public int insertArmyMem(ArmyMem armyMem);

    /**
     * 修改用户
     * 
     * @param armyMem 用户
     * @return 结果
     */
    public int updateArmyMem(ArmyMem armyMem);

    /**
     * 删除用户
     * 
     * @param memId 用户ID
     * @return 结果
     */
    public int deleteArmyMemById(String memId);

    /**
     * 批量删除用户
     * 
     * @param memIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteArmyMemByIds(String[] memIds);
}
