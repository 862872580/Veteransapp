package com.jeethink.project.army.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.jeethink.framework.aspectj.lang.annotation.Excel;
import com.jeethink.framework.web.domain.BaseEntity;

/**
 * 工作对象 army_com_work
 * 
 * @author miao
 * @date 2020-09-18
 */
public class ArmyComWork extends BaseEntity{
    private static final long serialVersionUID = 1L;

    /** 工作id */
    private Long workId;

    /** 工作职位 */
    @Excel(name = "工作职位")
    private String workPosition;

    /** 全职/兼职/专职 */
    @Excel(name = "全职/兼职/专职")
    private String workType;

    /** 最低薪资 */
    @Excel(name = "最低薪资")
    private Long workMinsalary;

    /** 最高薪资 */
    @Excel(name = "最高薪资")
    private Long workMaxsalary;

    /** 市 */
    @Excel(name = "市")
    private String workCity;

    /** 区 */
    @Excel(name = "区")
    private String workDistrict;

    /** 电话 */
    @Excel(name = "电话")
    private String workPhone;

    /** 邮箱 */
    @Excel(name = "邮箱")
    private String workEmail;

    /** 职位优势 */
    @Excel(name = "职位优势")
    private String workAdv;

    /** 薪资福利简述 */
    @Excel(name = "薪资福利简述")
    private String workSketch;

    /** 公司id */
    @Excel(name = "公司id")
    private Long comId;

    /** 工作地点 */
    @Excel(name = "工作地点")
    private String workAddress;

    /** 是否启用 */
    @Excel(name = "是否启用")
    private String status;

    /** 修改之前的id */
    @Excel(name = "修改之前的id")
    private Long previous;

    public void setWorkId(Long workId){
        this.workId = workId;
    }

    public Long getWorkId(){
        return workId;
    }
    public void setWorkPosition(String workPosition){
        this.workPosition = workPosition;
    }

    public String getWorkPosition(){
        return workPosition;
    }
    public void setWorkType(String workType){
        this.workType = workType;
    }

    public String getWorkType(){
        return workType;
    }
    public void setWorkMinsalary(Long workMinsalary){
        this.workMinsalary = workMinsalary;
    }

    public Long getWorkMinsalary(){
        return workMinsalary;
    }
    public void setWorkMaxsalary(Long workMaxsalary){
        this.workMaxsalary = workMaxsalary;
    }

    public Long getWorkMaxsalary(){
        return workMaxsalary;
    }
    public void setWorkCity(String workCity){
        this.workCity = workCity;
    }

    public String getWorkCity(){
        return workCity;
    }
    public void setWorkDistrict(String workDistrict){
        this.workDistrict = workDistrict;
    }

    public String getWorkDistrict(){
        return workDistrict;
    }
    public void setWorkPhone(String workPhone){
        this.workPhone = workPhone;
    }

    public String getWorkPhone(){
        return workPhone;
    }
    public void setWorkEmail(String workEmail){
        this.workEmail = workEmail;
    }

    public String getWorkEmail(){
        return workEmail;
    }
    public void setWorkAdv(String workAdv){
        this.workAdv = workAdv;
    }

    public String getWorkAdv(){
        return workAdv;
    }
    public void setWorkSketch(String workSketch){
        this.workSketch = workSketch;
    }

    public String getWorkSketch(){
        return workSketch;
    }
    public void setComId(Long comId){
        this.comId = comId;
    }

    public Long getComId(){
        return comId;
    }
    public void setWorkAddress(String workAddress){
        this.workAddress = workAddress;
    }

    public String getWorkAddress(){
        return workAddress;
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

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("workId", getWorkId())
            .append("workPosition", getWorkPosition())
            .append("workType", getWorkType())
            .append("workMinsalary", getWorkMinsalary())
            .append("workMaxsalary", getWorkMaxsalary())
            .append("workCity", getWorkCity())
            .append("workDistrict", getWorkDistrict())
            .append("workPhone", getWorkPhone())
            .append("workEmail", getWorkEmail())
            .append("workAdv", getWorkAdv())
            .append("workSketch", getWorkSketch())
            .append("comId", getComId())
            .append("workAddress", getWorkAddress())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("status", getStatus())
            .append("remark", getRemark())
            .append("previous", getPrevious())
            .toString();
    }
}
