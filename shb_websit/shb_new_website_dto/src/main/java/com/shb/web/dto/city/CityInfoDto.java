package com.shb.web.dto.city;

import java.io.Serializable;

@SuppressWarnings("serial")
public class CityInfoDto implements Serializable{
	
	 private String province; // 省
	 
	 private String cityName; // 城市名称 

	 public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	@Override
	public String toString() {
		return "CityInfoDto [province=" + province + ", cityName=" + cityName + "]";
	}

	

}
