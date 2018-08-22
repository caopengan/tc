package com.simba.tc.controller;

import com.simba.spider.entity.GoodsInfo;
import com.simba.spider.handler.SpiderHandler;
import com.simba.spider.repository.GoodsInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpiderController {
    @Autowired
    private GoodsInfoRepository goodsInfoRepository;

    @Autowired
    private SpiderHandler spiderHandler;
    @RequestMapping("/save")
    public int save(String goodsId, String goodsName, String imgUrl, Double goodsPrice) {
//        Person person = personRepository.save(new Person(null, name, age, address));
//        GoodsInfo goodsInfo = goodsInfoRepository.save(new GoodsInfo(goodsId,goodsName,imgUrl,goodsPrice));
        spiderHandler.spiderData();
        return 1;
    }
}
