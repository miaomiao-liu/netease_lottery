package cn.edu.swpu.cins.netease_lottery.dao;

import cn.edu.swpu.cins.netease_lottery.model.persistence.OrderDetail;
import cn.edu.swpu.cins.netease_lottery.model.persistence.OrderInfo;
import cn.edu.swpu.cins.netease_lottery.model.view.OrderIsWin;
import cn.edu.swpu.cins.netease_lottery.model.view.PreOrderDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by miaomiao on 17-7-26.
 */

@Repository
@Mapper
public interface OrderDao {

    //根据userId查询订单
//    public OrderInfo selectOrderByPetName(String petName);

    //增加订单
    int addOrderSelectId(OrderInfo orderInfo);
    //删除订单
    int deleteOrderById(int id);
    //添加order_detail_id   ?
    int updateOrderDetailId(OrderInfo orderInfo);
    //根据id查询order_detail_id
    OrderInfo selectOrderDetailId(int id);

    /**
     * 订单明细表
     */
    //添加订单明细
    int addOrderDetail(OrderDetail orderDetail);

    //添加订单明细及中奖情况
    int updateOrderDetailAll(OrderDetail orderDetail);

    //根据orderId查询订单情况
    List<OrderDetail> selectOrderDetailByOrderId(int orderId);

    //根据order_detail的id查询preOrderDetial
    PreOrderDetail selectOrderDetailById(int id);

}
