package com.example.balance.service;

import java.util.List;
import com.example.balance.domain.BalancePerformance;
import com.example.balance.domain.req.BalancePerformanceListReq;

/**
 * 性能检查Service接口
 *
 * @author ruoyi
 * @date 2025-02-08
 */
public interface IBalancePerformanceService
{
    /**
     * 查询性能检查
     *
     * @param id 性能检查主键
     * @return 性能检查
     */
    public BalancePerformance selectBalancePerformanceById(Long id);

    /**
     * 查询性能检查列表
     *
     * @param balancePerformance 性能检查
     * @return 性能检查集合
     */
    public List<BalancePerformance> selectBalancePerformanceList(BalancePerformance balancePerformance);

    /**
     * 新增性能检查
     *
     * @param balancePerformance 性能检查
     * @return 结果
     */
    public int insertBalancePerformance(BalancePerformance balancePerformance);

    /**
     * 修改性能检查
     *
     * @param balancePerformance 性能检查
     * @return 结果
     */
    public int updateBalancePerformance(BalancePerformance balancePerformance);

    /**
     * 批量删除性能检查
     *
     * @param ids 需要删除的性能检查主键集合
     * @return 结果
     */
    public int deleteBalancePerformanceByIds(Long[] ids);

    /**
     * 删除性能检查信息
     *
     * @param id 性能检查主键
     * @return 结果
     */
    public int deleteBalancePerformanceById(Long id);

    BalancePerformance getInfoByBalance(String balanceCode, Long outId,Long inId);

    int saveOrUpdate(BalancePerformance balancePerformance);

    List<BalancePerformance> selectLatest(BalancePerformanceListReq balancePerformanceListReq);

}
