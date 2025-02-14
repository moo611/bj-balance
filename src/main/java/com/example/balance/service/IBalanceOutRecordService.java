package com.example.balance.service;

import java.util.List;
import com.example.balance.domain.BalanceOutRecord;

/**
 * 天平出库记录Service接口
 *
 * @author ruoyi
 * @date 2025-02-08
 */
public interface IBalanceOutRecordService
{
    /**
     * 查询天平出库记录
     *
     * @param id 天平出库记录主键
     * @return 天平出库记录
     */
    public BalanceOutRecord selectBalanceOutRecordById(Long id);

    /**
     * 查询天平出库记录列表
     *
     * @param balanceOutRecord 天平出库记录
     * @return 天平出库记录集合
     */
    public List<BalanceOutRecord> selectBalanceOutRecordList(BalanceOutRecord balanceOutRecord);

    /**
     * 新增天平出库记录
     *
     * @param balanceOutRecord 天平出库记录
     * @return 结果
     */
    public int insertBalanceOutRecord(BalanceOutRecord balanceOutRecord);

    /**
     * 修改天平出库记录
     *
     * @param balanceOutRecord 天平出库记录
     * @return 结果
     */
    public int updateBalanceOutRecord(BalanceOutRecord balanceOutRecord);

    /**
     * 批量删除天平出库记录
     *
     * @param ids 需要删除的天平出库记录主键集合
     * @return 结果
     */
    public int deleteBalanceOutRecordByIds(Long[] ids);

    /**
     * 删除天平出库记录信息
     *
     * @param id 天平出库记录主键
     * @return 结果
     */
    public int deleteBalanceOutRecordById(Long id);
}
