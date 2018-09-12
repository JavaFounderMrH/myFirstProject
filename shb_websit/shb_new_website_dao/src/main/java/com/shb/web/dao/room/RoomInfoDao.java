package com.shb.web.dao.room;

import java.util.List;

import com.shb.web.dto.room.RoomDtos;
import com.shb.web.dto.room.RoomInfoDto;
import com.shb.web.dto.room.RoomPriceCalendarDto;
import com.shb.web.mobile.room.ReservationRoom;
import com.shb.web.mobile.room.RoomPicture;
import com.shb.web.mobile.room.RoomPriceCalendar;
import com.shb.web.mobile.room.RoomSupportingFacilities;
import com.shb.web.mobile.user.LandlordService;

public interface RoomInfoDao {

	List<RoomDtos> queryRoomInfoList(RoomInfoDto record);

	RoomInfoDto queryRoomInByRoomId(RoomInfoDto roomInfoDto);

	ReservationRoom queryReservationRoom(Long sriId);

	RoomPriceCalendar queryRoomPriceCalendarTotal(RoomPriceCalendar roomPriceCalendar);

	List<RoomPriceCalendar> queryRoomPriceCalendarTime(Long sriId);

	RoomPriceCalendar queryRoomPriceCalendarNums(RoomPriceCalendar roomPriceCalendar);

	List<RoomPicture> queryRoomPicture(Long sriId);

    List<RoomSupportingFacilities>queryRoomSupportingFacilities(Long sriId);

	List<LandlordService> queryRoomLandlordService(Long sriId);

	List<RoomPriceCalendarDto> queryRoomPriceCalendar(RoomPriceCalendarDto roomPriceCalendarDto);

	RoomPriceCalendar querylandlordStatement(RoomPriceCalendar roomPrice);

	}
