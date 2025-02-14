package com.example.balance.mapper;

import java.util.List;
import com.example.balance.domain.BalanceSize;
import org.apache.ibatis.annotations.Mapper;

/**
 * 尺寸Mapper接口
 *
 * @author ruoyi
 * @date 2025-02-05
 */
@Mapper
public interface BalanceSizeMapper
{
    /**
     * 查询尺寸
     *
     * @param id 尺寸主键
     * @return 尺寸
     */
    public BalanceSize selectBalanceSizeById(Long id);

    /**
     * 查询尺寸列表
     *
     * @param balanceSize 尺寸
     * @return 尺寸集合
     */
    public List<BalanceSize> selectBalanceSizeList(BalanceSize balanceSize);

    /**
     * 新增尺寸
     *
     * @param balanceSize 尺寸
     * @return 结果
     */
    public int insertBalanceSize(BalanceSize balanceSize);

    /**
     * 修改尺寸
     *
     * @param balanceSize 尺寸
     * @return 结果
     */
    public int updateBalanceSize(BalanceSize balanceSize);

    /**
     * 删除尺寸
     *
     * @param id 尺寸主键
     * @return 结果
     */
    public int deleteBalanceSizeById(Long id);

    /**
     * 批量删除尺寸
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBalanceSizeByIds(Long[] ids);

    BalanceSize selectBalanceSizeByBalanceCode(String balanceCode);

}
