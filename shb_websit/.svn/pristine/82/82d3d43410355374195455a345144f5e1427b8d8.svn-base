package com.shb.web.web.room;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.github.pagehelper.PageInfo;
import com.shb.web.api.activity.ShbRecommendedBitServcie;
import com.shb.web.api.city.RoomBannerInfoService;
import com.shb.web.api.redis.RedisService;
import com.shb.web.api.room.ReservationRoomService;
import com.shb.web.api.room.RoomInfoService;
import com.shb.web.api.room.RoomPriceCalendarService;
import com.shb.web.api.room.TradeareaOneService;
import com.shb.web.dto.room.ReservationRoomDto;
import com.shb.web.dto.room.RoomDto;
import com.shb.web.dto.room.RoomDtos;
import com.shb.web.dto.room.RoomInfoDto;
import com.shb.web.dto.room.RoomPriceCalendarDetailsDto;
import com.shb.web.mobile.activity.ShbRecommendedBit;
import com.shb.web.mobile.city.City;
import com.shb.web.mobile.room.RoomPicture;
import com.shb.web.mobile.room.RoomPriceCalendar;
import com.shb.web.mobile.room.TradeareaOne;
import com.shb.web.web.util.LocationUtils;

@RestController
@RequestMapping("roomInfoController")
public class RoomInfoController {

	@Autowired
	private RoomBannerInfoService roomBannerInfoService;

	@Autowired
	private RedisService redisService;

	@Autowired
	private RoomInfoService roomInfoService;

	@Autowired
	private ShbRecommendedBitServcie shbRecommendedBitServcie;

	@Autowired
	private ReservationRoomService reservationRoomService;

	@Autowired
	private RoomPriceCalendarService roomPriceCalendarService;

	@Autowired
	private TradeareaOneService tradeareaOneService;

	@Autowired
	RestTemplate restTemplate;

	// 线上
	private static String ul = "http://www.shanhaibian.com/shb_weixin";
	// private static String ul = "http://192.168.3.128/shb_weixin";

