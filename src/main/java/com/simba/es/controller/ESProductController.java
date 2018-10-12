package com.simba.es.controller;

import com.simba.common.util.UtilDateTime;
import com.simba.es.entity.ESProductInfo;
import com.simba.es.service.ESProductService;
import com.simba.mall.entity.Product;
import com.simba.mall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/es")
public class ESProductController {

    @Autowired
    private ESProductService ESProductService;

    @Autowired
    private ProductService productService;


    @PostMapping("/save")
    public String save(Long inventory,String productName,String productId,Double productPrice){

        int i = ESProductService.saveProduct(inventory, productName, productId, productPrice);
        if(i == 0){
            return "fail";
        }
        return "success";
    }

    @PostMapping("/add")
    public String save(@RequestBody ESProductInfo ESProductInfo){

        int i = ESProductService.addProduct(ESProductInfo);
        if(i == 0){
            return "fail";
        }
        return "success";
    }

    @PostMapping("/deleteAll")
    public int delete(){
        ESProductService.deleteProduct();
        return 1;
    }

    @PostMapping("/importProduct")
    public int importProductDataToEs(){
        Map<String, Object> allProduct = productService.getAllProduct();
        List<Product> plist = (List<Product>)allProduct.get("productList");
        return ESProductService.batchSaveProduct(plist);
    }

}
