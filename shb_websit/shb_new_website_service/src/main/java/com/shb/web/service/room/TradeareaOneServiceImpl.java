package com.shb.web.service.room;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.shb.web.api.room.TradeareaOneService;
import com.shb.web.dao.room.RoomBannerInfoDao;
import com.shb.web.dao.room.TradeareaOneDao;
import com.shb.web.mobile.city.City;
import com.shb.web.mobile.room.TradeareaOne;

@Service
public class TradeareaOneServiceImpl  implements TradeareaOneService{
	
	@Autowired 
	private TradeareaOneDao tradeareaOneDao;
	
	@Autowired
	private RoomBannerInfoDao roomBannerInfoDao;

	@Override
	public TradeareaOne selectByPrimaryKey(Long stoId) {
		return tradeareaOneDao.selectByPrimaryKey(stoId);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<TradeareaOne> queryTradeareaOne(String cityName, String areaCode) {
		
		List<TradeareaOne> list = null;
		
		try {
			 
			TradeareaOne tradearea = new TradeareaOne();

			if (areaCode != null && !areaCode.equals("") && !areaCode.equals("null")) {

				tradearea.setAreaCode(areaCode);

			} else {

				if (cityName == null || cityName.equals("")) {

					cityName = "北京";

				}

				City city = roomBannerInfoDao.querCityCode(cityName);

				if (city != null) {

					tradearea.setAreaCode(city.getAreaCode());
					
				} else {

					tradearea.setAreaCode("010");

				}

			}
			
		  list = tradeareaOneDao.queryTradeareaOne(tradearea);
			
			
		}catch (Exception ex){
			
			ex.printStackTrace();
			
			return list;
		}
		
		return list;
	}

}
