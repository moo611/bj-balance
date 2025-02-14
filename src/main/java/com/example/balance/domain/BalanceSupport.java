package com.example.balance.domain;


import com.example.balance.domain.base.BaseEntity;

/**
 * 支杆对象 balance_support
 *
 * @author ruoyi
 * @date 2025-02-06
 */
public class BalanceSupport extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** $column.columnComment */
    
    private String balanceCode;

    /** 安装支撑类型 */
    
    private String supportType;

    /** 安装支撑名称 */
    
    private String supportName;

    /** 结构图 */
    
    private String supportPic;

    /** 弹性角 */
    
    private String supportAng;

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
    public void setSupportType(String supportType)
    {
        this.supportType = supportType;
    }

    public String getSupportType()
    {
        return supportType;
    }
    public void setSupportName(String supportName)
    {
        this.supportName = supportName;
    }

    public String getSupportName()
    {
        return supportName;
    }
    public void setSupportPic(String supportPic)
    {
        this.supportPic = supportPic;
    }

    public String getSupportPic()
    {
        return supportPic;
    }
    public void setSupportAng(String supportAng)
    {
        this.supportAng = supportAng;
    }

    public String getSupportAng()
    {
        return supportAng;
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
