package com.shb.web.service.room;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shb.web.api.redis.RedisService;
import com.shb.web.api.room.RoomInfoService;
import com.shb.web.dao.room.RoomBannerInfoDao;
import com.shb.web.dao.room.RoomBedClassificationDao;
import com.shb.web.dao.room.RoomCollectionDao;
import com.shb.web.dao.room.RoomEvaluateDao;
import com.shb.web.dao.room.RoomInfoDao;
import com.shb.web.dao.room.RoomPriceCalendarDao;
import com.shb.web.dao.user.LandlordInfoDao;
import com.shb.web.dto.room.RoomDto;
import com.shb.web.dto.room.RoomDtos;
import com.shb.web.dto.room.RoomInfoDto;
import com.shb.web.dto.room.RoomPriceCalendarDto;
import com.shb.web.dto.user.LandlordProhibitDto;
import com.shb.web.mobile.city.City;
import com.shb.web.mobile.room.RoomBedClassification;
import com.shb.web.mobile.room.RoomCollection;
import com.shb.web.mobile.room.RoomPicture;
import com.shb.web.mobile.room.RoomPriceCalendar;
import com.shb.web.mobile.room.RoomSupportingFacilities;
import com.shb.web.mobile.user.LandlordInfo;
import com.shb.web.mobile.user.LandlordService;
import com.shb.web.mobile.user.User;

@Service
public class RoomInfoServiceImpl implements RoomInfoService {

	@Autowired
	private RoomInfoDao roomInfoDao;

	@Autowired
	private RoomPriceCalendarDao roomPriceCalendarDao;

	@Autowired
	private RoomBannerInfoDao roomBannerInfoDao;

	@Autowired
	private RedisService redisService;

	@Autowired
	private RoomBedClassificationDao roomBedClassificationDao;

	@Autowired
	private LandlordInfoDao landlordInfoDao;

	@Autowired
	private RoomEvaluateDao roomEvaluateDao;
	
	@Autowired
	private RoomCollectionDao roomCollectionDao;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM");

	@Override
	public PageInfo<RoomDtos> queryRoomInfoDtos(RoomInfoDto record, Integer pageNo, Integer pageSize) {
		PageInfo<RoomDtos> page = null;

		List<Long> srids = null;

		List<RoomDtos> list = null;

		try {

			if (record.getStartTime() != null && record.getEndTime() != null && record.getStartTime() != ""
					&& record.getEndTime() != "") {

				RoomPriceCalendar roomPriceCalendar = new RoomPriceCalendar();

				roomPriceCalendar.setStartTime(record.getStartTime());

				roomPriceCalendar.setEndTime(record.getEndTime());

				List<RoomPriceCalendar> roomPriceNums = roomPriceCalendarDao.queryRoomNumsCount(roomPriceCalendar);

				if (roomPriceNums != null && roomPriceNums.size() > 0) {

					srids = new ArrayList<Long>();

					for (RoomPriceCalendar st : roomPriceNums) {

						srids.add(st.getSriRid());

					}

					record.setSriIds(srids);

				}

			}

			if (record.getAreaCode() == null || "".equals(record.getAreaCode())) {

				if (record.getCityName() != null && !record.getCityName().equals("")) {

					String cityName = "";

					String areaCode = "";

					cityName = record.getCityName();

					City city = roomBannerInfoDao.querCityCode(cityName);

					if (city != null && city.getAreaCode() != null) {

						areaCode = city.getAreaCode();

						record.setAreaCode(areaCode);

					}

				}

			}

			pageNo = pageNo == null ? 1 : pageNo;

			pageSize = pageSize == null ? 10 : pageSize;

			PageHelper.startPage(pageNo, pageSize);

			if (record.getLatitude() != null && record.getLatitude().toString().indexOf("E") != -1) {

				record.setLatitude(null);

				record.setLongitude(null);
				
			}

			if (record.getLatitude() != null && record.getLatitude() == 0.0) {

				record.setLatitude(null);

				record.setLongitude(null);
				
			}

			if (record.getLatitude() != null) {
				
				if (record.getSort() == 0 || record.getSort() == null)
					record.setSort(4);

				record.setRoomTitle(null);

			}

			list = roomInfoDao.queryRoomInfoList(record);

			page = new PageInfo<RoomDtos>(list);

		} catch (Exception ex) {

			ex.printStackTrace();

			return page;
		}

		return page;
	}

	@Override
	public List<RoomPicture> queryRoomPicture(Long sriRid) {

		return roomInfoDao.queryRoomPicture(sriRid);
	}

