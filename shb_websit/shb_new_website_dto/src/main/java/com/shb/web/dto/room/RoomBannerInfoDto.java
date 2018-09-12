package com.shb.web.dto.room;

import java.io.Serializable;

@SuppressWarnings("serial")
public class RoomBannerInfoDto implements Serializable {

	private String title; // 标题

	private Integer jumpType; // 类型 0：请选择 1：H5 2：房屋详情 3：城市房源列表

	private String jumpAddress; // 跳转值

	private String pictureSrc; // 图片地址

	private Integer roomType; // 房间类型

	private String h5url; // 订阅号跳转路径

	public String getH5url() {
		return h5url;
	}

	public void setH5url(String h5url) {
		this.h5url = h5url;
	}

	public Integer getRoomType() {
		return roomType;
	}

	public void setRoomType(Integer roomType) {
		this.roomType = roomType;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getJumpType() {
		return jumpType;
	}

	public void setJumpType(Integer jumpType) {
		this.jumpType = jumpType;
	}

	public String getJumpAddress() {
		return jumpAddress;
	}

	public void setJumpAddress(String jumpAddress) {
		this.jumpAddress = jumpAddress;
	}

	public String getPictureSrc() {
		return pictureSrc;
	}

	public void setPictureSrc(String pictureSrc) {
		this.pictureSrc = pictureSrc;
	}

	@Override
	public String toString() {
		return "RoomBannerInfoDto [title=" + title + ", jumpType=" + jumpType + ", jumpAddress=" + jumpAddress
				+ ", pictureSrc=" + pictureSrc + ", roomType=" + roomType + ", h5url=" + h5url + "]";
	}

}
