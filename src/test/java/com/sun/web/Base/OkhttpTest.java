package com.sun.web.Base;

import com.sun.web.SunWebApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：suncj
 * @date ：2019/7/12 17:09
 */
@SpringBootTest(classes = SunWebApplication.class)
@RunWith(SpringRunner.class)
public class OkhttpTest {
    private static Logger log = LoggerFactory.getLogger(OkhttpTest.class);

    @Test
    public void test(){
        String response=null;
        Map<String,String> map=new HashMap<>();
        map.put("mac","123456");
        map.put("userId","10086");
        map.put("prid","3306");
        map.put("rid","4133");
        map.put("test","true");

//        try {
//            response= OkHttp3Util.httpPostFormReturnString("http://fjydimg.recomusic.net/iptv-fjyd/stb/get_mv_info",map);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        log.info(response);
    }



}
