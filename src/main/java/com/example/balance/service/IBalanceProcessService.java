package com.example.balance.service;

import java.util.List;
import com.example.balance.domain.BalanceProcess;
import com.example.balance.domain.BalanceSize;

/**
 * 加工Service接口
 *
 * @author ruoyi
 * @date 2025-02-05
 */
public interface IBalanceProcessService
{
    /**
     * 查询加工
     *
     * @param id 加工主键
     * @return 加工
     */
    public BalanceProcess selectBalanceProcessById(Long id);

    /**
     * 查询加工列表
     *
     * @param balanceProcess 加工
     * @return 加工集合
     */
    public List<BalanceProcess> selectBalanceProcessList(BalanceProcess balanceProcess);

    /**
     * 新增加工
     *
     * @param balanceProcess 加工
     * @return 结果
     */
    public int insertBalanceProcess(BalanceProcess balanceProcess);

    /**
     * 修改加工
     *
     * @param balanceProcess 加工
     * @return 结果
     */
    public int updateBalanceProcess(BalanceProcess balanceProcess);

    /**
     * 批量删除加工
     *
     * @param ids 需要删除的加工主键集合
     * @return 结果
     */
    public int deleteBalanceProcessByIds(Long[] ids);

    /**
     * 删除加工信息
     *
     * @param id 加工主键
     * @return 结果
     */
    public int deleteBalanceProcessById(Long id);

    BalanceProcess selectBalanceProcessByBalanceCode(String balanceCode);

    int saveOrUpdate(BalanceProcess balanceProcess);
}
