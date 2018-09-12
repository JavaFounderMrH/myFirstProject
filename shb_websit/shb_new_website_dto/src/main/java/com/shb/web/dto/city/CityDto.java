package com.shb.web.dto.city;

import java.io.Serializable;
import java.util.List;

import com.shb.web.mobile.city.City;
import com.shb.web.dto.city.HotcityInfoDto;

@SuppressWarnings("serial")
public class CityDto implements Serializable{
	
	private List<HotcityInfoDto> hotcityInfoList; //热门城市
	
	private List<City> cityList; // 维护的城市

	public List<HotcityInfoDto> getHotcityInfoList() {
		return hotcityInfoList;
	}

	public void setHotcityInfoList(List<HotcityInfoDto> hotcityInfoList) {
		this.hotcityInfoList = hotcityInfoList;
	}

	public List<City> getCityList() {
		return cityList;
	}

	public void setCityList(List<City> cityList) {
		this.cityList = cityList;
	}

}
