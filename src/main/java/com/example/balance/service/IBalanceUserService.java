package com.example.balance.service;

import com.example.balance.domain.BalanceUser;

import java.util.List;

/**
 * 用户Service接口
 *
 * 
 * @date 2024-10-19
 */
public interface IBalanceUserService
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
     * @param balanceUser 用户
     * @return 用户集合
     */
    public List<BalanceUser> selectBalanceUserList(BalanceUser balanceUser);

    /**
     * 新增用户
     *
     * @param balanceUser 用户
     * @return 结果
     */
    public int insertBalanceUser(BalanceUser balanceUser);

    /**
     * 修改用户
     *
     * @param balanceUser 用户
     * @return 结果
     */
    public int updateBalanceUser(BalanceUser balanceUser);

    /**
     * 批量删除用户
     *
     * @param ids 需要删除的用户主键集合
     * @return 结果
     */
    public int deleteBalanceUserByIds(Long[] ids);

    /**
     * 删除用户信息
     *
     * @param id 用户主键
     * @return 结果
     */
    public int deleteBalanceUserById(Long id);

    BalanceUser selectRtUserByUsername(String username);
}
