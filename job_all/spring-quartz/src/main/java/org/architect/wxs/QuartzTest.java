package org.architect.wxs;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.impl.StdScheduler;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *  单元测试类
 */
public class QuartzTest {

    private static Scheduler scheduler;

    public static void main(String[] args) throws SchedulerException {
        // 获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:/spring_quartz.xml");

        // 从容器中获取调度器
        scheduler = (StdScheduler) ac.getBean("scheduler");

        // 启动调度器
        scheduler.start();
    }

}
