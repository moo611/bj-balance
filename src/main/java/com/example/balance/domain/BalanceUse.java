package com.example.balance.domain;

import java.util.Date;

import com.example.balance.domain.base.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;


/**
 * 使用信息对象 balance_use
 *
 * @author ruoyi
 * @date 2025-02-08
 */
public class BalanceUse extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    public Long getOutId() {
        return outId;
    }

    public void setOutId(Long outId) {
        this.outId = outId;
    }

    /** 出库记录id */
    
    private Long outId;

    /** 试验型号 */
    
    private String testType;

    /** 支撑装置 */
    
    private String support;

    /** 模型 */
    
    private String mdl;

    /** 责任人 */
    
    private String person;

    /** 借用时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    
    private Date ctime;

    /** 使用周期 */
    
    private String useTime;

    public String getBalanceCode() {
        return balanceCode;
    }

    public void setBalanceCode(String balanceCode) {
        this.balanceCode = balanceCode;
    }

    /**
     * 天平code
     */

    private String balanceCode;

    /** 删除标识 */
    private String delFlag;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }

    public void setTestType(String testType)
    {
        this.testType = testType;
    }

    public String getTestType()
    {
        return testType;
    }
    public void setSupport(String support)
    {
        this.support = support;
    }

    public String getSupport()
    {
        return support;
    }
    public void setMdl(String mdl)
    {
        this.mdl = mdl;
    }

    public String getMdl()
    {
        return mdl;
    }
    public void setPerson(String person)
    {
        this.person = person;
    }

    public String getPerson()
    {
        return person;
    }
    public void setCtime(Date ctime)
    {
        this.ctime = ctime;
    }

    public Date getCtime()
    {
        return ctime;
    }
    public void setUseTime(String useTime)
    {
        this.useTime = useTime;
    }

    public String getUseTime()
    {
        return useTime;
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
