package com.example.balance.service.impl;

import com.example.balance.domain.BalanceUser;
import com.example.balance.mapper.BalanceUserMapper;
import com.example.balance.service.IBalanceUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 用户Service业务层处理
 *
 * 
 * @date 2024-10-19
 */
@Service
public class BalanceUserServiceImpl implements IBalanceUserService
{
    @Autowired
    private BalanceUserMapper sptUserMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;  // 注入 PasswordEncode
    /**
     * 查询用户
     *
     * @param id 用户主键
     * @return 用户
     */
    @Override
    public BalanceUser selectBalanceUserById(Long id)
    {
        return sptUserMapper.selectBalanceUserById(id);
    }

    /**
     * 查询用户列表
     *
     * @param sptUser 用户
     * @return 用户
     */
    @Override
    public List<BalanceUser> selectBalanceUserList(BalanceUser sptUser)
    {
        return sptUserMapper.selectBalanceUserList(sptUser);
    }

    /**
     * 新增用户
     *
     * @param sptUser 用户
     * @return 结果
     */
    @Override
    public int insertBalanceUser(BalanceUser sptUser)
    {
        BalanceUser old = sptUserMapper.selectBalanceUserByUsername(sptUser.getUsername());
        if (old != null){
            return -32001;
        }
        String encodedPassword = passwordEncoder.encode(sptUser.getPassword());
        sptUser.setPassword(encodedPassword);
        sptUser.setCreateTime(new Date());
        
        return sptUserMapper.insertBalanceUser(sptUser);
    }

    /**
     * 修改用户
     *
     * @param sptUser 用户
     * @return 结果
     */
    @Override
    public int updateBalanceUser(BalanceUser sptUser)
    {

        BalanceUser old = sptUserMapper.selectBalanceUserByUsername(sptUser.getUsername());
        if (!old.getId().equals(sptUser.getId())){
            return -32001;
        }

        sptUser.setUpdateTime(new Date());
        return sptUserMapper.updateBalanceUser(sptUser);
    }

    /**
     * 批量删除用户
     *
     * @param ids 需要删除的用户主键
     * @return 结果
     */
    @Override
    public int deleteBalanceUserByIds(Long[] ids)
    {
        return sptUserMapper.deleteBalanceUserByIds(ids);
    }

    /**
     * 删除用户信息
     *
     * @param id 用户主键
     * @return 结果
     */
    @Override
    public int deleteBalanceUserById(Long id)
    {
        return sptUserMapper.deleteBalanceUserById(id);
    }

    @Override
    public BalanceUser selectRtUserByUsername(String username) {
        return sptUserMapper.selectBalanceUserByUsername(username);
    }
}
