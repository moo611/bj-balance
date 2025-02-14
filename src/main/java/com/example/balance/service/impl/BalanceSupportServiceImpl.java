package com.example.balance.service.impl;

import java.util.Date;
import java.util.List;

import com.example.balance.config.auth.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.balance.mapper.BalanceSupportMapper;
import com.example.balance.domain.BalanceSupport;
import com.example.balance.service.IBalanceSupportService;

/**
 * 支杆Service业务层处理
 *
 * @author ruoyi
 * @date 2025-02-06
 */
@Service
public class BalanceSupportServiceImpl implements IBalanceSupportService
{
    @Autowired
    private BalanceSupportMapper balanceSupportMapper;

    /**
     * 查询支杆
     *
     * @param id 支杆主键
     * @return 支杆
     */
    @Override
    public BalanceSupport selectBalanceSupportById(Long id)
    {
        return balanceSupportMapper.selectBalanceSupportById(id);
    }

    /**
     * 查询支杆列表
     *
     * @param balanceSupport 支杆
     * @return 支杆
     */
    @Override
    public List<BalanceSupport> selectBalanceSupportList(BalanceSupport balanceSupport)
    {
        return balanceSupportMapper.selectBalanceSupportList(balanceSupport);
    }

    /**
     * 新增支杆
     *
     * @param balanceSupport 支杆
     * @return 结果
     */
    @Override
    public int insertBalanceSupport(BalanceSupport balanceSupport)
    {
        balanceSupport.setCreateTime(new Date());
        balanceSupport.setCreateBy(UserUtil.getCurrentUsername());
        return balanceSupportMapper.insertBalanceSupport(balanceSupport);
    }

    /**
     * 修改支杆
     *
     * @param balanceSupport 支杆
     * @return 结果
     */
    @Override
    public int updateBalanceSupport(BalanceSupport balanceSupport)
    {
        balanceSupport.setUpdateTime(new Date());
        balanceSupport.setUpdateBy(UserUtil.getCurrentUsername());
        return balanceSupportMapper.updateBalanceSupport(balanceSupport);
    }

    /**
     * 批量删除支杆
     *
     * @param ids 需要删除的支杆主键
     * @return 结果
     */
    @Override
    public int deleteBalanceSupportByIds(Long[] ids)
    {
        return balanceSupportMapper.deleteBalanceSupportByIds(ids);
    }

    /**
     * 删除支杆信息
     *
     * @param id 支杆主键
     * @return 结果
     */
    @Override
    public int deleteBalanceSupportById(Long id)
    {
        return balanceSupportMapper.deleteBalanceSupportById(id);
    }

    @Override
    public BalanceSupport selectBalanceSupportByBalanceCode(String balanceCode) {


        return balanceSupportMapper.selectBalanceSupportByBalanceCode(balanceCode);
    }

    @Override
    public int saveOrUpdate(BalanceSupport balanceSupport) {
        if (balanceSupport.getId() == null){
            balanceSupport.setCreateTime(new Date());
            balanceSupport.setCreateBy(UserUtil.getCurrentUsername());
            return balanceSupportMapper.insertBalanceSupport(balanceSupport);
        }else{
            balanceSupport.setUpdateTime(new Date());
            balanceSupport.setUpdateBy(UserUtil.getCurrentUsername());
            return balanceSupportMapper.updateBalanceSupport(balanceSupport);
        }
    }
}
