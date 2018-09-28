package com.simba.mall.service;

import com.simba.mall.entity.Product;
import com.simba.mall.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;


    public Map<String,Object> getAllProduct(){
        Map<String,Object> result = new HashMap<String,Object>();
        List<Product> all = productRepository.findAll();
        result.put("productList",all);
        result.put("total",all.size());
        return result;
    }

}
