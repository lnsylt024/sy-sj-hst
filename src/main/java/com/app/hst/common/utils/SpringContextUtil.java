package com.app.hst.common.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class SpringContextUtil implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringContextUtil.applicationContext = applicationContext;
    }

    public static ApplicationContext getApplicationContext(){
        return applicationContext;
    }

    /**
     * 通过beanName获取Bean
     */
    @SuppressWarnings("unchecked")
    public static <T> T getBean(String beanName) throws BeansException{
        if(null == applicationContext){
            return null;
        }
        return (T) applicationContext.getBean(beanName);
    }

    /**
     * 通过class获取Bean
     */
    @SuppressWarnings("unchecked")
    public static <T> T getBean(Class<?> clz) throws BeansException{
        if(null == applicationContext){
            return null;
        }
        return (T) applicationContext.getBean(clz);
    }

    /**
     * 通过name、clazz返回指定的Bean
     */
    public static <T> T getBean(String name, Class<T> clz) throws BeansException{
        return (T) getApplicationContext().getBean(name,clz);
    }

}
