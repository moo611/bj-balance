package com.example.balance.service.impl;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import com.example.balance.config.auth.UserUtil;
import com.example.balance.domain.req.BalancePerformanceListReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.balance.mapper.BalancePerformanceMapper;
import com.example.balance.domain.BalancePerformance;
import com.example.balance.service.IBalancePerformanceService;

/**
 * 性能检查Service业务层处理
 *
 * @author ruoyi
 * @date 2025-02-08
 */
@Service
public class BalancePerformanceServiceImpl implements IBalancePerformanceService
{
    @Autowired
    private BalancePerformanceMapper balancePerformanceMapper;

    /**
     * 查询性能检查
     *
     * @param id 性能检查主键
     * @return 性能检查
     */
    @Override
    public BalancePerformance selectBalancePerformanceById(Long id)
    {
        return balancePerformanceMapper.selectBalancePerformanceById(id);
    }

    /**
     * 查询性能检查列表
     *
     * @param balancePerformance 性能检查
     * @return 性能检查
     */
    @Override
    public List<BalancePerformance> selectBalancePerformanceList(BalancePerformance balancePerformance)
    {
        return balancePerformanceMapper.selectBalancePerformanceList(balancePerformance);
    }

    /**
     * 新增性能检查
     *
     * @param balancePerformance 性能检查
     * @return 结果
     */
    @Override
    public int insertBalancePerformance(BalancePerformance balancePerformance)
    {
        balancePerformance.setCreateTime(new Date());
        balancePerformance.setCreateBy(UserUtil.getCurrentUsername());
        return balancePerformanceMapper.insertBalancePerformance(balancePerformance);
    }

    /**
     * 修改性能检查
     *
     * @param balancePerformance 性能检查
     * @return 结果
     */
    @Override
    public int updateBalancePerformance(BalancePerformance balancePerformance)
    {
        balancePerformance.setUpdateTime(new Date());
        balancePerformance.setUpdateBy(UserUtil.getCurrentUsername());
        return balancePerformanceMapper.updateBalancePerformance(balancePerformance);
    }

    /**
     * 批量删除性能检查
     *
     * @param ids 需要删除的性能检查主键
     * @return 结果
     */
    @Override
    public int deleteBalancePerformanceByIds(Long[] ids)
    {
        return balancePerformanceMapper.deleteBalancePerformanceByIds(ids);
    }

    /**
     * 删除性能检查信息
     *
     * @param id 性能检查主键
     * @return 结果
     */
    @Override
    public int deleteBalancePerformanceById(Long id)
    {
        return balancePerformanceMapper.deleteBalancePerformanceById(id);
    }

    @Override
    public BalancePerformance getInfoByBalance(String balanceCode, Long outId,Long inId) {
        return balancePerformanceMapper.selectBalancePerformanceByBalance(balanceCode,outId,inId);
    }

    @Override
    public int saveOrUpdate(BalancePerformance balancePerformance) {
        if (balancePerformance.getId() == null){
            balancePerformance.setCreateTime(new Date());
            //balancePerformance.setUpdateTime(new Date());
            balancePerformance.setCreateBy(UserUtil.getCurrentUsername());

            return balancePerformanceMapper.insertBalancePerformance(balancePerformance);
        }else{
            balancePerformance.setUpdateTime(new Date());
            balancePerformance.setUpdateBy(UserUtil.getCurrentUsername());
            return balancePerformanceMapper.updateBalancePerformance(balancePerformance);
        }

    }

    @Override
    public List<BalancePerformance> selectLatest(BalancePerformanceListReq balancePerformanceListReq) {

        return balancePerformanceMapper.selectLatestPerformanceList(balancePerformanceListReq);
    }
}
