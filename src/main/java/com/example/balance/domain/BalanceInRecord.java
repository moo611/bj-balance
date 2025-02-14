package com.example.balance.domain;


import com.example.balance.domain.base.BaseEntity;

/**
 * 入库对象 balance_in_record
 *
 * @author ruoyi
 * @date 2025-02-09
 */
public class BalanceInRecord extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 天平code */
    
    private String balanceCode;

    public String getBalanceName() {
        return balanceName;
    }

    public void setBalanceName(String balanceName) {
        this.balanceName = balanceName;
    }

    /** 天平名称 */
    private String balanceName;

    /** 使用状况 */
    
    private String useState;

    /** 统合评价 */
    
    private String evaluation;

    /** 交接签名 */
    
    private String pName;

    /** 删除标识 */
    private String delFlag;

    public Float getDuration() {
        return duration;
    }

    public void setDuration(Float duration) {
        this.duration = duration;
    }

    public String getBus() {
        return bus;
    }

    public void setBus(String bus) {
        this.bus = bus;
    }

    /** 试验时长 */
    private Float duration;

    /** 试验车次 */
    private String bus;

    public Boolean getHasChecked() {
        return hasChecked;
    }

    public void setHasChecked(Boolean hasChecked) {
        this.hasChecked = hasChecked;
    }

    private Boolean hasChecked;

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
    public void setUseState(String useState)
    {
        this.useState = useState;
    }

    public String getUseState()
    {
        return useState;
    }
    public void setEvaluation(String evaluation)
    {
        this.evaluation = evaluation;
    }

    public String getEvaluation()
    {
        return evaluation;
    }
    public void setpName(String pName)
    {
        this.pName = pName;
    }

    public String getpName()
    {
        return pName;
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
