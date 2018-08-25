package com.simba.imageSearch.controller;

import com.simba.imageSearch.service.ImageSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
public class ImageSearchController {

    @Autowired
    private ImageSearchService imageSearchService;

    @RequestMapping("/similarAdd")
    public void similarImageAdd(){
        Map<String,String> param = new HashMap<String,String>();
        param.put("brief", "{\"name\":\"测试\", \"id\":\"1\"}");
        param.put("tags", "001,002");
//        param.put("url","E:\\5b08cfb3Nb4bd382e.jpg");
        param.put("url","https://img10.360buyimg.com/n7/jfs/t21052/252/290549868/67738/3a1172ef/5b08cfb3Nb4bd382e.jpg");
        imageSearchService.similarImageAdd(param);
    }
}
