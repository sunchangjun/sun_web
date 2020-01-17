package com.sun.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.sun.web.dao.IptvConfigDao;
import com.sun.web.domain.EasyUiListResult;
import com.sun.web.domain.IptvConfig;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ：suncj
 * @date ：2019/11/7 15:01
 */
@Controller
@CrossOrigin
@Log4j2
public class IptvConfigController {
    @Autowired
    IptvConfigDao iptvConfigDao;

    @PostMapping("findAllIptvConfig")
    @ResponseBody
    public Object findAllIptvConfig(){
        EasyUiListResult<IptvConfig> result = new EasyUiListResult<IptvConfig>();
        try {
            List<IptvConfig> ipconfigs=iptvConfigDao.findAll();
            if(!CollectionUtils.isEmpty(ipconfigs)){
                result.setTotal(ipconfigs.size());
                result.setRows(ipconfigs);
                result.setStatus(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    @PostMapping("saveIptvConfig")
    @ResponseBody
    public JsonResult saveIptvConfig( IptvConfig iptvConfig){
        JsonResult result=new  JsonResult();
        log.info(JSONObject.toJSONString(iptvConfig));

        return result;
    }
    @PostMapping("deleteIptvConfig")
    @ResponseBody
    public JsonResult deleteIptvConfig(Long id){
        JsonResult result=new  JsonResult();
        log.info(JSONObject.toJSONString(id));

        return result;
    }
}
