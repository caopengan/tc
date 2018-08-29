package com.simba.imageSearch.controller;

import com.simba.imageSearch.service.ImageSearchService;
import com.simba.imageSearch.utils.ASR;
import com.simba.imageSearch.utils.FingerPrint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.net.URL;

@RestController
public class ImageSearchController {

    @Autowired
    private ImageSearchService imageSearchService;

    @RequestMapping("/similarAdd")
    public void similarImageAdd(){
        Map<String,String> param = new HashMap<String,String>();
        param.put("brief", "{\"name\":\"测试\", \"id\":\"1\"}");
        param.put("tags", "001,002");
//        param.put("url","E:\\5b08cfb3Nb4bd382e.jpg");
        param.put("url","https://img10.360buyimg.com/n7/jfs/t21052/252/290549868/67738/3a1172ef/5b08cfb3Nb4bd382e.jpg");
        imageSearchService.similarImageAdd(param);
    }

    @RequestMapping("/compareImage")
    public void compareImage(String u1,String u2)throws IOException {
        //https://img10.360buyimg.com/n7/jfs/t23644/347/2368548013/106098/6a25a71b/5b7e70ebNe56b7b79.jpg
        //https://img10.360buyimg.com/n7/jfs/t22477/359/2429940774/222725/4c69318f/5b7e70dfNeeb5df03.jpg
        System.out.println("==url1=="+u1+"||=="+u2);
        //读取网络图片
        URL url1 = new URL(u1);
        URL url2 = new URL(u2);
        FingerPrint fp1 = new FingerPrint(ImageIO.read(url1));
        FingerPrint fp2 =new FingerPrint(ImageIO.read(url2));

        //读取本地图片
//        FingerPrint fp1 = new FingerPrint(ImageIO.read(new File("E:\\5b08cfb3Nb4bd382e.jpg")));
//        FingerPrint fp2 =new FingerPrint(ImageIO.read(new File("E:\\5ace10f7N1aad7299.jpg")));
//        System.out.println(fp1.toString(true));
        System.out.printf("sim=%f",fp1.compare(fp2));
    }


    @RequestMapping("/asr")
    public void asr()throws IOException {
        ASR asr = new ASR();
        try {
            asr.asr();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
