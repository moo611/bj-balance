package com.example.balance.domain;


import com.example.balance.domain.base.BaseEntity;

/**
 * 天平出库记录对象 balance_out_record
 *
 * @author ruoyi
 * @date 2025-02-08
 */
public class BalanceOutRecord extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** $column.columnComment */
    
    private String balanceCode;


    public String getBalanceName() {
        return balanceName;
    }

    public void setBalanceName(String balanceName) {
        this.balanceName = balanceName;
    }

    private String balanceName;

    /** 风洞名称 */
    
    private String wholeName;

    public String getWholeCode() {
        return wholeCode;
    }

    public void setWholeCode(String wholeCode) {
        this.wholeCode = wholeCode;
    }

    /** 风洞代号 */
    private String wholeCode;

    /** 借用人签名 */
    
    private String pName;


    public Boolean getHasChecked() {
        return hasChecked;
    }

    public void setHasChecked(Boolean hasChecked) {
        this.hasChecked = hasChecked;
    }

    private Boolean hasChecked;

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
    public void setWholeName(String wholeName)
    {
        this.wholeName = wholeName;
    }

    public String getWholeName()
    {
        return wholeName;
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
