package cn.edu.swpu.cins.netease_lottery.model.persistence;

import cn.edu.swpu.cins.netease_lottery.model.view.OrderList;

import java.util.List;

/**
 * Created by miaomiao on 17-7-26.
 */
public class OrderDetail {
    private int id;
    private int orderId;
    private int winningId;
    private String lotteryName;
    private List<Integer> lotteryNumber;
    private int multiple;
    private String isWin;
    private int winGrade;
    private int winMoney;

    public OrderDetail(int id, int orderId, int winningId, String lotteryName, List<Integer> lotteryNumber, int multiple, String isWin, int winGrade, int winMoney) {
        this.id = id;
        this.orderId = orderId;
        this.winningId = winningId;
        this.lotteryName = lotteryName;
        this.lotteryNumber = lotteryNumber;
        this.multiple = multiple;
        this.isWin = isWin;
        this.winGrade = winGrade;
        this.winMoney = winMoney;
    }

    public OrderDetail(int orderId, int winningId, String lotteryName, List<Integer> lotteryNumber, int multiple) {
        this.orderId = orderId;
        this.winningId = winningId;
        this.lotteryName = lotteryName;
        this.lotteryNumber = lotteryNumber;
        this.multiple = multiple;
    }

    public int getWinningId() {
        return winningId;
    }

    public void setWinningId(int winningId) {
        this.winningId = winningId;
    }

    public OrderDetail() {
    }

    public int getMultiple() {
        return multiple;
    }

    public void setMultiple(int multiple) {
        this.multiple = multiple;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
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

    public String getIsWin() {
        return isWin;
    }

    public void setIsWin(String isWin) {
        this.isWin = isWin;
    }

    public int getWinGrade() {
        return winGrade;
    }

    public void setWinGrade(int winGrade) {
        this.winGrade = winGrade;
    }

    public int getWinMoney() {
        return winMoney;
    }

    public void setWinMoney(int winMoney) {
        this.winMoney = winMoney;
    }
}
