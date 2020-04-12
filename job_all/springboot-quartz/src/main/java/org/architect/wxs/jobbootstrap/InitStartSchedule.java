package org.architect.wxs.jobbootstrap;

import org.architect.wxs.task.TestTask2;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class InitStartSchedule implements ApplicationRunner{
    public void run(ApplicationArguments args) throws Exception {
        SchedulerFactory sf = new StdSchedulerFactory();
        Scheduler scheduler = sf.getScheduler();
        scheduler.start();
        JobDetail jobDetail = createJobDetail("job1","group1");
        Trigger trigger = createTrigger("trigger1","group1");
        scheduler.scheduleJob(jobDetail, trigger);
    }

    protected JobDetail createJobDetail(String jobName, String jobGroup){
        return JobBuilder.newJob(TestTask2.class)
                .withIdentity(jobName, jobGroup)
                .build();
    }

    protected Trigger createTrigger(String triggerName, String triggerGroup){
        return  TriggerBuilder.newTrigger()
                .withIdentity(triggerName, triggerGroup)
                .withSchedule(
                        SimpleScheduleBuilder.simpleSchedule()
                                .withIntervalInSeconds(5)
                                .repeatForever()
                ).build();
    }
}
