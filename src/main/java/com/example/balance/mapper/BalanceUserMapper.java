package com.example.balance.mapper;

import com.example.balance.domain.BalanceUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 用户Mapper接口
 *
 * 
 * @date 2024-10-19
 */
@Mapper
public interface BalanceUserMapper
{
    /**
     * 查询用户
     *
     * @param id 用户主键
     * @return 用户
     */
    public BalanceUser selectBalanceUserById(Long id);

    /**
     * 查询用户列表
     *
     * @param sptUser 用户
     * @return 用户集合
     */
    public List<BalanceUser> selectBalanceUserList(BalanceUser sptUser);

    /**
     * 新增用户
     *
     * @param sptUser 用户
     * @return 结果
     */
    public int insertBalanceUser(BalanceUser sptUser);

    /**
     * 修改用户
     *
     * @param sptUser 用户
     * @return 结果
     */
    public int updateBalanceUser(BalanceUser sptUser);

    /**
     * 删除用户
     *
     * @param id 用户主键
     * @return 结果
     */
    public int deleteBalanceUserById(Long id);

    /**
     * 批量删除用户
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBalanceUserByIds(Long[] ids);

    BalanceUser selectBalanceUserByUsername(String username);

}
