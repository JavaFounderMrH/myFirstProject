package com.shb.web.api.order;

import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.shb.web.dto.order.ShbOrderInfoDto;
import com.shb.web.mobile.order.ShbOrderInfo;

public interface ShbOrderInfoService {

	PageInfo<ShbOrderInfoDto> queryShbOrderInfo(ShbOrderInfoDto shbOrderInfoDto, Integer pageNo, Integer pageSize);

	Map<String, Object> findOrderInfo(ShbOrderInfo orderInfo);

	Long updateState(ShbOrderInfo orderInfo);

	Long updatePrice(ShbOrderInfo orderInfo);

	ShbOrderInfoDto selectOrderInfoTime(Long soiId);

}
