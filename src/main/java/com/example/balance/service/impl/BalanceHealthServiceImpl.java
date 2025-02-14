package com.example.balance.service.impl;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import com.example.balance.config.auth.UserUtil;
import com.example.balance.domain.BalanceHealthVO;
import com.example.balance.domain.req.BalanceHealthListReq;
import com.example.balance.mapper.BalanceInRecordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.balance.mapper.BalanceHealthMapper;
import com.example.balance.domain.BalanceHealth;
import com.example.balance.service.IBalanceHealthService;

/**
 * 故障Service业务层处理
 *
 * @author ruoyi
 * @date 2025-02-09
 */
@Service
public class BalanceHealthServiceImpl implements IBalanceHealthService
{
    @Autowired
    private BalanceHealthMapper balanceHealthMapper;
    @Autowired
    private BalanceInRecordMapper balanceInRecordMapper;

    /**
     * 查询故障
     *
     * @param id 故障主键
     * @return 故障
     */
    @Override
    public BalanceHealth selectBalanceHealthById(Long id)
    {
        return balanceHealthMapper.selectBalanceHealthById(id);
    }

    /**
     * 查询故障列表
     *
     * @param balanceHealth 故障
     * @return 故障
     */
    @Override
    public List<BalanceHealth> selectBalanceHealthList(BalanceHealth balanceHealth)
    {
        return balanceHealthMapper.selectBalanceHealthList(balanceHealth);
    }

    /**
     * 新增故障
     *
     * @param balanceHealth 故障
     * @return 结果
     */
    @Override
    public int insertBalanceHealth(BalanceHealth balanceHealth)
    {
        balanceHealth.setCreateTime(new Date());
        balanceHealth.setCreateBy(UserUtil.getCurrentUsername());
        return balanceHealthMapper.insertBalanceHealth(balanceHealth);
    }

    /**
     * 修改故障
     *
     * @param balanceHealth 故障
     * @return 结果
     */
    @Override
    public int updateBalanceHealth(BalanceHealth balanceHealth)
    {
        balanceHealth.setUpdateTime(new Date());
        balanceHealth.setUpdateBy(UserUtil.getCurrentUsername());
        return balanceHealthMapper.updateBalanceHealth(balanceHealth);
    }

    /**
     * 批量删除故障
     *
     * @param ids 需要删除的故障主键
     * @return 结果
     */
    @Override
    public int deleteBalanceHealthByIds(Long[] ids)
    {
        return balanceHealthMapper.deleteBalanceHealthByIds(ids);
    }

    /**
     * 删除故障信息
     *
     * @param id 故障主键
     * @return 结果
     */
    @Override
    public int deleteBalanceHealthById(Long id)
    {
        return balanceHealthMapper.deleteBalanceHealthById(id);
    }

    @Override
    public BalanceHealth getInfoByBalance(String balanceCode, Long inId) {

        return balanceHealthMapper.getInfoByBalance(balanceCode,inId);

    }

    @Override
    public int saveOrUpdate(BalanceHealth balanceHealth) {

        if (balanceHealth.getId() == null){
            balanceHealth.setCreateTime(new Date());
            balanceHealth.setCreateBy(UserUtil.getCurrentUsername());
            return balanceHealthMapper.insertBalanceHealth(balanceHealth);
        }else {
            balanceHealth.setUpdateTime(new Date());
            balanceHealth.setUpdateBy(UserUtil.getCurrentUsername());
            return balanceHealthMapper.updateBalanceHealth(balanceHealth);
        }
    }

    @Override
    public List<BalanceHealthVO> selectLatest(BalanceHealthListReq balanceHealthListReq) {

        List<BalanceHealthVO>result = balanceHealthMapper.selectBalanceHealthLatest(balanceHealthListReq);

        for (BalanceHealthVO balanceHealthVO : result) {


            List<String>busList = balanceInRecordMapper.selectBusList(balanceHealthVO.getBalanceCode());
            StringBuilder sb = new StringBuilder();
            for (String busCode : busList) {
                sb.append(busCode).append(",");
            }
            if (sb.length() > 0) {
                sb.deleteCharAt(sb.length()-1);
            }

            balanceHealthVO.setHistory(sb.toString());

        }

        return result;
    }
}
