package com.shb.web.web.order;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.shb.web.api.coupon.CouponService;
import com.shb.web.api.order.OrderRefundService;
import com.shb.web.api.order.OrderStateService;
import com.shb.web.api.order.ShbOrderInfoService;
import com.shb.web.api.redis.RedisService;
import com.shb.web.api.room.RoomEvaluateService;
import com.shb.web.api.room.RoomPriceCalendarService;
import com.shb.web.dto.order.ShbOrderInfoDto;
import com.shb.web.dto.room.RoomEvaluateDto;
import com.shb.web.dto.room.RoomPriceCalendarDetailsDto;
import com.shb.web.mobile.coupon.Coupon;
import com.shb.web.mobile.order.OrderRefund;
import com.shb.web.mobile.order.OrderState;
import com.shb.web.mobile.order.ShbOrderInfo;
import com.shb.web.mobile.room.RoomEvaluatePicture;
import com.shb.web.mobile.room.RoomPriceCalendar;
import com.shb.web.mobile.user.User;
import com.shb.web.web.util.Client;

@RestController
@RequestMapping("/orderInfo")
public class ShbOrderInfoController {

	@Autowired
	private ShbOrderInfoService shbOrderInfoService;

	@Autowired
	private RoomPriceCalendarService roomPriceCalendarService;

	@Autowired
	private OrderStateService orderStateService;

	@Autowired
	private OrderRefundService orderRefundService;

	@Autowired
	private RoomEvaluateService roomEvaluateService;

	@Autowired
	private CouponService couponService;

	@Autowired
	private RedisService redisService;

	@Autowired
	RestTemplate restTemplate;

	//private static String ul = "http://www.shanhaibian.com/shb_weixin";
	private static String ul = "http://192.168.3.106/shb_weixin";

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/insertOrderInfo")
	public Map<String, Object> insertOrderInfo(@ModelAttribute("ShbOrderInfo") ShbOrderInfo orderInfo) {

		Map<String, Object> map = new HashMap<String, Object>();

		String userName = orderInfo.getUserName();

		String user = (String) redisService.get("LOGIN_USER_" + userName);

		if (user == null || "".equals(user)) {

			map.put("messcode", "002");

			map.put("message", "登录失效已过期请重新登陆!");

			return map;

		} else {

			redisService.set("LOGIN_USER_" + userName, userName, 30 * 24 * 60 * 60L);

			Long sriRid = orderInfo.getSriRid();

			String startTime = orderInfo.getStartTime();

			String endTime = orderInfo.getEndTime();

			String name = orderInfo.getName();

			String phone = orderInfo.getPhone();

			Integer reserveNumber = orderInfo.getReserveNumber();

			Integer checkNumber = orderInfo.getCheckNumber();

			Double priceTotal = orderInfo.getPriceTotal();

			Integer couponPrice = orderInfo.getCouponPrice();

			Double actualPrice = orderInfo.getActualPrice();

			Long scRid = orderInfo.getScRid();

			String url = ul + "/orderInfo/insertOrderInfo?userName=" + userName + "&sriRid=" + sriRid + "&startTime="
					+ startTime + "&endTime=" + endTime + "&name=" + name + "&phone=" + phone + "&reserveNumber="
					+ reserveNumber + "&checkNumber=" + checkNumber + "&priceTotal=" + priceTotal + "&couponPrice="
					+ couponPrice + "&actualPrice=" + actualPrice + "&scRid=" + scRid;

			map = restTemplate.getForEntity(url, Map.class).getBody();

			return map;

		}
		
	}

