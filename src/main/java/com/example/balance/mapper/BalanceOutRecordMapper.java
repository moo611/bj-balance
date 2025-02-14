package com.example.balance.mapper;

import java.util.List;
import com.example.balance.domain.BalanceOutRecord;
import org.apache.ibatis.annotations.Mapper;

/**
 * 天平出库记录Mapper接口
 *
 * @author ruoyi
 * @date 2025-02-08
 */
@Mapper
public interface BalanceOutRecordMapper
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
     * 删除天平出库记录
     *
     * @param id 天平出库记录主键
     * @return 结果
     */
    public int deleteBalanceOutRecordById(Long id);

    /**
     * 批量删除天平出库记录
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBalanceOutRecordByIds(Long[] ids);


    public int countBalanceOutRecord(String balanceCode);


}
