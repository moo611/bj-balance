package com.example.balance.domain;


import com.example.balance.domain.base.BaseEntity;

import java.util.List;

/**
 * 尺寸对象 balance_size
 *
 * @author ruoyi
 * @date 2025-02-05
 */
public class BalanceSize extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** $column.columnComment */
    
    private String balanceCode;

    /** 设计人员 */
    
    private String designerName;

    /** $column.columnComment */
    
    private String designShape;

    /** 设计任务文件id */
    
    private Long designTask;

    /** 设计报告id */
    
    private Long designReport;

    /** 设计图id */
    
    private Long designPic;


    public Float getSizeX() {
        return sizeX;
    }

    public void setSizeX(Float sizeX) {
        this.sizeX = sizeX;
    }

    public Float getSizeY() {
        return sizeY;
    }

    public void setSizeY(Float sizeY) {
        this.sizeY = sizeY;
    }

    public Float getSizeZ() {
        return sizeZ;
    }

    public void setSizeZ(Float sizeZ) {
        this.sizeZ = sizeZ;
    }

    private Float sizeX;


    private Float sizeY;

    private Float sizeZ;


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
    public void setDesignerName(String designerName)
    {
        this.designerName = designerName;
    }

    public String getDesignerName()
    {
        return designerName;
    }
    public void setDesignShape(String designShape)
    {
        this.designShape = designShape;
    }

    public String getDesignShape()
    {
        return designShape;
    }
    public void setDesignTask(Long designTask)
    {
        this.designTask = designTask;
    }

    public Long getDesignTask()
    {
        return designTask;
    }
    public void setDesignReport(Long designReport)
    {
        this.designReport = designReport;
    }

    public Long getDesignReport()
    {
        return designReport;
    }
    public void setDesignPic(Long designPic)
    {
        this.designPic = designPic;
    }

    public Long getDesignPic()
    {
        return designPic;
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
