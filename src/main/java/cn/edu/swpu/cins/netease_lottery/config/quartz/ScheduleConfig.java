package cn.edu.swpu.cins.netease_lottery.config.quartz;

import org.quartz.*;
import org.quartz.spi.JobFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import java.io.IOException;

@Configuration
public class ScheduleConfig {

    @Autowired
    private static final Logger logger = LoggerFactory.getLogger(ScheduleConfig.class);

    @Bean
    public JobFactory jobFactory(ApplicationContext applicationContext) {
        AutowiringSpringBeanJobFactory jobFactory = new AutowiringSpringBeanJobFactory();
        jobFactory.setApplicationContext(applicationContext);
        return jobFactory;
    }

    @Bean(name = "myJobTrigger")
    public CronTriggerFactoryBean startDemoJob() throws SchedulerException {
        logger.info("myJob定时任务开始启动......");

        JobDetail jobDetail = JobBuilder.newJob(MyJob.class)
                .withIdentity("myjob", "myJobGroup")
                .build();

        CronTriggerFactoryBean bean = new CronTriggerFactoryBean();
        bean.setJobDetail(jobDetail);
        bean.setCronExpression("0 0/10 8-22 * * ? *");

        logger.info("myJob定时任务启动完成......");
        return bean;
    }


    @Bean(initMethod = "start", destroyMethod = "destroy")
    public SchedulerFactoryBean schedulerFactoryBean(JobFactory jobFactory, Trigger... triggers) throws IOException {
        SchedulerFactoryBean factory = new SchedulerFactoryBean();
        factory.setOverwriteExistingJobs(true);
        factory.setJobFactory(jobFactory);
        factory.setTriggers(triggers);
        return factory;
    }

}
