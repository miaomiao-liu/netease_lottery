package cn.edu.swpu.cins.netease_lottery.model.persistence;

import java.util.Date;
import java.util.List;

/**
 * Created by miaomiao on 17-7-26.
 */
public class OrderInfo {
    private int id;
    private List<Integer> orderDetailId;
    private String petName;
    private Date detTime;

    public OrderInfo(int id, List<Integer> orderDetailId, String petName, Date detTime) {
        this.id = id;
        this.orderDetailId = orderDetailId;
        this.petName = petName;
        this.detTime = detTime;
    }

    public OrderInfo() {
    }

    public List<Integer> getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(List<Integer> orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public Date getDetTime() {
        return detTime;
    }

    public void setDetTime(Date detTime) {
        this.detTime = detTime;
    }
}
