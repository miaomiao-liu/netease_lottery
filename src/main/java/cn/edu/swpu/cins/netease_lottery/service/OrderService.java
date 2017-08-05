package cn.edu.swpu.cins.netease_lottery.service;

import cn.edu.swpu.cins.netease_lottery.exception.OrderException;
import cn.edu.swpu.cins.netease_lottery.model.persistence.OrderInfo;
import cn.edu.swpu.cins.netease_lottery.model.view.CustomerOrderDetail;
import cn.edu.swpu.cins.netease_lottery.model.view.OrderIsWin;

import java.util.List;

/**
 * Created by miaomiao on 17-7-28.
 */
public interface OrderService {

    public int addOrderInfo(OrderInfo orderInfo) throws OrderException;

    public int addOrderDetail(int orderId,CustomerOrderDetail orderInfoDetail) throws OrderException;

    public List<OrderIsWin> handleOrderDetail(int id,CustomerOrderDetail orderInfoDetail) throws OrderException;
}
