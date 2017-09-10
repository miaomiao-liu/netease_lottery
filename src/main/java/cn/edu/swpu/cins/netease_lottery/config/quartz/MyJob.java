package cn.edu.swpu.cins.netease_lottery.config.quartz;

import cn.edu.swpu.cins.netease_lottery.exception.WinningException;
import cn.edu.swpu.cins.netease_lottery.service.WinningService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * Created by miaomiao on 17-8-5.
 */
@Component
public class MyJob implements Job,Serializable{
    private static final long serialVersionUID = 1L;
    private static final Logger logger= LoggerFactory.getLogger(MyJob.class);


    @Autowired
    private WinningService winningService;
//    @Autowired
//    private WinningDao winningDao;
//    @Autowired
//    GenerateWinNumber generateWinNumber;


    public MyJob() {
    }




//            //产生中奖号码
//        WinningDetail winningDetail = new WinningDetail();
//        List<Integer> numbers = generateWinNumber.generateNumber();
//        winningDetail.setWinNumber(numbers);
//        winningDetail.setBigSmall(generateWinNumber.bigSmallCompare(numbers));
//        winningDao.addLotteryDetail(winningDetail);

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("Hello World!");
        try {
            winningService.addWinDetail();
        } catch (WinningException e) {
            e.printStackTrace();
        }
    }
}