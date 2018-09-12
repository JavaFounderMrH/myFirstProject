package com.shb.web.dto.room;

import java.io.Serializable;
import java.util.List;

import com.shb.web.dto.user.LandlordProhibitDto;
import com.shb.web.mobile.room.RoomBedClassification;
import com.shb.web.mobile.room.RoomEvaluate;
import com.shb.web.mobile.room.RoomPicture;
import com.shb.web.mobile.room.RoomSupportingFacilities;
import com.shb.web.mobile.user.LandlordInfo;
import com.shb.web.mobile.user.LandlordService;
import com.shb.web.mobile.user.User;

@SuppressWarnings("serial")
public class RoomDto implements Serializable {

	private RoomInfoDto roomInfo; // 房间信息

	private List<RoomPicture> roomPictureList; // 房间图片信息

	private List<RoomBedClassification> roomBedClassificationList; // 床位信息

	private List<RoomSupportingFacilities> roomSupportingFacilitiesList; // 配套设施

	private LandlordInfo landlordInfo; // 房东信息

	private List<RoomEvaluate> roomEvaluateList; // 用户评论

	private List<User> userEvaluateList;

	private List<LandlordService> landlordService; // 房东服务

	private List<RoomDtos> RoomInfoDtoList;

	private List<RoomPriceCalendarDto> roomPriceCalendarListDto; // 房间日历价格

	private LandlordProhibitDto landlordProhibitDto; // 房东禁止服务

	private String refundAgreement; // 退款协议

	public String getRefundAgreement() {
		return refundAgreement;
	}

	public void setRefundAgreement(String refundAgreement) {
		this.refundAgreement = refundAgreement;
	}

	public LandlordProhibitDto getLandlordProhibitDto() {
		return landlordProhibitDto;
	}

	public void setLandlordProhibitDto(LandlordProhibitDto landlordProhibitDto) {
		this.landlordProhibitDto = landlordProhibitDto;
	}

	public List<RoomPriceCalendarDto> getRoomPriceCalendarListDto() {
		return roomPriceCalendarListDto;
	}

	public void setRoomPriceCalendarListDto(List<RoomPriceCalendarDto> roomPriceCalendarListDto) {
		this.roomPriceCalendarListDto = roomPriceCalendarListDto;
	}

	public List<RoomDtos> getRoomInfoDtoList() {
		return RoomInfoDtoList;
	}

	public void setRoomInfoDtoList(List<RoomDtos> roomInfoDtoList) {
		RoomInfoDtoList = roomInfoDtoList;
	}

	public List<User> getUserEvaluateList() {
		return userEvaluateList;
	}

	public void setUserEvaluateList(List<User> userEvaluateList) {
		this.userEvaluateList = userEvaluateList;
	}

	public RoomInfoDto getRoomInfo() {
		return roomInfo;
	}

	public void setRoomInfo(RoomInfoDto roomInfo) {
		this.roomInfo = roomInfo;
	}

	public List<RoomPicture> getRoomPictureList() {
		return roomPictureList;
	}

	public void setRoomPictureList(List<RoomPicture> roomPictureList) {
		this.roomPictureList = roomPictureList;
	}

	public List<RoomBedClassification> getRoomBedClassificationList() {
		return roomBedClassificationList;
	}

	public void setRoomBedClassificationList(List<RoomBedClassification> roomBedClassificationList) {
		this.roomBedClassificationList = roomBedClassificationList;
	}

	public List<RoomSupportingFacilities> getRoomSupportingFacilitiesList() {
		return roomSupportingFacilitiesList;
	}

	public void setRoomSupportingFacilitiesList(List<RoomSupportingFacilities> roomSupportingFacilitiesList) {
		this.roomSupportingFacilitiesList = roomSupportingFacilitiesList;
	}

	public LandlordInfo getLandlordInfo() {
		return landlordInfo;
	}

	public void setLandlordInfo(LandlordInfo landlordInfo) {
		this.landlordInfo = landlordInfo;
	}

	public List<RoomEvaluate> getRoomEvaluateList() {
		return roomEvaluateList;
	}

	public void setRoomEvaluateList(List<RoomEvaluate> roomEvaluateList) {
		this.roomEvaluateList = roomEvaluateList;
	}

	public List<LandlordService> getLandlordService() {
		return landlordService;
	}

	public void setLandlordService(List<LandlordService> landlordService) {
		this.landlordService = landlordService;
	}

}
