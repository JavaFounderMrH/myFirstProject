package com.shb.web.mobile.order;

public class ShbOrderDetailed {

	private Long detailedId;

	private String time;

	private String weekDate;

	private Double price;

	private Long orderId;

	public ShbOrderDetailed(Long detailedId, String time, String weekDate, Double price, Long orderId) {
		this.detailedId = detailedId;
		this.time = time;
		this.weekDate = weekDate;
		this.price = price;
		this.orderId = orderId;
	}

	public ShbOrderDetailed() {
		super();
	}

	public Long getDetailedId() {
		return detailedId;
	}

	public void setDetailedId(Long detailedId) {
		this.detailedId = detailedId;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getWeekDate() {
		return weekDate;
	}

	public void setWeekDate(String weekDate) {
		this.weekDate = weekDate == null ? null : weekDate.trim();
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
}