package com.example.balance.mapper;

import java.util.List;
import com.example.balance.domain.BalanceHealth;
import com.example.balance.domain.BalanceHealthVO;
import com.example.balance.domain.req.BalanceHealthListReq;
import org.apache.ibatis.annotations.Mapper;

/**
 * 故障Mapper接口
 *
 * @author ruoyi
 * @date 2025-02-09
 */
@Mapper
public interface BalanceHealthMapper
{
    /**
     * 查询故障
     *
     * @param id 故障主键
     * @return 故障
     */
    public BalanceHealth selectBalanceHealthById(Long id);

    /**
     * 查询故障列表
     *
     * @param balanceHealth 故障
     * @return 故障集合
     */
    public List<BalanceHealth> selectBalanceHealthList(BalanceHealth balanceHealth);

    /**
     * 新增故障
     *
     * @param balanceHealth 故障
     * @return 结果
     */
    public int insertBalanceHealth(BalanceHealth balanceHealth);

    /**
     * 修改故障
     *
     * @param balanceHealth 故障
     * @return 结果
     */
    public int updateBalanceHealth(BalanceHealth balanceHealth);

    /**
     * 删除故障
     *
     * @param id 故障主键
     * @return 结果
     */
    public int deleteBalanceHealthById(Long id);

    /**
     * 批量删除故障
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBalanceHealthByIds(Long[] ids);

    BalanceHealth getInfoByBalance(String balanceCode, Long inId);

    List<BalanceHealthVO> selectBalanceHealthLatest(BalanceHealthListReq balanceHealthListReq);



}
