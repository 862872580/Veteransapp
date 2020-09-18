package com.jeethink.project.army.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.jeethink.framework.aspectj.lang.annotation.Excel;
import com.jeethink.framework.web.domain.BaseEntity;

/**
 * 工作经历对象 army_mem_workexp
 * 
 * @author miao
 * @date 2020-09-18
 */
public class ArmyMemWorkexp extends BaseEntity{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long workexpId;

    /** 用户id */
    @Excel(name = "用户id")
    private String memId;

    /** 公司名称 */
    @Excel(name = "公司名称")
    private String comName;

    /** 开始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "开始时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date beginTime;

    /** 结束时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "结束时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date endTime;

    /** 职位 */
    @Excel(name = "职位")
    private String workexpPosition;

    /** 工作内容 */
    @Excel(name = "工作内容")
    private String workexpContent;

    /** 薪资 */
    @Excel(name = "薪资")
    private Long workexpSalary;

    /** 是否启用 */
    @Excel(name = "是否启用")
    private String status;

    public void setWorkexpId(Long workexpId){
        this.workexpId = workexpId;
    }

    public Long getWorkexpId(){
        return workexpId;
    }
    public void setMemId(String memId){
        this.memId = memId;
    }

    public String getMemId(){
        return memId;
    }
    public void setComName(String comName){
        this.comName = comName;
    }

    public String getComName(){
        return comName;
    }
    public void setBeginTime(Date beginTime){
        this.beginTime = beginTime;
    }

    public String getWorkexpPosition(){
        return workexpPosition;
    }
    public void setWorkexpContent(String workexpContent){
        this.workexpContent = workexpContent;
    }

    public String getWorkexpContent(){
        return workexpContent;
    }
    public void setWorkexpSalary(Long workexpSalary){
        this.workexpSalary = workexpSalary;
    }

    public Long getWorkexpSalary(){
        return workexpSalary;
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
            .append("workexpId", getWorkexpId())
            .append("memId", getMemId())
            .append("comName", getComName())
            .append("beginTime", getBeginTime())
            .append("endTime", getEndTime())
            .append("workexpPosition", getWorkexpPosition())
            .append("workexpContent", getWorkexpContent())
            .append("workexpSalary", getWorkexpSalary())
            .append("updateTime", getUpdateTime())
            .append("createTime", getCreateTime())
            .append("status", getStatus())
            .toString();
    }
}
