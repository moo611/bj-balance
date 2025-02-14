package com.example.balance.controller;

import java.util.Collections;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.example.balance.domain.BalancePerformance;
import com.example.balance.domain.base.AjaxResult;
import com.example.balance.domain.base.R;
import com.example.balance.domain.req.BalancePerformanceListReq;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.balance.domain.BalancePerformance;
import com.example.balance.service.IBalancePerformanceService;


/**
 * 性能检查Controller
 *
 * @author ruoyi
 * @date 2025-02-08
 */
@RestController
@RequestMapping("/balancePerformance")
public class BalancePerformanceController extends BaseController {
    @Autowired
    private IBalancePerformanceService balancePerformanceService;

    /**
     * 查询性能检查列表
     */

    @GetMapping("/list")
    public R list(BalancePerformanceListReq balancePerformanceListReq) {

        PageHelper.startPage(balancePerformanceListReq.getPageNum(), balancePerformanceListReq.getPageSize());
        BalancePerformance balancePerformance = new BalancePerformance();
        BeanUtils.copyProperties(balancePerformanceListReq, balancePerformance);

        List<BalancePerformance> balancePerformances = balancePerformanceService.selectBalancePerformanceList(balancePerformance);
        if (balancePerformances.size() > 0) {
            PageInfo<BalancePerformance> pageInfo = new PageInfo<>(balancePerformances);
            return R.ok(pageInfo);
        }
        return R.ok(new PageInfo<BalancePerformance>(Collections.emptyList()));

    }

    @GetMapping("/latest")
    public R latest(BalancePerformanceListReq balancePerformanceListReq) {
        PageHelper.startPage(balancePerformanceListReq.getPageNum(), balancePerformanceListReq.getPageSize());
        List<BalancePerformance> balancePerformances = balancePerformanceService.selectLatest(balancePerformanceListReq);
        if (balancePerformances.size() > 0) {
            PageInfo<BalancePerformance> pageInfo = new PageInfo<>(balancePerformances);
            return R.ok(pageInfo);
        }
        return R.ok(new PageInfo<BalancePerformance>(Collections.emptyList()));

    }


    /**
     * 获取性能检查详细信息
     */

    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(balancePerformanceService.selectBalancePerformanceById(id));
    }


    @GetMapping("/info")
    public AjaxResult getInfoByBalance(@RequestParam("balanceCode") String balanceCode,
                                       @RequestParam(value = "outId", required = false) Long outId,
                                       @RequestParam(value = "inId", required = false) Long inId) {
        return success(balancePerformanceService.getInfoByBalance(balanceCode, outId,inId));
    }

    /**
     * 新增性能检查
     */


    @PostMapping
    public AjaxResult add(@RequestBody BalancePerformance balancePerformance) {
        return toAjax(balancePerformanceService.insertBalancePerformance(balancePerformance));
    }


    /**
     * 新增性能检查
     */


    @PostMapping("/saveOrUpdate")
    public AjaxResult saveOrUpdate(@RequestBody BalancePerformance balancePerformance) {
        return toAjax(balancePerformanceService.saveOrUpdate(balancePerformance));
    }

    /**
     * 修改性能检查
     */


    @PutMapping
    public AjaxResult edit(@RequestBody BalancePerformance balancePerformance) {
        return toAjax(balancePerformanceService.updateBalancePerformance(balancePerformance));
    }

    /**
     * 删除性能检查
     */


    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(balancePerformanceService.deleteBalancePerformanceByIds(ids));
    }
}
