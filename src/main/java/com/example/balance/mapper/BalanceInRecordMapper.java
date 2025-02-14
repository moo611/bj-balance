package com.example.balance.mapper;

import java.util.List;
import com.example.balance.domain.BalanceInRecord;
import org.apache.ibatis.annotations.Mapper;

/**
 * 入库Mapper接口
 *
 * @author ruoyi
 * @date 2025-02-09
 */
@Mapper
public interface BalanceInRecordMapper
{
    /**
     * 查询入库
     *
     * @param id 入库主键
     * @return 入库
     */
    public BalanceInRecord selectBalanceInRecordById(Long id);

    /**
     * 查询入库列表
     *
     * @param balanceInRecord 入库
     * @return 入库集合
     */
    public List<BalanceInRecord> selectBalanceInRecordList(BalanceInRecord balanceInRecord);

    /**
     * 新增入库
     *
     * @param balanceInRecord 入库
     * @return 结果
     */
    public int insertBalanceInRecord(BalanceInRecord balanceInRecord);

    /**
     * 修改入库
     *
     * @param balanceInRecord 入库
     * @return 结果
     */
    public int updateBalanceInRecord(BalanceInRecord balanceInRecord);

    /**
     * 删除入库
     *
     * @param id 入库主键
     * @return 结果
     */
    public int deleteBalanceInRecordById(Long id);

    /**
     * 批量删除入库
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBalanceInRecordByIds(Long[] ids);

    List<String> selectBusList(String balanceCode);

    int countBalanceInRecord(String balanceCode);

    List<BalanceInRecord>selectCount(String balanceCode);

}
