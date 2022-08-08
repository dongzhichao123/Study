package com.example.springboot_demo.quartz;

import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuartzConfig {
//    @Bean
    public JobDetail testJobDetail() {
        return JobBuilder.newJob(TestJob.class).withIdentity("TestJob").storeDurably().build();
    }

//    @Bean
//    public Trigger testTriger() {
//        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule("0/5 * * * * ?");
//        return TriggerBuilder.newTrigger().forJob(testJobDetail()).withIdentity("TestTrigger").withSchedule(cronScheduleBuilder).build();
//    }
}
