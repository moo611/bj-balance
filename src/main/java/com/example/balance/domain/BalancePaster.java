package com.example.balance.domain;

import java.util.Date;

import com.example.balance.domain.base.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;


/**
 * 贴片信息对象 balance_paster
 *
 * @author ruoyi
 * @date 2025-02-05
 */
public class BalancePaster extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * $column.columnComment
     */
    private Long id;

    /**
     * $column.columnComment
     */

    private String balanceCode;

    /**
     * 应变计信息
     */

    private Long strainGaugeId;

    /**
     * 贴片时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")

    private Date bpasterTime;

    /**
     * 贴片位置
     */

    private String bpasterPos;

    /**
     * 组桥图
     */

    private String bprocessPhoto;

    /**
     * 桥压
     */

    private Float bridgePressure;

    /**
     * 贴片人员名称
     */

    private String bprocessPerson;

    private String strainGaugeType;


    private String strainGaugeNorm;

    private String strainGaugeFactory;

    /**
     * 温度补偿
     */

    private Float tempCompensation;

    /**
     * 贴片过程数据
     */

    private String bpasterPrcdata;

    /**
     * 删除标识
     */
    private String delFlag;


    public String getStrainGaugeFactory() {
        return strainGaugeFactory;
    }

    public void setStrainGaugeFactory(String strainGaugeFactory) {
        this.strainGaugeFactory = strainGaugeFactory;
    }

    public String getStrainGaugeNorm() {
        return strainGaugeNorm;
    }

    public void setStrainGaugeNorm(String strainGaugeNorm) {
        this.strainGaugeNorm = strainGaugeNorm;
    }

    public String getStrainGaugeType() {
        return strainGaugeType;
    }

    public void setStrainGaugeType(String strainGaugeType) {
        this.strainGaugeType = strainGaugeType;
    }


    public Float getTempCompensation() {
        return tempCompensation;
    }

    public void setTempCompensation(Float tempCompensation) {
        this.tempCompensation = tempCompensation;
    }

    public Float getBridgePressure() {
        return bridgePressure;
    }

    public void setBridgePressure(Float bridgePressure) {
        this.bridgePressure = bridgePressure;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setBalanceCode(String balanceCode) {
        this.balanceCode = balanceCode;
    }

    public String getBalanceCode() {
        return balanceCode;
    }

    public void setStrainGaugeId(Long strainGaugeId) {
        this.strainGaugeId = strainGaugeId;
    }

    public Long getStrainGaugeId() {
        return strainGaugeId;
    }

    public void setBpasterTime(Date bpasterTime) {
        this.bpasterTime = bpasterTime;
    }

    public Date getBpasterTime() {
        return bpasterTime;
    }

    public void setBpasterPos(String bpasterPos) {
        this.bpasterPos = bpasterPos;
    }

    public String getBpasterPos() {
        return bpasterPos;
    }

    public void setBprocessPhoto(String bprocessPhoto) {
        this.bprocessPhoto = bprocessPhoto;
    }

    public String getBprocessPhoto() {
        return bprocessPhoto;
    }

    public void setBprocessPerson(String bprocessPerson) {
        this.bprocessPerson = bprocessPerson;
    }

    public String getBprocessPerson() {
        return bprocessPerson;
    }

    public void setBpasterPrcdata(String bpasterPrcdata) {
        this.bpasterPrcdata = bpasterPrcdata;
    }

    public String getBpasterPrcdata() {
        return bpasterPrcdata;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public String getDelFlag() {
        return delFlag;
    }


}
