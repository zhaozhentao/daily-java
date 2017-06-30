package com.zzt.daily.controller.apicontroller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.HashMap;

/**
 * Created by zhaotao on 2017/6/29.
 */
@RestController
@RequestMapping("/api")
public class BlogController {

    @Value("${upload_image_path}")
    String folder;

    @Value("${system_path}")
    String system_path;

    @Value("${public_path}")
    String public_path;

    @PostMapping("/upload_image")
    public Object uploadImage(@RequestParam(value = "file") MultipartFile file) {
        if (!file.isEmpty()) {
            try {
                String localFileName = folder + System.currentTimeMillis() + "_" + file.getOriginalFilename();
                File localFile = new File(system_path + localFileName);
                if (!localFile.getParentFile().exists()) {
                    localFile.getParentFile().mkdirs();
                }
                InputStream inputStream = file.getInputStream();
                FileOutputStream outputStream = new FileOutputStream(localFile);

                int len;
                byte[] bs = new byte[1024];
                while ((len = inputStream.read(bs)) != -1) {
                    outputStream.write(bs, 0, len);
                }
                outputStream.close();
                inputStream.close();
                HashMap<String, String> body = new HashMap<>();
                body.put("filename", public_path + localFileName);
                return body;
            } catch (Exception e) {
                return "lkjsdf";
            }
        } else {
            return "lksdf";
        }
    }
}
