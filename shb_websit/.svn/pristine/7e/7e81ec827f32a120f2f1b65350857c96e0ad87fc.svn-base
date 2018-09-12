package com.shb.web.service.room;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shb.web.api.room.RoomPriceCalendarService;
import com.shb.web.dao.order.ShbOrderDetailedMapper;
import com.shb.web.dao.room.RoomInfoDao;
import com.shb.web.dao.room.RoomPriceCalendarDao;
import com.shb.web.dto.room.RoomInfoDto;
import com.shb.web.dto.room.RoomPriceCalendarDetailsDto;
import com.shb.web.mobile.room.RoomPriceCalendar;
@Service
public class RoomPriceCalendarServiceImpl implements RoomPriceCalendarService {
	
	@Autowired
	private  RoomPriceCalendarDao roomPriceCalendarDao;
	
	@Autowired
	private RoomInfoDao roomInfoDao;
	
	@Autowired
	private ShbOrderDetailedMapper shbOrderDetailedMapper;
	

	@Override
	public RoomPriceCalendarDetailsDto queryRoomPriceCalendarDetailsDto(RoomPriceCalendar roomPriceCalendar) {
		
		RoomPriceCalendarDetailsDto  roomPriceCalendarDetailsDto = null;
		
		Integer Overnight = 2;
		
		List<RoomPriceCalendar> roomPriceCalendarList = null;
		
		try {
			
			roomPriceCalendarDetailsDto = new RoomPriceCalendarDetailsDto();
			
			RoomInfoDto roomInfoDto = new RoomInfoDto();
			
			roomInfoDto.setSriId(roomPriceCalendar.getSriRid());
			
			RoomInfoDto roomInfoDtos = roomInfoDao.queryRoomInByRoomId(roomInfoDto);
			
			if (roomInfoDtos != null){
			
			if (roomInfoDtos.getRoomTitle()!=null){
				
				roomPriceCalendarDetailsDto.setRoomTitle(roomInfoDtos.getRoomTitle());
				
			}
			
			if(roomPriceCalendar.getOrderId()==null ||roomPriceCalendar.getOrderId()==0){
				
                   if (roomInfoDtos.getWhetherOvernight()==1){
					
					Overnight = 1;
				}
				
	           if (roomInfoDtos.getWhetherOvernight()==0){
					
					Overnight = 2;
				}
				
				roomPriceCalendar.setOvernight(Overnight);
				
				 roomPriceCalendarList = roomPriceCalendarDao.queryRoomPriceCalendarPriceDetails(roomPriceCalendar);
				
			}else {

				roomPriceCalendarList = shbOrderDetailedMapper.queryShbOderPriceDetails(roomPriceCalendar);

			}
			
			roomPriceCalendarDetailsDto.setRoomPriceCalendarList(roomPriceCalendarList);
			
			}
			
		}catch (Exception ex){
			
			ex.printStackTrace();
			
			return roomPriceCalendarDetailsDto;
			
		}
		
		return roomPriceCalendarDetailsDto;
	}
}
