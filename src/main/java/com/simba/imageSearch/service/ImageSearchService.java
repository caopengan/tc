package com.simba.imageSearch.service;

import com.simba.imageSearch.utils.AuthService;
import com.simba.imageSearch.utils.HttpClientUtils;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
@Service
public class ImageSearchService {

    public static final String similar_add_url = "https://aip.baidubce.com/rest/2.0/image-classify/v1/realtime_search/similar/add";

    public int similarImageAdd(Map<String,String> opt){
        // 传入可选参数调用接口
//        HashMap<String, String> options = new HashMap<String, String>();
//        options.put("brief", "{\"name\":\"周杰伦\", \"id\":\"666\"}");
//        options.put("tags", "100,11");
//
//
//        // 参数为本地路径
//        String image = "test.jpg";
//        JSONObject res = client.similarAdd(image, options);
//        System.out.println(res.toString(2));
//
//        // 参数为二进制数组
//        byte[] file = readFile("test.jpg");
//        res = client.similarAdd(file, options);
//        System.out.println(res.toString(2));
        //result:{"access_token":"24.9bd407bb00739ccf4e1b6cc354027e09.2592000.1537776924.282335-11727550","session_key":"9mzdAqBOSlqtonCCrVX0OzeH+qIf3rvMSi4\/JkU+ynPGtoLq3cHlctnYviHypOeDa2oUdh3e\/ZsLENLfYNP5s0k4cyy1Gg==","scope":"public brain_all_scope vis-classify_\u5b9e\u65f6\u68c0\u7d22-\u76f8\u4f3c brain_realtime_same_hq brain_realtime_similar brain_realtime_product wise_adapt lebo_resource_base lightservice_public hetu_basic lightcms_map_poi kaidian_kaidian ApsMisTest_Test\u6743\u9650 vis-classify_flower lpq_\u5f00\u653e cop_helloScope ApsMis_fangdi_permission smartapp_snsapi_base iop_autocar oauth_tp_app smartapp_smart_game_openapi","refresh_token":"25.277a62ed2f63cd577fb0de18697407c3.315360000.1850544924.282335-11727550","session_secret":"7a2613b0344d2e3e1b7447c2743c4c7c","expires_in":2592000}
        String access_token1="24.9bd407bb00739ccf4e1b6cc354027e09.2592000.1537776924.282335-11727550";//有效期1个月
//        String url = similar_add_url+"?access_token="+ AuthService.getAuth();
        String url = similar_add_url+"?access_token="+ access_token1;
        String s = HttpClientUtils.doPost(url, opt);
        System.out.println("=============="+s);
        return 1;
    }

}
