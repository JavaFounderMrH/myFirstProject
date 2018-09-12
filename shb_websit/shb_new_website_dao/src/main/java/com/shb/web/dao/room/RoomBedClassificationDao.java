package com.shb.web.dao.room;

import java.util.List;

import com.shb.web.mobile.room.RoomBedClassification;

public interface RoomBedClassificationDao {

	Integer queryRoomBedClassificationCount(Long sriRid);

	List<RoomBedClassification> queryRoomBedType(Long sriRid);

}