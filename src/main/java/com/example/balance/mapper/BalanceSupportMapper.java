package com.example.balance.mapper;

import java.util.List;
import com.example.balance.domain.BalanceSupport;
import org.apache.ibatis.annotations.Mapper;

/**
 * 支杆Mapper接口
 *
 * @author ruoyi
 * @date 2025-02-06
 */
@Mapper
public interface BalanceSupportMapper
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
     * 删除支杆
     *
     * @param id 支杆主键
     * @return 结果
     */
    public int deleteBalanceSupportById(Long id);

    /**
     * 批量删除支杆
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBalanceSupportByIds(Long[] ids);

    BalanceSupport selectBalanceSupportByBalanceCode(String balanceCode);

}
