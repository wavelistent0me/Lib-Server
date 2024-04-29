package com.example.libserver.controller;

import com.example.libserver.common.AjaxResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.UUID;

@RestController
@RequestMapping("/libserver")
@CrossOrigin
public class ImageUploadController {

    //用来规定时间格式
    SimpleDateFormat sdf = new SimpleDateFormat("/yyyy.MM.dd/");

    @Value("${images-file-path}")
    private String imagesPath;

    @PostMapping("/imagesUpload")
    public AjaxResult imagesUpload(MultipartFile file, HttpServletRequest req) {

        System.out.println(file);

        //获取文件的名字
        String originalFilename = file.getOriginalFilename();

        //判断文件类型
        if (!originalFilename.endsWith(".jpg") && !originalFilename.endsWith(".png")) {
            return AjaxResult.Error();
        }
        //给上传文件新建目录
        String date = sdf.format(new Date());
        String path = imagesPath + date;
        //若目录不存在则创建目录
        File folder = new File(path);
        if (!folder.exists()) {
            folder.mkdirs();
        }
        //设置上传文件名称
        String imageName = "";
        if (originalFilename.endsWith(".jpg")) {
            imageName = UUID.randomUUID().toString() + ".jpg";
        }
        else if (originalFilename.endsWith(".png")) {
            imageName = UUID.randomUUID().toString() + ".png";
        }

        try {
            //生成文件,folder为文件目录,imageName为文件名
            file.transferTo(new File(folder, imageName));
            //生成返回给前端的url
            String url = req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort()
                    + "/images" + date + imageName;

            HashMap<String, Object> map = new HashMap<>();
            map.put("url", url);

            return AjaxResult.Success(map);
        }
        catch (IOException e) {
            e.printStackTrace();
            return AjaxResult.Error();
        }
    }

    @PostMapping("/textUpload")
    public AjaxResult handleFileUpload(MultipartFile file) {
        try {
            // 打印文件名
            System.out.println("Received file: " + file.getOriginalFilename());

            InputStreamReader isr = new InputStreamReader(file.getInputStream());
            BufferedReader br = new BufferedReader(isr);
            String str = null;
            while ((str = br.readLine()) != null){
                System.out.println(str);
            }
            System.out.println("----------------------------------------------");
            // 读取文件内容并打印
            String content = new String(file.getBytes());
            System.out.println("File content: " + content);

            HashMap<String, Object> map = new HashMap<>();
            map.put("content", content);

            // 返回成功提示
            return AjaxResult.Success(map);
        }
        catch (IOException e) {
            e.printStackTrace();
            // 返回失败提示
            return AjaxResult.Error();
        }
    }
}
