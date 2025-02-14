package com.example.balance.mapper;

import java.util.List;
import com.example.balance.domain.BalanceInfo;
import com.example.balance.domain.BalanceInfoVO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 天平基本信息Mapper接口
 *
 * @author ruoyi
 * @date 2025-02-05
 */
@Mapper
public interface BalanceInfoMapper
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
     * 删除天平基本信息
     *
     * @param balanceCode 天平基本信息主键
     * @return 结果
     */
    public int deleteBalanceInfoByBalanceCode(String balanceCode);

    /**
     * 批量删除天平基本信息
     *
     * @param balanceCodes 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBalanceInfoByBalanceCodes(String[] balanceCodes);

    List<BalanceInfoVO> selectBalanceInfoVOList();

}
