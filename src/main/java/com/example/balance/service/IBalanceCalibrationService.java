package com.example.balance.service;

import java.util.List;
import com.example.balance.domain.BalanceCalibration;

/**
 * 证书Service接口
 *
 * @author ruoyi
 * @date 2025-02-06
 */
public interface IBalanceCalibrationService
{
    /**
     * 查询证书
     *
     * @param bcalibrationCode 证书主键
     * @return 证书
     */
    public BalanceCalibration selectBalanceCalibrationByBcalibrationCode(String bcalibrationCode);

    /**
     * 查询证书列表
     *
     * @param balanceCalibration 证书
     * @return 证书集合
     */
    public List<BalanceCalibration> selectBalanceCalibrationList(BalanceCalibration balanceCalibration);

    /**
     * 新增证书
     *
     * @param balanceCalibration 证书
     * @return 结果
     */
    public int insertBalanceCalibration(BalanceCalibration balanceCalibration);

    /**
     * 修改证书
     *
     * @param balanceCalibration 证书
     * @return 结果
     */
    public int updateBalanceCalibration(BalanceCalibration balanceCalibration);

    /**
     * 批量删除证书
     *
     * @param bcalibrationCodes 需要删除的证书主键集合
     * @return 结果
     */
    public int deleteBalanceCalibrationByBcalibrationCodes(String[] bcalibrationCodes);

    /**
     * 删除证书信息
     *
     * @param bcalibrationCode 证书主键
     * @return 结果
     */
    public int deleteBalanceCalibrationByBcalibrationCode(String bcalibrationCode);

    BalanceCalibration selectBalanceCalibrationByBalanceCode(String balanceCode);
}
