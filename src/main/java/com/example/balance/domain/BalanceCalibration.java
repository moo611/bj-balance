package com.example.balance.domain;

import java.util.Date;

import com.example.balance.domain.base.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;


/**
 * 证书对象 balance_calibration
 *
 * @author ruoyi
 * @date 2025-02-06
 */
public class BalanceCalibration extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private String bcalibrationCode;

    /** $column.columnComment */
    
    private String balanceCode;

    /** 证书名称 */
    
    private String bcalibrationName;

    /** 证书有效期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    
    private Date bcalibrationTime;

    /** 证书文件 */
    
    private String bcalibrationFile;

    /** 证书版本 */
    
    private String bcalibrationVersion;

    /** 删除标识 */
    private String delFlag;

    public void setBcalibrationCode(String bcalibrationCode)
    {
        this.bcalibrationCode = bcalibrationCode;
    }

    public String getBcalibrationCode()
    {
        return bcalibrationCode;
    }
    public void setBalanceCode(String balanceCode)
    {
        this.balanceCode = balanceCode;
    }

    public String getBalanceCode()
    {
        return balanceCode;
    }
    public void setBcalibrationName(String bcalibrationName)
    {
        this.bcalibrationName = bcalibrationName;
    }

    public String getBcalibrationName()
    {
        return bcalibrationName;
    }
    public void setBcalibrationTime(Date bcalibrationTime)
    {
        this.bcalibrationTime = bcalibrationTime;
    }

    public Date getBcalibrationTime()
    {
        return bcalibrationTime;
    }
    public void setBcalibrationFile(String bcalibrationFile)
    {
        this.bcalibrationFile = bcalibrationFile;
    }

    public String getBcalibrationFile()
    {
        return bcalibrationFile;
    }
    public void setBcalibrationVersion(String bcalibrationVersion)
    {
        this.bcalibrationVersion = bcalibrationVersion;
    }

    public String getBcalibrationVersion()
    {
        return bcalibrationVersion;
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
