package com.shb.web.dto.room;

import java.io.Serializable;
import java.util.List;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.shb.web.mobile.room.RoomPriceCalendar;

public class RoomPriceCalendarDetailsDto implements Serializable {

	private static final long serialVersionUID = -4567692331903226152L;

	private String roomTitle; // 房间标题

	public String getRoomTitle() {
		return roomTitle;
	}

	public void setRoomTitle(String roomTitle) {
		this.roomTitle = roomTitle;
	}

	public Double getTotal() {
		return total;
	}

	@JsonSerialize
	public void setTotal(Double total) {
		this.total = total;
	}

	public List<RoomPriceCalendar> getRoomPriceCalendarList() {
		return roomPriceCalendarList;
	}

	public void setRoomPriceCalendarList(List<RoomPriceCalendar> roomPriceCalendarList) {
		this.roomPriceCalendarList = roomPriceCalendarList;
	}

	private Double total; // 价格

	private List<RoomPriceCalendar> roomPriceCalendarList;

}
