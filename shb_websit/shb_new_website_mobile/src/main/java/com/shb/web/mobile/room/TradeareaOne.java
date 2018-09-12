package com.shb.web.mobile.room;

import java.io.Serializable;

@SuppressWarnings("serial")
public class TradeareaOne implements Serializable{
	
    private Long stoId; // 一级商圈ID 主键

    private String areaCode; // 城市编号

    private String code;

    private String tradeareaOne; // 一级商圈名称

    private String tradeareaSyn; // 简介

    private String addUn; //

    private String createTime;  //创建时间

    private String operator; //操作人

    private String modifyTime; // 修改时间

    private Integer isDelete; // 逻辑删除
    
    private String maplongitudes; // 经纬度
    
    private String cityName; // 城市名称
    
    private Integer type; // 展示状态
    
    
    public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getMaplongitudes() {
		return maplongitudes;
	}

	public void setMaplongitudes(String maplongitudes) {
		this.maplongitudes = maplongitudes;
	}


	public Long getStoId() {
		return stoId;
	}

	public void setStoId(Long stoId) {
		this.stoId = stoId;
	}

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getTradeareaOne() {
		return tradeareaOne;
	}

	public void setTradeareaOne(String tradeareaOne) {
		this.tradeareaOne = tradeareaOne;
	}

	public String getTradeareaSyn() {
		return tradeareaSyn;
	}

	public void setTradeareaSyn(String tradeareaSyn) {
		this.tradeareaSyn = tradeareaSyn;
	}

	public String getAddUn() {
		return addUn;
	}

	public void setAddUn(String addUn) {
		this.addUn = addUn;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(String modifyTime) {
		this.modifyTime = modifyTime;
	}

	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

  
}