	@RequestMapping(value = "/confirmOrder")
	public Map<String, Object> confirmOrder(ShbOrderInfo orderInfo) {

		Map<String, Object> map = new HashMap<String, Object>();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		Integer state = 0;

		Coupon co = null;

		String username = "";

		ShbOrderInfo shbOrderInfo = null;

		OrderRefund orderRefund = null;

		try {

			shbOrderInfo = new ShbOrderInfo();

			shbOrderInfo.setSoiId(orderInfo.getSoiId());

			Map<String, Object> order = shbOrderInfoService.findOrderInfo(orderInfo);

			username = order.get("phone").toString();

			if (orderInfo.getState() != null && orderInfo.getState() == 6) {

				shbOrderInfo = new ShbOrderInfo();

				shbOrderInfo.setSoiId(orderInfo.getSoiId());

				Map<String, Object> maps = shbOrderInfoService.findOrderInfo(orderInfo);

				shbOrderInfo.setStartTime(maps.get("startTime").toString());

				shbOrderInfo.setEndTime(maps.get("endTime").toString());

				shbOrderInfo.setReserveNumber(Integer.valueOf(maps.get("reserveNumber").toString()));

				shbOrderInfo.setSriRid(Long.valueOf(maps.get("sriRid").toString()));

				if (maps.get("whetherOvernight") != null) {

					if (Integer.valueOf(maps.get("whetherOvernight").toString()) == 1) {

						shbOrderInfo.setFlag(1);

					} else {

						shbOrderInfo.setFlag(2);

					}
					
				}

				shbOrderInfoService.updatePrice(shbOrderInfo);

				if (maps.get("scRid") != null) {

					co = new Coupon();

					co.setScId(Long.valueOf(maps.get("scRid").toString()));

					co.setState(1);

					couponService.updateByPrimaryKeySelective(co);
					
				}

				if (maps.get("landPhone") != null) {

					Client.mdsmssend(maps.get("landPhone").toString(),
							"【山海边】订单" + orderInfo.getSoiId() + "已失效，失效原因：用户已取消订单，如有疑问请拨打山海边客服电话：4001500599。");
				
				}

			}

			if (orderInfo.getStsate() != null && orderInfo.getStsate() == 8) {

				state = 2;

				orderRefund = new OrderRefund();

				orderRefund.setSrId(orderInfo.getSrId());

				orderRefund.setRefundState(4); // 取消退款

				orderRefundService.updateByPrimaryKeySelective(orderRefund);

			} else {

				state = orderInfo.getState();

			}

			orderInfo.setState(state);

			OrderState orderStat = null;

			if (orderInfo.getStsate() != null && orderInfo.getStsate() == 8) {

				orderStat = new OrderState();

				orderStat.setSoiId(orderInfo.getSoiId());

				orderStat.setCreateTime(sdf.format(new Date()));

				orderStat.setState(15);

				orderStat.setOperator(username);

				orderStateService.insertSelective(orderStat);
			}

			orderStat = new OrderState();

			orderStat.setSoiId(orderInfo.getSoiId());

			orderStat.setCreateTime(sdf.format(new Date()));

			orderStat.setState(state);

			orderStat.setOperator(username);

			orderStateService.insertSelective(orderStat);

			Long result = shbOrderInfoService.updateState(orderInfo);

			if (result > 0) {

				map.put("message", "确认成功！");

				map.put("messcode", "001");

				return map;

			} else {

				map.put("message", "系统错误！");

				map.put("messcode", "003");

				return map;
			}

		} catch (Exception e) {

			e.printStackTrace();

			map.put("message", "系统错误！");

			map.put("messcode", "003");

			return map;
		}

	}

	@RequestMapping(value = "/queryOrderInfoTime")
	public Map<String, Object> queryOrderInfoTime(Long soiId) {

		Map<String, Object> map = new HashMap<String, Object>();

		try {
			
			ShbOrderInfoDto  ShbOrderInfoDto = shbOrderInfoService.selectOrderInfoTime(soiId);

			ShbOrderInfo shbOrderInfo = new ShbOrderInfo();
			
			shbOrderInfo.setSoiId(soiId);
			
			Map<String, Object> soi = shbOrderInfoService.findOrderInfo(shbOrderInfo);
			
			RoomPriceCalendar roomPriceCalendar = new RoomPriceCalendar();

			roomPriceCalendar.setSriRid((long) soi.get("sriRid"));

			roomPriceCalendar.setNums((int) soi.get("reserveNumber"));

			roomPriceCalendar.setOrderId(soiId);

			RoomPriceCalendarDetailsDto roomPriceCalendarDetailsDto = roomPriceCalendarService
					.queryRoomPriceCalendarDetailsDto(roomPriceCalendar);

			map.put("roomPriceCalendarDetailsDto", roomPriceCalendarDetailsDto);
			
			map.put("ShbOrderInfoDto", ShbOrderInfoDto);
			
			map.put("soi", soi);
			
			map.put("message", "查询成功！");

			map.put("messcode", "001");
			
			return map;

		} catch (Exception ex) {

			ex.printStackTrace();

			map.put("message", "系统错误！");

			map.put("messcode", "003");

			return map;

		}

	}