	@SuppressWarnings("unchecked")
	@Override
	public PageInfo<RoomDtos> queryRoomInfoList(RoomInfoDto record, Integer pageNo, Integer pageSize, Long sliId) {

		PageInfo<RoomDtos> page = null;

		try {

			pageNo = pageNo == null ? 1 : pageNo;

			pageSize = pageSize == null ? 10 : pageSize;

			PageHelper.startPage(pageNo, pageSize);

			List<RoomDtos> list = null;

			List<?> listfromRedis = redisService.lRange("PC_LANDLORD_MORE_ROOM_" + sliId, 0, -1);

			if (listfromRedis.size() > 0) {

				list = (List<RoomDtos>) listfromRedis.get(0);

			} else {

				list = roomInfoDao.queryRoomInfoList(record);

				redisService.lPush("PC_LANDLORD_MORE_ROOM_" + sliId, list);

				redisService.expire("PC_LANDLORD_MORE_ROOM_" + sliId, 60 * 60 * 24L);

			}

			page = new PageInfo<RoomDtos>(list);

		} catch (Exception ex) {

			ex.printStackTrace();

			return page;

		}

		return page;
	}

	@SuppressWarnings("unchecked")
	@Override
	public RoomDto queryRoomInfoById(Long srId, String username) {

		RoomDto roomDto = null;

		Integer rooroomUpDay = 0;

		String strs[] = new String[] { "当天", "前一天", "前两天", "前三天", "前四天", "前五天", "前六天", "前七天" };

		String roomInfo = "PC_ROOMINFO_";
		
		RoomInfoDto roomInfoDto = null;
		
		String startTime = "";
		
		String endTime = "";
		
		Calendar c = Calendar.getInstance();

		try {
				
				RoomInfoDto roomInfoDtos = new RoomInfoDto();

				roomInfoDtos.setSriId(srId);

				roomInfoDto = roomInfoDao.queryRoomInByRoomId(roomInfoDtos);
			
			/*if(username != null && !"".equals(username) && roomInfoDto != null){
				
				RoomCollection roomCollection = new RoomCollection();
				
				roomCollection.setSriRid(srId);
				
				roomCollection.setUsername(username);
				
				RoomCollection queryRoomCollection = roomCollectionDao.queryRoomCollection(roomCollection);
				
				if(queryRoomCollection != null){
					
					roomInfoDto.setFalg(1);
					
				}else{
					
					roomInfoDto.setFalg(0);
					
				}
				
			}*/

			if (roomInfoDto != null) {

				LandlordProhibitDto landlordProhibitDto = new LandlordProhibitDto();

				roomDto = new RoomDto();

				roomDto.setRoomInfo(roomInfoDto);

				if (roomInfoDto.getWhertherRefund() != null) {

					if (roomInfoDto.getWhertherRefund() == 1) {

						if (roomInfoDto.getRoomUpDay() != null) {

							rooroomUpDay = roomInfoDto.getRoomUpDay();
						}

						roomDto.setRefundAgreement(strs[rooroomUpDay]);

					}
				}

				if (roomInfoDto.getReceptionSex() != null) {

					if (roomInfoDto.getReceptionSex() == 1) {

						landlordProhibitDto.setReceptionSex("不接待男士");
					}

					if (roomInfoDto.getReceptionSex() == 2) {

						landlordProhibitDto.setReceptionSex("不接待女士");
					}
				}

				if (roomInfoDto.getWhetherPet() != null && roomInfoDto.getWhetherPet() == 0) {

					landlordProhibitDto.setWhetherPet("不允许带宠物");

				}

				if (roomInfoDto.getWhetherSomking() != null && roomInfoDto.getWhetherSomking() == 0) {

					landlordProhibitDto.setWhetherSomking("不允许抽烟");

				}

				if (roomInfoDto.getWhetherParty() != null && roomInfoDto.getWhetherParty() == 0) {

					landlordProhibitDto.setWhetherParty("不允许聚会");

				}

				if (roomInfoDto.getWhetherCook() != null && roomInfoDto.getWhetherCook() == 0) {

					landlordProhibitDto.setWhetherCook("不允许做饭");

				}

				if (roomInfoDto.getReceptionAge() == null || roomInfoDto.getReceptionAge().equals("")) {

					landlordProhibitDto.setReceptionAgeZero("不接待儿童（0-12岁）");

					landlordProhibitDto.setReceptionAgeSix("不接待老人（65岁以上）");

					landlordProhibitDto.setReceptionAgeGuests("不接待外宾");

				} else {

					String receptionAge = roomInfoDto.getReceptionAge();

					String str[] = receptionAge.split(",");

					for (int i = 0; i < str.length; i++) {

						if (str.length == 1) {

							if (str[i].equals("1")) {

								landlordProhibitDto.setReceptionAgeSix("不接待老人（65岁以上）");

								landlordProhibitDto.setReceptionAgeGuests("不接待外宾");

							} else if (str[i].equals("2")) {

								landlordProhibitDto.setReceptionAgeZero("不接待儿童（0-12岁）");

								landlordProhibitDto.setReceptionAgeGuests("不接待外宾");

							} else if (str[i].equals("3")) {

								landlordProhibitDto.setReceptionAgeZero("不接待儿童（0-12岁）");

								landlordProhibitDto.setReceptionAgeSix("不接待老人（65岁以上）");

							}
						} else if (str.length == 2) {

							if (str[0].equals("1") && str[1].equals("2")) {

								landlordProhibitDto.setReceptionAgeGuests("不接待外宾");

							} else if (str[0].equals("1") && str[1].equals("3")) {

								landlordProhibitDto.setReceptionAgeSix("不接待老人（65岁以上）");

							} else if (str[0].equals("2") && str[1].equals("3")) {

								landlordProhibitDto.setReceptionAgeZero("不接待儿童（0-12岁）");

							}

						}
					}
				}

				roomDto.setLandlordProhibitDto(landlordProhibitDto);

				List<RoomPicture> roomPictureList = null;

				List<RoomBedClassification> RoomBedClassificationList = null;

				List<RoomSupportingFacilities> roomSupportingFacilitiesList = null;

				List<User> roomEvaluateList = null;

				List<LandlordService> LandlordServiceList = null;

				List<RoomDtos> roomList = null;

				roomPictureList = roomInfoDao.queryRoomPicture(roomInfoDto.getSriId());

				roomDto.setRoomPictureList(roomPictureList);

				RoomBedClassificationList = roomBedClassificationDao.queryRoomBedType(roomInfoDto.getSriId());

				roomDto.setRoomBedClassificationList(RoomBedClassificationList);

				roomSupportingFacilitiesList = roomInfoDao.queryRoomSupportingFacilities(roomInfoDto.getSriId());

				roomDto.setRoomSupportingFacilitiesList(roomSupportingFacilitiesList);

				if (roomInfoDto.getRoomUpload() != null && !roomInfoDto.getRoomUpload().equals("")) {

					LandlordInfo landlordInfo = landlordInfoDao.queryLandlordInfoByName(roomInfoDto.getRoomUpload());

					roomDto.setLandlordInfo(landlordInfo);
				}

				roomEvaluateList = roomEvaluateDao.queryUserRoomEvaluate(roomInfoDto.getSriId());

				if (roomEvaluateList != null && roomEvaluateList.size() > 0) {

					roomDto.setUserEvaluateList(roomEvaluateList);

				}

				LandlordServiceList = roomInfoDao.queryRoomLandlordService(roomInfoDto.getSriId());

				roomDto.setLandlordService(LandlordServiceList);

				Double longitude = 0.0;

				Double latitude = 0.0;

				List<Long> srIds = null;

				if (roomInfoDto.getLongitude() != null && !roomInfoDto.getLongitude().equals("")) {

					longitude = roomInfoDto.getLongitude();

				}

				if (roomInfoDto.getLatitude() != null && !roomInfoDto.getLatitude().equals("")) {

					latitude = roomInfoDto.getLatitude();

				}

				srIds = new ArrayList<Long>();

				if (srId != null) {

					srIds.add(srId);

				}

				if (srIds != null && srIds.size() > 0) {

					roomInfoDto.setSriIds(srIds);

				}

				roomInfoDto.setSriId(null);

				roomInfoDto.setLatitude(latitude);

				roomInfoDto.setLongitude(longitude);

				roomList = roomInfoDao.queryRoomInfoList(roomInfoDto);

				roomDto.setRoomInfoDtoList(roomList);

				List<RoomPriceCalendarDto> roomPriceCalendarList = null;

				RoomPriceCalendarDto roomPriceCalendarDto = new RoomPriceCalendarDto();

				String time = dateFormat.format(new Date());
				  
				time  = time+"-31";
				
				roomPriceCalendarDto.setType(1);

				roomPriceCalendarDto.setSriRid(srId);
				
				roomPriceCalendarDto.setTime(time);

				roomPriceCalendarList = roomInfoDao.queryRoomPriceCalendar(roomPriceCalendarDto);

				roomDto.setRoomPriceCalendarListDto(roomPriceCalendarList);
				
				List<RoomPriceCalendar> roomPriceCalendarLists = roomInfoDao.queryRoomPriceCalendarTime(roomInfoDto.getSriId());

				if (roomPriceCalendarLists != null && roomPriceCalendarLists.size() > 0) {

					startTime = roomPriceCalendarLists.get(0).getTime();

					endTime = startTime;

					Date da = sdf.parse(endTime);

					c.setTime(da);

					int day = c.get(Calendar.DATE);

					c.set(Calendar.DATE, day + 1);

					endTime = sdf.format(c.getTime());

				} else {

					startTime = sdf.format(new Date());

					int day = c.get(Calendar.DATE);

					c.set(Calendar.DATE, day + 1);

					endTime = sdf.format(c.getTime());

				}
				
				roomInfoDto.setStartTime(startTime);
				
				roomInfoDto.setEndTime(endTime);

			}

		} catch (Exception ex) {

			ex.printStackTrace();

		}

		return roomDto;

	}

}
