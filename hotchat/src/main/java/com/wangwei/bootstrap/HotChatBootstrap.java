package com.wangwei.bootstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Auther wangwei
 * @Date 2018/12/11 1:22 PM
 */
@SpringBootApplication(scanBasePackages = "com.wangwei")
public class HotChatBootstrap {
    public static void main(String[] args){
        SpringApplication.run(HotChatBootstrap.class, args);
    }
}
