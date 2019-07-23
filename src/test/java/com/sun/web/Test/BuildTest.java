package com.sun.web.Test;

import com.alibaba.fastjson.JSONObject;
import com.sun.web.design_patterns.BuilderMode;
import com.sun.web.design_patterns.BuilderMode.ConcreteBuilder;
import com.sun.web.design_patterns.CombinationMode;
import org.junit.Test;

/**
 * @author ：suncj
 * @date ：2019/7/22 17:52
 */
public class BuildTest {


    public void testBuilderMode(){
        BuilderMode BuilderMode1=new ConcreteBuilder().buildId("10001").buildName("scj").build();
        System.out.println(JSONObject.toJSONString(BuilderMode1));
    }

    @Test
    public void testCombinationMode(){
        CombinationMode.Composite composite=new CombinationMode.Composite("总部","管理各部门");
        composite.add(new CombinationMode.Leaf("技术部","技术开发"));
        composite.add(new CombinationMode.Composite("设计部","设计产品").add(new CombinationMode.Leaf("ui","设计图片")).add(new CombinationMode.Leaf("cmd","设计结构")));
        composite.add(new CombinationMode.Leaf("运营部","市场推广"));
        composite.display(10);
        System.out.println(JSONObject.toJSONString(composite));

    }
}
