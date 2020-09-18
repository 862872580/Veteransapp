package com.jeethink.project.army.mapper;

import java.util.List;
import com.jeethink.project.army.domain.ArmyMemEduexp;

/**
 * 教育经历Mapper接口
 * 
 * @author miao
 * @date 2020-09-18
 */
public interface ArmyMemEduexpMapper {
    /**
     * 查询教育经历
     * 
     * @param eduexpId 教育经历ID
     * @return 教育经历
     */
    public ArmyMemEduexp selectArmyMemEduexpById(Long eduexpId);

    /**
     * 查询教育经历列表
     * 
     * @param armyMemEduexp 教育经历
     * @return 教育经历集合
     */
    public List<ArmyMemEduexp> selectArmyMemEduexpList(ArmyMemEduexp armyMemEduexp);

    /**
     * 新增教育经历
     * 
     * @param armyMemEduexp 教育经历
     * @return 结果
     */
    public int insertArmyMemEduexp(ArmyMemEduexp armyMemEduexp);

    /**
     * 修改教育经历
     * 
     * @param armyMemEduexp 教育经历
     * @return 结果
     */
    public int updateArmyMemEduexp(ArmyMemEduexp armyMemEduexp);

    /**
     * 删除教育经历
     * 
     * @param eduexpId 教育经历ID
     * @return 结果
     */
    public int deleteArmyMemEduexpById(Long eduexpId);

    /**
     * 批量删除教育经历
     * 
     * @param eduexpIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteArmyMemEduexpByIds(Long[] eduexpIds);
}
