package com.jeethink.project.army.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.jeethink.framework.aspectj.lang.annotation.Excel;
import com.jeethink.framework.web.domain.BaseEntity;

/**
 * 求职意向对象 army_mem_workaim
 * 
 * @author miao
 * @date 2020-09-18
 */
public class ArmyMemWorkaim extends BaseEntity{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long workaimId;

    /** 用户id */
    @Excel(name = "用户id")
    private String memId;

    /** 全职，兼职，专职 */
    @Excel(name = "全职，兼职，专职")
    private String workaimType;

    /** 职位 */
    @Excel(name = "职位")
    private String workaimPosition;

    /** 区 */
    @Excel(name = "区")
    private String workaimDistrict;

    /** 市 */
    @Excel(name = "市")
    private String workaimCity;

    /** 最低薪资 */
    @Excel(name = "最低薪资")
    private Long workaimMinsalary;

    /** 最高薪资 */
    @Excel(name = "最高薪资")
    private Long workaimMaxsalary;

    /** 状态 */
    @Excel(name = "状态")
    private String status;

    public void setWorkaimId(Long workaimId){
        this.workaimId = workaimId;
    }

    public Long getWorkaimId(){
        return workaimId;
    }
    public void setMemId(String memId){
        this.memId = memId;
    }

    public String getMemId(){
        return memId;
    }
    public void setWorkaimType(String workaimType){
        this.workaimType = workaimType;
    }

    public String getWorkaimType(){
        return workaimType;
    }
    public void setWorkaimPosition(String workaimPosition){
        this.workaimPosition = workaimPosition;
    }

    public String getWorkaimPosition(){
        return workaimPosition;
    }
    public void setWorkaimDistrict(String workaimDistrict){
        this.workaimDistrict = workaimDistrict;
    }

    public String getWorkaimDistrict(){
        return workaimDistrict;
    }
    public void setWorkaimCity(String workaimCity){
        this.workaimCity = workaimCity;
    }

    public String getWorkaimCity(){
        return workaimCity;
    }
    public void setWorkaimMinsalary(Long workaimMinsalary){
        this.workaimMinsalary = workaimMinsalary;
    }

    public Long getWorkaimMinsalary(){
        return workaimMinsalary;
    }
    public void setWorkaimMaxsalary(Long workaimMaxsalary){
        this.workaimMaxsalary = workaimMaxsalary;
    }

    public Long getWorkaimMaxsalary(){
        return workaimMaxsalary;
    }
    public void setStatus(String status){
        this.status = status;
    }

    public String getStatus(){
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("workaimId", getWorkaimId())
            .append("memId", getMemId())
            .append("workaimType", getWorkaimType())
            .append("workaimPosition", getWorkaimPosition())
            .append("workaimDistrict", getWorkaimDistrict())
            .append("workaimCity", getWorkaimCity())
            .append("workaimMinsalary", getWorkaimMinsalary())
            .append("workaimMaxsalary", getWorkaimMaxsalary())
            .append("updateTime", getUpdateTime())
            .append("createTime", getCreateTime())
            .append("status", getStatus())
            .toString();
    }
}
