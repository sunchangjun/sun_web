package com.sun.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@EnableScheduling
@SpringBootApplication
@EnableTransactionManagement(proxyTargetClass = true)
@ServletComponentScan("com.sun.web")
//@EnableRedisHttpSession
public class SunWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(SunWebApplication.class, args);

    }

}
