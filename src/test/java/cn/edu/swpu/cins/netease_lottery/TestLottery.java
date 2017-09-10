package cn.edu.swpu.cins.netease_lottery;

import cn.edu.swpu.cins.netease_lottery.dao.CustomerDao;
import cn.edu.swpu.cins.netease_lottery.dao.OrderDao;
import cn.edu.swpu.cins.netease_lottery.dao.WinningDao;
import cn.edu.swpu.cins.netease_lottery.service.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by miaomiao on 17-7-29.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class TestLottery {

    @Autowired
    OrderDao orderDao;
    @Autowired
    WinningDao winningDao;
    @Autowired
    CustomerDao customerDao;
    @Autowired
    OrderService orderService;

    @Test
    public void contextLoads() throws SchedulerException {



//        OrderInfo orderInfo = new OrderInfo();
//        int id = 8;
//        List<Integer> orderDetailId = new ArrayList<>();
//        orderDetailId.add(1);
//        orderDetailId.add(3);
//        orderDetailId.add(4);
//        orderInfo.setId(id);
//        orderInfo.setOrderDetailId(orderDetailId);
//        orderDao.updateOrderDetailId(orderInfo);


//        int id = 13;
//        List<OrderDetail> orderDetail = orderDao.selectOrderDetailByOrderId(id);
//        System.out.println(orderDetail);



        //测试订单的存储，并返回自增id
//        OrderInfo orderInfo = new OrderInfo();
//        orderInfo.setPetName("miaomiao");
//        orderInfo.setDetTime(new Date());
//        System.out.println("插入前："+orderInfo.getId());
//        System.out.println(orderService.addOrderInfo(orderInfo));
//        System.out.println("插入后："+orderInfo.getId());
//
//        OrderDetail orderDetail = new OrderDetail();
//        orderDetail.setOrderId(orderInfo.getId());
//        orderDetail.setLotteryName("任二");
//        orderDetail.setMultiple(2);
//        System.out.println(orderDetail);
//        orderDao.addOrderDetail(orderDetail);



//        List<Integer> numbers = winningDao.selectWinningNumber(1).getWinNumber();
//        int mm=0;
//        for(int i=0;i<5;i++){
//            System.out.println("中奖号码："+numbers.get(i));
//        }


//        for(Object integer:numbers){
//            System.out.println(integer);
//        }


//        AddOrderView customerOrderDetail = new AddOrderView();
//        customerOrderDetail.setMultiple(2);
//        OrderList order = new OrderList();
//        order.setLotteryName("任二");
//        GenerateWinNumber generateWinNumber = new GenerateWinNumber();
//        List<Integer> num =new ArrayList<>();
//        num.add(1);
//        num.add(2);
//        num.add(3);
//        num.add(4);
//        num.add(5);
//
//        System.out.println("用户号码："+num);
//
//        for (int number:numbers){
//            for(int nums:num){
//                if(number==nums){
//                    mm++;
//                }
//            }
//        }

//        for (int i=0;i<numbers.size();i++){
//            for (int j=0;j<num.size();j++){
//                if(numbers.get(i).intValue()==(num.get(j)).intValue()){
//                    mm++;
//                }
//            }
//        }

//        System.out.println(mm);

//        for(int m : num){
//            if(numbers.contains(m)){
//                mm++;
//            }
//        }
//        System.out.println("mm:"+mm);
//        order.setLotteryNumber(num);
//        List<OrderList> orderLists = new ArrayList<>();
//        orderLists.add(order);
//        customerOrderDetail.setLottery(orderLists);
//        HandleCustomerLottery handleCustomerLottery = new HandleCustomerLottery();
//        System.out.println(handleCustomerLottery.handleLottery(order,numbers,customerOrderDetail.getMultiple()).getIsWin());



//        OrderDetail orderDetail = new OrderDetail();
//        orderDetail.setId(1);
//        orderDetail.setIsWin("是");
//        orderDetail.setWinGrade(1);
//        orderDetail.setWinMoney(120);
//        orderDao.updateOrderDetailAll(orderDetail);



//        OrderInfo orderInfo1 = new OrderInfo();
//        orderInfo1.setPetName("miao");
//        orderInfo1.setDetTime(new Date());
//        System.out.println("插入前："+orderInfo1.getId());
//        orderDao.addOrderSelectId(orderInfo1);
//        System.out.println(orderDao.addOrderSelectId(orderInfo));
//        System.out.println("插入后："+orderInfo1.getId());


        //测试生成中奖号码，存取中奖号码，返回自增id
//        GenerateWinNumber generateWinNumber = new GenerateWinNumber();
//        WinningDetail winningDetail = new WinningDetail();
//        List<Integer> numbers = generateWinNumber.generateNumber();
//        System.out.println(numbers);
//        System.out.println(generateWinNumber.bigSmallCompare(numbers));
//
//        winningDetail.setWinNumber(numbers);
//        winningDetail.setBigSmall(generateWinNumber.bigSmallCompare(numbers));
//        winningDao.addLotteryDetail(winningDetail);
//        System.out.println("插入后的id为："+winningDetail.getId());
//        System.out.println("插入后的bigSmall为："+winningDetail.getBigSmall());
//
//        List<Integer> number = winningDao.selectWinningNumber(winningDetail.getId()).getWinNumber();
//        System.out.println("查询到的号码为："+number);
//        String bigSmall = winningDao.selectWinningNumber(winningDetail.getId()).getBigSmall();
//        System.out.println("查询到的大小比为："+bigSmall);

//        CustomerInfo customerInfo= customerDao.selectByPetName("miaomiao");
//        System.out.println(customerInfo.getId());



    }
}
