package com.lfz.demo.config;

import com.github.pagehelper.PageInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MybatisPlusConfig {
    /*
    * pageHelp插件配置
    * */
    @Bean
    public PageInterceptor pageInterceptor(){
        return new PageInterceptor();
    }
}
