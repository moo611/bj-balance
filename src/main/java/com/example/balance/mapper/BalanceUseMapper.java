package com.example.balance.mapper;

import java.util.List;
import com.example.balance.domain.BalanceUse;
import org.apache.ibatis.annotations.Mapper;

/**
 * 使用信息Mapper接口
 *
 * @author ruoyi
 * @date 2025-02-08
 */

@Mapper
public interface BalanceUseMapper
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
     * 删除使用信息
     *
     * @param id 使用信息主键
     * @return 结果
     */
    public int deleteBalanceUseById(Long id);

    /**
     * 批量删除使用信息
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBalanceUseByIds(Long[] ids);

    BalanceUse selectBalanceUseByBalance(String balanceCode, Long outId);
}
