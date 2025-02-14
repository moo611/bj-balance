package com.example.balance.controller;

import java.util.Collections;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.example.balance.domain.BalancePerformance;
import com.example.balance.domain.BalanceUse;
import com.example.balance.domain.base.AjaxResult;
import com.example.balance.domain.base.R;
import com.example.balance.domain.req.BalanceUseListReq;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.balance.domain.BalanceUse;
import com.example.balance.service.IBalanceUseService;


/**
 * 使用信息Controller
 *
 * @author ruoyi
 * @date 2025-02-08
 */
@RestController
@RequestMapping("/balanceUse")
public class BalanceUseController extends BaseController
{
    @Autowired
    private IBalanceUseService balanceUseService;

    /**
     * 查询使用信息列表
     */
    
    @GetMapping("/list")
    public R list(BalanceUseListReq balanceUseListReq)
    {
        PageHelper.startPage(balanceUseListReq.getPageNum(), balanceUseListReq.getPageSize());
        BalanceUse balanceUse = new BalanceUse();
        BeanUtils.copyProperties(balanceUseListReq, balanceUse);

        List<BalanceUse> balanceUses = balanceUseService.selectBalanceUseList(balanceUse);
        if (balanceUses.size() > 0) {
            PageInfo<BalanceUse> pageInfo = new PageInfo<>(balanceUses);
            return R.ok(pageInfo);
        }
        return R.ok(new PageInfo<BalanceUse>(Collections.emptyList()));
    }



    /**
     * 获取使用信息详细信息
     */
    
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(balanceUseService.selectBalanceUseById(id));
    }

    @GetMapping("/info")
    public AjaxResult getInfoByBalance(@RequestParam("balanceCode") String balanceCode, @RequestParam("outId")Long outId)
    {
        return success(balanceUseService.getInfoByBalance(balanceCode,outId));
    }

    /**
     * 新增使用信息
     */
    
    
    @PostMapping
    public AjaxResult add(@RequestBody BalanceUse balanceUse)
    {
        return toAjax(balanceUseService.insertBalanceUse(balanceUse));
    }

    /**
     * 新增性能检查
     */


    @PostMapping("/saveOrUpdate")
    public AjaxResult saveOrUpdate(@RequestBody BalanceUse balanceUse)
    {
        return toAjax(balanceUseService.saveOrUpdate(balanceUse));
    }

    /**
     * 修改使用信息
     */
    
    
    @PutMapping
    public AjaxResult edit(@RequestBody BalanceUse balanceUse)
    {
        return toAjax(balanceUseService.updateBalanceUse(balanceUse));
    }

    /**
     * 删除使用信息
     */
    
    
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(balanceUseService.deleteBalanceUseByIds(ids));
    }
}
