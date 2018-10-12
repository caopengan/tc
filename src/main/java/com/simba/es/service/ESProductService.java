package com.simba.es.service;

import com.simba.common.util.UtilDateTime;
import com.simba.common.util.UtilValidate;
import com.simba.es.entity.ESProductInfo;
import com.simba.es.repository.ESProductRepository;
import com.simba.mall.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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

    public int addProduct(ESProductInfo esProductInfo){
        ESProductInfo pi = ESProductRepository.save(esProductInfo);
        if(UtilValidate.isNotEmpty(pi)){
            return 1;
        }
        return 0;
    }

    public int deleteProduct(){
        ESProductRepository.deleteAll();

        return 1;
    }

    /**
     * 批量导入商品数据
     * @param pList
     * @return
     */
    public int batchSaveProduct(List<Product> pList){
        List<ESProductInfo> espList = new ArrayList<ESProductInfo>();
        Timestamp now = UtilDateTime.nowTimestamp();
        for(Product p :pList){
            ESProductInfo esp = new ESProductInfo();
            esp.setId(p.getId());
            esp.setProductId(p.getProductId());
            esp.setProductName(p.getProductName());
            esp.setProductPrice(p.getProductPrice());
//            esp.setInventory(Long.valueOf(p.get("").toString()));
            esp.setCreatedDateTime(now);
            esp.setUpdatedDateTime(now);
            espList.add(esp);
        }
        Iterable<ESProductInfo> esProductInfos = ESProductRepository.saveAll(espList);
        Iterator<ESProductInfo> iterator = esProductInfos.iterator();
        int c = 0;
        while (iterator.hasNext()){
            c++;
        }
        return c;

    }

}
