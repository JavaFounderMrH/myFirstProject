package com.shb.web.mobile.room;

import java.io.Serializable;

@SuppressWarnings("serial")
public class TradeareaTwo implements Serializable{
	
    private Long sttId; // 二级商圈ID

    private Long stoRid; // 一级商圈ID
    
    private String code;

    private String tradeareaTwo; //二级商圈名称

    private String tradeareaSyn; // 简介

    private String addUn;

    private String createTime; // 创建时间

    private String operator; // 操作人

    private String modifyTime; // 淇敼鏃堕棿

    private Integer isDelete; // 閫昏緫鍒犻櫎 
    
    private String maplongitudes; // 缁忕含搴�
    
    private String cityName; // 鍩庡競鍚嶇О
    
    private Integer type; // 鏄惁灞曠ず
    
    private Double longitude; // 缁忓害
	
	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	private Double latitude; //绾害
	
	private String address; // 鍧愭爣璇︾粏鍦板潃
    

    public Long getSttId() {
		return sttId;
	}

	public void setSttId(Long sttId) {
		this.sttId = sttId;
	}

	public Long getStoRid() {
		return stoRid;
	}

	public void setStoRid(Long stoRid) {
		this.stoRid = stoRid;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getTradeareaTwo() {
		return tradeareaTwo;
	}

	public void setTradeareaTwo(String tradeareaTwo) {
		this.tradeareaTwo = tradeareaTwo;
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


   
}