package com.shb.web.api.room;

import com.shb.web.dto.room.ReservationRoomDto;
import com.shb.web.dto.room.RoomInfoDto;

public interface ReservationRoomService {

	ReservationRoomDto queryReservationRoomInfo(RoomInfoDto roomInfoDto);
	
}
