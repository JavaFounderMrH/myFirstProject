package com.shb.web.dto.room;

import java.io.Serializable;

@SuppressWarnings("serial")
public class RoomDtos implements Serializable{
	
	private Long sriId; // 房间ID
	
	private String roomTitle; // 房间标题

	private String portraitSrc;// 房东头像

    private Integer leaseType; // 房屋出租类型
	
	private Integer checkNumber; // 入住人数
	
	private Integer whetherCheckTrue;   // 是否验真
	
	private String picSrc; // 房间图片
	
    private Double price; // 房间每天价格
	 
	private Double discount; // 折扣数
	
    private Integer badNums; // 床位数
	
	private Double score = 5.0; // 评分
	
	private Integer falg; // 收藏标记
	
	private Integer priceType; // 日历价格类型
	
    private Double longitude; // 经度
	
	private Double latitude; // 维度
	
	private String  distance; // 距离

	private String username; // 用户名
	
	private Long sliId; //房东id
	
	private String landlordNickname; //房东昵称
	
	private Integer livingRoomNumber; //客厅数量
	
	private Integer bedroomNumber; // 卧室数量
	
	private Integer toiletNumber; //卫生间数量
	
	private Integer kitchenNumber; //厨房数量
	
	private Integer balconyNumber; //阳台数量
	
	public Integer getLivingRoomNumber() {
		return livingRoomNumber;
	}

	public void setLivingRoomNumber(Integer livingRoomNumber) {
		this.livingRoomNumber = livingRoomNumber;
	}

	public Integer getBedroomNumber() {
		return bedroomNumber;
	}

	public void setBedroomNumber(Integer bedroomNumber) {
		this.bedroomNumber = bedroomNumber;
	}

	public Integer getToiletNumber() {
		return toiletNumber;
	}

	public void setToiletNumber(Integer toiletNumber) {
		this.toiletNumber = toiletNumber;
	}

	public Integer getKitchenNumber() {
		return kitchenNumber;
	}

	public void setKitchenNumber(Integer kitchenNumber) {
		this.kitchenNumber = kitchenNumber;
	}

	public Integer getBalconyNumber() {
		return balconyNumber;
	}

	public void setBalconyNumber(Integer balconyNumber) {
		this.balconyNumber = balconyNumber;
	}

	public String getLandlordNickname() {
		return landlordNickname;
	}

	public void setLandlordNickname(String landlordNickname) {
		this.landlordNickname = landlordNickname;
	}

	public Long getSliId() {
		return sliId;
	}

	public void setSliId(Long sliId) {
		this.sliId = sliId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

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

	public String getDistance() {
		return distance;
	}

	public void setDistance(String distance) {
		this.distance = distance;
	}

	public Long getSriId() {
		return sriId;
	}

	public void setSriId(Long sriId) {
		this.sriId = sriId;
	}

	public String getRoomTitle() {
		return roomTitle;
	}

	public void setRoomTitle(String roomTitle) {
		this.roomTitle = roomTitle;
	}

	public String getPortraitSrc() {
		return portraitSrc;
	}

	public void setPortraitSrc(String portraitSrc) {
		this.portraitSrc = portraitSrc;
	}

	public Integer getLeaseType() {
		return leaseType;
	}

	public void setLeaseType(Integer leaseType) {
		this.leaseType = leaseType;
	}

	public Integer getCheckNumber() {
		return checkNumber;
	}

	public void setCheckNumber(Integer checkNumber) {
		this.checkNumber = checkNumber;
	}

	public Integer getWhetherCheckTrue() {
		return whetherCheckTrue;
	}

	public void setWhetherCheckTrue(Integer whetherCheckTrue) {
		this.whetherCheckTrue = whetherCheckTrue;
	}

	public String getPicSrc() {
		return picSrc;
	}

	public void setPicSrc(String picSrc) {
		this.picSrc = picSrc;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public Integer getBadNums() {
		return badNums;
	}

	public void setBadNums(Integer badNums) {
		this.badNums = badNums;
	}

	public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}

	public Integer getFalg() {
		return falg;
	}

	public void setFalg(Integer falg) {
		this.falg = falg;
	}

	public Integer getPriceType() {
		return priceType;
	}

	public void setPriceType(Integer priceType) {
		this.priceType = priceType;
	}

	public String getRoomUpload() {
		return roomUpload;
	}

	public void setRoomUpload(String roomUpload) {
		this.roomUpload = roomUpload;
	}

	private String roomUpload; // 房东账号

	private Double discountPrice; //折算价格
	
	public Double getDiscountPrice() {
		return discountPrice;
	}

	public void setDiscountPrice(Double discountPrice) {
		this.discountPrice = discountPrice;
	}

}
