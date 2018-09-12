package com.shb.web.api.room;


import java.util.List;

import com.github.pagehelper.PageInfo;
import com.shb.web.dto.room.RoomDto;
import com.shb.web.dto.room.RoomDtos;
import com.shb.web.dto.room.RoomInfoDto;
import com.shb.web.mobile.room.RoomPicture;

/**
 * ������Ϣ
 * @author haoge
 *
 */
public interface RoomInfoService {
    
	PageInfo<RoomDtos> queryRoomInfoDtos(RoomInfoDto roomInfoDto, Integer pageNo, Integer pageSize);

	List<RoomPicture> queryRoomPicture(Long sriRid);

	PageInfo<RoomDtos> queryRoomInfoList(RoomInfoDto record,Integer pageNo, Integer pageSize, Long sliId);

	/*RoomInfo selectByPrimaryKey(Long sriRid);*/

	RoomDto queryRoomInfoById(Long sriRid, String username);
     
	/*List<RoomInfoDto> queryRoomInfoActivity();

	List<RoomInfoDto> queryRoomInfoActivityWei();

	List<RoomPriceCalendarDto> queryRoomPriceCalendar(RoomPriceCalendarDto roomPriceCalendarDto);

	List<RoomDtos> queryActivityRoomList(ActivityRoomSort activityRoomSort);

	RoomPriceCalendar querylandlordStatement(RoomPriceCalendar roomPrice);

	LandlordReceivables selectLandlordReceivablesInfoByRoomId(Long sriRid);
	
   List<RoomInfoTitle> queryRoomTitle(String roomTitle);
	
	List<Landlord> queryLandByNinkName(String ninkName);
	
	List<RoomBadTypeDto> queryRoomBadType(Long hotelId);
	
	List<RoomPriceCalendarDto> queryRoomPriceCount(RoomInfoDto roomInfoDto);*/


}

