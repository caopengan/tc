package com.simba.spider.service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import com.google.common.collect.Lists;
import com.simba.common.util.UtilDateTime;
import com.simba.mall.entity.Product;
import com.simba.mall.repository.ProductRepository;
import com.simba.spider.common.HttpClientUtils;
import com.simba.spider.entity.GoodsInfo;
import com.simba.spider.repository.GoodsInfoRepository;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Service;

@Service
public class SpiderService {
    private static Logger logger = LoggerFactory.getLogger(SpiderService.class);
    private static String HTTPS_PROTOCOL = "https:";
    @Autowired
    private GoodsInfoRepository goodsInfoRepository;
    
    @Autowired
    private ProductRepository productRepository;

    public void spiderData(String url, Map<String, String> params) {
        String html = HttpClientUtils.sendGet(url, null, params);
        if(!StringUtils.isBlank(html)) {
            List<GoodsInfo> goodsInfos =parseJDHtml(html);
            for(GoodsInfo gi:goodsInfos){
                System.out.println("-----------"+gi);
                goodsInfoRepository.save(gi);
//                goodsInfoRepository.insertJDGoods(gi.getGoodsId(),gi.getGoodsName(),gi.getImgUrl(),gi.getGoodsPrice());
            }
//            goodsInfoDao.saveBatch(goodsInfos);
        }
    }

    public void spiderJDData(String url, Map<String, String> params) {
        String html = HttpClientUtils.sendGet(url, null, params);
        if(!StringUtils.isBlank(html)) {
            List<Product> productList =parseJdProductHtml(html);
            productRepository.saveAll(productList);
        }
        
    }

    /**
     * 解析html
     * @param html
     */
    private List<GoodsInfo> parseJDHtml(String html) {
        //商品集合
        List<GoodsInfo> goods = Lists.newArrayList();
        /**
         * 获取dom并解析
         */
        Document document = Jsoup.parse(html);
        Elements elements = document.
                select("ul[class=gl-warp clearfix]").select("li[class=gl-item]");
        int index = 0;
        for(Element element : elements) {
            String goodsId = element.attr("data-sku");
            String goodsName = element.select("div[class=p-name p-name-type-2]").select("em").text();
            String goodsPrice = element.select("div[class=p-price]").select("strong").select("i").text();
            String imgUrl = HTTPS_PROTOCOL + element.select("div[class=p-img]").select("a").select("img").attr("source-data-lazy-img");
            GoodsInfo goodsInfo = new GoodsInfo(goodsId, goodsName, imgUrl, Double.parseDouble(goodsPrice));
            goods.add(goodsInfo);
            String jsonStr = JSON.toJSONString(goodsInfo);
            logger.info("成功爬取【" + goodsName + "】的基本信息 ");
            logger.info(jsonStr);
            if(index ++ == 9) {
                break;
            }
        }
        return goods;
    }

    /**
     * 解析html
     * @param html
     */
    private List<Product> parseJdProductHtml(String html) {
        //商品集合
        List<Product> products = Lists.newArrayList();
        /**
         * 获取dom并解析
         */
        Document document = Jsoup.parse(html);
        Elements elements = document.
                select("ul[class=gl-warp clearfix]").select("li[class=gl-item]");
        int index = 0;
        Timestamp now = UtilDateTime.nowTimestamp();
        for(Element element : elements) {
            String productId = element.attr("data-sku");
            String productName = element.select("div[class=p-name p-name-type-2]").select("em").text();
            String productPrice = element.select("div[class=p-price]").select("strong").select("i").text();
            String imgUrl = HTTPS_PROTOCOL + element.select("div[class=p-img]").select("a").select("img").attr("source-data-lazy-img");
            Product p = new Product();
            p.setCreatedDateTime(now);
            p.setProductId(productId);
            p.setProductMainImage(imgUrl);
            p.setProductName(productName);
            p.setProductPrice(Double.parseDouble(productPrice));
            p.setUpdatedDateTime(now);
            products.add(p);
            String jsonStr = JSON.toJSONString(p);
            logger.info("成功爬取【" + productName + "】的基本信息 ");
            logger.info(jsonStr);
            if(index ++ == 9) {
                break;
            }
        }
        return products;
    }
}
