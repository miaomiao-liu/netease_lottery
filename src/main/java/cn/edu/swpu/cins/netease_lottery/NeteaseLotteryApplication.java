package cn.edu.swpu.cins.netease_lottery;

import org.quartz.SchedulerException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NeteaseLotteryApplication {

	public static void main(String[] args) throws SchedulerException {
		SpringApplication.run(NeteaseLotteryApplication.class, args);
	}
}
