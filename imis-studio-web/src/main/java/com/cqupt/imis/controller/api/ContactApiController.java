package com.cqupt.imis.controller.api;

import com.cqupt.imis.common.utils.MailUtils;
import com.cqupt.imis.domain.ContactInfoVo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhoujun
 */
@RestController
@RequestMapping("/api/imis")
public class ContactApiController {

    @RequestMapping("/sendMessage")
    public ResponseEntity<?> sendMessage(@RequestBody ContactInfoVo contactInfoVo){
        //用zhoujun@imis.group 向imis-studio@imis.group
        String message="来自"+contactInfoVo.getName()+"邮箱为"+contactInfoVo.getEamilAddress()+"的留言"
                +"："+contactInfoVo.getMessage();
        MailUtils.sendEmail(message,"用户留言","imis-studio@imis.group");
        //给用户邮箱回信
        MailUtils.sendEmail("您的留言已经收到，会尽快给您答复","信管工作室留言反馈",contactInfoVo.getEamilAddress());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
