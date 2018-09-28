package com.simba.mall.controller;

import com.simba.mall.service.ProductService;
import com.simba.spider.handler.SpiderHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class ProductController {

    @Autowired
    private SpiderHandler spiderHandler;

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/snatchJDProduct",method = RequestMethod.POST)
    @ResponseBody
    public int snatchJDProduct(){
        spiderHandler.spiderData();
        return 0;
    }

    @GetMapping("/getAllProduct")
    @ResponseBody
    public Map<String,Object> findAllProduct(){

        return productService.getAllProduct();
    }

}
