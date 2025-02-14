package com.example.balance.mapper;

import java.util.List;
import com.example.balance.domain.BalancePerformance;
import com.example.balance.domain.req.BalancePerformanceListReq;
import org.apache.ibatis.annotations.Mapper;

/**
 * 性能检查Mapper接口
 *
 * @author ruoyi
 * @date 2025-02-08
 */
@Mapper
public interface BalancePerformanceMapper
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


    List<BalancePerformance>selectLatestPerformanceList(BalancePerformanceListReq balancePerformanceListReq);

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
     * 删除性能检查
     *
     * @param id 性能检查主键
     * @return 结果
     */
    public int deleteBalancePerformanceById(Long id);

    /**
     * 批量删除性能检查
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBalancePerformanceByIds(Long[] ids);

    BalancePerformance selectBalancePerformanceByBalance(String balanceCode, Long outId,Long inId);

}
