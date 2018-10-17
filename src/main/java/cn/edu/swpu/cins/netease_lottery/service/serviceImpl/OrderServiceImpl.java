package cn.edu.swpu.cins.netease_lottery.service.serviceImpl;

import cn.edu.swpu.cins.netease_lottery.dao.OrderDao;
import cn.edu.swpu.cins.netease_lottery.dao.WinningDao;
import cn.edu.swpu.cins.netease_lottery.enums.ExceptionEnum;
import cn.edu.swpu.cins.netease_lottery.exception.OrderException;
import cn.edu.swpu.cins.netease_lottery.model.persistence.OrderDetail;
import cn.edu.swpu.cins.netease_lottery.model.persistence.OrderInfo;
import cn.edu.swpu.cins.netease_lottery.model.view.*;
import cn.edu.swpu.cins.netease_lottery.service.OrderService;
import cn.edu.swpu.cins.netease_lottery.util.HandleCustomerLottery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Supplier;

/**
 * Created by miaomiao on 17-7-28.
 */

@Service
public class OrderServiceImpl implements OrderService {


    @Autowired
    OrderDao orderDao;
    @Autowired
    WinningDao winningDao;

    @Autowired
    private HandleCustomerLottery handleCustomerLottery;

    //添加订单
    @Override
    public int addOrderInfo(OrderInfo orderInfo) {
        orderInfo.setDetTime(new Date());
        orderDao.addOrderSelectId(orderInfo);
        return 1;
    }

    //添加订单详情   return ?
    @Override
    public int addOrderDetail(int orderId,AddOrderView addOrderView) throws OrderException {
        try{
            int multiple = addOrderView.getMultiple();
            int winningId = addOrderView.getWinningId();
            List<Integer> idList = new ArrayList<>();
            Supplier<OrderInfo> orderInfoSupplier = OrderInfo::new;
            OrderInfo orderInfo = orderInfoSupplier.get();
            for(OrderList order : addOrderView.getLottery()) {
                String lotteryName = order.getLotteryName();
                List<Integer> lotteryNumber = order.getLotteryNumber();
                OrderDetail orderDetail = new OrderDetail(orderId,winningId,lotteryName,lotteryNumber,multiple);
                orderDao.addOrderDetail(orderDetail);
                idList.add(orderDetail.getId());
                //把订单详情 id数组 添加到order_info中
                orderInfo.setId(orderId);
                orderInfo.setOrderDetailId(idList);
                orderDao.updateOrderDetailId(orderInfo);
        }
        return 1;
        }catch (Exception e){
            throw new OrderException(ExceptionEnum.INNER_ERROR.getMsg());
        }
    }

    //处理订单 ??
    @Override
    public List<OrderIsWin> handleOrderDetail(List<Integer> orderInfoId) throws OrderException{
        try {
            List<OrderIsWin> orderIsWinObject = new ArrayList();
            Supplier<OrderDetail> orderDetailSupplier = OrderDetail::new;
            OrderDetail orderDetail = orderDetailSupplier.get();
            PreOrderDetail preOrderDetail;

            for (int orderId : orderInfoId) {
                //OrderDetail表中的id数组，对应OrderInfo表中id的order_detail_id
                List<Integer> orderDetailId = orderDao.selectOrderDetailId(orderId).getOrderDetailId();
                for (int i = 0; i < orderDetailId.size(); i++) {
                    int id = orderDetailId.get(i);
                    preOrderDetail = orderDao.selectOrderDetailById(id);
                    //本期随机生成的中奖号码
                    int winningId = preOrderDetail.getWinningId() ;
                    List<Integer> numbers = winningDao.selectWinningNumber(winningId).getWinNumber();
                    OrderIsWin orderIsWin = handleCustomerLottery.handleLottery(preOrderDetail, numbers);
                    //把orderIsWin添加到数据库 id?
                    orderDetail.setId(orderDetailId.get(i));
                    orderDetail.setIsWin(orderIsWin.getIsWin());
                    orderDetail.setWinGrade(orderIsWin.getWinGrade());
                    orderDetail.setWinMoney(orderIsWin.getWinMoney());
                    orderDao.updateOrderDetailAll(orderDetail);
                    orderIsWinObject.add(orderIsWin);
                }
            }
            return orderIsWinObject;
        }catch (Exception e){
            throw  new OrderException(ExceptionEnum.INNER_ERROR.getMsg());
        }
    }

}
