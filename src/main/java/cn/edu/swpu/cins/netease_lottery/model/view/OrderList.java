package cn.edu.swpu.cins.netease_lottery.model.view;

import java.util.List;

/**
 * Created by miaomiao on 17-7-31.
 */
public class OrderList {
    private String lotteryName;
    private List<Integer> lotteryNumber;

    public OrderList() {
    }

    public OrderList(String lotteryName, List<Integer> lotteryNumber) {
        this.lotteryName = lotteryName;
        this.lotteryNumber = lotteryNumber;
    }

    public String getLotteryName() {
        return lotteryName;
    }

    public void setLotteryName(String lotteryName) {
        this.lotteryName = lotteryName;
    }

    public List<Integer> getLotteryNumber() {
        return lotteryNumber;
    }

    public void setLotteryNumber(List<Integer> lotteryNumber) {
        this.lotteryNumber = lotteryNumber;
    }
}
