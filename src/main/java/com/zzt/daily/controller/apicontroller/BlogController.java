package com.zzt.daily.controller.apicontroller;

import com.zzt.daily.auth.JwtUser;
import com.zzt.daily.helper.Markdown;
import com.zzt.daily.mapper.BlogMapper;
import com.zzt.daily.model.Blog;
import com.zzt.daily.requests.PageValidator;
import com.zzt.daily.requests.StoreBlogRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
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

    @Autowired
    BlogMapper blogMapper;

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

    @PostMapping("/blogs")
    public Object store(@RequestBody @Valid StoreBlogRequest storeBlogRequest, HttpServletRequest request, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body("bad");
        }

        Blog blog = new Blog();
        blog.title = storeBlogRequest.title;
        blog.user_id = ((JwtUser) request.getAttribute("loginUser")).getUser().id;
        blog.body = Markdown.convertMarkdownToHtml(storeBlogRequest.body);
        blog.body_original = storeBlogRequest.body;
        blog.created_at = new Date();
        if (blogMapper.create(blog) > 0) {
            return ResponseEntity.status(HttpStatus.CREATED).body(blog);
        } else {
            return ResponseEntity.badRequest().body("failed");
        }
    }

    @GetMapping("/blogs/{id}")
    public Object show(@PathVariable(name = "id") int id) {
        Blog blog = blogMapper.findById(id);
        if (blog == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("not found");
        }
        return blog;
    }

    @GetMapping("/blogs")
    public Object index(@Valid PageValidator pageValidator, HttpServletRequest request) {
        int userId = ((JwtUser) request.getAttribute("loginUser")).getUser().id;
        ArrayList<Blog> blogs = blogMapper.findByUserId(userId, pageValidator.getOffset(), pageValidator.perPage);
        return blogs;
    }

    @DeleteMapping("/blogs/{id}")
    public Object destroy(@PathVariable(name = "id") int id, HttpServletRequest request) {
        int userId = ((JwtUser) request.getAttribute("loginUser")).getUser().id;
        Blog blog = blogMapper.findById(id);
        if (blog == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("不存在的");
        }

        if (blog.user_id == userId) {
            blogMapper.deleteById(id);
            return "ok";
        } else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("只能删除自己的blog");
        }
    }
}
