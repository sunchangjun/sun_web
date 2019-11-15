package com.sun.web.dao;

import com.sun.web.SunWebApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author ：suncj
 * @date ：2019/7/24 9:59
 */
@SpringBootTest(classes = SunWebApplication.class)
@RunWith(SpringRunner.class)
public class RedisTest {
    @Autowired
    private RedisService redisService;
    @Test
    public void  testSetRedis(){
        redisService.set("test_reids",1);
    }
}
