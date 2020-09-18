package com.jeethink.project.army.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.jeethink.framework.aspectj.lang.annotation.Excel;
import com.jeethink.framework.web.domain.BaseEntity;

/**
 * 教育经历对象 army_mem_eduexp
 * 
 * @author miao
 * @date 2020-09-18
 */
public class ArmyMemEduexp extends BaseEntity{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long eduexpId;

    /** 用户id */
    @Excel(name = "用户id")
    private String memId;

    /** 学校名称 */
    @Excel(name = "学校名称")
    private String schoolName;

    /** 开始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "开始时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date startTime;

    /** 结束时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "结束时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date endTime;

    /** 学历 */
    @Excel(name = "学历")
    private String education;

    /** 专业 */
    @Excel(name = "专业")
    private String major;

    /** 状态 */
    @Excel(name = "状态")
    private String status;

    public void setEduexpId(Long eduexpId){
        this.eduexpId = eduexpId;
    }

    public Long getEduexpId(){
        return eduexpId;
    }
    public void setMemId(String memId){
        this.memId = memId;
    }

    public String getMemId(){
        return memId;
    }
    public void setSchoolName(String schoolName){
        this.schoolName = schoolName;
    }

    public String getSchoolName(){
        return schoolName;
    }
    public void setStartTime(Date startTime){
        this.startTime = startTime;
    }

    public Date getStartTime(){
        return startTime;
    }

    public void setEducation(String education){
        this.education = education;
    }

    public String getEducation(){
        return education;
    }
    public void setMajor(String major){
        this.major = major;
    }

    public String getMajor(){
        return major;
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
            .append("eduexpId", getEduexpId())
            .append("memId", getMemId())
            .append("schoolName", getSchoolName())
            .append("startTime", getStartTime())
            .append("endTime", getEndTime())
            .append("education", getEducation())
            .append("major", getMajor())
            .append("updateTime", getUpdateTime())
            .append("createTime", getCreateTime())
            .append("status", getStatus())
            .toString();
    }
}