	@RequestMapping(value = "/findOrderInfo")
	public Map<String, Object> findOrderInfo(ShbOrderInfo orderInfo) {

		Map<String, Object> map = new HashMap<String, Object>();

		String str[] = new String[] { "当天", "前一天", "前两天", "前三天", "前四天", "前五天", "前六天", "前七天" };

		String refundAgreement = "";

		RoomEvaluateDto roomEvaluateDto = null;

		OrderRefund orderRefund = null;

		List<Map<String, Object>> orderRefundList = null;

		try {

			Map<String, Object> soi = shbOrderInfoService.findOrderInfo(orderInfo);

			if (soi.get("soiId") != null) {

				orderRefund = new OrderRefund();

				orderRefund.setOrderNumber(Long.valueOf(soi.get("soiId").toString()));

				orderRefundList = orderRefundService.queryOrderRefund(orderRefund);

			}

			User us = new User();

			us.setSoiRid(orderInfo.getSoiId());

			us.setUsername(orderInfo.getUserName());

			User user = roomEvaluateService.queryUserRoomEvaluateOrder(us);

			if (user != null) {

				roomEvaluateDto = new RoomEvaluateDto();

				roomEvaluateDto.setUser(user);

				List<RoomEvaluatePicture> roomEvaluatePictureList = roomEvaluateService
						.queryRoomEvaluatePicture(user.getSreId());

				roomEvaluateDto.setRoomEvaluatePictureList(roomEvaluatePictureList);

			}

			if (soi.get("whertherRefund") != null) {

				Integer roomUpDay = Integer.valueOf(soi.get("roomUpDay").toString());

				refundAgreement = str[roomUpDay];

				soi.put("refundAgreement", refundAgreement);

			}

			RoomPriceCalendar roomPriceCalendar = new RoomPriceCalendar();

			roomPriceCalendar.setSriRid((long) soi.get("sriRid"));

			roomPriceCalendar.setNums((int) soi.get("reserveNumber"));

			roomPriceCalendar.setOrderId(orderInfo.getSoiId());

			RoomPriceCalendarDetailsDto roomPriceCalendarDetailsDto = roomPriceCalendarService
					.queryRoomPriceCalendarDetailsDto(roomPriceCalendar);

			map.put("messcode", "001");

			map.put("message", "查询成功！");

			map.put("soi", soi);

			map.put("RoomPriceCalendarDetailsDto", roomPriceCalendarDetailsDto);

			map.put("roomEvaluateDto", roomEvaluateDto);

			map.put("orderRefundList", orderRefundList);

			return map;

		} catch (Exception e) {

			e.printStackTrace();

			map.put("message", "系统错误！");

			map.put("messcode", "003");

			return map;
		}
	}
	 
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/applyRefund")
	private Map<String, Object> applyRefund(Long soiId , Integer applyRefundInfo , String otherRefund) {

		Map<String, Object> map = new HashMap<String, Object>();
		
		try{
			
			String url = null;
			
			url = ul+"/refund/applyRefund?soiId="+soiId+"&applyRefundInfo="+applyRefundInfo+"&otherRefund="+otherRefund;
			
			map = restTemplate.getForEntity(url, Map.class).getBody();
			
			return map;
			
		}catch (Exception e) {
			
			e.printStackTrace();
			
			return map;
			
		}
		
	}

}
