package com.sun.web.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author ：suncj
 * @date ：2019/7/17 10:10
 */
@Controller
public class LoginController {

    private ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();

    @ApiOperation(value="获取用户详细信息", notes="根据url的id来获取用户详细信息")
    @ApiImplicitParam(name = "id", value = "用户ID", required = false, dataType = "Integer", paramType = "path")
    @GetMapping("/login_html")
    public String swagger_login(){
        System.out.println("1");
        return "/login/login.html";
    }

    @PostMapping("/login_swagger")
    @ResponseBody
    public boolean  login_swagger(String username,String password){
        try {
            System.out.println("login_swagger");

            if ("admin".equals(username) && "123456".equals(password)) {
                return true;
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally {

        }


        return false;
    }


}
