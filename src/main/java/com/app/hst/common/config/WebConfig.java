package com.app.hst.common.config;

import com.app.hst.common.filter.TokenFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.DelegatingFilterProxy;

import javax.servlet.Filter;

@Configuration
public class WebConfig {
    @Bean
    public Filter tokenFilter(){
        return new TokenFilter();
    }
    @Bean
    public FilterRegistrationBean tokenFilterRegistration(){
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new DelegatingFilterProxy("tokenFilter"));
        bean.addUrlPatterns("/*");
        bean.setName("tokenFilter");
        bean.setOrder(1);
        return bean;
    }
}
