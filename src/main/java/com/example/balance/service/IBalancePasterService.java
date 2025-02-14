package com.example.balance.service;

import java.util.List;
import com.example.balance.domain.BalancePaster;

/**
 * 贴片信息Service接口
 *
 * @author ruoyi
 * @date 2025-02-05
 */
public interface IBalancePasterService
{
    /**
     * 查询贴片信息
     *
     * @param id 贴片信息主键
     * @return 贴片信息
     */
    public BalancePaster selectBalancePasterById(Long id);

    /**
     * 查询贴片信息列表
     *
     * @param balancePaster 贴片信息
     * @return 贴片信息集合
     */
    public List<BalancePaster> selectBalancePasterList(BalancePaster balancePaster);

    /**
     * 新增贴片信息
     *
     * @param balancePaster 贴片信息
     * @return 结果
     */
    public int insertBalancePaster(BalancePaster balancePaster);

    /**
     * 修改贴片信息
     *
     * @param balancePaster 贴片信息
     * @return 结果
     */
    public int updateBalancePaster(BalancePaster balancePaster);

    /**
     * 批量删除贴片信息
     *
     * @param ids 需要删除的贴片信息主键集合
     * @return 结果
     */
    public int deleteBalancePasterByIds(Long[] ids);

    /**
     * 删除贴片信息信息
     *
     * @param id 贴片信息主键
     * @return 结果
     */
    public int deleteBalancePasterById(Long id);

    BalancePaster selectBalancePasterByBalanceCode(String balanceCode);
}
