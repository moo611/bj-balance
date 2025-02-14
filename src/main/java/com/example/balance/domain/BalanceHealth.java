package com.example.balance.domain;


import com.example.balance.domain.base.BaseEntity;

/**
 * 故障对象 balance_health
 *
 * @author ruoyi
 * @date 2025-02-09
 */
public class BalanceHealth extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    public Long getInId() {
        return inId;
    }

    public void setInId(Long inId) {
        this.inId = inId;
    }

    /** 入库记录id */
    
    private Long inId;

    /** 天平code */
    
    private String balanceCode;

    /** 试验型号 */
    
    private String healthType;

    /** 使用条件 */
    
    private String healthCons;

    /** 故障状态 */
    
    private String healthState;

    /** 故障原因 */
    
    private String healthReason;

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

    public void setBalanceCode(String balanceCode)
    {
        this.balanceCode = balanceCode;
    }

    public String getBalanceCode()
    {
        return balanceCode;
    }
    public void setHealthType(String healthType)
    {
        this.healthType = healthType;
    }

    public String getHealthType()
    {
        return healthType;
    }
    public void setHealthCons(String healthCons)
    {
        this.healthCons = healthCons;
    }

    public String getHealthCons()
    {
        return healthCons;
    }
    public void setHealthState(String healthState)
    {
        this.healthState = healthState;
    }

    public String getHealthState()
    {
        return healthState;
    }
    public void setHealthReason(String healthReason)
    {
        this.healthReason = healthReason;
    }

    public String getHealthReason()
    {
        return healthReason;
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
