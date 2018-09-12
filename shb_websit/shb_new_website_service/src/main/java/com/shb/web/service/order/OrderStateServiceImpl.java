package com.shb.web.service.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shb.web.api.order.OrderStateService;
import com.shb.web.dao.order.OrderStateDao;
import com.shb.web.mobile.order.OrderState;

@Service
public class OrderStateServiceImpl implements OrderStateService {

	@Autowired
	private OrderStateDao orderStateDao;
	
	@Override
	public Long insertSelective(OrderState record) {
		return orderStateDao.insertSelective(record);
	}

}
