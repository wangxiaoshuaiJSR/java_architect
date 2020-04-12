package org.architect.wxs.service;

import org.architect.wxs.task.BaseJob;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SchedulerService {
    @Autowired
    private Scheduler scheduler;

    /**
     * 新增定时任务
     * @param jobClassName 类路径
     * @param jobName 任务名称
     * @param jobGroupName 组别
     * @param cronExpression Cron表达式
     * @throws Exception
     */
    public void addJob(String jobClassName,String jobName, String jobGroupName, String cronExpression) throws Exception {
        // 构建job信息
        JobDetail jobDetail =createJobDetail(jobClassName,jobName,jobGroupName);
        // 表达式调度构建器(即任务执行的时间)
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(cronExpression);
        // 按新的cronExpression表达式构建一个新的trigger
        CronTrigger trigger = createTrigger(scheduleBuilder,jobName,jobGroupName);
        try {
            scheduler.scheduleJob(jobDetail, trigger);
        } catch (SchedulerException e) {
            throw new Exception("创建定时任务失败");
        }
    }
    //删除
    public void updateState(String jobName, String jobGroupName) throws Exception {
        TriggerKey triggerKey = TriggerKey.triggerKey(jobName, jobGroupName);
        Boolean state = scheduler.checkExists(triggerKey);
        scheduler.pauseTrigger(TriggerKey.triggerKey(jobName, jobGroupName));
        scheduler.unscheduleJob(TriggerKey.triggerKey(jobName, jobGroupName));
        if(state){
            scheduler.deleteJob(JobKey.jobKey(jobName, jobGroupName));
        }
    }

    //激活
    public void resumJob(String jobName, String jobGroupName) throws SchedulerException {
        scheduler.pauseJob(JobKey.jobKey(jobName, jobGroupName));
        scheduler.resumeJob(JobKey.jobKey(jobName, jobGroupName));
    }

    //停止
    public void pauseJob(String jobName, String jobGroupName) throws SchedulerException {
        scheduler.pauseJob(JobKey.jobKey(jobName, jobGroupName));
    }
    //修改cro表达式
    public void updateCronExpression(String jobName, String jobGroupName,String cronExpression) throws SchedulerException {
        TriggerKey triggerKey = TriggerKey.triggerKey(jobName, jobGroupName);
        // 表达式调度构建器
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(cronExpression);
        CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);
        // 按新的cronExpression表达式重新构建trigger
        trigger = trigger.getTriggerBuilder().withIdentity(triggerKey).withSchedule(scheduleBuilder).startNow().build();
        // 按新的trigger重新设置job执行
        scheduler.rescheduleJob(triggerKey, trigger);
    }






    protected JobDetail createJobDetail(String jobClassName,String jobName, String jobGroup) throws Exception {
        return JobBuilder.newJob(getClass(jobClassName).getClass())
                .withIdentity(jobName, jobGroup).build();
    }

    protected CronTrigger createTrigger(CronScheduleBuilder scheduleBuilder,String triggerName, String triggerGroup){
        return  TriggerBuilder.newTrigger().withIdentity(triggerName, triggerGroup)
                .withSchedule(scheduleBuilder).startNow().build();
    }
    /**
     * 获取Job实例
     * @param classname
     * @return
     * @throws Exception
     */
    public BaseJob getClass(String classname) throws Exception {
        try {
            Class<?> c = Class.forName(classname);
            return (BaseJob) c.newInstance();
        } catch (Exception e) {
            throw new Exception("类["+classname+"]不存在！");
        }

    }
}
