package com.example.balance.service.impl;

import java.util.Date;
import java.util.List;

import com.example.balance.config.auth.UserUtil;
import com.example.balance.utils.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.balance.mapper.BalanceCalibrationMapper;
import com.example.balance.domain.BalanceCalibration;
import com.example.balance.service.IBalanceCalibrationService;

/**
 * 证书Service业务层处理
 *
 * @author ruoyi
 * @date 2025-02-06
 */
@Service
public class BalanceCalibrationServiceImpl implements IBalanceCalibrationService
{
    @Autowired
    private BalanceCalibrationMapper balanceCalibrationMapper;

    /**
     * 查询证书
     *
     * @param bcalibrationCode 证书主键
     * @return 证书
     */
    @Override
    public BalanceCalibration selectBalanceCalibrationByBcalibrationCode(String bcalibrationCode)
    {
        return balanceCalibrationMapper.selectBalanceCalibrationByBcalibrationCode(bcalibrationCode);
    }

    /**
     * 查询证书列表
     *
     * @param balanceCalibration 证书
     * @return 证书
     */
    @Override
    public List<BalanceCalibration> selectBalanceCalibrationList(BalanceCalibration balanceCalibration)
    {
        return balanceCalibrationMapper.selectBalanceCalibrationList(balanceCalibration);
    }

    /**
     * 新增证书
     *
     * @param balanceCalibration 证书
     * @return 结果
     */
    @Override
    public int insertBalanceCalibration(BalanceCalibration balanceCalibration)
    {
        balanceCalibration.setCreateTime(new Date());
        balanceCalibration.setCreateBy(UserUtil.getCurrentUsername());
        balanceCalibration.setBcalibrationCode(UUIDUtil.get16UUID());
        return balanceCalibrationMapper.insertBalanceCalibration(balanceCalibration);
    }

    /**
     * 修改证书
     *
     * @param balanceCalibration 证书
     * @return 结果
     */
    @Override
    public int updateBalanceCalibration(BalanceCalibration balanceCalibration)
    {
        balanceCalibration.setUpdateTime(new Date());
        balanceCalibration.setUpdateBy(UserUtil.getCurrentUsername());
        return balanceCalibrationMapper.updateBalanceCalibration(balanceCalibration);
    }

    /**
     * 批量删除证书
     *
     * @param bcalibrationCodes 需要删除的证书主键
     * @return 结果
     */
    @Override
    public int deleteBalanceCalibrationByBcalibrationCodes(String[] bcalibrationCodes)
    {
        return balanceCalibrationMapper.deleteBalanceCalibrationByBcalibrationCodes(bcalibrationCodes);
    }

    /**
     * 删除证书信息
     *
     * @param bcalibrationCode 证书主键
     * @return 结果
     */
    @Override
    public int deleteBalanceCalibrationByBcalibrationCode(String bcalibrationCode)
    {
        return balanceCalibrationMapper.deleteBalanceCalibrationByBcalibrationCode(bcalibrationCode);
    }

    @Override
    public BalanceCalibration selectBalanceCalibrationByBalanceCode(String balanceCode) {
        return balanceCalibrationMapper.selectBalanceCalibrationByBalanceCode(balanceCode);
    }
}
