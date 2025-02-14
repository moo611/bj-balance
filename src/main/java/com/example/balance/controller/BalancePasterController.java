package com.example.balance.controller;

import java.util.Collections;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.example.balance.domain.BalancePaster;
import com.example.balance.domain.base.AjaxResult;
import com.example.balance.domain.base.R;
import com.example.balance.domain.req.BalancePasterListReq;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import com.example.balance.domain.BalancePaster;
import com.example.balance.service.IBalancePasterService;


/**
 * 贴片信息Controller
 *
 * @author ruoyi
 * @date 2025-02-05
 */
@RestController
@RequestMapping("/balancePaster")
public class BalancePasterController extends BaseController
{
    @Autowired
    private IBalancePasterService balancePasterService;

    /**
     * 查询贴片信息列表
     */
    
    @GetMapping("/list")
    public R list(BalancePasterListReq balancePasterListReq)
    {
        PageHelper.startPage(balancePasterListReq.getPageNum(), balancePasterListReq.getPageSize());
        BalancePaster balancePaster = new BalancePaster();
        BeanUtils.copyProperties(balancePasterListReq, balancePaster);

        List<BalancePaster> balancePasters = balancePasterService.selectBalancePasterList(balancePaster);
        if (balancePasters.size() > 0) {
            PageInfo<BalancePaster> pageInfo = new PageInfo<>(balancePasters);
            return R.ok(pageInfo);
        }
        return R.ok(new PageInfo<BalancePaster>(Collections.emptyList()));
    }

  

    /**
     * 获取贴片信息详细信息
     */
    
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(balancePasterService.selectBalancePasterById(id));
    }


    @GetMapping("/info")
    public AjaxResult getInfoByCode(@RequestParam("balanceCode")String balanceCode)
    {
        return success(balancePasterService.selectBalancePasterByBalanceCode(balanceCode));
    }
    

    /**
     * 新增贴片信息
     */
    
    
    @PostMapping
    public AjaxResult add(@RequestBody BalancePaster balancePaster)
    {
        return toAjax(balancePasterService.insertBalancePaster(balancePaster));
    }

    /**
     * 修改贴片信息
     */
    
    
    @PutMapping
    public AjaxResult edit(@RequestBody BalancePaster balancePaster)
    {
        return toAjax(balancePasterService.updateBalancePaster(balancePaster));
    }

    /**
     * 删除贴片信息
     */
    
    
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(balancePasterService.deleteBalancePasterByIds(ids));
    }
}
