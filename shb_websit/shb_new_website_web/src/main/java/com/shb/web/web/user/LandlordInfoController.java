package com.shb.web.web.user;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.shb.web.api.room.RoomEvaluateService;
import com.shb.web.api.room.RoomInfoService;
import com.shb.web.api.user.LandlordInfoService;
import com.shb.web.dto.room.RoomDtos;
import com.shb.web.dto.room.RoomInfoDto;
import com.shb.web.mobile.room.RoomEvaluate;
import com.shb.web.mobile.user.LandlordInfo;

@RestController
@RequestMapping("/LandlordInfo")
public class LandlordInfoController {
	
	@Autowired
	private LandlordInfoService landlordInfoService;
	
	@Autowired
	private RoomInfoService roomInfoService;
	
	@Autowired
	private RoomEvaluateService roomEvaluateService;

	 @RequestMapping(value = "/querylandlordInfoById")
	 private  Map<String,Object> querylandlordInfoById(@RequestParam(value = "sliId", required = false) Long sliId ,Integer bingPage){
		 
		  Map<String,Object> map =  new HashMap<String,Object>();
		  
		  PageInfo<RoomDtos> roomInfoList = null;
		  
		  PageInfo<RoomEvaluate> roomEvaluateList = null;
		  
		  LandlordInfo landlordInfo = null;
		  
		  Integer roomListSize = 0;
		  
		  Integer roomEvaluateListSize = 0;
		  
		  try {
			  
			  landlordInfo = landlordInfoService.queryLandlordInfoById(sliId);
			  
			  if (landlordInfo!=null && landlordInfo.getUsername()!=null){
				  
				  RoomInfoDto roomInfoDto = new RoomInfoDto();
				  
				  roomInfoDto.setRoomUpload(landlordInfo.getUsername());
				  
				  roomInfoList = roomInfoService.queryRoomInfoList(roomInfoDto, bingPage, 10,sliId);
				  
				  if(roomInfoList != null && roomInfoList.getList() != null){
					  
					  roomListSize = roomInfoList.getSize();
					  
				  }
				  
				  roomEvaluateList = roomEvaluateService.queryRoomEvaluateListByUsername(landlordInfo.getUsername(),bingPage, 10);
				  
				  if(roomEvaluateList != null && roomEvaluateList.getList() != null){
					  
					  roomEvaluateListSize = roomEvaluateList.getSize();
					  
				  }
				  
				  map.put("message", "成功!");
					  
				  map.put("messcode", "001");
					  
				  map.put("landlordInfo", landlordInfo);
					  
				  map.put("roomInfoList", roomInfoList);
				  
				  map.put("roomListSize", roomListSize);
				  
				  map.put("roomEvaluateList", roomEvaluateList);
				  
				  map.put("roomEvaluateListSize", roomEvaluateListSize);
					  
				  return map;
				  
			  }else {
				  
				  map.put("message", "暂无数据!");
				  
				  map.put("messcode", "002");
				  
				  return map;
				  
			  }
			  
		  }catch (Exception ex){
			  
			  ex.printStackTrace();
			  
              map.put("message", "系统异常!");
			  
			  map.put("messcode", "003");
			  
			  return map;
			  
		  }
		  
	 }

}
