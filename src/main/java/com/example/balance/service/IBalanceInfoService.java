package com.example.balance.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.balance.domain.BalanceInRecord;
import com.example.balance.domain.BalanceInfo;
import com.example.balance.domain.req.BalanceSelectReq;

/**
 * 天平基本信息Service接口
 *
 * @author ruoyi
 * @date 2025-02-05
 */
public interface IBalanceInfoService
{
    /**
     * 查询天平基本信息
     *
     * @param balanceCode 天平基本信息主键
     * @return 天平基本信息
     */
    public BalanceInfo selectBalanceInfoByBalanceCode(String balanceCode);

    /**
     * 查询天平基本信息列表
     *
     * @param balanceInfo 天平基本信息
     * @return 天平基本信息集合
     */
    public List<BalanceInfo> selectBalanceInfoList(BalanceInfo balanceInfo);

    /**
     * 新增天平基本信息
     *
     * @param balanceInfo 天平基本信息
     * @return 结果
     */
    public int insertBalanceInfo(BalanceInfo balanceInfo);

    /**
     * 修改天平基本信息
     *
     * @param balanceInfo 天平基本信息
     * @return 结果
     */
    public int updateBalanceInfo(BalanceInfo balanceInfo);

    /**
     * 批量删除天平基本信息
     *
     * @param balanceCodes 需要删除的天平基本信息主键集合
     * @return 结果
     */
    public int deleteBalanceInfoByBalanceCodes(String[] balanceCodes);

    /**
     * 删除天平基本信息信息
     *
     * @param balanceCode 天平基本信息主键
     * @return 结果
     */
    public int deleteBalanceInfoByBalanceCode(String balanceCode);

   List<BalanceInRecord> count(String balanceCode);

    List<BalanceInfo> select(BalanceSelectReq balanceSelectReq);

}
