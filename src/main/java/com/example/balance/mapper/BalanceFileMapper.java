package com.example.balance.mapper;

import java.util.List;
import com.example.balance.domain.BalanceFile;
import org.apache.ibatis.annotations.Mapper;

/**
 * 文件Mapper接口
 *
 * @author ruoyi
 * @date 2025-02-07
 */
@Mapper
public interface BalanceFileMapper
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
     * 删除文件
     *
     * @param id 文件主键
     * @return 结果
     */
    public int deleteBalanceFileById(Long id);

    /**
     * 批量删除文件
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBalanceFileByIds(Long[] ids);
}
