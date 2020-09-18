package com.jeethink.project.army.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.jeethink.framework.aspectj.lang.annotation.Excel;
import com.jeethink.framework.web.domain.BaseEntity;

/**
 * 公司对象 army_com
 * 
 * @author miao
 * @date 2020-09-18
 */
public class ArmyCom extends BaseEntity{
    private static final long serialVersionUID = 1L;

    /** 公司id */
    private Long comId;

    /** 公司账号 */
    private String comname;

    /** 公司密码 */
    private String compassword;

    /** 公司名称 */
    @Excel(name = "公司名称")
    private String comName;

    /** 公司规模 */
    @Excel(name = "公司规模")
    private String comScale;

    /** 行业 */
    @Excel(name = "行业")
    private String comIndustry;

    /** 地址 */
    @Excel(name = "地址")
    private String comAddress;

    /** 公司介绍 */
    @Excel(name = "公司介绍")
    private String comSketch;

    /** 法人 */
    @Excel(name = "法人")
    private String comBoss;

    /** 产品介绍 */
    @Excel(name = "产品介绍")
    private String comProduct;

    /** 公司照片 */
    @Excel(name = "公司照片")
    private String comPhoto;

    /** 状态 */
    @Excel(name = "状态")
    private String status;

    /** 修改之前的id */
    private Long previous;

    public void setComId(Long comId){
        this.comId = comId;
    }

    public Long getComId(){
        return comId;
    }
    public void setComname(String comname){
        this.comname = comname;
    }

    public String getComname(){
        return comname;
    }
    public void setCompassword(String compassword){
        this.compassword = compassword;
    }

    public String getCompassword(){
        return compassword;
    }
    public void setComName(String comName){
        this.comName = comName;
    }

    public String getComName(){
        return comName;
    }
    public void setComScale(String comScale){
        this.comScale = comScale;
    }

    public String getComScale(){
        return comScale;
    }
    public void setComIndustry(String comIndustry){
        this.comIndustry = comIndustry;
    }

    public String getComIndustry(){
        return comIndustry;
    }
    public void setComAddress(String comAddress){
        this.comAddress = comAddress;
    }

    public String getComAddress(){
        return comAddress;
    }
    public void setComSketch(String comSketch){
        this.comSketch = comSketch;
    }

    public String getComSketch(){
        return comSketch;
    }
    public void setComBoss(String comBoss){
        this.comBoss = comBoss;
    }

    public String getComBoss(){
        return comBoss;
    }
    public void setComProduct(String comProduct){
        this.comProduct = comProduct;
    }

    public String getComProduct(){
        return comProduct;
    }
    public void setComPhoto(String comPhoto){
        this.comPhoto = comPhoto;
    }

    public String getComPhoto(){
        return comPhoto;
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
            .append("comId", getComId())
            .append("comname", getComname())
            .append("compassword", getCompassword())
            .append("comName", getComName())
            .append("comScale", getComScale())
            .append("comIndustry", getComIndustry())
            .append("comAddress", getComAddress())
            .append("comSketch", getComSketch())
            .append("comBoss", getComBoss())
            .append("comProduct", getComProduct())
            .append("comPhoto", getComPhoto())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("status", getStatus())
            .append("remark", getRemark())
            .append("previous", getPrevious())
            .toString();
    }
}
