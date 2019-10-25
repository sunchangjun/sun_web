package com.sun.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.sun.web.dao.IptvOrderResultCodeDao;
import com.sun.web.domain.EasyUiListResult;
import com.sun.web.entity.IptvOrderResultCode;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Date;
import java.util.List;

/**
 * @author ：suncj
 * @date ：2019/10/21 17:24
 */
@Controller
@CrossOrigin
@Log4j2
public class SunConsoleStatisController {

    @Autowired
    private IptvOrderResultCodeDao iptvOrderResultCodeDao;

    /*获取订单回调统计*/
    @PostMapping("getOrderResultTable")
    @ResponseBody
    public Object getOrderResultTable(String beginTime, String endTime, MultipartFile file, Model model){
        EasyUiListResult<IptvOrderResultCode> result = new EasyUiListResult<IptvOrderResultCode>();
        try {
            log.info("beginTime={},endTime={}",beginTime,endTime);
            if(null != file){
               log.info("file={}",file.getOriginalFilename());
                String path="F:/"+file.getOriginalFilename();
                File newFile=new File(path);
                //通过CommonsMultipartFile的方法直接写文件（注意这个时候）
                file.transferTo(newFile);
            }else{
                log.error("上传文件=null");
            }
            List<IptvOrderResultCode> list = iptvOrderResultCodeDao.findByTimeBetten(beginTime, endTime);
            result.setTotal(list.size());
            result.setRows(list);
            log.info("返回数据:list={}", JSONObject.toJSONString(list));
        }catch(Exception e){
            e.printStackTrace();
        }
        return  result;
    }
}
