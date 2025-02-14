package com.example.balance.controller;

import java.util.Collections;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.example.balance.domain.base.AjaxResult;
import com.example.balance.domain.base.R;
import com.example.balance.domain.req.BalanceInfoListReq;
import com.example.balance.domain.req.BalanceSelectReq;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.balance.domain.BalanceInfo;
import com.example.balance.service.IBalanceInfoService;


/**
 * 天平基本信息Controller
 *
 * @author ruoyi
 * @date 2025-02-05
 */
@RestController
@RequestMapping("/balanceInfo")
public class BalanceInfoController extends BaseController
{
    @Autowired
    private IBalanceInfoService balanceInfoService;

    /**
     * 查询天平基本信息列表
     */
    
    @GetMapping("/list")
    public R list(BalanceInfoListReq balanceInfoListReq)
    {
        PageHelper.startPage(balanceInfoListReq.getPageNum(), balanceInfoListReq.getPageSize());
        BalanceInfo balanceInfo = new BalanceInfo();
        BeanUtils.copyProperties(balanceInfoListReq, balanceInfo);

        List<BalanceInfo> balanceInfos = balanceInfoService.selectBalanceInfoList(balanceInfo);
        if (balanceInfos.size() > 0) {
            PageInfo<BalanceInfo> pageInfo = new PageInfo<>(balanceInfos);
            return R.ok(pageInfo);
        }
        return R.ok(new PageInfo<BalanceInfo>(Collections.emptyList()));
    }

   

    /**
     * 获取天平基本信息详细信息
     */
    
    @GetMapping(value = "/{balanceCode}")
    public AjaxResult getInfo(@PathVariable("balanceCode") String balanceCode)
    {
        return success(balanceInfoService.selectBalanceInfoByBalanceCode(balanceCode));
    }

    /**
     * 新增天平基本信息
     */
    
    
    @PostMapping
    public AjaxResult add(@RequestBody BalanceInfo balanceInfo)
    {
        return toAjax(balanceInfoService.insertBalanceInfo(balanceInfo));
    }

    /**
     * 修改天平基本信息
     */
    
    
    @PutMapping
    public AjaxResult edit(@RequestBody BalanceInfo balanceInfo)
    {
        return toAjax(balanceInfoService.updateBalanceInfo(balanceInfo));
    }

    /**
     * 删除天平基本信息
     */
    
    
    @DeleteMapping("/{balanceCodes}")
    public AjaxResult remove(@PathVariable String[] balanceCodes)
    {
        return toAjax(balanceInfoService.deleteBalanceInfoByBalanceCodes(balanceCodes));
    }


    @GetMapping("/count/{balanceCode}")
    public AjaxResult count(@PathVariable String balanceCode){

        return AjaxResult.success(balanceInfoService.count(balanceCode));

    }

    @PostMapping("/select")
    public AjaxResult add(@RequestBody BalanceSelectReq balanceSelectReq)
    {
        return AjaxResult.success(balanceInfoService.select(balanceSelectReq));
    }

}
