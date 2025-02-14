package com.example.balance.service.impl;

import java.util.Date;
import java.util.List;

import com.example.balance.config.auth.UserUtil;
import com.example.balance.domain.BalanceSize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.balance.mapper.BalanceProcessMapper;
import com.example.balance.domain.BalanceProcess;
import com.example.balance.service.IBalanceProcessService;

/**
 * 加工Service业务层处理
 *
 * @author ruoyi
 * @date 2025-02-05
 */
@Service
public class BalanceProcessServiceImpl implements IBalanceProcessService
{
    @Autowired
    private BalanceProcessMapper balanceProcessMapper;

    /**
     * 查询加工
     *
     * @param id 加工主键
     * @return 加工
     */
    @Override
    public BalanceProcess selectBalanceProcessById(Long id)
    {
        return balanceProcessMapper.selectBalanceProcessById(id);
    }

    /**
     * 查询加工列表
     *
     * @param balanceProcess 加工
     * @return 加工
     */
    @Override
    public List<BalanceProcess> selectBalanceProcessList(BalanceProcess balanceProcess)
    {
        return balanceProcessMapper.selectBalanceProcessList(balanceProcess);
    }

    /**
     * 新增加工
     *
     * @param balanceProcess 加工
     * @return 结果
     */
    @Override
    public int insertBalanceProcess(BalanceProcess balanceProcess)
    {
        balanceProcess.setCreateTime(new Date());
        balanceProcess.setCreateBy(UserUtil.getCurrentUsername());
        return balanceProcessMapper.insertBalanceProcess(balanceProcess);
    }

    /**
     * 修改加工
     *
     * @param balanceProcess 加工
     * @return 结果
     */
    @Override
    public int updateBalanceProcess(BalanceProcess balanceProcess)
    {
        balanceProcess.setUpdateTime(new Date());
        balanceProcess.setUpdateBy(UserUtil.getCurrentUsername());
        return balanceProcessMapper.updateBalanceProcess(balanceProcess);
    }

    /**
     * 批量删除加工
     *
     * @param ids 需要删除的加工主键
     * @return 结果
     */
    @Override
    public int deleteBalanceProcessByIds(Long[] ids)
    {
        return balanceProcessMapper.deleteBalanceProcessByIds(ids);
    }

    /**
     * 删除加工信息
     *
     * @param id 加工主键
     * @return 结果
     */
    @Override
    public int deleteBalanceProcessById(Long id)
    {
        return balanceProcessMapper.deleteBalanceProcessById(id);
    }

    @Override
    public BalanceProcess selectBalanceProcessByBalanceCode(String balanceCode) {

        return balanceProcessMapper.selectBalanceProcessByBalanceCode(balanceCode);
    }

    @Override
    public int saveOrUpdate(BalanceProcess balanceProcess) {
        if (balanceProcess.getId() == null) {
            balanceProcess.setCreateTime(new Date());
            balanceProcess.setCreateBy(UserUtil.getCurrentUsername());
            return balanceProcessMapper.insertBalanceProcess(balanceProcess);
        }else{
            balanceProcess.setUpdateTime(new Date());
            balanceProcess.setUpdateBy(UserUtil.getCurrentUsername());
            return balanceProcessMapper.updateBalanceProcess(balanceProcess);
        }
    }
}
