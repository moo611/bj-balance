package com.example.balance.controller;

import java.util.Collections;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.example.balance.domain.BalanceSupport;
import com.example.balance.domain.BalanceSupport;
import com.example.balance.domain.base.AjaxResult;
import com.example.balance.domain.base.R;
import com.example.balance.domain.req.BalanceSupportListReq;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.balance.domain.BalanceSupport;
import com.example.balance.service.IBalanceSupportService;


/**
 * 支杆Controller
 *
 * @author ruoyi
 * @date 2025-02-06
 */
@RestController
@RequestMapping("/balanceSupport")
public class BalanceSupportController extends BaseController
{
    @Autowired
    private IBalanceSupportService balanceSupportService;

    /**
     * 查询支杆列表
     */
    
    @GetMapping("/list")
    public R list(BalanceSupportListReq balanceSupportListReq)
    {

        PageHelper.startPage(balanceSupportListReq.getPageNum(), balanceSupportListReq.getPageSize());
        BalanceSupport balanceSupport = new BalanceSupport();
        BeanUtils.copyProperties(balanceSupportListReq, balanceSupport);

        List<BalanceSupport> balanceSupports = balanceSupportService.selectBalanceSupportList(balanceSupport);
        if (balanceSupports.size() > 0) {
            PageInfo<BalanceSupport> pageInfo = new PageInfo<>(balanceSupports);
            return R.ok(pageInfo);
        }
        return R.ok(new PageInfo<BalanceSupport>(Collections.emptyList()));
        
    }

   

    /**
     * 获取支杆详细信息
     */
    
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(balanceSupportService.selectBalanceSupportById(id));
    }

    @GetMapping("/info")
    public AjaxResult getInfoByCode(@RequestParam("balanceCode")String balanceCode)
    {
        return success(balanceSupportService.selectBalanceSupportByBalanceCode(balanceCode));
    }

    /**
     * 新增支杆
     */
    
    
    @PostMapping
    public AjaxResult add(@RequestBody BalanceSupport balanceSupport)
    {
        return toAjax(balanceSupportService.insertBalanceSupport(balanceSupport));
    }


    @PostMapping("/saveOrUpdate")
    public AjaxResult saveOrUpdate(@RequestBody BalanceSupport balanceSupport)
    {
        return toAjax(balanceSupportService.saveOrUpdate(balanceSupport));
    }

    /**
     * 修改支杆
     */
    
    
    @PutMapping
    public AjaxResult edit(@RequestBody BalanceSupport balanceSupport)
    {
        return toAjax(balanceSupportService.updateBalanceSupport(balanceSupport));
    }

    /**
     * 删除支杆
     */
    
    
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(balanceSupportService.deleteBalanceSupportByIds(ids));
    }
}
