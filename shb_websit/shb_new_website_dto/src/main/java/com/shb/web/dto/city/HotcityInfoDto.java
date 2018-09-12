package com.shb.web.dto.city;

import java.io.Serializable;

@SuppressWarnings("serial")
public class HotcityInfoDto implements Serializable{
	
    private String picture; // 图片地址
    
    private String name; // 名称
    
    private String areaCode; // 城市编号
    
    private String cityIcon; //城市Icon

	public String getCityIcon() {
		return cityIcon;
	}

	public void setCityIcon(String cityIcon) {
		this.cityIcon = cityIcon;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

}
