package com.jeethink.project.army.service.impl;

import java.util.List;
import java.util.Random;
import java.util.UUID;

import com.jeethink.common.utils.DateUtils;
import com.jeethink.framework.SMS.TengXunSMS;
import com.jeethink.project.army.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jeethink.project.army.mapper.ArmyMemMapper;
import com.jeethink.project.army.domain.ArmyMem;
import com.jeethink.project.army.service.IArmyMemService;

/**
 * 用户Service业务层处理
 * 
 * @author miao
 * @date 2020-09-18
 */
@Service
public class ArmyMemServiceImpl implements IArmyMemService {
    @Autowired
    private ArmyMemMapper armyMemMapper;

    @Autowired
    private RedisUtil redisUtil;

    /**
     * 查询用户
     * 
     * @param memId 用户ID
     * @return 用户
     */
    @Override
    public ArmyMem selectArmyMemById(String memId) {
        ArmyMem armyMem = armyMemMapper.selectArmyMemById(memId);
        return armyMem;
    }

    /**
     * 查询用户列表
     * 
     * @param armyMem 用户
     * @return 用户
     */
    @Override
    public List<ArmyMem> selectArmyMemList(ArmyMem armyMem) {
        return armyMemMapper.selectArmyMemList(armyMem);
    }

    /**
     * 新增用户
     * 
     * @param armyMem 用户
     * @return 结果
     */
    @Override
    public int insertArmyMem(ArmyMem armyMem) {
        armyMem.setCreateTime(DateUtils.getNowDate());
        armyMem.setMemId(UUID.randomUUID().toString());
        armyMem.setStatus("1");
        return armyMemMapper.insertArmyMem(armyMem);
    }

    /**
     * 修改用户
     * 
     * @param armyMem 用户
     * @return 结果
     */
    @Override
    public int updateArmyMem(ArmyMem armyMem) {
        armyMem.setUpdateTime(DateUtils.getNowDate());
        return armyMemMapper.updateArmyMem(armyMem);
    }

    /**
     * 批量删除用户
     * 
     * @param memIds 需要删除的用户ID
     * @return 结果
     */
    @Override
    public int deleteArmyMemByIds(String[] memIds) {
        return armyMemMapper.deleteArmyMemByIds(memIds);
    }

    /**
     * 删除用户信息
     * 
     * @param memId 用户ID
     * @return 结果
     */
    @Override
    public int deleteArmyMemById(String memId) {
        return armyMemMapper.deleteArmyMemById(memId);
    }

    @Override
    public String login(String phone, String code) {
        if (code.equals(redisUtil.getString(phone))) {
            return "1";
        }else{
            return "0";
        }
    }

    @Override
    public String sendSMS(String phone) {
        if (armyMemMapper.selectMemByPhone(phone) == null){
            return "0";
        }
        //生成随机验证码
        String code = String.valueOf(new Random().nextInt(899999) + 100000);

        //redis存储验证码并设置超时时间
        long overtime = 60;
        redisUtil.setString(phone,code,overtime);

        //发送验证码
        TengXunSMS.validation(phone, code, 334697);
        return "1";
    }
}
