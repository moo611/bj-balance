package com.example.balance.service.impl;

import java.util.*;
import java.util.stream.Collectors;

import com.example.balance.config.auth.UserUtil;
import com.example.balance.domain.*;
import com.example.balance.domain.req.BalanceSelectReq;
import com.example.balance.mapper.*;
import com.example.balance.utils.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.balance.service.IBalanceInfoService;
import org.springframework.transaction.annotation.Transactional;

/**
 * 天平基本信息Service业务层处理
 *
 * @author ruoyi
 * @date 2025-02-05
 */
@Service
public class BalanceInfoServiceImpl implements IBalanceInfoService {
    @Autowired
    private BalanceInfoMapper balanceInfoMapper;

    @Autowired
    BalanceInRecordMapper balanceInRecordMapper;

    /**
     * 查询天平基本信息
     *
     * @param balanceCode 天平基本信息主键
     * @return 天平基本信息
     */
    @Override
    public BalanceInfo selectBalanceInfoByBalanceCode(String balanceCode) {
        return balanceInfoMapper.selectBalanceInfoByBalanceCode(balanceCode);
    }

    /**
     * 查询天平基本信息列表
     *
     * @param balanceInfo 天平基本信息
     * @return 天平基本信息
     */
    @Override
    public List<BalanceInfo> selectBalanceInfoList(BalanceInfo balanceInfo) {

        List<BalanceInfo>res = balanceInfoMapper.selectBalanceInfoList(balanceInfo);

        for (BalanceInfo b : res) {

            List<String>busList = balanceInRecordMapper.selectBusList(b.getBalanceCode());
            b.setBalanceTnum((long) busList.size());
        }


        return res;
    }

    /**
     * 新增天平基本信息
     *
     * @param balanceInfo 天平基本信息
     * @return 结果
     */
    @Override
    @Transactional
    public int insertBalanceInfo(BalanceInfo balanceInfo) {
        balanceInfo.setCreateTime(new Date());
        balanceInfo.setBalanceCode(UUIDUtil.get16UUID());
        balanceInfo.setCreateBy(UserUtil.getCurrentUsername());
        int rows = balanceInfoMapper.insertBalanceInfo(balanceInfo);

        //新增其他表
//        BalanceSize balanceSize = new BalanceSize();
//        balanceSize.setCreateTime(new Date());
//        balanceSize.setCreateBy(UserUtil.getCurrentUsername());
//        balanceSize.setBalanceCode(balanceInfo.getBalanceCode());
//        balanceSizeMapper.insertBalanceSize(balanceSize);
//
//        BalanceProcess balanceProcess = new BalanceProcess();
//        balanceProcess.setCreateTime(new Date());
//        balanceProcess.setCreateBy(UserUtil.getCurrentUsername());
//        balanceProcess.setBalanceCode(balanceInfo.getBalanceCode());
//        balanceProcessMapper.insertBalanceProcess(balanceProcess);
//
//        BalancePaster balancePaster = new BalancePaster();
//        balancePaster.setCreateTime(new Date());
//        balancePaster.setCreateBy(UserUtil.getCurrentUsername());
//        balancePaster.setBalanceCode(balanceInfo.getBalanceCode());
//        balancePasterMapper.insertBalancePaster(balancePaster);
//
//        BalanceSupport balanceSupport = new BalanceSupport();
//        balanceSupport.setCreateTime(new Date());
//        balanceSupport.setCreateBy(UserUtil.getCurrentUsername());
//        balanceSupport.setBalanceCode(balanceInfo.getBalanceCode());
//        balanceSupportMapper.insertBalanceSupport(balanceSupport);


        return rows;
    }

    /**
     * 修改天平基本信息
     *
     * @param balanceInfo 天平基本信息
     * @return 结果
     */
    @Override
    public int updateBalanceInfo(BalanceInfo balanceInfo) {
        balanceInfo.setUpdateTime(new Date());
        balanceInfo.setUpdateBy(UserUtil.getCurrentUsername());
        return balanceInfoMapper.updateBalanceInfo(balanceInfo);
    }

    /**
     * 批量删除天平基本信息
     *
     * @param balanceCodes 需要删除的天平基本信息主键
     * @return 结果
     */
    @Override
    public int deleteBalanceInfoByBalanceCodes(String[] balanceCodes) {
        return balanceInfoMapper.deleteBalanceInfoByBalanceCodes(balanceCodes);
    }

    /**
     * 删除天平基本信息信息
     *
     * @param balanceCode 天平基本信息主键
     * @return 结果
     */
    @Override
    public int deleteBalanceInfoByBalanceCode(String balanceCode) {
        return balanceInfoMapper.deleteBalanceInfoByBalanceCode(balanceCode);
    }

    @Override
    public List<BalanceInRecord> count(String balanceCode) {

        return balanceInRecordMapper.selectCount(balanceCode);

    }

    @Override
    public List<BalanceInfo> select(BalanceSelectReq balanceSelectReq) {


        List<BalanceInfoVO> balanceInfoVOS = balanceInfoMapper.selectBalanceInfoVOList();


        return balanceInfoVOS.stream().sorted(Comparator.comparingDouble(b -> b.getWeightedMatchScore(balanceSelectReq.getBalanceX(),
                balanceSelectReq.getBalanceY(), balanceSelectReq.getBalanceZ(), balanceSelectReq.getBalanceMx(), balanceSelectReq.getBalanceMy(), balanceSelectReq.getBalanceMz(), balanceSelectReq.getSizeX(), balanceSelectReq.getSizeY(), balanceSelectReq.getSizeZ())))
                .limit(balanceSelectReq.getTopN())
                .collect(Collectors.toList());

    }


}
