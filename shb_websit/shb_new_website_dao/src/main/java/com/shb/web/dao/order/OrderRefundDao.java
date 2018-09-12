package com.shb.web.dao.order;

import java.util.List;
import java.util.Map;

import com.shb.web.mobile.order.OrderRefund;


public interface OrderRefundDao {

    Long insertSelective(OrderRefund record);
    
    Long updateOrderRefund(Long orderNumber);
    
    Long updateByPrimaryKeySelective(OrderRefund record);

    List<Map<String,Object>> queryOrderRefund(OrderRefund record);

}