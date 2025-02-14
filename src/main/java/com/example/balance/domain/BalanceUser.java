package com.example.balance.domain;


import com.example.balance.domain.base.BaseEntity;

/**
 * 用户对象 balance_user
 *
 * 
 * @date 2025-02-01
 */
public class BalanceUser extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** $column.columnComment */
    
    private String username;

    /** $column.columnComment */
    
    private String password;

    /** $column.columnComment */
    
    private String nickname;

    /** 0、游客1、管理员 */
    
    private String role;

    /** 删除标识 */
    private String delFlag;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getUsername()
    {
        return username;
    }
    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getPassword()
    {
        return password;
    }
    public void setNickname(String nickname)
    {
        this.nickname = nickname;
    }

    public String getNickname()
    {
        return nickname;
    }
    public void setRole(String role)
    {
        this.role = role;
    }

    public String getRole()
    {
        return role;
    }
    public void setDelFlag(String delFlag)
    {
        this.delFlag = delFlag;
    }

    public String getDelFlag()
    {
        return delFlag;
    }

    
}
