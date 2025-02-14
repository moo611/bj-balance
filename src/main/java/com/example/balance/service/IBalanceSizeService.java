package com.example.balance.service;

import java.util.List;
import com.example.balance.domain.BalanceSize;

/**
 * 尺寸Service接口
 *
 * @author ruoyi
 * @date 2025-02-05
 */
public interface IBalanceSizeService
{
    /**
     * 查询尺寸
     *
     * @param id 尺寸主键
     * @return 尺寸
     */
    public BalanceSize selectBalanceSizeById(Long id);

    /**
     * 查询尺寸列表
     *
     * @param balanceSize 尺寸
     * @return 尺寸集合
     */
    public List<BalanceSize> selectBalanceSizeList(BalanceSize balanceSize);

    /**
     * 新增尺寸
     *
     * @param balanceSize 尺寸
     * @return 结果
     */
    public int insertBalanceSize(BalanceSize balanceSize);

    /**
     * 修改尺寸
     *
     * @param balanceSize 尺寸
     * @return 结果
     */
    public int updateBalanceSize(BalanceSize balanceSize);

    /**
     * 批量删除尺寸
     *
     * @param ids 需要删除的尺寸主键集合
     * @return 结果
     */
    public int deleteBalanceSizeByIds(Long[] ids);

    /**
     * 删除尺寸信息
     *
     * @param id 尺寸主键
     * @return 结果
     */
    public int deleteBalanceSizeById(Long id);

    BalanceSize selectBalanceSizeByBalanceCode(String balanceCode);

    int saveOrUpdate(BalanceSize balanceSize);
}
