package com.shb.web.mobile.room;

import java.io.Serializable;

/**
 * 轮播图
 * 
 */

@SuppressWarnings("serial")
public class RoomBannerInfo implements Serializable {

	private Long scfId; // 主键ID

	private Long sort; // 排序

	private String title; // 标题

	private String pictureSrc; // 图片地址

	private Integer jumpType; // 类型 0：请选择 1：H5 2：房屋详情 3：城市房源列表

	private String jumpAddress; // 跳转值

	private Integer exhibitionSate; // 展示状态

	private String startTime; // 开始时间

	private String endTime; // 结束时间

	private Integer isDelete; // 逻辑删除

	private String operator; // 操作人

	private String createTime; // 创建时间

	private String modifyTime; // 修改时间

	private Long sriRid; // 房间ID

	private Long roomId;

	private Long scRid; // 城市外键

	private Long ssuiRid; //

	private Integer roomType; // 房间类型

	private String h5url; // 订阅号跳转地址

	public String getH5url() {
		return h5url;
	}

	public void setH5url(String h5url) {
		this.h5url = h5url;
	}

	public Long getScfId() {
		return scfId;
	}

	public void setScfId(Long scfId) {
		this.scfId = scfId;
	}

	public Long getSort() {
		return sort;
	}

	public void setSort(Long sort) {
		this.sort = sort;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title == null ? null : title.trim();
	}

	public String getPictureSrc() {
		return pictureSrc;
	}

	public void setPictureSrc(String pictureSrc) {
		this.pictureSrc = pictureSrc == null ? null : pictureSrc.trim();
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
		this.jumpAddress = jumpAddress == null ? null : jumpAddress.trim();
	}

	public Integer getExhibitionSate() {
		return exhibitionSate;
	}

	public void setExhibitionSate(Integer exhibitionSate) {
		this.exhibitionSate = exhibitionSate;
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

	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator == null ? null : operator.trim();
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(String modifyTime) {
		this.modifyTime = modifyTime;
	}

	public Long getSriRid() {
		return sriRid;
	}

	public void setSriRid(Long sriRid) {
		this.sriRid = sriRid;
	}

	public Long getRoomId() {
		return roomId;
	}

	public void setRoomId(Long roomId) {
		this.roomId = roomId;
	}

	public Long getScRid() {
		return scRid;
	}

	public void setScRid(Long scRid) {
		this.scRid = scRid;
	}

	public Long getSsuiRid() {
		return ssuiRid;
	}

	public void setSsuiRid(Long ssuiRid) {
		this.ssuiRid = ssuiRid;
	}

	public Integer getRoomType() {
		return roomType;
	}

	public void setRoomType(Integer roomType) {
		this.roomType = roomType;
	}

}