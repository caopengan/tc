package com.simba.imageSearch.utils;

import com.baidu.aip.speech.AipSpeech;
import com.baidu.aip.util.Util;
import org.json.JSONObject;

public class ASR {

    //设置APPID/AK/SK
    public static final String APP_ID = "9804966";
    public static final String API_KEY = "DZ3kTwZyEGykyf0pSbP3orAK";
    public static final String SECRET_KEY = "41a5ec243af5d5349e4e917c66e5c85b";

    public void asr() throws Exception{
        // 对本地语音文件进行识别
        // 初始化一个AipSpeech
        AipSpeech client = new AipSpeech(APP_ID, API_KEY, SECRET_KEY);

        // 可选：设置网络连接参数
//        client.setConnectionTimeoutInMillis(2000);
//        client.setSocketTimeoutInMillis(60000);

        // 可选：设置代理服务器地址, http和socket二选一，或者均不设置
//        client.setHttpProxy("proxy_host", proxy_port);  // 设置http代理
//        client.setSocketProxy("proxy_host", proxy_port);  // 设置socket代理

        // 可选：设置log4j日志输出格式，若不设置，则使用默认配置
        // 也可以直接通过jvm启动参数设置此环境变量
//        System.setProperty("aip.log4j.conf", "path/to/your/log4j.properties");


        String path = "D:\\code\\java-sdk\\speech_sdk\\src\\test\\resources\\16k_test.pcm";
        JSONObject asrRes = client.asr(path, "pcm", 16000, null);
        System.out.println(asrRes);

        // 对语音二进制数据进行识别
        byte[] data = Util.readFileByBytes(path);     //readFileByBytes仅为获取二进制数据示例
        JSONObject asrRes2 = client.asr(data, "pcm", 16000, null);
        System.out.println(asrRes2);
    }
}
