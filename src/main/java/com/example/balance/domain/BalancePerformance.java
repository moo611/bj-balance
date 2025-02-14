package com.example.balance.domain;


import com.example.balance.domain.base.BaseEntity;

/**
 * 性能检查对象 balance_performance
 *
 * @author ruoyi
 * @date 2025-02-08
 */
public class BalancePerformance extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * $column.columnComment
     */
    private Long id;

    public Long getOutId() {
        return outId;
    }

    public void setOutId(Long outId) {
        this.outId = outId;
    }

    public Long getInId() {
        return inId;
    }

    public void setInId(Long inId) {
        this.inId = inId;
    }

    /**
     * 出库记录id
     */
    
    private Long outId;

    /**
     * 入库记录id
     */
    private Long inId;

    public Float getPerformanceRe() {
        return performanceRe;
    }

    public void setPerformanceRe(Float performanceRe) {
        this.performanceRe = performanceRe;
    }

    public Float getPerformanceInsulation() {
        return performanceInsulation;
    }

    public void setPerformanceInsulation(Float performanceInsulation) {
        this.performanceInsulation = performanceInsulation;
    }



    /**
     * 桥路电阻
     */
    
    private Float performanceRe;

    /**
     * 绝缘性能
     */
    
    private Float performanceInsulation;

    /**
     * 零点时漂
     */
    
    private String performanceZero;

    /**
     * 加载检查
     */
    
    private String performanceLoad;

    /**
     * 检查结果
     */
    
    private String performanceResult;

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

    public String getBalanceName() {
        return balanceName;
    }

    public void setBalanceName(String balanceName) {
        this.balanceName = balanceName;
    }

    //天平代号
    private String balanceName;

    /**
     * 删除标识
     */
    private String delFlag;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }





    public void setPerformanceZero(String performanceZero) {
        this.performanceZero = performanceZero;
    }

    public String getPerformanceZero() {
        return performanceZero;
    }

    public void setPerformanceLoad(String performanceLoad) {
        this.performanceLoad = performanceLoad;
    }

    public String getPerformanceLoad() {
        return performanceLoad;
    }

    public void setPerformanceResult(String performanceResult) {
        this.performanceResult = performanceResult;
    }

    public String getPerformanceResult() {
        return performanceResult;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public String getDelFlag() {
        return delFlag;
    }

}
