package com.shb.web.api.room;

import com.shb.web.dto.room.RoomPriceCalendarDetailsDto;
import com.shb.web.mobile.room.RoomPriceCalendar;

public interface RoomPriceCalendarService {

	public RoomPriceCalendarDetailsDto queryRoomPriceCalendarDetailsDto(RoomPriceCalendar roomPriceCalendar);

}
