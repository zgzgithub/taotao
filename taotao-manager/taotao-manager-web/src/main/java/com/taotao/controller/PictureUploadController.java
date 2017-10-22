package com.taotao.controller;

import com.alibaba.druid.support.json.JSONUtils;
import com.taotao.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@Controller
public class PictureUploadController {
    @Autowired
    private PictureService pictureService;

    @RequestMapping(value = "/pic/upload")
    @ResponseBody
    public String pictureUpload(MultipartFile uploadFile){
        Map result=pictureService.pictureUpload(uploadFile);
        String json=JSONUtils.toJSONString(result);
        return json;
    }
}
