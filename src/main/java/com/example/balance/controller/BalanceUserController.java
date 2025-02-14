package com.example.balance.controller;

import com.example.balance.config.auth.JwtUtil;
import com.example.balance.config.auth.MyUserDetailsService;
import com.example.balance.config.auth.UserUtil;
import com.example.balance.domain.BalanceUser;
import com.example.balance.domain.base.AjaxResult;
import com.example.balance.domain.base.R;
import com.example.balance.domain.req.LoginReq;
import com.example.balance.domain.req.BalanceUserListReq;
import com.example.balance.service.IBalanceUserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;


/**
 * 用户Controller
 *
 * 
 * @date 2024-10-19
 */
@RestController
@RequestMapping("/user")
public class BalanceUserController extends BaseController {
    @Autowired
    private IBalanceUserService balanceUserService;

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private MyUserDetailsService myUserDetailsService;
    @Autowired
    private JwtUtil jwtUtil;
    @PostMapping("/login")
    @ApiOperation("登录")
    public AjaxResult login(@RequestBody LoginReq loginReq) {

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginReq.getUsername(), loginReq.getPassword())
            );
        }catch (Exception e){
            return AjaxResult.error("用户名或密码错误");
        }

        final UserDetails userDetails = myUserDetailsService.loadUserByUsername(loginReq.getUsername());
        return AjaxResult.success("ok",jwtUtil.generateToken(userDetails.getUsername()));

    }


    /**
     * 查询用户列表
     */

    @GetMapping("/list")
    public R list(BalanceUserListReq balanceUserListReq) {
        PageHelper.startPage(balanceUserListReq.getPageNum(), balanceUserListReq.getPageSize());
        BalanceUser balanceUser = new BalanceUser();
        BeanUtils.copyProperties(balanceUserListReq, balanceUser);

        List<BalanceUser> balanceUsers = balanceUserService.selectBalanceUserList(balanceUser);
        if (balanceUsers.size() > 0) {
            PageInfo<BalanceUser> pageInfo = new PageInfo<>(balanceUsers);
            return R.ok(pageInfo);
        }
        return R.ok(new PageInfo<BalanceUser>(Collections.emptyList()));
    }


    /**
     * 获取用户详细信息
     */

    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(balanceUserService.selectBalanceUserById(id));
    }

    /**
     * 获取用户详细信息
     */

    @GetMapping(value = "/info")
    @ApiOperation("获取用户详细信息")
    public AjaxResult getInfo()
    {
        String username = UserUtil.getCurrentUsername();
        return success(balanceUserService.selectRtUserByUsername(username));
    }

    /**
     * 新增用户
     */


    @PostMapping
    public AjaxResult add(@RequestBody BalanceUser balanceUser) {

        int res = balanceUserService.insertBalanceUser(balanceUser);
        if (res == -32001){
            return AjaxResult.error("用户名已存在");
        }
        return toAjax(res);


    }

    /**
     * 修改用户
     */


    @PutMapping
    public AjaxResult edit(@RequestBody BalanceUser balanceUser) {
        int res = balanceUserService.updateBalanceUser(balanceUser);
        if (res == -32001){
            return AjaxResult.error("用户名已存在");
        }
        return toAjax(res);
    }

    /**
     * 删除用户
     */


    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(balanceUserService.deleteBalanceUserByIds(ids));
    }
}
