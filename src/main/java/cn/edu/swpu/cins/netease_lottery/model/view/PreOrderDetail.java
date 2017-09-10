package cn.edu.swpu.cins.netease_lottery.model.view;

import java.util.List;

/**
 * Created by miaomiao on 17-9-10.
 */
public class PreOrderDetail {

    private int id;
    private int orderId;
    private int winningId;
    private String lotteryName;
    private List<Integer> lotteryNumber;
    private  int multiple;

    public PreOrderDetail(int id, int orderId, int winningId, String lotteryName, List<Integer> lotteryNumber, int multiple) {
        this.id = id;
        this.orderId = orderId;
        this.winningId = winningId;
        this.lotteryName = lotteryName;
        this.lotteryNumber = lotteryNumber;
        this.multiple = multiple;
    }

    public PreOrderDetail() {
    }

    public int getOrderId() {
        return orderId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getWinningId() {
        return winningId;
    }

    public void setWinningId(int winningId) {
        this.winningId = winningId;
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

    public int getMultiple() {
        return multiple;
    }

    public void setMultiple(int multiple) {
        this.multiple = multiple;
    }
}
