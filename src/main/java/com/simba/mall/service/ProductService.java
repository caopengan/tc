package com.simba.mall.service;

import com.simba.mall.entity.Product;
import com.simba.mall.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

import java.util.HashMap;
import java.util.Iterator;
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

    public Map<String,Object> getProductPage(Map<String,Object> params){
        Map<String,Object> result = new HashMap<String,Object>();
        Pageable page = PageRequest.of(Integer.parseInt(params.get("currentPage").toString()),Integer.parseInt(params.get("pageSize").toString()));
        Page<Product> p = productRepository.findAll(page);
        result.put("productList",p.getContent());
        result.put("total",p.getTotalPages());
        return result;
    }

}
