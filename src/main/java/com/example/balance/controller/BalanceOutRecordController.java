package com.example.balance.controller;

import java.util.Collections;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.example.balance.domain.BalanceOutRecord;
import com.example.balance.domain.BalancePerformance;
import com.example.balance.domain.base.AjaxResult;
import com.example.balance.domain.base.R;
import com.example.balance.domain.req.BalanceOutRecordListReq;
import com.example.balance.mapper.BalancePerformanceMapper;
import com.example.balance.service.IBalancePerformanceService;
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

import com.example.balance.domain.BalanceOutRecord;
import com.example.balance.service.IBalanceOutRecordService;


/**
 * 天平出库记录Controller
 *
 * @author ruoyi
 * @date 2025-02-08
 */
@RestController
@RequestMapping("/balanceOutRecord")
public class BalanceOutRecordController extends BaseController
{
    @Autowired
    private IBalanceOutRecordService balanceOutRecordService;

    /**
     * 查询天平出库记录列表
     */
    
    @GetMapping("/list")
    public R list(BalanceOutRecordListReq balanceOutRecordListReq)
    {

        PageHelper.startPage(balanceOutRecordListReq.getPageNum(), balanceOutRecordListReq.getPageSize());
        BalanceOutRecord balanceOutRecord = new BalanceOutRecord();
        BeanUtils.copyProperties(balanceOutRecordListReq, balanceOutRecord);

        List<BalanceOutRecord> balanceOutRecords = balanceOutRecordService.selectBalanceOutRecordList(balanceOutRecord);

        if (balanceOutRecords.size() > 0) {
            PageInfo<BalanceOutRecord> pageInfo = new PageInfo<>(balanceOutRecords);
            return R.ok(pageInfo);
        }
        return R.ok(new PageInfo<BalanceOutRecord>(Collections.emptyList()));
        
    }
    

    /**
     * 获取天平出库记录详细信息
     */
    
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(balanceOutRecordService.selectBalanceOutRecordById(id));
    }

    /**
     * 新增天平出库记录
     */
    
    
    @PostMapping
    public AjaxResult add(@RequestBody BalanceOutRecord balanceOutRecord)
    {
        int res = balanceOutRecordService.insertBalanceOutRecord(balanceOutRecord);
        if (res == -32001){
            return AjaxResult.error("请先入库");
        }

        return toAjax(res);
    }

    /**
     * 修改天平出库记录
     */
    
    
    @PutMapping
    public AjaxResult edit(@RequestBody BalanceOutRecord balanceOutRecord)
    {
        return toAjax(balanceOutRecordService.updateBalanceOutRecord(balanceOutRecord));
    }

    /**
     * 删除天平出库记录
     */
    
    
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(balanceOutRecordService.deleteBalanceOutRecordByIds(ids));
    }
}
