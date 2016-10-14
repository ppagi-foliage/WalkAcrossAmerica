package com.waa.application;

import java.util.Arrays;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication 
@ComponentScan("com.waa")
@EnableMongoRepositories("com.waa.core.entity.dao")
public class WalkAcrossAmericaApplication
{
    private static Log log = LogFactory.getLog(WalkAcrossAmericaApplication.class);
    
    public static void main(String[] args)
    {
        log.info("Starting WalkAcrossAmericaApplication");
        ApplicationContext ctx = SpringApplication.run(WalkAcrossAmericaApplication.class, args);
        
        String[] beanNames = ctx.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for (String beanName : beanNames) {
            log.debug(beanName);
        }
    }
}
