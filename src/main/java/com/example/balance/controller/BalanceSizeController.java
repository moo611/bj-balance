package com.example.balance.controller;

import java.util.Collections;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.example.balance.domain.BalanceSize;
import com.example.balance.domain.base.AjaxResult;
import com.example.balance.domain.base.R;
import com.example.balance.domain.req.BalanceSizeListReq;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.balance.domain.BalanceSize;
import com.example.balance.service.IBalanceSizeService;

/**
 * 尺寸Controller
 *
 * @author ruoyi
 * @date 2025-02-05
 */
@RestController
@RequestMapping("/balanceSize")
public class BalanceSizeController extends BaseController
{
    @Autowired
    private IBalanceSizeService balanceSizeService;

    /**
     * 查询尺寸列表
     */
    
    @GetMapping("/list")
    public R list(BalanceSizeListReq balanceSizeListReq)
    {
        PageHelper.startPage(balanceSizeListReq.getPageNum(), balanceSizeListReq.getPageSize());
        BalanceSize balanceSize = new BalanceSize();
        BeanUtils.copyProperties(balanceSizeListReq, balanceSize);

        List<BalanceSize> balanceSizes = balanceSizeService.selectBalanceSizeList(balanceSize);
        if (balanceSizes.size() > 0) {
            PageInfo<BalanceSize> pageInfo = new PageInfo<>(balanceSizes);
            return R.ok(pageInfo);
        }
        return R.ok(new PageInfo<BalanceSize>(Collections.emptyList()));
    }

    

    /**
     * 获取尺寸详细信息
     */
    
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(balanceSizeService.selectBalanceSizeById(id));
    }

    @GetMapping("/info")
    public AjaxResult getInfoByCode(@RequestParam("balanceCode")String balanceCode)
    {
        return success(balanceSizeService.selectBalanceSizeByBalanceCode(balanceCode));
    }

    /**
     * 新增尺寸
     */
    
    
    @PostMapping
    public AjaxResult add(@RequestBody BalanceSize balanceSize)
    {
        return toAjax(balanceSizeService.insertBalanceSize(balanceSize));
    }


    @PostMapping("/saveOrUpdate")
    public AjaxResult saveOrUpdate(@RequestBody BalanceSize balanceSize)
    {
        return toAjax(balanceSizeService.saveOrUpdate(balanceSize));
    }

    /**
     * 修改尺寸
     */
    
    
    @PutMapping
    public AjaxResult edit(@RequestBody BalanceSize balanceSize)
    {
        return toAjax(balanceSizeService.updateBalanceSize(balanceSize));
    }

    /**
     * 删除尺寸
     */
    
    
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(balanceSizeService.deleteBalanceSizeByIds(ids));
    }
}
