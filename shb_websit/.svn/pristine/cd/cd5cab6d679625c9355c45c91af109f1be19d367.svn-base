package com.shb.web.dao.room;

import java.util.List;

import com.shb.web.mobile.room.RoomEvaluate;
import com.shb.web.mobile.room.RoomEvaluatePicture;
import com.shb.web.mobile.user.User;

public interface RoomEvaluateDao {

	RoomEvaluate queryRoomEvaluateInfo(Long sriRid);

	List<User> queryUserRoomEvaluate(Long sriRid);

	List<RoomEvaluatePicture> queryRoomEvaluatePicture(Long sreRid);

	Long insertSelective(RoomEvaluate roomEvaluate);

	User queryUserRoomEvaluateOrder(User user);

	List<RoomEvaluate> queryRoomEvaluateListByUsername(String username);
	
}