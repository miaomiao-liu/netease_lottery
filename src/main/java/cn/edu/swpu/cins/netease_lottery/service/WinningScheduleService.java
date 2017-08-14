package cn.edu.swpu.cins.netease_lottery.service;

import org.quartz.SchedulerException;

/**
 * Created by miaomiao on 17-8-8.
 */
public interface WinningScheduleService {
    public void schedule() throws SchedulerException;
}
