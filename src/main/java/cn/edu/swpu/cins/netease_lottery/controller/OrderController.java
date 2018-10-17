package cn.edu.swpu.cins.netease_lottery.controller;

import cn.edu.swpu.cins.netease_lottery.dao.CustomerDao;
import cn.edu.swpu.cins.netease_lottery.dao.OrderDao;
import cn.edu.swpu.cins.netease_lottery.enums.ExceptionEnum;
import cn.edu.swpu.cins.netease_lottery.enums.OrderEnum;
import cn.edu.swpu.cins.netease_lottery.model.persistence.OrderDetail;
import cn.edu.swpu.cins.netease_lottery.model.persistence.OrderInfo;
import cn.edu.swpu.cins.netease_lottery.model.view.AddOrderView;
import cn.edu.swpu.cins.netease_lottery.model.view.OrderIsWin;
import cn.edu.swpu.cins.netease_lottery.service.OrderService;
import cn.edu.swpu.cins.netease_lottery.util.GetUserName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by miaomiao on 17-7-26.
 */

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderDao orderDao;
    @Autowired
    private CustomerDao customerDao;
    @Autowired
    private GetUserName getUserName;
    @Autowired
    private OrderService orderService;


    //订单orderId
    @Value("${NeteaseLottery.header}")
    private String id;


    //保存彩票订单
    @PostMapping("/addOrder")
    public ResponseEntity<?> addOrder(@RequestBody AddOrderView addOrderView,
                                      HttpServletRequest request){
        try {
            String petName = getUserName.getUsernameFromRequest(request);
            OrderInfo orderInfo = new OrderInfo();
            orderInfo.setPetName(petName);
            if(orderService.addOrderInfo(orderInfo) == 1){
                //添加订单时获取主键
                int orderId = orderInfo.getId();
                if(orderService.addOrderDetail(orderId,addOrderView) ==1) {
                    //添加订单成功 返回订单order_detail的order_info的id
                    return new ResponseEntity<Object>(orderId, HttpStatus.OK);
                }else {
                    orderDao.deleteOrderById(orderId);
                    return new ResponseEntity<Object>(OrderEnum.FAIL_ADD_ORDER.getMsg(),HttpStatus.OK);
                }
            }
            return new ResponseEntity<Object>(OrderEnum.FAIL_ADD_ORDER.getMsg(),HttpStatus.OK);
        }catch (Exception e){
         return new ResponseEntity<Object>(e.getMessage(),HttpStatus.OK);
        }
    }


    @PostMapping("/handleOrder")
    public ResponseEntity<?> handleOrder(@RequestParam List<Integer> orderInfoList){
        try {
//            int orderId = request.getIntHeader(id);
//            List<Integer> orderId = handleOrderView.getOrderId();
            List<OrderIsWin> orderIsWinList = orderService.handleOrderDetail(orderInfoList);
            return new ResponseEntity<Object>(orderIsWinList,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<Object>(e.getMessage(),HttpStatus.OK);
        }

    }


    //查看订单详情
    @GetMapping("/queryOrder")
    public ResponseEntity<?> queryOrder(HttpServletRequest request){
        int orderId = request.getIntHeader(id);
        if(orderDao.selectOrderDetailByOrderId(orderId) != null){
            List<OrderDetail> orderDetailList = orderDao.selectOrderDetailByOrderId(orderId);
            return new ResponseEntity<Object>(orderDetailList,HttpStatus.OK);
        }
        return new ResponseEntity<Object>(ExceptionEnum.DATABASE_ERROR.getMsg(),HttpStatus.OK);
    }

}
