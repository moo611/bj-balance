package com.example.balance.controller;

import java.util.Collections;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.example.balance.domain.BalanceCalibration;
import com.example.balance.domain.base.AjaxResult;
import com.example.balance.domain.base.R;
import com.example.balance.domain.req.BalanceCalibrationListReq;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.balance.domain.BalanceCalibration;
import com.example.balance.service.IBalanceCalibrationService;


/**
 * 证书Controller
 *
 * @author ruoyi
 * @date 2025-02-06
 */
@RestController
@RequestMapping("/balanceCalibration")
public class BalanceCalibrationController extends BaseController
{
    @Autowired
    private IBalanceCalibrationService balanceCalibrationService;

    /**
     * 查询证书列表
     */
    
    @GetMapping("/list")
    public R list(BalanceCalibrationListReq balanceCalibrationListReq)
    {
        PageHelper.startPage(balanceCalibrationListReq.getPageNum(), balanceCalibrationListReq.getPageSize());
        BalanceCalibration balanceCalibration = new BalanceCalibration();
        BeanUtils.copyProperties(balanceCalibrationListReq, balanceCalibration);

        List<BalanceCalibration> balanceCalibrations = balanceCalibrationService.selectBalanceCalibrationList(balanceCalibration);
        if (balanceCalibrations.size() > 0) {
            PageInfo<BalanceCalibration> pageInfo = new PageInfo<>(balanceCalibrations);
            return R.ok(pageInfo);
        }
        return R.ok(new PageInfo<BalanceCalibration>(Collections.emptyList()));
    }



    /**
     * 获取证书详细信息
     */
    
    @GetMapping(value = "/{bcalibrationCode}")
    public AjaxResult getInfo(@PathVariable("bcalibrationCode") String bcalibrationCode)
    {
        return success(balanceCalibrationService.selectBalanceCalibrationByBcalibrationCode(bcalibrationCode));
    }



    @GetMapping("/info")
    public AjaxResult getInfoByCode(@RequestParam("balanceCode")String balanceCode)
    {
        return success(balanceCalibrationService.selectBalanceCalibrationByBalanceCode(balanceCode));
    }

    /**
     * 新增证书
     */
    
    
    @PostMapping
    public AjaxResult add(@RequestBody BalanceCalibration balanceCalibration)
    {
        return toAjax(balanceCalibrationService.insertBalanceCalibration(balanceCalibration));
    }

    /**
     * 修改证书
     */
    
    
    @PutMapping
    public AjaxResult edit(@RequestBody BalanceCalibration balanceCalibration)
    {
        return toAjax(balanceCalibrationService.updateBalanceCalibration(balanceCalibration));
    }

    /**
     * 删除证书
     */
    
    
    @DeleteMapping("/{bcalibrationCodes}")
    public AjaxResult remove(@PathVariable String[] bcalibrationCodes)
    {
        return toAjax(balanceCalibrationService.deleteBalanceCalibrationByBcalibrationCodes(bcalibrationCodes));
    }
}
