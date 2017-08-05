package cn.edu.swpu.cins.netease_lottery.service.serviceImpl;

import cn.edu.swpu.cins.netease_lottery.dao.OrderDao;
import cn.edu.swpu.cins.netease_lottery.dao.WinningDao;
import cn.edu.swpu.cins.netease_lottery.enums.ExceptionEnum;
import cn.edu.swpu.cins.netease_lottery.enums.OrderEnum;
import cn.edu.swpu.cins.netease_lottery.exception.OrderException;
import cn.edu.swpu.cins.netease_lottery.model.persistence.OrderDetail;
import cn.edu.swpu.cins.netease_lottery.model.persistence.OrderInfo;
import cn.edu.swpu.cins.netease_lottery.model.view.CustomerOrderDetail;
import cn.edu.swpu.cins.netease_lottery.model.view.OrderIsWin;
import cn.edu.swpu.cins.netease_lottery.model.view.OrderList;
import cn.edu.swpu.cins.netease_lottery.service.OrderService;
import cn.edu.swpu.cins.netease_lottery.util.HandleCustomerLottery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

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
    public int addOrderDetail(int orderId,CustomerOrderDetail customerOrderDetail) throws OrderException {
        try{
            int multiple = customerOrderDetail.getMultiple();
            int winningId = customerOrderDetail.getWinningId();
            List<Integer> idList = new ArrayList<>();
            OrderInfo orderInfo = new OrderInfo();
            for(OrderList order : customerOrderDetail.getLottery()) {
                String lotteryName = order.getLotteryName();
                List<Integer> lotteryNumberList = order.getLotteryNumber();
                OrderDetail orderDetail = new OrderDetail(orderId,winningId,lotteryName,lotteryNumberList,multiple);
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

    //处理订单
    @Override
    public List<OrderIsWin> handleOrderDetail(int orderInfoId,CustomerOrderDetail customerOrderDetail) throws OrderException{
        try {
            List<Integer> orderDetailId = orderDao.selectOrderDetailId(orderInfoId).getOrderDetailId();
            int winningId = customerOrderDetail.getWinningId();
            List<OrderIsWin> orderIsWinObject = new ArrayList();
            OrderDetail orderDetail = new OrderDetail();
            //本期随机生成的中奖号码
            List<Integer> numbers = winningDao.selectWinningNumber(winningId).getWinNumber();
            for(int i=0; i < orderDetailId.size(); i++){
                OrderList orderList = customerOrderDetail.getLottery().get(i);
                OrderIsWin orderIsWin = handleCustomerLottery.handleLottery(orderList,numbers,customerOrderDetail.getMultiple());
                //把orderIsWin添加到数据库 id?
                orderDetail.setId(orderDetailId.get(i));
                orderDetail.setIsWin(orderIsWin.getIsWin());
                orderDetail.setWinGrade(orderIsWin.getWinGrade());
                orderDetail.setWinMoney(orderIsWin.getWinMoney());
                orderDao.updateOrderDetailAll(orderDetail);
                orderIsWinObject.add(orderIsWin);
            }
            return orderIsWinObject;
        }catch (Exception e){
            throw  new OrderException(ExceptionEnum.INNER_ERROR.getMsg());
        }
    }

}
