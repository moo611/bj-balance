package com.example.balance.controller;

import com.example.balance.domain.base.AjaxResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/file")
@CrossOrigin(origins = "*") // 允许所有来源，或替换为具体的来源
public class FileController {

    // 上传文件保存路径，可自定义
    private static final String UPLOAD_DIR = "C:\\Users\\lnpjj\\Desktop\\jiedan\\风洞天平\\bj-balance\\files\\";

    @PostMapping("/upload")
    public AjaxResult upload(@RequestParam("file") MultipartFile file) {

        if (file.isEmpty()) {

            return AjaxResult.error("文件不存在");
        }

        try {
            // 保证目录存在
            File dir = new File(UPLOAD_DIR);
            if (!dir.exists()) {
                dir.mkdirs();
            }

            String originalFilename = file.getOriginalFilename();
            String filePath = UPLOAD_DIR + UUID.randomUUID() + "_" + originalFilename;
            file.transferTo(new File(filePath));
            return AjaxResult.success("上传成功", filePath);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return AjaxResult.error("上传失败");
    }



    @GetMapping("/download")
    public void downloadFile(@RequestParam("path") String filePath, HttpServletResponse response) {
        File file = new File(filePath);
        if (!file.exists()) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        try (InputStream inputStream = new FileInputStream(file);
             OutputStream outputStream = response.getOutputStream()) {

            // 设置响应头
            response.setContentType("application/octet-stream");
            response.setHeader("Content-Disposition",
                    "attachment; filename=" + URLEncoder.encode(file.getName(), "UTF-8"));
            response.setContentLengthLong(file.length());

            // 写入文件流
            byte[] buffer = new byte[1024];
            int len;
            while ((len = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, len);
            }

            outputStream.flush();
        } catch (IOException e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }

}