	/**
	 * 
	 * 查看房源信息列表
	 * 
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/queryRoomInfoDtos")
	private Map<String, Object> queryRoomInfoDtos(RoomInfoDto roomInfoDto, Integer bingPage,
			HttpServletRequest request) {

		Map<String, Object> map = new HashMap<String, Object>();

		PageInfo<RoomDtos> roomList = null;

		List<Long> srids = null;

		List<ShbRecommendedBit> shbRecommendedBitList = null;

		List<TradeareaOne> queryTradeareaOne = null;

		String sup = null;

		String cityName = "";

		String areaCode = "";

		try {

			if (roomInfoDto.getSupString() != null && !"".equals(roomInfoDto.getSupString())) {
				
				sup = (compare(roomInfoDto.getSupString()).replace(",","%"));
				
			}

			roomInfoDto.setSupString(sup);

			ShbRecommendedBit shbRecommendedBit = new ShbRecommendedBit();

			shbRecommendedBit.setFlag(3);

			shbRecommendedBitList = shbRecommendedBitServcie.queryShbRecommendedBitList(shbRecommendedBit);

			if (roomInfoDto.getCityName() == null || roomInfoDto.getCityName().equals("")) {

				cityName = "北京";

			} else {

				cityName = roomInfoDto.getCityName();
			}

			if (roomInfoDto.getAreaCode() == null || "".equals(roomInfoDto.getAreaCode())) {

				City city = roomBannerInfoService.querCityCode(cityName);

				if (city != null && city.getAreaCode() != null) {

					areaCode = city.getAreaCode(); // 获取城市编码

					roomInfoDto.setAreaCode(areaCode);

				}

			}

			queryTradeareaOne = tradeareaOneService.queryTradeareaOne(cityName, areaCode);

			if ((roomInfoDto.getLatitude() != null && roomInfoDto.getLongitude() != null)
					|| (roomInfoDto.getStartTime() != "" && roomInfoDto.getEndTime() != "")
							&& (roomInfoDto.getStartTime() != null && roomInfoDto.getEndTime() != null)) {
				
				if(roomInfoDto.getSort() == null){
				
					if(roomInfoDto.getLatitude() != null && roomInfoDto.getLongitude() != null){
						
						roomInfoDto.setSort(4); // 按距离价格排序
						
					}else{
						
						roomInfoDto.setSort(0); 
						
					}
					
				}
				
				roomList = roomInfoService.queryRoomInfoDtos(roomInfoDto, bingPage, 4);

				if (roomList.getList() != null && roomInfoDto.getLatitude() != null && roomInfoDto.getLongitude() != null) {

					srids = new ArrayList<Long>();

					for (RoomDtos str : roomList.getList()) {

						Double mis = LocationUtils.getDistance(roomInfoDto.getLatitude(), roomInfoDto.getLongitude(),
								str.getLatitude(), str.getLongitude());

						if (mis > 1000) {

							str.setDistance(formatDouble4(mis / 1000) + "Km");

						} else {

							str.setDistance(formatDouble2(mis) + "m");
						}

						if (roomInfoDto.getStartTime() == null) {

							srids.add(str.getSriId());

						}

					}
				}

				map.put("message", "查询成功!");

				map.put("messageCode", "001");

				map.put("roomList", roomList.getList());

				map.put("pags", roomList.getPages());

				map.put("shbRecommendedBitList", shbRecommendedBitList);

				map.put("queryTradeareaOne", queryTradeareaOne);

				map.put("bingPage", bingPage);

				return map;

			} else {

				areaCode = "_";

				if (roomInfoDto.getAreaCode() != null) {
					areaCode += roomInfoDto.getAreaCode();
				}

				if("".equals(roomInfoDto.getSupString())){
					
					roomInfoDto.setSupString(null);
					
				}
				
				if (roomInfoDto.getBedroomNumber() != 0 || roomInfoDto.getSupString()!=null || roomInfoDto.getHouseType() != null) {

					roomList = roomInfoService.queryRoomInfoDtos(roomInfoDto, bingPage, 4);

					map.put("message", "查询成功!");

					map.put("messageCode", "001");

					map.put("roomList", roomList.getList());

					map.put("pags", roomList.getPages());

					map.put("shbRecommendedBitList", shbRecommendedBitList);

					map.put("queryTradeareaOne", queryTradeareaOne);

					map.put("bingPage", bingPage);

					return map;

				}

				String room = "CITY_ROOMLIST_PC" + areaCode+"_" + bingPage;

				List<?> cityRoomList = redisService.lRange(room, 0, -1);

				if (cityRoomList != null && cityRoomList.size() > 0) {

					roomList = (PageInfo<RoomDtos>) cityRoomList.get(0);

				} else {

					roomList = roomInfoService.queryRoomInfoDtos(roomInfoDto, bingPage, 4);

					redisService.lPush(room, roomList);

					if (roomInfoDto.getUsername() != null && roomInfoDto.getUsername() != "") {

						redisService.expire(room, 60 * 60L);

					} else {

						redisService.expire(room, 60 * 60 * 24L);

					}

				}

				map.put("message", "查询成功!");

				map.put("messageCode", "001");

				map.put("roomList", roomList.getList());

				map.put("pags", roomList.getPages());

				map.put("shbRecommendedBitList", shbRecommendedBitList);

				map.put("queryTradeareaOne", queryTradeareaOne);

				map.put("bingPage", bingPage);

				return map;

			}

		} catch (Exception ex) {

			ex.printStackTrace();

			map.put("message", "系统异常!");

			map.put("messcode", "003");

			return map;

		}

	}

	/**
	 * 根据id查询房间图片
	 */

	@RequestMapping(value = "/queryRoomPictureListByRoomId")
	private Map<String, Object> queryRoomPictureListByRoomId(Long sriRid) {

		Map<String, Object> map = new HashMap<String, Object>();

		try {

			List<RoomPicture> roomPictureList = roomInfoService.queryRoomPicture(sriRid);

			map.put("message", "查询成功!");

			map.put("messcode", "001");

			map.put("roomPictureList", roomPictureList);

			return map;

		} catch (Exception ex) {

			ex.printStackTrace();

			map.put("message", "系统异常!");

			map.put("messcode", "003");

			return map;

		}

	}

