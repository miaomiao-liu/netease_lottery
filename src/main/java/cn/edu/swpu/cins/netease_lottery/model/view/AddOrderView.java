package cn.edu.swpu.cins.netease_lottery.model.view;

import java.util.List;
import java.util.Map;

/**
 * Created by miaomiao on 17-7-29.
 */
public class AddOrderView {
    private int winningId;
    private List<OrderList> lottery;
    private int multiple;
    private List<Integer> orderId;

    public AddOrderView() {
    }

    public AddOrderView(int winningId, List<OrderList> lottery, int multiple, List<Integer> orderId) {
        this.winningId = winningId;
        this.lottery = lottery;
        this.multiple = multiple;
        this.orderId = orderId;
    }

    public int getWinningId() {
        return winningId;
    }

    public void setWinningId(int winningId) {
        this.winningId = winningId;
    }

    public List<OrderList> getLottery() {
        return lottery;
    }

    public void setLottery(List<OrderList> lottery) {
        this.lottery = lottery;
    }

    public int getMultiple() {
        return multiple;
    }

    public void setMultiple(int multiple) {
        this.multiple = multiple;
    }

    public List<Integer> getOrderId() {
        return orderId;
    }

    public void setOrderId(List<Integer> orderId) {
        this.orderId = orderId;
    }
}
