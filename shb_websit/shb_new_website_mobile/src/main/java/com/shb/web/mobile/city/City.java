package com.shb.web.mobile.city;

import java.io.Serializable;

@SuppressWarnings("serial")
public class City implements Serializable{
	
    private Long scId;  // 主键ID

    private String province; // 省

    private String cityName; // 城市名称

    private String area; //区

    private String areaCode; // 区号

    private String cityPy;

    private String cityPyjx;
    
    private String description; // 城市描述
    
    private String cityPhoto; // 城市图片
    
    private String cityTitlePhoto; // 城市标题图片

	public String getCityPhoto() {
		return cityPhoto;
	}

	public void setCityPhoto(String cityPhoto) {
		this.cityPhoto = cityPhoto;
	}

	public String getCityTitlePhoto() {
		return cityTitlePhoto;
	}

	public void setCityTitlePhoto(String cityTitlePhoto) {
		this.cityTitlePhoto = cityTitlePhoto;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getScId() {
        return scId;
    }

    public void setScId(Long scId) {
        this.scId = scId;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName == null ? null : cityName.trim();
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode == null ? null : areaCode.trim();
    }

    public String getCityPy() {
        return cityPy;
    }

    public void setCityPy(String cityPy) {
        this.cityPy = cityPy == null ? null : cityPy.trim();
    }

    public String getCityPyjx() {
        return cityPyjx;
    }

    public void setCityPyjx(String cityPyjx) {
        this.cityPyjx = cityPyjx == null ? null : cityPyjx.trim();
    }

}