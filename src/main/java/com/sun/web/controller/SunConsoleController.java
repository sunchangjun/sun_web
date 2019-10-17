package com.sun.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.sun.web.dao.IptvResVerDao;
import com.sun.web.domain.EasyUiBaseQuery;
import com.sun.web.domain.EasyUiListResult;
import com.sun.web.domain.IptvResVer;
import com.sun.web.enums.IptvObjectEnum;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author ：suncj
 * @date ：2019/10/11 14:37
 */

@Controller
@Log4j2
public class SunConsoleController {
    @Autowired
    IptvResVerDao iptvResVerDao;

    @GetMapping("programlist")
    public String list(String type, Model model) {
        model.addAttribute("type", type);
        log.debug("跳转资源页面:" + type);

        return "program/list";
    }

    @GetMapping("listData")
    @ResponseBody
    public Object listData(EasyUiBaseQuery query, HttpServletRequest req) {
        EasyUiListResult<IptvResVer> result = new EasyUiListResult<IptvResVer>();
        int i = iptvResVerDao.consoleResListByTypeCount(query);
        result.setTotal(i);
        List<IptvResVer> vers = this.iptvResVerDao.consoleResListByType(query, (query.getPage() - 1) * query.getRows(), query.getRows());
        result.setRows(vers);
        log.debug("返回数据:listData");
        return result;
    }

    /**
     * 修改资源免费状态
     * @return
     */
    @RequestMapping(value="editorResfreeStatus", produces = "application/json; charset=utf-8")
    @ResponseBody
    public Object editorResfreeStatus(Long rid,Integer free) {
        try {
        } catch (Exception e) {
            e.printStackTrace();
            return new JsonResult(false, "操作失败:"+e.getMessage(), null);
        }
        log.debug("修改免费-按钮");
        return new JsonResult(true, "操作成功!!!!", null);
    }

    /**
     * 分类管理界面,包括(歌手分类 ,歌曲分类,MV分类,歌单分类,榜单分类)
     *
     * @param type
     * @return
     */
    @GetMapping("catelist")
    public Object catelist(String type, Model model) {
        model.addAttribute("type", type);
        log.debug("加载cate/list页面");
        return "cate/list";
    }

    /**
     * 分类列表数据
     *
     * @param type
     * @return
     */
    @GetMapping("catelistata")
    @ResponseBody
    public Object catelistata(String type, Model model) {
        List<IptvResVer> vers = this.iptvResVerDao.findResListByTypeAndChildType(IptvObjectEnum.cate,  IptvObjectEnum.valueOf(type), 0, 1000000, true);
        EasyUiListResult<IptvResVer> result = new EasyUiListResult<IptvResVer>();
        result.setTotal(vers.size());
        result.setRows(vers);
        log.debug("返回catelistata数据");
        return result;
    }

    @RequestMapping("getResList")
    @ResponseBody
    public Object getResList(Long prid) {
        /*
         * 比较算法分析
         * 1-当以前有的资源被global_disable时,两个环境都不会查到
         * 2-当test有,生产无,这是运营平台新增link,此时test_vid与prod_vid不同,prod_vid为0
         * 3-当test有,生产有,这时候要比较版本是不是相同,判断是否有修改
         * 3-当test无,生产有,这是test进行了删除,此时test_vid和prod_vid一定不同
         */
        List<IptvResVer> vers = this.iptvResVerDao.findResListPageable(null,null,prid,null,0,100000,true);
        for(IptvResVer ver : vers){
            ver.setAvailable(true);
        }

        EasyUiListResult<IptvResVer> result = new EasyUiListResult<IptvResVer>();
        result.setTotal(vers.size());
        result.setRows(vers);
        // add by zhangsl at 2019-06-03 begin
        result.setStatus(true);
        List<IptvResVer> prod_vers = this.iptvResVerDao.findResListPageable(null,null,prid,null,0,100000,false);
        for(IptvResVer ver : vers){
            ver.setAvailable(true);
        }
        if (prod_vers.size() != vers.size()) {
            result.setStatus(false);
        } else {
            for (IptvResVer ver : vers) {
                if (ver.getLink_test_vid().longValue() != ver.getLink_prod_vid().longValue()) {
                    result.setStatus(false);
                    return result;
                }
            }
            for (IptvResVer ver : prod_vers) {
                if (ver.getLink_test_vid().longValue() != ver.getLink_prod_vid().longValue()) {
                    result.setStatus(false);
                    return result;
                }
            }
        }
        log.debug("返回getResList数据");
        return result;
    }

    /**
     * 编辑并保存修改后的ver,所有的[资源管理]下的对象类型,在编辑后进行保存时都使用了这个方法
     */
    @RequestMapping("editorProgram")
    @ResponseBody
    public Object editorProgram(IptvResVer ver, MultipartFile iptvBigPoster, MultipartFile iptvSmallPoster, HttpServletRequest req) throws Exception {

        return new JsonResult();
    }

    }
