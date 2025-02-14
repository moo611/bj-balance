package com.example.balance.controller;

import java.util.Collections;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.example.balance.domain.BalanceInRecord;
import com.example.balance.domain.base.AjaxResult;
import com.example.balance.domain.base.R;
import com.example.balance.domain.req.BalanceInRecordListReq;
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

import com.example.balance.domain.BalanceInRecord;
import com.example.balance.service.IBalanceInRecordService;


/**
 * 入库Controller
 *
 * @author ruoyi
 * @date 2025-02-09
 */
@RestController
@RequestMapping("/balanceInRecord")
public class BalanceInRecordController extends BaseController
{
    @Autowired
    private IBalanceInRecordService balanceInRecordService;

    /**
     * 查询入库列表
     */
    
    @GetMapping("/list")
    public R list(BalanceInRecordListReq balanceInRecordListReq)
    {

        PageHelper.startPage(balanceInRecordListReq.getPageNum(), balanceInRecordListReq.getPageSize());
        BalanceInRecord balanceInRecord = new BalanceInRecord();
        BeanUtils.copyProperties(balanceInRecordListReq, balanceInRecord);

        List<BalanceInRecord> balanceInRecords = balanceInRecordService.selectBalanceInRecordList(balanceInRecord);

        if (balanceInRecords.size() > 0) {
            PageInfo<BalanceInRecord> pageInfo = new PageInfo<>(balanceInRecords);
            return R.ok(pageInfo);
        }
        return R.ok(new PageInfo<BalanceInRecord>(Collections.emptyList()));

    }

    

    /**
     * 获取入库详细信息
     */
    
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(balanceInRecordService.selectBalanceInRecordById(id));
    }

    /**
     * 新增入库
     */
    
    
    @PostMapping
    public AjaxResult add(@RequestBody BalanceInRecord balanceInRecord)
    {
        int res = balanceInRecordService.insertBalanceInRecord(balanceInRecord);
        if (res == -32001){
            return AjaxResult.error("请先出库");
        }
        return toAjax(res);
    }

    /**
     * 修改入库
     */
    
    
    @PutMapping
    public AjaxResult edit(@RequestBody BalanceInRecord balanceInRecord)
    {
        return toAjax(balanceInRecordService.updateBalanceInRecord(balanceInRecord));
    }

    /**
     * 删除入库
     */
    
    
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(balanceInRecordService.deleteBalanceInRecordByIds(ids));
    }
}
