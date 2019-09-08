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
 *
 * @author zhoujun
 * @date 2018/7/22
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
        userService.saveUser(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @RequestMapping("/upload")
    public ResponseEntity<String> upload(@RequestParam("file")MultipartFile multipartFile) throws IOException {
        String path=uploadFileService.uploadStream(multipartFile.getInputStream(),multipartFile.getOriginalFilename());
        return  new ResponseEntity<>(path,HttpStatus.OK);
    }
    @RequestMapping("/loadAllUsers")
    public ResponseEntity<?> loadAllUsers(){
        List<User> users=userService.getAllUsers();
        return new ResponseEntity<>(users,HttpStatus.OK);
    }
    @RequestMapping("/test")
    public String test(){
        return "hello word ";
    }
}
