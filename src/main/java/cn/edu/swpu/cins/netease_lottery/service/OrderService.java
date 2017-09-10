package cn.edu.swpu.cins.netease_lottery.service;

import cn.edu.swpu.cins.netease_lottery.exception.OrderException;
import cn.edu.swpu.cins.netease_lottery.model.persistence.OrderInfo;
import cn.edu.swpu.cins.netease_lottery.model.view.AddOrderView;
import cn.edu.swpu.cins.netease_lottery.model.view.OrderIsWin;

import java.util.List;

/**
 * Created by miaomiao on 17-7-28.
 */
public interface OrderService {

    int addOrderInfo(OrderInfo orderInfo) throws OrderException;

    int addOrderDetail(int orderId,AddOrderView orderInfoDetail) throws OrderException;

    List<OrderIsWin> handleOrderDetail(List<Integer> orderInfoList) throws OrderException;
}
