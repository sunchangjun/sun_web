package com.sun.web.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

/**
 * 开机启动
 * @author ：suncj
 * @date ：2019/7/4 16:52
 */
//@Component
//@Profile("product")
public class MyCommandRunner implements CommandLineRunner {



    @Override
    public void run(String... args) throws Exception {
        System.out.println("---------------------开始执行任务------------------");
        System.out.println("---------------------任务执行结束------------------");
    }
}
