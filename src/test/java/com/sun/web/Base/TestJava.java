package com.sun.web.Base;

import com.utils.Md5Utils;
import lombok.extern.log4j.Log4j2;
import org.junit.Test;

/**
 * @author ：suncj
 * @date ：2019/10/31 14:49
 */
@Log4j2
public class TestJava {

    @Test
    public void buildPassword(){
       String password= Md5Utils.encode("123456");
       log.info(password);
    }
}
