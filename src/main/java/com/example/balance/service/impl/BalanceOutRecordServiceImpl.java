package com.example.balance.service.impl;

import java.util.Date;
import java.util.List;

import com.example.balance.config.auth.UserUtil;
import com.example.balance.domain.BalanceInfo;
import com.example.balance.domain.BalancePerformance;
import com.example.balance.mapper.BalanceInRecordMapper;
import com.example.balance.mapper.BalanceInfoMapper;
import com.example.balance.mapper.BalancePerformanceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.balance.mapper.BalanceOutRecordMapper;
import com.example.balance.domain.BalanceOutRecord;
import com.example.balance.service.IBalanceOutRecordService;
import org.springframework.transaction.annotation.Transactional;

/**
 * 天平出库记录Service业务层处理
 *
 * @author ruoyi
 * @date 2025-02-08
 */
@Service
public class BalanceOutRecordServiceImpl implements IBalanceOutRecordService {
    @Autowired
    private BalanceOutRecordMapper balanceOutRecordMapper;
    @Autowired
    private BalanceInRecordMapper balanceInRecordMapper;
    @Autowired
    private BalancePerformanceMapper balancePerformanceMapper;
    @Autowired
    BalanceInfoMapper balanceInfoMapper;
    /**
     * 查询天平出库记录
     *
     * @param id 天平出库记录主键
     * @return 天平出库记录
     */
    @Override
    public BalanceOutRecord selectBalanceOutRecordById(Long id) {
        return balanceOutRecordMapper.selectBalanceOutRecordById(id);
    }

    /**
     * 查询天平出库记录列表
     *
     * @param balanceOutRecord 天平出库记录
     * @return 天平出库记录
     */
    @Override
    public List<BalanceOutRecord> selectBalanceOutRecordList(BalanceOutRecord balanceOutRecord) {

        List<BalanceOutRecord> result = balanceOutRecordMapper.selectBalanceOutRecordList(balanceOutRecord);
        for (BalanceOutRecord balanceOutRecord1 : result) {

            String balanceCode = balanceOutRecord1.getBalanceCode();
            Long id = balanceOutRecord1.getId();

            BalancePerformance balancePerformance = balancePerformanceMapper.selectBalancePerformanceByBalance(balanceCode, id, null);
            balanceOutRecord1.setHasChecked(balancePerformance != null);

        }
        return result;
    }

    /**
     * 新增天平出库记录
     *
     * @param balanceOutRecord 天平出库记录
     * @return 结果
     */
    @Override
    @Transactional
    public int insertBalanceOutRecord(BalanceOutRecord balanceOutRecord) {

        BalanceInfo balanceInfo = balanceInfoMapper.selectBalanceInfoByBalanceCode(balanceOutRecord.getBalanceCode());

        if (balanceInfo.getStatus().equals("1")){
            return -32001;
        }

        balanceInfo.setStatus("1");
        balanceInfoMapper.updateBalanceInfo(balanceInfo);

        balanceOutRecord.setCreateTime(new Date());
        balanceOutRecord.setCreateBy(UserUtil.getCurrentUsername());
        return balanceOutRecordMapper.insertBalanceOutRecord(balanceOutRecord);
    }

    /**
     * 修改天平出库记录
     *
     * @param balanceOutRecord 天平出库记录
     * @return 结果
     */
    @Override
    public int updateBalanceOutRecord(BalanceOutRecord balanceOutRecord) {
        balanceOutRecord.setUpdateTime(new Date());
        balanceOutRecord.setUpdateBy(UserUtil.getCurrentUsername());
        return balanceOutRecordMapper.updateBalanceOutRecord(balanceOutRecord);
    }

    /**
     * 批量删除天平出库记录
     *
     * @param ids 需要删除的天平出库记录主键
     * @return 结果
     */
    @Override
    public int deleteBalanceOutRecordByIds(Long[] ids) {
        return balanceOutRecordMapper.deleteBalanceOutRecordByIds(ids);
    }

    /**
     * 删除天平出库记录信息
     *
     * @param id 天平出库记录主键
     * @return 结果
     */
    @Override
    public int deleteBalanceOutRecordById(Long id) {
        return balanceOutRecordMapper.deleteBalanceOutRecordById(id);
    }
}
