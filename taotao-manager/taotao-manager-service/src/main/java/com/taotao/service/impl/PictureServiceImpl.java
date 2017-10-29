package com.taotao.service.impl;

import com.taotao.common.utils.FtpUtil;
import com.taotao.common.utils.IDUtils;
import com.taotao.service.PictureService;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;


@Service
public class PictureServiceImpl implements PictureService{

    @Value("${FTP_ADDRESS}")
    private String ftpAddress;
    @Value("${FTP_PORT}")
    private Integer ftpPort;
    @Value("${FTP_USERNAME}")
    private String ftpUsername;
    @Value("${FTP_PASSWROD}")
    private String ftpPassword;
    @Value("${FTP_BASE_PATH}")
    private String ftpBasePath;
    @Value("${IMAGE_BASE_PATH}")
    private String imageBasePath;

    @Override
    public Map pictureUpload(MultipartFile multipartFile) {
        Map resultMap=new HashMap();
        //生出新的文件名
        //取出原始的文件名
        String oldFileName=multipartFile.getOriginalFilename();
        //生成新的文件名
        String newFileName=IDUtils.genImageName();
        newFileName=newFileName+oldFileName.substring(oldFileName.lastIndexOf("."));
        //图片上传
        try {
            InputStream inputStream=multipartFile.getInputStream();
            String imagePath = new DateTime().toString("/yyyy/MM/dd");
            boolean result=FtpUtil.uploadFile(ftpAddress,ftpPort,ftpUsername,ftpPassword,ftpBasePath,imagePath,newFileName,inputStream);
            if(!result){
                resultMap.put("error",1);
                resultMap.put("message","文件上传失败");
                return resultMap;
            }
            resultMap.put("error",0);
            resultMap.put("url",imageBasePath+imagePath+"/"+newFileName);
            return resultMap;

        } catch (IOException e) {
            resultMap.put("error",1);
            resultMap.put("message","文件上传异常");
            return resultMap;
        }
    }



}
