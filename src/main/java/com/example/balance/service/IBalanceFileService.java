package com.example.balance.service;

import java.util.List;
import com.example.balance.domain.BalanceFile;

/**
 * 文件Service接口
 *
 * @author ruoyi
 * @date 2025-02-07
 */
public interface IBalanceFileService
{
    /**
     * 查询文件
     *
     * @param id 文件主键
     * @return 文件
     */
    public BalanceFile selectBalanceFileById(Long id);

    /**
     * 查询文件列表
     *
     * @param balanceFile 文件
     * @return 文件集合
     */
    public List<BalanceFile> selectBalanceFileList(BalanceFile balanceFile);

    /**
     * 新增文件
     *
     * @param balanceFile 文件
     * @return 结果
     */
    public int insertBalanceFile(BalanceFile balanceFile);

    /**
     * 修改文件
     *
     * @param balanceFile 文件
     * @return 结果
     */
    public int updateBalanceFile(BalanceFile balanceFile);

    /**
     * 批量删除文件
     *
     * @param ids 需要删除的文件主键集合
     * @return 结果
     */
    public int deleteBalanceFileByIds(Long[] ids);

    /**
     * 删除文件信息
     *
     * @param id 文件主键
     * @return 结果
     */
    public int deleteBalanceFileById(Long id);
}
