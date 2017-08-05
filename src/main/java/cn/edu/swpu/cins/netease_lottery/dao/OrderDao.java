package cn.edu.swpu.cins.netease_lottery.dao;

import cn.edu.swpu.cins.netease_lottery.model.persistence.OrderDetail;
import cn.edu.swpu.cins.netease_lottery.model.persistence.OrderInfo;
import cn.edu.swpu.cins.netease_lottery.model.view.OrderIsWin;
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
    public int addOrderSelectId(OrderInfo orderInfo);
    //删除订单
    public int deleteOrderById(int id);
    //添加order_detail_id   ?
    public int updateOrderDetailId(OrderInfo orderInfo);
    //根据id查询order_detail_id
    public OrderInfo selectOrderDetailId(int id);

    /**
     * 订单明细表
     */
    //添加订单明细
    public int addOrderDetail(OrderDetail orderDetail);

    //添加订单明细及中奖情况
    public int updateOrderDetailAll(OrderDetail orderDetail);

    //根据orderId查询订单情况
    public  List<OrderDetail> selectOrderDetailByOrderId(int orderId);

}
