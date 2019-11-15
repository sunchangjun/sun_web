package com.sun.web.dao;

import com.alibaba.fastjson.JSONObject;
import com.sun.web.SunWebApplication;
import com.sun.web.domain.IptvConfig;
import com.sun.web.domain.IptvConsolePrivilege;
import lombok.extern.log4j.Log4j2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author ：suncj
 * @date ：2019/10/10 14:31
 */
@SpringBootTest(classes = SunWebApplication.class)
@RunWith(SpringRunner.class)
@Log4j2
public class MysqlTest {
    @Autowired
    IptvConfigDao iptvConfigDao;
    @Autowired
    private IptvConsolePrivilegeDao privilegeDao;

    @Test
    public void  test(){
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
        log.info(JSONObject.toJSONString(topPrivileges));
        log.info(JSONObject.toJSONString(rolePrivileges));
    }

}
