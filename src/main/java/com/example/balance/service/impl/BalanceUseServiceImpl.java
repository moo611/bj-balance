package com.example.balance.service.impl;

import java.util.Date;
import java.util.List;

import com.example.balance.config.auth.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.balance.mapper.BalanceUseMapper;
import com.example.balance.domain.BalanceUse;
import com.example.balance.service.IBalanceUseService;

/**
 * 使用信息Service业务层处理
 *
 * @author ruoyi
 * @date 2025-02-08
 */
@Service
public class BalanceUseServiceImpl implements IBalanceUseService
{
    @Autowired
    private BalanceUseMapper balanceUseMapper;

    /**
     * 查询使用信息
     *
     * @param id 使用信息主键
     * @return 使用信息
     */
    @Override
    public BalanceUse selectBalanceUseById(Long id)
    {
        return balanceUseMapper.selectBalanceUseById(id);
    }

    /**
     * 查询使用信息列表
     *
     * @param balanceUse 使用信息
     * @return 使用信息
     */
    @Override
    public List<BalanceUse> selectBalanceUseList(BalanceUse balanceUse)
    {
        return balanceUseMapper.selectBalanceUseList(balanceUse);
    }

    /**
     * 新增使用信息
     *
     * @param balanceUse 使用信息
     * @return 结果
     */
    @Override
    public int insertBalanceUse(BalanceUse balanceUse)
    {
        balanceUse.setCreateTime(new Date());
        balanceUse.setCreateBy(UserUtil.getCurrentUsername());
        return balanceUseMapper.insertBalanceUse(balanceUse);
    }

    /**
     * 修改使用信息
     *
     * @param balanceUse 使用信息
     * @return 结果
     */
    @Override
    public int updateBalanceUse(BalanceUse balanceUse)
    {
        balanceUse.setUpdateTime(new Date());
        balanceUse.setUpdateBy(UserUtil.getCurrentUsername());
        return balanceUseMapper.updateBalanceUse(balanceUse);
    }

    /**
     * 批量删除使用信息
     *
     * @param ids 需要删除的使用信息主键
     * @return 结果
     */
    @Override
    public int deleteBalanceUseByIds(Long[] ids)
    {
        return balanceUseMapper.deleteBalanceUseByIds(ids);
    }

    /**
     * 删除使用信息信息
     *
     * @param id 使用信息主键
     * @return 结果
     */
    @Override
    public int deleteBalanceUseById(Long id)
    {
        return balanceUseMapper.deleteBalanceUseById(id);
    }

    @Override
    public BalanceUse getInfoByBalance(String balanceCode, Long outId) {
        return balanceUseMapper.selectBalanceUseByBalance(balanceCode,outId);
    }

    @Override
    public int saveOrUpdate(BalanceUse balanceUse) {
        if (balanceUse.getId() == null){
            balanceUse.setCreateTime(new Date());
            balanceUse.setCreateBy(UserUtil.getCurrentUsername());
            return balanceUseMapper.insertBalanceUse(balanceUse);
        }else{
            balanceUse.setUpdateTime(new Date());
            balanceUse.setUpdateBy(UserUtil.getCurrentUsername());
            return balanceUseMapper.updateBalanceUse(balanceUse);
        }
    }
}
