package com.shb.web.service.order;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shb.web.api.order.OrderRefundService;
import com.shb.web.dao.order.OrderRefundDao;
import com.shb.web.mobile.order.OrderRefund;

@Service
public class OrderRefundServiceImpl implements OrderRefundService {

	@Autowired
	private OrderRefundDao orderRefundDao;

	@Override
	public Long insertRefundInfo(OrderRefund or) {
		return orderRefundDao.insertSelective(or);
	}

	@Override
	public Long updateOrderRefund(Long orderNumber) {
		return orderRefundDao.updateOrderRefund(orderNumber);
	}

	@Override
	public List<Map<String, Object>> queryOrderRefund(OrderRefund record) {
		return orderRefundDao.queryOrderRefund(record);
	}

	@Override
	public Long updateByPrimaryKeySelective(OrderRefund record) {
		return orderRefundDao.updateByPrimaryKeySelective(record);
	}

}
