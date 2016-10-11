package com.waa.application;

import java.util.Arrays;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication  
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
        log.info("Started WalkAcrossAmericaApplication");
    }
}
