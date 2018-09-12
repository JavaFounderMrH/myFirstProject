package com.shb.web.api.city;

import java.util.List;

import com.shb.web.mobile.city.City;
import com.shb.web.mobile.room.RoomBannerInfo;


public interface RoomBannerInfoService {

	List<RoomBannerInfo>queryRoomBannerInfo();

	City querCityCode (String cityName);
}
