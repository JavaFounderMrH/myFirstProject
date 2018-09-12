package com.shb.web.service.order;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shb.web.api.order.ShbOrderInfoService;
import com.shb.web.dao.order.ShbOrderInfoDao;
import com.shb.web.dao.room.RoomPriceCalendarDao;
import com.shb.web.dto.order.ShbOrderInfoDto;
import com.shb.web.mobile.order.ShbOrderInfo;

@Service
public class ShbOrderInfoServiceImpl implements ShbOrderInfoService {

	@Autowired
	private ShbOrderInfoDao shbOrderInfoDao;
	
	@Autowired
	private RoomPriceCalendarDao roomPriceCalendarDao;

	@Override
	public PageInfo<ShbOrderInfoDto> queryShbOrderInfo(ShbOrderInfoDto shbOrderInfoDto , Integer pageNo, Integer pageSize) {
		
		PageInfo<ShbOrderInfoDto> page = null;
		
		try {
			
			String str[] = new String[] { "当天", "前一天", "前两天", "前三天", "前四天", "前五天", "前六天", "前七天" };
			
			pageNo = pageNo == null ? 1 : pageNo;

			pageSize = pageSize == null ? 10 : pageSize;

			PageHelper.startPage(pageNo, pageSize);
			
			List<ShbOrderInfoDto> list = shbOrderInfoDao.queryShbOrderInfo(shbOrderInfoDto);
			
			if (list != null && list.size() > 0) {

				for (ShbOrderInfoDto st : list) {

					if (st.getRoomUpDay() != null) {

						st.setRefundAgreement(str[st.getRoomUpDay()]);

					}

					if (st.getWhetherOvernight() != null) {

						if (st.getWhetherOvernight() == 0) {

							st.setChechDays(st.getChechDays() + 1);

						}

					}

				}

			}
			
			page = new PageInfo<ShbOrderInfoDto>(list);
			
		}catch (Exception ex){
			
			ex.printStackTrace();
			
			return page;
			
		}
		
		return page;
		
	}

	@Override
	public Map<String, Object> findOrderInfo(ShbOrderInfo orderInfo) {
		
		return shbOrderInfoDao.findOrderInfo(orderInfo);
	}
	
	@Override
	public Long updateState(ShbOrderInfo orderInfo) {
		return shbOrderInfoDao.updateState(orderInfo);
	}
	
	@Override
	public Long updatePrice(ShbOrderInfo orderInfo) {
		return roomPriceCalendarDao.updatePrice(orderInfo);
	}
	
	@Override
	public ShbOrderInfoDto selectOrderInfoTime(Long soiId) {
		return shbOrderInfoDao.selectOrderInfoTime(soiId);
	}

}
