package com.example.balance.controller;

import java.util.Collections;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.example.balance.domain.BalanceProcess;
import com.example.balance.domain.BalanceSize;
import com.example.balance.domain.base.AjaxResult;
import com.example.balance.domain.base.R;
import com.example.balance.domain.req.BalanceProcessListReq;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.balance.domain.BalanceProcess;
import com.example.balance.service.IBalanceProcessService;


/**
 * 加工Controller
 *
 * @author ruoyi
 * @date 2025-02-05
 */
@RestController
@RequestMapping("/balanceProcess")
public class BalanceProcessController extends BaseController
{
    @Autowired
    private IBalanceProcessService balanceProcessService;

    /**
     * 查询加工列表
     */
    
    @GetMapping("/list")
    public R list(BalanceProcessListReq balanceProcessListReq)
    {
        PageHelper.startPage(balanceProcessListReq.getPageNum(), balanceProcessListReq.getPageSize());
        BalanceProcess balanceProcess = new BalanceProcess();
        BeanUtils.copyProperties(balanceProcessListReq, balanceProcess);

        List<BalanceProcess> balanceProcesss = balanceProcessService.selectBalanceProcessList(balanceProcess);
        if (balanceProcesss.size() > 0) {
            PageInfo<BalanceProcess> pageInfo = new PageInfo<>(balanceProcesss);
            return R.ok(pageInfo);
        }
        return R.ok(new PageInfo<BalanceProcess>(Collections.emptyList()));
    }

  

    /**
     * 获取加工详细信息
     */
    
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(balanceProcessService.selectBalanceProcessById(id));
    }

    @GetMapping("/info")
    public AjaxResult getInfoByCode(@RequestParam("balanceCode")String balanceCode)
    {
        return success(balanceProcessService.selectBalanceProcessByBalanceCode(balanceCode));
    }

    /**
     * 新增加工
     */
    
    
    @PostMapping
    public AjaxResult add(@RequestBody BalanceProcess balanceProcess)
    {
        return toAjax(balanceProcessService.insertBalanceProcess(balanceProcess));
    }

    @PostMapping("/saveOrUpdate")
    public AjaxResult saveOrUpdate(@RequestBody BalanceProcess balanceProcess)
    {
        return toAjax(balanceProcessService.saveOrUpdate(balanceProcess));
    }


    /**
     * 修改加工
     */
    
    
    @PutMapping
    public AjaxResult edit(@RequestBody BalanceProcess balanceProcess)
    {
        return toAjax(balanceProcessService.updateBalanceProcess(balanceProcess));
    }

    /**
     * 删除加工
     */
    
    
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(balanceProcessService.deleteBalanceProcessByIds(ids));
    }
}
