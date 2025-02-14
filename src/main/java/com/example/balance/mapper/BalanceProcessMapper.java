package com.example.balance.mapper;

import java.util.List;
import com.example.balance.domain.BalanceProcess;
import org.apache.ibatis.annotations.Mapper;

/**
 * 加工Mapper接口
 *
 * @author ruoyi
 * @date 2025-02-05
 */
@Mapper
public interface BalanceProcessMapper
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
     * 删除加工
     *
     * @param id 加工主键
     * @return 结果
     */
    public int deleteBalanceProcessById(Long id);

    /**
     * 批量删除加工
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBalanceProcessByIds(Long[] ids);

    BalanceProcess selectBalanceProcessByBalanceCode(String balanceCode);


}
