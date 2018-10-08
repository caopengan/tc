package com.simba.es.controller;

import com.simba.es.service.ESProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/es")
public class ESProductController {

    @Autowired
    private ESProductService ESProductService;


    @PostMapping("/save")
    public String save(Long inventory,String productName,String productId,Double productPrice){

        int i = ESProductService.saveProduct(inventory, productName, productId, productPrice);
        if(i == 0){
            return "fail";
        }
        return "success";
    }
}
