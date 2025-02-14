package com.example.balance.service;

import java.util.List;
import com.example.balance.domain.BalanceSupport;

/**
 * 支杆Service接口
 *
 * @author ruoyi
 * @date 2025-02-06
 */
public interface IBalanceSupportService
{
    /**
     * 查询支杆
     *
     * @param id 支杆主键
     * @return 支杆
     */
    public BalanceSupport selectBalanceSupportById(Long id);

    /**
     * 查询支杆列表
     *
     * @param balanceSupport 支杆
     * @return 支杆集合
     */
    public List<BalanceSupport> selectBalanceSupportList(BalanceSupport balanceSupport);

    /**
     * 新增支杆
     *
     * @param balanceSupport 支杆
     * @return 结果
     */
    public int insertBalanceSupport(BalanceSupport balanceSupport);

    /**
     * 修改支杆
     *
     * @param balanceSupport 支杆
     * @return 结果
     */
    public int updateBalanceSupport(BalanceSupport balanceSupport);

    /**
     * 批量删除支杆
     *
     * @param ids 需要删除的支杆主键集合
     * @return 结果
     */
    public int deleteBalanceSupportByIds(Long[] ids);

    /**
     * 删除支杆信息
     *
     * @param id 支杆主键
     * @return 结果
     */
    public int deleteBalanceSupportById(Long id);

    BalanceSupport selectBalanceSupportByBalanceCode(String balanceCode);

    int saveOrUpdate(BalanceSupport balanceSupport);

}
