package com.shb.web.service.room;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shb.web.api.city.RoomBannerInfoService;
import com.shb.web.dao.room.RoomBannerInfoDao;
import com.shb.web.mobile.city.City;
import com.shb.web.mobile.room.RoomBannerInfo;

@Service
public class RoomBannerInfoServiceImpl implements RoomBannerInfoService {
	
	@Autowired
	private RoomBannerInfoDao  roomBannerInfoDao;

	@Override
	public List<RoomBannerInfo> queryRoomBannerInfo() {
		return roomBannerInfoDao.queryRoomBannerInfo();
	}

	@Override
	public City querCityCode(String cityName) {
		return roomBannerInfoDao.querCityCode(cityName);
	}

}
