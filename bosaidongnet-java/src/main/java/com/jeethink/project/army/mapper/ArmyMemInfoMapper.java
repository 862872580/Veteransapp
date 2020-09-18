package com.jeethink.project.army.mapper;

import java.util.List;
import com.jeethink.project.army.domain.ArmyMemInfo;

/**
 * 用户详细信息Mapper接口
 * 
 * @author miao
 * @date 2020-09-18
 */
public interface ArmyMemInfoMapper {
    /**
     * 查询用户详细信息
     * 
     * @param infoId 用户详细信息ID
     * @return 用户详细信息
     */
    public ArmyMemInfo selectArmyMemInfoById(Long infoId);

    /**
     * 查询用户详细信息列表
     * 
     * @param armyMemInfo 用户详细信息
     * @return 用户详细信息集合
     */
    public List<ArmyMemInfo> selectArmyMemInfoList(ArmyMemInfo armyMemInfo);

    /**
     * 新增用户详细信息
     * 
     * @param armyMemInfo 用户详细信息
     * @return 结果
     */
    public int insertArmyMemInfo(ArmyMemInfo armyMemInfo);

    /**
     * 修改用户详细信息
     * 
     * @param armyMemInfo 用户详细信息
     * @return 结果
     */
    public int updateArmyMemInfo(ArmyMemInfo armyMemInfo);

    /**
     * 删除用户详细信息
     * 
     * @param infoId 用户详细信息ID
     * @return 结果
     */
    public int deleteArmyMemInfoById(Long infoId);

    /**
     * 批量删除用户详细信息
     * 
     * @param infoIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteArmyMemInfoByIds(Long[] infoIds);
}
