package com.example.balance.controller;

import java.util.Collections;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.example.balance.domain.BalanceFile;
import com.example.balance.domain.base.AjaxResult;
import com.example.balance.domain.base.R;
import com.example.balance.domain.req.BalanceFileListReq;
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

import com.example.balance.domain.BalanceFile;
import com.example.balance.service.IBalanceFileService;


/**
 * 文件Controller
 *
 * @author ruoyi
 * @date 2025-02-07
 */
@RestController
@RequestMapping("/balanceFile")
public class BalanceFileController extends BaseController
{
    @Autowired
    private IBalanceFileService balanceFileService;

    /**
     * 查询文件列表
     */
    
    @GetMapping("/list")
    public R list(BalanceFileListReq balanceFileListReq)
    {
        PageHelper.startPage(balanceFileListReq.getPageNum(), balanceFileListReq.getPageSize());
        BalanceFile balanceFile = new BalanceFile();
        BeanUtils.copyProperties(balanceFileListReq, balanceFile);

        List<BalanceFile> balanceFiles = balanceFileService.selectBalanceFileList(balanceFile);
        if (balanceFiles.size() > 0) {
            PageInfo<BalanceFile> pageInfo = new PageInfo<>(balanceFiles);
            return R.ok(pageInfo);
        }
        return R.ok(new PageInfo<BalanceFile>(Collections.emptyList()));
    }

   

    /**
     * 获取文件详细信息
     */
    
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(balanceFileService.selectBalanceFileById(id));
    }

    /**
     * 新增文件
     */
    
    
    @PostMapping
    public AjaxResult add(@RequestBody BalanceFile balanceFile)
    {
        return toAjax(balanceFileService.insertBalanceFile(balanceFile));
    }

    /**
     * 修改文件
     */
    
    
    @PutMapping
    public AjaxResult edit(@RequestBody BalanceFile balanceFile)
    {
        return toAjax(balanceFileService.updateBalanceFile(balanceFile));
    }

    /**
     * 删除文件
     */
    
    
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(balanceFileService.deleteBalanceFileByIds(ids));
    }
}
