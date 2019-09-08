package com.cqupt.imis.config;

import com.cqupt.imis.common.exceptions.BaseException;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

/**
 * @author zhoujun
 */
@Aspect
@Component
@Slf4j
public class ControllerConfig {

    @Pointcut("execution(public * com.cqupt.imis.controller..*.*(..))")
    public void controllerConfig(){}


    /**
     * 环绕通知,环绕增强，相当于MethodInterceptor
     */
    @Around("controllerConfig()")
    public Object around(ProceedingJoinPoint pjp) {
        try {
            return pjp.proceed();
        } catch (BaseException e){
            log.error("出错了",e);
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
        catch (Throwable e) {
            log.error("出错了",e);
            return new ResponseEntity<>("出错了，请联系管理员",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
