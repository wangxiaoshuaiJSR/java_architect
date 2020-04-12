package org.architect.wxs.config;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigrableScheduler {
    @Bean
    public Scheduler scheduler(){
        Scheduler scheduler =null;
        try {
            // 通过SchedulerFactory获取一个调度器实例
            SchedulerFactory sf = new StdSchedulerFactory();
            scheduler = sf.getScheduler();
            // 启动调度器
            scheduler.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return scheduler;
    }
}
