package com.example.balance.service;

import java.util.List;
import com.example.balance.domain.BalanceUse;

/**
 * 使用信息Service接口
 *
 * @author ruoyi
 * @date 2025-02-08
 */
public interface IBalanceUseService
{
    /**
     * 查询使用信息
     *
     * @param id 使用信息主键
     * @return 使用信息
     */
    public BalanceUse selectBalanceUseById(Long id);

    /**
     * 查询使用信息列表
     *
     * @param balanceUse 使用信息
     * @return 使用信息集合
     */
    public List<BalanceUse> selectBalanceUseList(BalanceUse balanceUse);

    /**
     * 新增使用信息
     *
     * @param balanceUse 使用信息
     * @return 结果
     */
    public int insertBalanceUse(BalanceUse balanceUse);

    /**
     * 修改使用信息
     *
     * @param balanceUse 使用信息
     * @return 结果
     */
    public int updateBalanceUse(BalanceUse balanceUse);

    /**
     * 批量删除使用信息
     *
     * @param ids 需要删除的使用信息主键集合
     * @return 结果
     */
    public int deleteBalanceUseByIds(Long[] ids);

    /**
     * 删除使用信息信息
     *
     * @param id 使用信息主键
     * @return 结果
     */
    public int deleteBalanceUseById(Long id);

    BalanceUse getInfoByBalance(String balanceCode, Long outId);

    int saveOrUpdate(BalanceUse balanceUse);

}
