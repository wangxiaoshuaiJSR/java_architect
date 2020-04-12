package org.architect.wxs.controller;

import org.architect.wxs.domain.RequestDto;
import org.architect.wxs.service.SchedulerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JobController {
    @Autowired
    SchedulerService schedulerService;

    @PostMapping("/addJob")
    public void addJob(@RequestBody RequestDto requestDto) throws Exception {
        //String jobClassName,String jobName, String jobGroupName, String cronExpression
        schedulerService.addJob(requestDto.getJobClassName(),requestDto.getJobName(),requestDto.getJobGroupName(),requestDto.getCronExpression());
    }

    @PostMapping("/test")
    public void test(@RequestBody RequestDto requestDto) throws Exception {
        System.out.println(requestDto.toString());
    }

    @PostMapping("/updateState")
    public void updateState(@RequestBody RequestDto requestDto) throws Exception {
        schedulerService.updateState(requestDto.getJobName(),requestDto.getJobGroupName());
    }

    @PostMapping("/resumJob")
    public void resumJob(@RequestBody RequestDto requestDto) throws Exception {
        schedulerService.resumJob(requestDto.getJobName(),requestDto.getJobGroupName());
    }
    @PostMapping("/pauseJob")
    public void pauseJob(@RequestBody RequestDto requestDto) throws Exception {
        schedulerService.pauseJob(requestDto.getJobName(),requestDto.getJobGroupName());
    }

}
