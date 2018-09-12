package com.shb.web.dto.city;

import java.io.Serializable;

@SuppressWarnings("serial")
public class CityListDto implements Serializable, Comparable<CityListDto>{
	
	private String cityName; // 城市名称
	
	private String areaCode; // 城市编号
	
	private String cityPhoto; // 城市图片
	
	private Integer sort;

	public String getCityPhoto() {
		return cityPhoto;
	}

	public void setCityPhoto(String cityPhoto) {
		this.cityPhoto = cityPhoto;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	@Override
	public int compareTo(CityListDto o) {
		
		
		return o.getSort()-this.sort;
		
		//return this.sort.compareTo(o.getSort());
	}
	
	@Override
	public String toString() {
		return "CityListDto [cityName=" + cityName + ", areaCode=" + areaCode + "]";
	}

	
}
