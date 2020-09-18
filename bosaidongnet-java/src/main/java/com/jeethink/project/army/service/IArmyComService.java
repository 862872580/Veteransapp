package com.jeethink.project.army.service;

import java.util.List;
import com.jeethink.project.army.domain.ArmyCom;

/**
 * 公司Service接口
 * 
 * @author miao
 * @date 2020-09-18
 */
public interface IArmyComService {
    /**
     * 查询公司
     * 
     * @param comId 公司ID
     * @return 公司
     */
    public ArmyCom selectArmyComById(Long comId);

    /**
     * 查询公司列表
     * 
     * @param armyCom 公司
     * @return 公司集合
     */
    public List<ArmyCom> selectArmyComList(ArmyCom armyCom);

    /**
     * 新增公司
     * 
     * @param armyCom 公司
     * @return 结果
     */
    public int insertArmyCom(ArmyCom armyCom);

    /**
     * 修改公司
     * 
     * @param armyCom 公司
     * @return 结果
     */
    public int updateArmyCom(ArmyCom armyCom);

    /**
     * 批量删除公司
     * 
     * @param comIds 需要删除的公司ID
     * @return 结果
     */
    public int deleteArmyComByIds(Long[] comIds);

    /**
     * 删除公司信息
     * 
     * @param comId 公司ID
     * @return 结果
     */
    public int deleteArmyComById(Long comId);
}
