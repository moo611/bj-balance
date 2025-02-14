package com.example.balance.controller;

import java.util.Collections;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.example.balance.domain.BalanceHealth;
import com.example.balance.domain.BalanceHealth;
import com.example.balance.domain.BalanceHealthVO;
import com.example.balance.domain.base.AjaxResult;
import com.example.balance.domain.base.R;
import com.example.balance.domain.req.BalanceHealthListReq;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.balance.domain.BalanceHealth;
import com.example.balance.service.IBalanceHealthService;


/**
 * 故障Controller
 *
 * @author ruoyi
 * @date 2025-02-09
 */
@RestController
@RequestMapping("/balanceHealth")
public class BalanceHealthController extends BaseController
{
    @Autowired
    private IBalanceHealthService balanceHealthService;

    /**
     * 查询故障列表
     */
   
    @GetMapping("/list")
    public R list(BalanceHealthListReq balanceHealthListReq)
    {

        PageHelper.startPage(balanceHealthListReq.getPageNum(), balanceHealthListReq.getPageSize());
        BalanceHealth balanceHealth = new BalanceHealth();
        BeanUtils.copyProperties(balanceHealthListReq, balanceHealth);

        List<BalanceHealth> balanceHealths = balanceHealthService.selectBalanceHealthList(balanceHealth);
        if (balanceHealths.size() > 0) {
            PageInfo<BalanceHealth> pageInfo = new PageInfo<>(balanceHealths);
            return R.ok(pageInfo);
        }
        return R.ok(new PageInfo<BalanceHealth>(Collections.emptyList()));
        
        
    }

    @GetMapping("/latest")
    public R latest(BalanceHealthListReq balanceHealthListReq)
    {

        PageHelper.startPage(balanceHealthListReq.getPageNum(), balanceHealthListReq.getPageSize());
        List<BalanceHealthVO> balanceHealthVOs = balanceHealthService.selectLatest(balanceHealthListReq);
        if (balanceHealthVOs.size() > 0) {
            PageInfo<BalanceHealthVO> pageInfo = new PageInfo<>(balanceHealthVOs);
            return R.ok(pageInfo);
        }
        return R.ok(new PageInfo<BalanceHealthVO>(Collections.emptyList()));


    }


    /**
     * 获取故障详细信息
     */
   
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(balanceHealthService.selectBalanceHealthById(id));
    }

    @GetMapping("/info")
    public AjaxResult getInfoByBalance(@RequestParam("balanceCode") String balanceCode, @RequestParam("inId")Long inId)
    {
        return success(balanceHealthService.getInfoByBalance(balanceCode,inId));
    }
    

    /**
     * 新增故障
     */
   
   
    @PostMapping
    public AjaxResult add(@RequestBody BalanceHealth balanceHealth)
    {
        return toAjax(balanceHealthService.insertBalanceHealth(balanceHealth));
    }

    @PostMapping("/saveOrUpdate")
    public AjaxResult saveOrUpdate(@RequestBody BalanceHealth balanceHealth)
    {
        return toAjax(balanceHealthService.saveOrUpdate(balanceHealth));
    }

    /**
     * 修改故障
     */
   
   
    @PutMapping
    public AjaxResult edit(@RequestBody BalanceHealth balanceHealth)
    {
        return toAjax(balanceHealthService.updateBalanceHealth(balanceHealth));
    }

    /**
     * 删除故障
     */
   
   
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(balanceHealthService.deleteBalanceHealthByIds(ids));
    }
}
