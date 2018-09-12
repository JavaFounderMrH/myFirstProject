package com.shb.web.dto.room;

import java.io.Serializable;
import java.util.List;

import com.shb.web.mobile.coupon.Coupon;
import com.shb.web.mobile.room.ReservationRoom;


@SuppressWarnings("serial")
public class ReservationRoomDto implements Serializable{
	
	private ReservationRoom reservationRoom; // 房间信息
	
	private String startTime; // 入住时间
	
    private String endTime; // 结束时间
	
	private Coupon coupon; // 优惠券信息
	
	private Integer nums; // 套数
	
	private String src;
	
	private Long scId;

	private Integer price; // 优惠券面额
	
	private Double totalPrice; //订单总价
	
	private String name; // 预订人
	
	private String phone; // 预订人手机号
	
	private Integer checkNumber; // 入住人数
	
	private Integer defaultNums = 1; // 默认套数
	
	private Integer defaultCheckNumber = 1; // 默认入住人数
	
	private String refundAgreement; // 退款协议
	
	private List<Coupon> normalCoupon; // 可用优惠券
	
	public List<Coupon> getNormalCoupon() {
		return normalCoupon;
	}

	public void setNormalCoupon(List<Coupon> normalCoupon) {
		this.normalCoupon = normalCoupon;
	}

	public String getRefundAgreement() {
		return refundAgreement;
	}

	public void setRefundAgreement(String refundAgreement) {
		this.refundAgreement = refundAgreement;
	}

	public Integer getDefaultNums() {
		return defaultNums;
	}

	public void setDefaultNums(Integer defaultNums) {
		this.defaultNums = defaultNums;
	}

	public Integer getDefaultCheckNumber() {
		return defaultCheckNumber;
	}

	public void setDefaultCheckNumber(Integer defaultCheckNumber) {
		this.defaultCheckNumber = defaultCheckNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getCheckNumber() {
		return checkNumber;
	}

	public void setCheckNumber(Integer checkNumber) {
		this.checkNumber = checkNumber;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	
	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getSrc() {
		return src;
	}

	public void setSrc(String src) {
		this.src = src;
	}

	public Long getScId() {
		return scId;
	}

	public void setScId(Long scId) {
		this.scId = scId;
	}

	public ReservationRoom getReservationRoom() {
		return reservationRoom;
	}

	public void setReservationRoom(ReservationRoom reservationRoom) {
		this.reservationRoom = reservationRoom;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	
	public Coupon getCoupon() {
		return coupon;
	}

	public void setCoupon(Coupon coupon) {
		this.coupon = coupon;
	}

	public Integer getNums() {
		return nums;
	}

	public void setNums(Integer nums) {
		this.nums = nums;
	}
	
}
