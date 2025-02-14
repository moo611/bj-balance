package com.example.balance.domain;

import java.util.Date;

import com.example.balance.domain.base.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;


/**
 * 天平基本信息对象 balance_info
 *
 * @author ruoyi
 * @date 2025-02-05
 */
public class BalanceInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 代号 */
    private String balanceCode;


    public String getBalanceName() {
        return balanceName;
    }

    public void setBalanceName(String balanceName) {
        this.balanceName = balanceName;
    }

    private String balanceName;

    /** 类型 */
    
    private String balanceType;

    /** 天平分类 */
    
    private String balanceClassify;

    /** 天平材质 */
    
    private String balanceMaterial;

    /** 支杆数量 */
    
    private Long balanceSupport;

    /** 接口形式 */
    
    private String balanceInferface;

    /** 设计师 */
    
    private String balanceDesigner;

    /** 设计时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    
    private Date balanceDtime;

    /** 加工单位 */
    
    private String balanceFactory;

    /** 加工时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    
    private Date balanceFtime;

    public Float getBalanceX() {
        return balanceX;
    }

    public void setBalanceX(Float balanceX) {
        this.balanceX = balanceX;
    }

    public Float getBalanceY() {
        return balanceY;
    }

    public void setBalanceY(Float balanceY) {
        this.balanceY = balanceY;
    }

    public Float getBalanceZ() {
        return balanceZ;
    }

    public void setBalanceZ(Float balanceZ) {
        this.balanceZ = balanceZ;
    }

    public Float getBalanceMx() {
        return balanceMx;
    }

    public void setBalanceMx(Float balanceMx) {
        this.balanceMx = balanceMx;
    }

    public Float getBalanceMy() {
        return balanceMy;
    }

    public void setBalanceMy(Float balanceMy) {
        this.balanceMy = balanceMy;
    }

    public Float getBalanceMz() {
        return balanceMz;
    }

    public void setBalanceMz(Float balanceMz) {
        this.balanceMz = balanceMz;
    }

    /** 量程X */
    
    private Float balanceX;

    /** 量程Y */
    
    private Float balanceY;

    /** 量程Z */
    
    private Float balanceZ;

    /** 量程MX */
    
    private Float balanceMx;

    /** 量程MY */
    
    private Float balanceMy;

    /** 量程MZ */
    
    private Float balanceMz;

    /** 试验总车次 */
    
    private Long balanceTnum;

    /** 天平现状 */
    
    private String balanceState;

    /** 删除标识 */
    private String delFlag;
    /** 出入库状态 */
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    private String status;

    public void setBalanceCode(String balanceCode)
    {
        this.balanceCode = balanceCode;
    }

    public String getBalanceCode()
    {
        return balanceCode;
    }
    public void setBalanceType(String balanceType)
    {
        this.balanceType = balanceType;
    }

    public String getBalanceType()
    {
        return balanceType;
    }
    public void setBalanceClassify(String balanceClassify)
    {
        this.balanceClassify = balanceClassify;
    }

    public String getBalanceClassify()
    {
        return balanceClassify;
    }
    public void setBalanceMaterial(String balanceMaterial)
    {
        this.balanceMaterial = balanceMaterial;
    }

    public String getBalanceMaterial()
    {
        return balanceMaterial;
    }
    public void setBalanceSupport(Long balanceSupport)
    {
        this.balanceSupport = balanceSupport;
    }

    public Long getBalanceSupport()
    {
        return balanceSupport;
    }
    public void setBalanceInferface(String balanceInferface)
    {
        this.balanceInferface = balanceInferface;
    }

    public String getBalanceInferface()
    {
        return balanceInferface;
    }
    public void setBalanceDesigner(String balanceDesigner)
    {
        this.balanceDesigner = balanceDesigner;
    }

    public String getBalanceDesigner()
    {
        return balanceDesigner;
    }
    public void setBalanceDtime(Date balanceDtime)
    {
        this.balanceDtime = balanceDtime;
    }

    public Date getBalanceDtime()
    {
        return balanceDtime;
    }
    public void setBalanceFactory(String balanceFactory)
    {
        this.balanceFactory = balanceFactory;
    }

    public String getBalanceFactory()
    {
        return balanceFactory;
    }
    public void setBalanceFtime(Date balanceFtime)
    {
        this.balanceFtime = balanceFtime;
    }

    public Date getBalanceFtime()
    {
        return balanceFtime;
    }

    public void setBalanceTnum(Long balanceTnum)
    {
        this.balanceTnum = balanceTnum;
    }

    public Long getBalanceTnum()
    {
        return balanceTnum;
    }
    public void setBalanceState(String balanceState)
    {
        this.balanceState = balanceState;
    }

    public String getBalanceState()
    {
        return balanceState;
    }
    public void setDelFlag(String delFlag)
    {
        this.delFlag = delFlag;
    }

    public String getDelFlag()
    {
        return delFlag;
    }


}
