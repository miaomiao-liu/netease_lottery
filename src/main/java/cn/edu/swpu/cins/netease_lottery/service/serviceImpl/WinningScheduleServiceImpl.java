package cn.edu.swpu.cins.netease_lottery.service.serviceImpl;

import cn.edu.swpu.cins.netease_lottery.service.WinningScheduleService;
import cn.edu.swpu.cins.netease_lottery.util.WinningJob;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


/**
 * 初始化Bean:
 *import org.springframework.beans.factory.InitializingBean; 的afterPropertiesSet()方法
 * 销毁:
 * import org.springframework.beans.factory.DisposableBean; 的destroy()方法
 * Created by miaomiao on 17-8-5.
 */
@Service
public class WinningScheduleServiceImpl implements WinningScheduleService{

    public void schedule() throws SchedulerException {

        JobDetail jobDetail = JobBuilder
                .newJob(WinningJob.class)
                .withIdentity("job1","group1")
                .build();

        CronTrigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("myTrigger","group1")
                .startNow()
                .withSchedule(CronScheduleBuilder.cronSchedule("0/10 * 8-22 * * ? *"))
                .build();

        SchedulerFactory sfact = new StdSchedulerFactory();
        Scheduler scheduler = sfact.getScheduler();
        scheduler.start();
        scheduler.scheduleJob(jobDetail,trigger);
    }

}
