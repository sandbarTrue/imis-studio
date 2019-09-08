package com.cqupt.imis.service.impl;

import com.cqupt.imis.common.exceptions.UploadException;
import com.cqupt.imis.common.upload.MyUploadManager;
import com.cqupt.imis.common.utils.ArgumentUtil;
import com.cqupt.imis.service.UploadFileService;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.File;
import java.io.InputStream;

/**
 * Created by zhoujun on 2018/7/29.
 */
@Service
@Slf4j
public class UploadFileServiceImpl  implements UploadFileService{
    private final  String URL="http://img.qiniu.imis.group/";

    private final Logger logger= LoggerFactory.getLogger(getClass());
    @Resource
    private MyUploadManager myUploadManager;
    @Override
    // TODO: 2018/8/5 改写成模板方法
    public String uploadFile(File file) {
        ArgumentUtil.agrgumentValid(file);
        Response  response= null;
        try {
            response = myUploadManager.getUploadManager().
                        put(file,file.getName(),myUploadManager.getUploadToken());
            if(response.statusCode!=200){
                logger.error("上传失败,"+response.body());
                throw new UploadException("上传失败,"+response.body());
            }
        } catch (QiniuException e) {
            logger.error("上传失败",e);
            throw new UploadException("上传失败,"+e.getMessage());
        }
        return URL+file.getName();
    }

    @Override
    public String uploadBytes(byte[] bytes,String name) throws QiniuException {
        ArgumentUtil.agrgumentValid(bytes);
        Response  response= null;
        try {
            response=myUploadManager.getUploadManager().put(bytes,name,myUploadManager.getUploadToken());
            if(response.statusCode!=200){
                logger.error("上传失败,"+response.body());
                throw new UploadException("上传失败,"+response.body());
            }
        } catch (QiniuException e) {
            logger.error("上传失败",e);
            throw new UploadException("上传失败,"+e.getMessage());
        }
        return URL+name;
    }

    @Override
    public String uploadStream(InputStream inputStream,String  name) throws QiniuException {
        ArgumentUtil.agrgumentValid(inputStream);
        Response  response= null;
        try {
            response=myUploadManager.getUploadManager().
                    put(inputStream,name,myUploadManager.getUploadToken(),null,null);
            if(response.statusCode!=200){
                logger.error("上传失败,"+response.body());
                throw new UploadException("上传失败,"+response.body());
            }
        } catch (QiniuException e) {
            logger.error("上传失败",e);
            throw new UploadException("上传失败,"+e.getMessage());
        }
        return URL+name;
    }
}
