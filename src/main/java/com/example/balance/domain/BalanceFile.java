package com.example.balance.domain;


import com.example.balance.domain.base.BaseEntity;

/**
 * 文件对象 balance_file
 *
 * @author ruoyi
 * @date 2025-02-07
 */
public class BalanceFile extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** $column.columnComment */
    
    private String fileName;

    /** 0、设计任务书1、设计报告2、设计图 */
    
    private String fileType;

    /** $column.columnComment */
    
    private String filePath;

    /** 0、设计1、加工 */
    
    private String fileBelong;

    /** 删除标识 */
    private String delFlag;

    public String getBalanceCode() {
        return balanceCode;
    }

    public void setBalanceCode(String balanceCode) {
        this.balanceCode = balanceCode;
    }

    /** 天平code */
    private String balanceCode;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setFileName(String fileName)
    {
        this.fileName = fileName;
    }

    public String getFileName()
    {
        return fileName;
    }
    public void setFileType(String fileType)
    {
        this.fileType = fileType;
    }

    public String getFileType()
    {
        return fileType;
    }
    public void setFilePath(String filePath)
    {
        this.filePath = filePath;
    }

    public String getFilePath()
    {
        return filePath;
    }
    public void setFileBelong(String fileBelong)
    {
        this.fileBelong = fileBelong;
    }

    public String getFileBelong()
    {
        return fileBelong;
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
