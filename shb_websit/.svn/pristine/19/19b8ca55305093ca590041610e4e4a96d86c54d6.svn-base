package com.shb.web.api.room;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.shb.web.dto.room.RoomEvaluateDto;
import com.shb.web.mobile.room.RoomEvaluate;
import com.shb.web.mobile.room.RoomEvaluatePicture;
import com.shb.web.mobile.user.User;

public interface RoomEvaluateService {

	List<RoomEvaluateDto> queryRoomEvaluate(Long sriRid, Integer pageNo, Integer pageSize);

	Long insertSelective(RoomEvaluate roomEvaluate);

	List<RoomEvaluatePicture> queryRoomEvaluatePicture(Long sreRid);

	User queryUserRoomEvaluateOrder(User user);

	PageInfo<RoomEvaluate> queryRoomEvaluateListByUsername(String username, Integer bingPage, Integer pageSize);

}
