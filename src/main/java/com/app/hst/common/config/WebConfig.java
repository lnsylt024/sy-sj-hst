package com.app.hst.common.config;

import com.app.hst.common.filter.TokenFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.util.pattern.PathPatternParser;

import javax.servlet.Filter;

@Configuration
public class WebConfig {
    //过滤器-------------------
    @Bean
    public Filter tokenFilter(){
        return new TokenFilter();
    }
    @Bean
    public FilterRegistrationBean tokenFilterRegistration(){
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new DelegatingFilterProxy("tokenFilter"));//与上面的方面名一致
        bean.addUrlPatterns("/*");
        bean.setOrder(1);
        return bean;
    }
    //过滤器-------------------

    public void configurePathMatch(PathMatchConfigurer configurer) {
        configurer.setPatternParser(new PathPatternParser());
    }
}
