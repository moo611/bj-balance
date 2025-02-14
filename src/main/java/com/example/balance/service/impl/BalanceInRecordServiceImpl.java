package com.example.balance.service.impl;

import java.util.Date;
import java.util.List;

import com.example.balance.config.auth.UserUtil;
import com.example.balance.domain.BalanceInRecord;
import com.example.balance.domain.BalanceInfo;
import com.example.balance.domain.BalancePerformance;
import com.example.balance.mapper.BalanceInfoMapper;
import com.example.balance.mapper.BalanceOutRecordMapper;
import com.example.balance.mapper.BalancePerformanceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.balance.mapper.BalanceInRecordMapper;
import com.example.balance.domain.BalanceInRecord;
import com.example.balance.service.IBalanceInRecordService;
import org.springframework.transaction.annotation.Transactional;

/**
 * 入库Service业务层处理
 *
 * @author ruoyi
 * @date 2025-02-09
 */
@Service
public class BalanceInRecordServiceImpl implements IBalanceInRecordService
{
    @Autowired
    private BalanceInRecordMapper balanceInRecordMapper;
    @Autowired
    private BalancePerformanceMapper balancePerformanceMapper;
    @Autowired
    private BalanceOutRecordMapper balanceOutRecordMapper;
    @Autowired
    BalanceInfoMapper balanceInfoMapper;
    /**
     * 查询入库
     *
     * @param id 入库主键
     * @return 入库
     */
    @Override
    public BalanceInRecord selectBalanceInRecordById(Long id)
    {
        return balanceInRecordMapper.selectBalanceInRecordById(id);
    }

    /**
     * 查询入库列表
     *
     * @param balanceInRecord 入库
     * @return 入库
     */
    @Override
    public List<BalanceInRecord> selectBalanceInRecordList(BalanceInRecord balanceInRecord)
    {
        List<BalanceInRecord> result = balanceInRecordMapper.selectBalanceInRecordList(balanceInRecord);
        for (BalanceInRecord balanceInRecord1 : result) {

            String balanceCode = balanceInRecord1.getBalanceCode();
            Long id = balanceInRecord1.getId();

            BalancePerformance balancePerformance = balancePerformanceMapper.selectBalancePerformanceByBalance(balanceCode, null, id);
            balanceInRecord1.setHasChecked(balancePerformance != null);

        }
        return result;
    }

    /**
     * 新增入库
     *
     * @param balanceInRecord 入库
     * @return 结果
     */
    @Override
    @Transactional
    public int insertBalanceInRecord(BalanceInRecord balanceInRecord)
    {

//        int totalOut = balanceOutRecordMapper.countBalanceOutRecord(balanceInRecord.getBalanceCode());
//        int totalIn = balanceInRecordMapper.countBalanceInRecord(balanceInRecord.getBalanceCode());
        BalanceInfo balanceInfo = balanceInfoMapper.selectBalanceInfoByBalanceCode(balanceInRecord.getBalanceCode());
        if (balanceInfo.getStatus().equals("0")){
            return -32001;
        }

        balanceInfo.setStatus("0");
        balanceInfoMapper.updateBalanceInfo(balanceInfo);


        balanceInRecord.setCreateTime(new Date());
        balanceInRecord.setCreateBy(UserUtil.getCurrentUsername());
        balanceInRecord.setUpdateTime(new Date());
        return balanceInRecordMapper.insertBalanceInRecord(balanceInRecord);
    }

    /**
     * 修改入库
     *
     * @param balanceInRecord 入库
     * @return 结果
     */
    @Override
    public int updateBalanceInRecord(BalanceInRecord balanceInRecord)
    {
        balanceInRecord.setUpdateTime(new Date());
        balanceInRecord.setUpdateBy(UserUtil.getCurrentUsername());
        return balanceInRecordMapper.updateBalanceInRecord(balanceInRecord);
    }

    /**
     * 批量删除入库
     *
     * @param ids 需要删除的入库主键
     * @return 结果
     */
    @Override
    public int deleteBalanceInRecordByIds(Long[] ids)
    {
        return balanceInRecordMapper.deleteBalanceInRecordByIds(ids);
    }

    /**
     * 删除入库信息
     *
     * @param id 入库主键
     * @return 结果
     */
    @Override
    public int deleteBalanceInRecordById(Long id)
    {
        return balanceInRecordMapper.deleteBalanceInRecordById(id);
    }
}
