package com.sun.web.Test;

import com.alibaba.fastjson.JSONObject;
import com.sun.web.entity.BuilderMode;
import com.sun.web.entity.BuilderMode.ConcreteBuilder;
import org.junit.Test;

/**
 * @author ：suncj
 * @date ：2019/7/22 17:52
 */
public class BuildTest {

    @Test
    public void test(){
        BuilderMode BuilderMode1=new ConcreteBuilder().buildId("10001").buildName("scj").build();
        System.out.println(JSONObject.toJSONString(BuilderMode1));
    }
}
