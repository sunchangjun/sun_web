package com.sun.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.sun.web.domain.IptvConfig;
import com.sun.web.domain.IptvConsoleUser;
import com.sun.web.entity.IptvOrderResultCode;
import com.sun.web.enums.ConstantConfig;
import com.utils.Md5Utils;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author ：suncj
 * @date ：2020/1/9 14:18
 */
@Log4j2
@Controller
@CrossOrigin
public class UniAppController {
    @PostMapping("/uni/get_data")
    @ResponseBody
    public JsonResult get_data(String userName, String password, HttpServletRequest request){
        log.info("userName={},password={}",userName,password);
        JsonResult result=new  JsonResult();
        IptvConfig c1=new IptvConfig();
        c1.setKey("select");
        c1.setValue("all");
        result.setBackmsg("成功");
        result.setSuccess(true);
        result.setData(c1);
        return result;
    }


}
