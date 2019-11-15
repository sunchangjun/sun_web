package com.sun.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPObject;
import com.google.common.collect.Lists;
import com.sun.web.domain.IptvConsoleUser;
import com.sun.web.enums.ConstantConfig;
import com.sun.web.jdbc.IptvJdbcTemplateDao;
import com.utils.Md5Utils;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author ：suncj
 * @date ：2019/10/25 16:25
 */
@Log4j2
@Controller
@CrossOrigin
public class SunLoginController {
    @Autowired
    IptvJdbcTemplateDao iptvJdbcTemplateDao;

    @GetMapping("/login/loginHtml")
    public String loginHtml(){
        return "login/newlogin";
    }

    @PostMapping("/login/loginVerification")
    @ResponseBody
    public JsonResult login_security(String userName, String password, HttpServletRequest request){
        JsonResult result=new  JsonResult();
        result.setSuccess(false);
        try {
            IptvConsoleUser consoleUser= iptvJdbcTemplateDao.findUserByUserId(userName);
            if(null !=consoleUser && StringUtils.isNotBlank(consoleUser.getPassword()) &&  Md5Utils.encode(password).equals(consoleUser.getPassword()) ){
                HttpSession session=  request.getSession();
                session.setAttribute(ConstantConfig.USER_LOGIN_SESSION, userName);
                Object object=session.getAttribute(ConstantConfig.USER_LOGIN_SESSION);
                log.info("登录成功,存储session={}", JSONObject.toJSONString(object));
                result.setSuccess(true);
                result.setBackmsg("");
                result.setBackmsg("登录成功");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}
