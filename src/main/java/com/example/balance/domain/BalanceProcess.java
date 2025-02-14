package com.example.balance.domain;

import java.util.Date;

import com.example.balance.domain.base.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;


/**
 * 加工对象 balance_process
 *
 * @author ruoyi
 * @date 2025-02-05
 */
public class BalanceProcess extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** $column.columnComment */
    
    private String balanceCode;

    /** 制造材料 */
    
    private String bprocessMaterials;

    /** 加工厂商名称 */
    
    private String bprocessFactory;

    /** 加工时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    
    private Date bprocessCtime;

    /** 加工图片id */
    
    private Long bprocessPhoto;

    /** 图形文件id */
    
    private Long balanceFile;

    /** 加工合同id */
    
    private Long bprocessAgreement;

    /** 加工工艺 */
    
    private String bprocessCraft;

    /** 质量检验id */
    
    private Long qualityInspection;

    /** 合同验收id */
    
    private Long contractAcceptance;

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
    public void setBprocessMaterials(String bprocessMaterials)
    {
        this.bprocessMaterials = bprocessMaterials;
    }

    public String getBprocessMaterials()
    {
        return bprocessMaterials;
    }
    public void setBprocessFactory(String bprocessFactory)
    {
        this.bprocessFactory = bprocessFactory;
    }

    public String getBprocessFactory()
    {
        return bprocessFactory;
    }
    public void setBprocessCtime(Date bprocessCtime)
    {
        this.bprocessCtime = bprocessCtime;
    }

    public Date getBprocessCtime()
    {
        return bprocessCtime;
    }
    public void setBprocessPhoto(Long bprocessPhoto)
    {
        this.bprocessPhoto = bprocessPhoto;
    }

    public Long getBprocessPhoto()
    {
        return bprocessPhoto;
    }
    public void setBalanceFile(Long balanceFile)
    {
        this.balanceFile = balanceFile;
    }

    public Long getBalanceFile()
    {
        return balanceFile;
    }
    public void setBprocessAgreement(Long bprocessAgreement)
    {
        this.bprocessAgreement = bprocessAgreement;
    }

    public Long getBprocessAgreement()
    {
        return bprocessAgreement;
    }
    public void setBprocessCraft(String bprocessCraft)
    {
        this.bprocessCraft = bprocessCraft;
    }

    public String getBprocessCraft()
    {
        return bprocessCraft;
    }
    public void setQualityInspection(Long qualityInspection)
    {
        this.qualityInspection = qualityInspection;
    }

    public Long getQualityInspection()
    {
        return qualityInspection;
    }
    public void setContractAcceptance(Long contractAcceptance)
    {
        this.contractAcceptance = contractAcceptance;
    }

    public Long getContractAcceptance()
    {
        return contractAcceptance;
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
