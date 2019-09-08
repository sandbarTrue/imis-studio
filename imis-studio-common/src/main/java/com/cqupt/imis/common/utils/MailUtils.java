package com.cqupt.imis.common.utils;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author zhoujun
 */
public class MailUtils {

    static ExecutorService executorService = Executors.newFixedThreadPool(10);

      public static  void sendEmail(String message,String subject,String target){
          //定义Callable, 返回一个结果
          Runnable task = ()->{
              SimpleEmail email = new SimpleEmail();
              //发送邮件的服务器
              email.setHostName("smtp.exmail.qq.com");
              // 邮件服务器smtp协议端口
              email.setSmtpPort(465);
              // 邮箱账户
              email.setAuthentication("imis-studio-admin@imis.group", "!Sandbar731203");
              // 邮件的字符集
              email.setCharset("utf8");
              // 是否启用SSL
              email.setSSLOnConnect(true);
              try {
                  email.addTo(target);
                  email.setFrom("imis-studio-admin@imis.group");
                  email.setMsg(message);
                  email.setSubject(subject);
                  email.send();
              } catch (EmailException e) {
                  e.printStackTrace();
              }
          };
         executorService.submit(task);
      }
}
