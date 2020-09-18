package com.jeethink.project.army.mapper;

import java.util.List;
import com.jeethink.project.army.domain.ArmyMemWorkexp;

/**
 * 工作经历Mapper接口
 * 
 * @author miao
 * @date 2020-09-18
 */
public interface ArmyMemWorkexpMapper {
    /**
     * 查询工作经历
     * 
     * @param workexpId 工作经历ID
     * @return 工作经历
     */
    public ArmyMemWorkexp selectArmyMemWorkexpById(Long workexpId);

    /**
     * 查询工作经历列表
     * 
     * @param armyMemWorkexp 工作经历
     * @return 工作经历集合
     */
    public List<ArmyMemWorkexp> selectArmyMemWorkexpList(ArmyMemWorkexp armyMemWorkexp);

    /**
     * 新增工作经历
     * 
     * @param armyMemWorkexp 工作经历
     * @return 结果
     */
    public int insertArmyMemWorkexp(ArmyMemWorkexp armyMemWorkexp);

    /**
     * 修改工作经历
     * 
     * @param armyMemWorkexp 工作经历
     * @return 结果
     */
    public int updateArmyMemWorkexp(ArmyMemWorkexp armyMemWorkexp);

    /**
     * 删除工作经历
     * 
     * @param workexpId 工作经历ID
     * @return 结果
     */
    public int deleteArmyMemWorkexpById(Long workexpId);

    /**
     * 批量删除工作经历
     * 
     * @param workexpIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteArmyMemWorkexpByIds(Long[] workexpIds);
}
