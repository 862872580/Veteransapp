package com.jeethink.project.army.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.jeethink.framework.aspectj.lang.annotation.Excel;
import com.jeethink.framework.web.domain.BaseEntity;

/**
 * 用户详细信息对象 army_mem_info
 * 
 * @author miao
 * @date 2020-09-18
 */
public class ArmyMemInfo extends BaseEntity{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long infoId;

    /** 用户id */
    @Excel(name = "用户id")
    private String memId;

    /** 身高 */
    @Excel(name = "身高")
    private Long infoHeight;

    /** 体重 */
    @Excel(name = "体重")
    private Long infoWeight;

    /** 简述 */
    @Excel(name = "简述")
    private String infoSketch;

    /** 是否启用 */
    @Excel(name = "是否启用")
    private String status;

    public void setInfoId(Long infoId){
        this.infoId = infoId;
    }

    public Long getInfoId(){
        return infoId;
    }
    public void setMemId(String memId){
        this.memId = memId;
    }

    public String getMemId(){
        return memId;
    }
    public void setInfoHeight(Long infoHeight){
        this.infoHeight = infoHeight;
    }

    public Long getInfoHeight(){
        return infoHeight;
    }
    public void setInfoWeight(Long infoWeight){
        this.infoWeight = infoWeight;
    }

    public Long getInfoWeight(){
        return infoWeight;
    }
    public void setInfoSketch(String infoSketch){
        this.infoSketch = infoSketch;
    }

    public String getInfoSketch(){
        return infoSketch;
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
            .append("infoId", getInfoId())
            .append("memId", getMemId())
            .append("infoHeight", getInfoHeight())
            .append("infoWeight", getInfoWeight())
            .append("infoSketch", getInfoSketch())
            .append("updateTime", getUpdateTime())
            .append("createTime", getCreateTime())
            .append("status", getStatus())
            .toString();
    }
}