	/**
	 * 查询城市信息
	 */

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/queryCityInfo")
	private Map<String, Object> queryCityInfo(String query) {

		Map<String, Object> map = new HashMap<String, Object>();

		String url = null;

		try {

			if (query != null && !"".equals(query)) {

				url = ul + "/appPullNewActivity/baiduQuery?query=" + query;

			} else {

				url = ul + "/city/queryCityInfo";

			}

			map = restTemplate.getForEntity(url, Map.class).getBody();

			return map;

		} catch (Exception ex) {

			ex.printStackTrace();

			map.put("message", "系统异常!");

			map.put("messcode", "003");

			return map;

		}

	}

	@RequestMapping(value = "/queryRoomInfoById")
	private Map<String, Object> queryRoomInfoById(@RequestParam(value = "sriRid", required = false) Long sriRid,
			String username) {

		Map<String, Object> map = new HashMap<String, Object>();

		RoomDto roomDtos = null;

		try {

			roomDtos = roomInfoService.queryRoomInfoById(sriRid, username);

			map.put("message", "查询成功!");

			map.put("messcode", "001");

			map.put("roomDtos", roomDtos);

			return map;

		} catch (Exception ex) {

			ex.printStackTrace();

			map.put("message", "系统异常!");

			map.put("messcode", "003");

			return map;

		}

	}

	@RequestMapping(value = "/queryReservationRoomInfo")
	private Map<String, Object> queryReservationRoomInfo(@ModelAttribute("RoomInfoDto") RoomInfoDto roomInfoDto,
			HttpServletRequest request, String username) {

		System.out.println(roomInfoDto.getDefaultNums());
		Map<String, Object> map = new HashMap<String, Object>();

		try {

			username = (String) redisService.get("LOGIN_USER_" + username);

			if (username == null) {

				map.put("messcode", "002");

				map.put("message", "登录失效请重新登陆!");

				return map;

			}

			roomInfoDto.setUsername(username);

			ReservationRoomDto reservationRoomDto = reservationRoomService.queryReservationRoomInfo(roomInfoDto);

			RoomPriceCalendar roomPriceCalendar = new RoomPriceCalendar();

			roomPriceCalendar.setStartTime(roomInfoDto.getStartTime());

			roomPriceCalendar.setStartTime(roomInfoDto.getEndTime());

			roomPriceCalendar.setNums(roomInfoDto.getDefaultNums());

			RoomPriceCalendarDetailsDto RoomPriceCalendarDetailsDto = roomPriceCalendarService
					.queryRoomPriceCalendarDetailsDto(roomPriceCalendar);

			map.put("RoomPriceCalendarDetailsDto", RoomPriceCalendarDetailsDto);

			map.put("reservationRoomDto", reservationRoomDto);

			map.put("messcode", "001");

			map.put("message", "查询成功!");

			return map;

		} catch (Exception ex) {

			ex.printStackTrace();

			map.put("message", "系统异常!");

			map.put("messcode", "003");

			return map;

		}

	}

	public static String formatDouble4(double d) {

		DecimalFormat df = new DecimalFormat("#.00");

		return df.format(d);
	}

	public static String formatDouble2(double d) {

		DecimalFormat df = new DecimalFormat("#");

		return df.format(d);
	}
	
	public static String compare(String s){
		
		String[] split = s.split(",");
		
		if(split.length == 1){
			
			return s;
			
		}
		
		int[] arr = new int[split.length];
		
		for(int a = 0 ; a < split.length; a++){
			
			arr[a] = Integer.parseInt(split[a]);
			
		}
		
		Arrays.sort(arr);
		
		String supString = "";
		
		for (Integer string : arr) {
			
			supString += ","+string;
			
		}
		
		return supString.substring(1);
	}
}
