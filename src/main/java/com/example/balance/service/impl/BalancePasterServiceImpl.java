package com.example.balance.service.impl;

import java.util.Date;
import java.util.List;

import com.example.balance.config.auth.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.balance.mapper.BalancePasterMapper;
import com.example.balance.domain.BalancePaster;
import com.example.balance.service.IBalancePasterService;

/**
 * 贴片信息Service业务层处理
 *
 * @author ruoyi
 * @date 2025-02-05
 */
@Service
public class BalancePasterServiceImpl implements IBalancePasterService
{
    @Autowired
    private BalancePasterMapper balancePasterMapper;

    /**
     * 查询贴片信息
     *
     * @param id 贴片信息主键
     * @return 贴片信息
     */
    @Override
    public BalancePaster selectBalancePasterById(Long id)
    {
        return balancePasterMapper.selectBalancePasterById(id);
    }

    /**
     * 查询贴片信息列表
     *
     * @param balancePaster 贴片信息
     * @return 贴片信息
     */
    @Override
    public List<BalancePaster> selectBalancePasterList(BalancePaster balancePaster)
    {
        return balancePasterMapper.selectBalancePasterList(balancePaster);
    }

    /**
     * 新增贴片信息
     *
     * @param balancePaster 贴片信息
     * @return 结果
     */
    @Override
    public int insertBalancePaster(BalancePaster balancePaster)
    {
        balancePaster.setCreateTime(new Date());
        balancePaster.setCreateBy(UserUtil.getCurrentUsername());
        return balancePasterMapper.insertBalancePaster(balancePaster);
    }

    /**
     * 修改贴片信息
     *
     * @param balancePaster 贴片信息
     * @return 结果
     */
    @Override
    public int updateBalancePaster(BalancePaster balancePaster)
    {
        balancePaster.setUpdateTime(new Date());
        balancePaster.setUpdateBy(UserUtil.getCurrentUsername());
        return balancePasterMapper.updateBalancePaster(balancePaster);
    }

    /**
     * 批量删除贴片信息
     *
     * @param ids 需要删除的贴片信息主键
     * @return 结果
     */
    @Override
    public int deleteBalancePasterByIds(Long[] ids)
    {
        return balancePasterMapper.deleteBalancePasterByIds(ids);
    }

    /**
     * 删除贴片信息信息
     *
     * @param id 贴片信息主键
     * @return 结果
     */
    @Override
    public int deleteBalancePasterById(Long id)
    {
        return balancePasterMapper.deleteBalancePasterById(id);
    }

    @Override
    public BalancePaster selectBalancePasterByBalanceCode(String balanceCode) {
        return balancePasterMapper.selectBalancePasterByBalanceCode(balanceCode);
    }
}
