package com.sun.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.sun.web.dao.IptvConsolePrivilegeDao;
import com.sun.web.domain.IptvConsolePrivilege;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author ：suncj
 * @date ：2019/7/17 10:10
 */
@CrossOrigin
@Controller
@Log4j2
public class SunWebLoginController {
    @Autowired
    private IptvConsolePrivilegeDao privilegeDao;

    private ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();

    @ApiOperation(value="获取用户详细信息", notes="根据url的id来获取用户详细信息")
    @ApiImplicitParam(name = "id", value = "用户ID", required = false, dataType = "Integer", paramType = "path")
    @GetMapping("/login_html")
    public String swagger_login(){
        return "/login/login.html";
    }
    @GetMapping("/login")
    @ResponseBody
    public JsonResult  login(){
        return new JsonResult(true,"www.baidu.com");
    }

    @GetMapping("/consolelogin")
    public String  consolelogin(Model model){
        List<IptvConsolePrivilege> topPrivileges = privilegeDao.findTopPrivileges();
        List<IptvConsolePrivilege> rolePrivileges =  privilegeDao.findPrivilegesByRoleId(1);
        boolean layout = false;
        for(int i=0;i<topPrivileges.size();i++){
            IptvConsolePrivilege top = topPrivileges.get(i);
            int j = 0;
            for (IptvConsolePrivilege p : rolePrivileges) {
                if(p.getParent_id()==null&&"layout".equals(p.getUrl())){
                    //栏目管理
                    layout = true;
                    continue;
                }
                if(p.getParent_id()==top.getId()){
                    j++;
                    top.getChilds().add(p);
                }
            }
            if(j==0&&!layout){
                topPrivileges.remove(top);
                i--;
            }
        }




        log.info("返回栏目数据");
        model.addAttribute("privileges", topPrivileges);
        return "index";
    }
    @GetMapping("/404")
    public String get404(){

        return "404";
    }


}
