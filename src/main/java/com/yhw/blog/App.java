package com.yhw.blog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @Author yhw
 */
@SpringBootApplication
@MapperScan("com.yhw.blog.mapper")
@EnableCaching//开启缓存注解
@ServletComponentScan
public class App {
    public static void main(String args[]){
        SpringApplication.run(App.class,args);
    }
}
