package com.simba.es.service;

import com.simba.common.util.UtilDateTime;
import com.simba.common.util.UtilValidate;
import com.simba.es.entity.ESProductInfo;
import com.simba.es.repository.ESProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class ESProductService {

    @Autowired
    private ESProductRepository ESProductRepository;

    public int saveProduct(Long inventory,String productName,String productId,Double productPrice){
        ESProductInfo esProductInfo = new ESProductInfo();
        Timestamp now = UtilDateTime.nowTimestamp();
        esProductInfo.setCreatedDateTime(now);
        esProductInfo.setUpdatedDateTime(now);
        esProductInfo.setInventory(inventory);
        esProductInfo.setProductName(productName);
        esProductInfo.setProductId(productId);
        esProductInfo.setProductPrice(productPrice);
        ESProductInfo pi = ESProductRepository.save(esProductInfo);
        if(UtilValidate.isNotEmpty(pi)){
            return 1;
        }
        return 0;
    }

}
