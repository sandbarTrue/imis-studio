package com.cqupt.imis.controller.api;

import com.cqupt.imis.service.UploadFileService;
import com.cqupt.imis.service.UserService;
import com.cqupt.imis.service.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

/**
 * Created by zhoujun on 2018/7/22.
 */
@RestController
@RequestMapping("/api/imis")
public class UserApiController {
    @Resource
    private UploadFileService uploadFileService;
    @Resource
    private UserService userService;
    @RequestMapping("/regist")
    public ResponseEntity<?> regist(@RequestBody User user){
        try{
            userService.saveUser(user);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @RequestMapping("/upload")
    public ResponseEntity<String> upload(@RequestParam("file")MultipartFile multipartFile) throws IOException {
        String path=null;
        try{
            path=uploadFileService.uploadStream(multipartFile.getInputStream(),multipartFile.getOriginalFilename());
        }catch (Exception e){
            return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<String>(path, HttpStatus.OK);
    }
    @RequestMapping("/loadAllUsers")
    public ResponseEntity<?> loadAllUsers(){
        List<User> users=null;
        try{
             users=userService.getAllUsers();
        }
        catch (Exception e){
            return new ResponseEntity<>("查询失败",HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(users,HttpStatus.OK);
    }
}
