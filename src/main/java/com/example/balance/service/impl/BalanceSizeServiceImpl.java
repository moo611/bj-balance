package com.example.balance.service.impl;

import java.util.Date;
import java.util.List;

import com.example.balance.config.auth.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.balance.mapper.BalanceSizeMapper;
import com.example.balance.domain.BalanceSize;
import com.example.balance.service.IBalanceSizeService;

/**
 * 尺寸Service业务层处理
 *
 * @author ruoyi
 * @date 2025-02-05
 */
@Service
public class BalanceSizeServiceImpl implements IBalanceSizeService
{
    @Autowired
    private BalanceSizeMapper balanceSizeMapper;

    /**
     * 查询尺寸
     *
     * @param id 尺寸主键
     * @return 尺寸
     */
    @Override
    public BalanceSize selectBalanceSizeById(Long id)
    {
        return balanceSizeMapper.selectBalanceSizeById(id);
    }

    /**
     * 查询尺寸列表
     *
     * @param balanceSize 尺寸
     * @return 尺寸
     */
    @Override
    public List<BalanceSize> selectBalanceSizeList(BalanceSize balanceSize)
    {
        return balanceSizeMapper.selectBalanceSizeList(balanceSize);
    }

    /**
     * 新增尺寸
     *
     * @param balanceSize 尺寸
     * @return 结果
     */
    @Override
    public int insertBalanceSize(BalanceSize balanceSize)
    {
        balanceSize.setCreateTime(new Date());
        balanceSize.setCreateBy(UserUtil.getCurrentUsername());
        return balanceSizeMapper.insertBalanceSize(balanceSize);
    }

    /**
     * 修改尺寸
     *
     * @param balanceSize 尺寸
     * @return 结果
     */
    @Override
    public int updateBalanceSize(BalanceSize balanceSize)
    {
        balanceSize.setUpdateTime(new Date());
        balanceSize.setUpdateBy(UserUtil.getCurrentUsername());
        return balanceSizeMapper.updateBalanceSize(balanceSize);
    }

    /**
     * 批量删除尺寸
     *
     * @param ids 需要删除的尺寸主键
     * @return 结果
     */
    @Override
    public int deleteBalanceSizeByIds(Long[] ids)
    {
        return balanceSizeMapper.deleteBalanceSizeByIds(ids);
    }

    /**
     * 删除尺寸信息
     *
     * @param id 尺寸主键
     * @return 结果
     */
    @Override
    public int deleteBalanceSizeById(Long id)
    {
        return balanceSizeMapper.deleteBalanceSizeById(id);
    }

    @Override
    public BalanceSize selectBalanceSizeByBalanceCode(String balanceCode) {


        return balanceSizeMapper.selectBalanceSizeByBalanceCode(balanceCode);
    }

    @Override
    public int saveOrUpdate(BalanceSize balanceSize) {
        if (balanceSize.getId() == null) {
            balanceSize.setCreateTime(new Date());
            balanceSize.setCreateBy(UserUtil.getCurrentUsername());
            return balanceSizeMapper.insertBalanceSize(balanceSize);
        }else{
            balanceSize.setUpdateTime(new Date());
            balanceSize.setUpdateBy(UserUtil.getCurrentUsername());
            return balanceSizeMapper.updateBalanceSize(balanceSize);
        }

    }
}
