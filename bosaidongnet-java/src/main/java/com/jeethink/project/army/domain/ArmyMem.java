package com.jeethink.project.army.domain;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.jeethink.framework.aspectj.lang.annotation.Excel;
import com.jeethink.framework.web.domain.BaseEntity;

/**
 * 用户对象 army_mem
 * 
 * @author miao
 * @date 2020-09-18
 */
public class ArmyMem extends BaseEntity{
    private static final long serialVersionUID = 1L;

    /** 用户id */
    private String memId;

    /** 姓名 */
    @Excel(name = "姓名")
    private String memName;

    /** 性别 */
    @Excel(name = "性别")
    private String memSex;

    /** 年龄 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "年龄", width = 30, dateFormat = "yyyy-MM-dd")
    private Date memBirthday;

    /** 学历 */
    @Excel(name = "学历")
    private String memEducation;

    /** 手机号 */
    @Excel(name = "手机号")
    private String memPhone;

    /** 邮箱 */
    @Excel(name = "邮箱")
    private String memEmail;

    /** 求职状态 */
    @Excel(name = "求职状态")
    private String memJobstate;

    /** 头像位置 */
    @Excel(name = "头像位置")
    private String memPhoto;

    /** 状态 */
    @Excel(name = "状态")
    private String status;

    /** 修改之前的id */
    @Excel(name = "修改之前的id")
    private Long previous;

    private ArmyMemInfo armyMemInfo;

    private List<ArmyMemEduexp> armyMemEduexps;

    private List<ArmyMemWorkexp> armyMemWorkexps;

    private List<ArmyMemWorkaim> armyMemWorkaims;

    public void setMemId(String memId){
        this.memId = memId;
    }

    public String getMemId(){
        return memId;
    }
    public void setMemName(String memName){
        this.memName = memName;
    }

    public String getMemName(){
        return memName;
    }
    public void setMemSex(String memSex){
        this.memSex = memSex;
    }

    public String getMemSex(){
        return memSex;
    }
    public void setMemBirthday(Date memBirthday){
        this.memBirthday = memBirthday;
    }

    public Date getMemBirthday(){
        return memBirthday;
    }
    public void setMemEducation(String memEducation){
        this.memEducation = memEducation;
    }

    public String getMemEducation(){
        return memEducation;
    }
    public void setMemPhone(String memPhone){
        this.memPhone = memPhone;
    }

    public String getMemPhone(){
        return memPhone;
    }
    public void setMemEmail(String memEmail){
        this.memEmail = memEmail;
    }

    public String getMemEmail(){
        return memEmail;
    }
    public void setMemJobstate(String memJobstate){
        this.memJobstate = memJobstate;
    }

    public String getMemJobstate(){
        return memJobstate;
    }
    public void setMemPhoto(String memPhoto){
        this.memPhoto = memPhoto;
    }

    public String getMemPhoto(){
        return memPhoto;
    }
    public void setStatus(String status){
        this.status = status;
    }

    public String getStatus(){
        return status;
    }
    public void setPrevious(Long previous){
        this.previous = previous;
    }

    public Long getPrevious(){
        return previous;
    }

    public ArmyMemInfo getArmyMemInfo() {
        return armyMemInfo;
    }

    public void setArmyMemInfo(ArmyMemInfo armyMemInfo) {
        this.armyMemInfo = armyMemInfo;
    }

    public List<ArmyMemEduexp> getArmyMemEduexps() {
        return armyMemEduexps;
    }

    public void setArmyMemEduexps(List<ArmyMemEduexp> armyMemEduexps) {
        this.armyMemEduexps = armyMemEduexps;
    }

    public List<ArmyMemWorkexp> getArmyMemWorkexps() {
        return armyMemWorkexps;
    }

    public void setArmyMemWorkexps(List<ArmyMemWorkexp> armyMemWorkexps) {
        this.armyMemWorkexps = armyMemWorkexps;
    }

    public List<ArmyMemWorkaim> getArmyMemWorkaims() {
        return armyMemWorkaims;
    }

    public void setArmyMemWorkaims(List<ArmyMemWorkaim> armyMemWorkaims) {
        this.armyMemWorkaims = armyMemWorkaims;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("memId", getMemId())
            .append("memName", getMemName())
            .append("memSex", getMemSex())
            .append("memBirthday", getMemBirthday())
            .append("memEducation", getMemEducation())
            .append("memPhone", getMemPhone())
            .append("memEmail", getMemEmail())
            .append("memJobstate", getMemJobstate())
            .append("memPhoto", getMemPhoto())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("status", getStatus())
            .append("remark", getRemark())
            .append("previous", getPrevious())
            .toString();
    }
}
