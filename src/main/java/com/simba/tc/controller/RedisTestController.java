package com.simba.tc.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.simba.redis.common.util.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.cache.CacheProperties;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static javafx.scene.input.KeyCode.T;

@RestController
public class RedisTestController {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping("/addRedisData")
    public void addRedisData(){
        List<String> list =new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("v");
        stringRedisTemplate.opsForValue().set("abc", "测试");
        stringRedisTemplate.opsForValue().set("cpa", "11111");
        stringRedisTemplate.opsForList().leftPushAll("qq",list); // 向redis存入List
        stringRedisTemplate.opsForList().range("qwe",0,-1).forEach(value ->{
            System.out.println(value);
        });
    }

    @RequestMapping("/batchAddRedisData")
    public int batchAddRedisData(){
        String jsonStr = RedisUtils.getDatafromFile("product");
        Map<String,Object> map = (Map<String,Object>)JSON.parse(jsonStr);
        List<Map<String,Object>> categoryList = (List<Map<String,Object>>)map.get("categoryList");
        List<Map<String,Object>> productList = (List<Map<String,Object>>)map.get("productList");
//        byte[] serialize = RedisUtils.serialize(productList);
        String abc = stringRedisTemplate.opsForValue().get("abc");
        System.out.println("abc===="+abc);
        redisTemplate.opsForList().leftPushAll("categoryList",categoryList);
        redisTemplate.opsForList().leftPushAll("clearProductList",productList);
        return 0;
    }

    @RequestMapping("/getRedisListData")
    public void getRedisListData(){
        List<Map<String,Object>> list = redisTemplate.opsForList().range("categoryList",0,-1);
        System.out.println(list.toString());
        List<Map<String,Object>> plistUnSerio = redisTemplate.opsForList().range("clearProductList",0,-1);
//        List<Map<String, Object>> plist = RedisUtils.unserializeForList(plistUnSerio);
        System.out.println(plistUnSerio.toString());
    }


}
