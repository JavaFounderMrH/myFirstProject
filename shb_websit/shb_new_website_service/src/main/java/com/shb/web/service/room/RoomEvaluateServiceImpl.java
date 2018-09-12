package com.shb.web.service.room;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shb.web.api.room.RoomEvaluateService;
import com.shb.web.dao.room.RoomEvaluateDao;
import com.shb.web.dto.room.RoomEvaluateDto;
import com.shb.web.mobile.room.RoomEvaluate;
import com.shb.web.mobile.room.RoomEvaluatePicture;
import com.shb.web.mobile.user.User;

@Service
public class RoomEvaluateServiceImpl implements RoomEvaluateService {
	
	@Autowired
	private RoomEvaluateDao roomEvaluateDao;

	@Override
	public List<RoomEvaluateDto> queryRoomEvaluate(Long sriRid, Integer pageNo, Integer pageSize) {
		
		List<RoomEvaluateDto> roomEvaluateDtoList = null;
		
		RoomEvaluateDto roomEvaluateDto = null;
		
		PageInfo<User> page = null;
		
		try {
			
			pageNo = pageNo == null ? 1 : pageNo;

			pageSize = pageSize == null ? 10 : pageSize;

			PageHelper.startPage(pageNo, pageSize);
			
			List<User> userList = roomEvaluateDao.queryUserRoomEvaluate(sriRid);
			
			page = new PageInfo<User>(userList);
			
			Integer pages = page.getPages();
			
			if (page.getList()!=null && page.getList().size() >0){
				
				roomEvaluateDtoList = new ArrayList<RoomEvaluateDto>();
				
				for (User ser:page.getList()){
					
					roomEvaluateDto = new RoomEvaluateDto();
					
					roomEvaluateDto.setUser(ser);
					
					List <RoomEvaluatePicture>  roomEvaluatePicture = roomEvaluateDao.queryRoomEvaluatePicture(ser.getSreId());
					
					roomEvaluateDto.setRoomEvaluatePictureList(roomEvaluatePicture);
					
					roomEvaluateDto.setBingPage(pageNo);
					
					roomEvaluateDto.setPages(pages);
					
					roomEvaluateDtoList.add(roomEvaluateDto);	
				}
				
			}
			
		}catch (Exception ex){
			
			ex.printStackTrace();
			
			return roomEvaluateDtoList;
			
			
		}
		return roomEvaluateDtoList;
	}

	@Override
	public Long insertSelective(RoomEvaluate roomEvaluate) {
		return roomEvaluateDao.insertSelective(roomEvaluate);
	}

	@Override
	public List<RoomEvaluatePicture> queryRoomEvaluatePicture(Long sreRid) {
		return roomEvaluateDao.queryRoomEvaluatePicture(sreRid);
	}

	@Override
	public User queryUserRoomEvaluateOrder(User user) {
		return roomEvaluateDao.queryUserRoomEvaluateOrder(user);
	}

	@Override
	public PageInfo<RoomEvaluate> queryRoomEvaluateListByUsername(String username,Integer pageNo,Integer pageSize) {
		
		PageInfo<RoomEvaluate> page = null;
		
		try {
			
			pageNo = pageNo == null ? 1 : pageNo;

			pageSize = pageSize == null ? 10 : pageSize;

			PageHelper.startPage(pageNo, pageSize);
			
			List<RoomEvaluate> list = roomEvaluateDao.queryRoomEvaluateListByUsername(username);
			
			page = new PageInfo<RoomEvaluate>(list);
			
		}catch (Exception e) {
			
			e.printStackTrace();
		
		}
		
		return page;
				
	}
	
}
