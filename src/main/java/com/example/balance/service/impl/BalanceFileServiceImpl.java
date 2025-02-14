package com.example.balance.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.balance.mapper.BalanceFileMapper;
import com.example.balance.domain.BalanceFile;
import com.example.balance.service.IBalanceFileService;

/**
 * 文件Service业务层处理
 *
 * @author ruoyi
 * @date 2025-02-07
 */
@Service
public class BalanceFileServiceImpl implements IBalanceFileService
{
    @Autowired
    private BalanceFileMapper balanceFileMapper;

    /**
     * 查询文件
     *
     * @param id 文件主键
     * @return 文件
     */
    @Override
    public BalanceFile selectBalanceFileById(Long id)
    {
        return balanceFileMapper.selectBalanceFileById(id);
    }

    /**
     * 查询文件列表
     *
     * @param balanceFile 文件
     * @return 文件
     */
    @Override
    public List<BalanceFile> selectBalanceFileList(BalanceFile balanceFile)
    {
        return balanceFileMapper.selectBalanceFileList(balanceFile);
    }

    /**
     * 新增文件
     *
     * @param balanceFile 文件
     * @return 结果
     */
    @Override
    public int insertBalanceFile(BalanceFile balanceFile)
    {
        balanceFile.setCreateTime(new Date());
        return balanceFileMapper.insertBalanceFile(balanceFile);
    }

    /**
     * 修改文件
     *
     * @param balanceFile 文件
     * @return 结果
     */
    @Override
    public int updateBalanceFile(BalanceFile balanceFile)
    {
        balanceFile.setUpdateTime(new Date());
        return balanceFileMapper.updateBalanceFile(balanceFile);
    }

    /**
     * 批量删除文件
     *
     * @param ids 需要删除的文件主键
     * @return 结果
     */
    @Override
    public int deleteBalanceFileByIds(Long[] ids)
    {
        return balanceFileMapper.deleteBalanceFileByIds(ids);
    }

    /**
     * 删除文件信息
     *
     * @param id 文件主键
     * @return 结果
     */
    @Override
    public int deleteBalanceFileById(Long id)
    {
        return balanceFileMapper.deleteBalanceFileById(id);
    }
}
