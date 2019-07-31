package com.sun.web.cronjob;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author ：suncj
 * @date ：2019/7/29 10:21
 */
@Component
public class LogTask {
    private static final Logger log = LoggerFactory.getLogger(LogTask.class);
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    @Scheduled(cron = "* 56 10 * * *")
    public void test() {
        log.info("当前时间={}",sdf.format(new Date()));
    }
}
