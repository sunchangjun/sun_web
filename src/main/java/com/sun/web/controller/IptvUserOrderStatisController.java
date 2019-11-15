package com.sun.web.controller;

import com.sun.web.dao.IptvConfigDao;
import com.sun.web.dao.IptvUserOrderStatisDao;
import com.sun.web.domain.EasyUiListResult;
import com.sun.web.domain.IptvConfig;
import com.sun.web.entity.IptvUserOrderStatis;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author ：suncj
 * @date ：2019/11/14 10:51
 */
@Controller
@CrossOrigin
@Log4j2
public class IptvUserOrderStatisController {

    @Autowired
    IptvUserOrderStatisDao iptvUserOrderStatisDao;

    @PostMapping("findAllIptvUserOrderStatis")
    @ResponseBody
    public Object findAllIptvConfig(){
        EasyUiListResult<IptvUserOrderStatis> result = new EasyUiListResult<IptvUserOrderStatis>();
        try {
            List<IptvUserOrderStatis> ipconfigs=iptvUserOrderStatisDao.findAll();
            if(CollectionUtils.isNotEmpty(ipconfigs)){
                result.setTotal(ipconfigs.size());
                result.setRows(ipconfigs);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
