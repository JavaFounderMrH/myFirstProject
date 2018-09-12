package com.shb.web.service.room;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shb.web.api.room.ReservationRoomService;
import com.shb.web.dao.coupon.CouponDao;
import com.shb.web.dao.order.ShbOrderInfoDao;
import com.shb.web.dao.room.RoomInfoDao;
import com.shb.web.dto.room.ReservationRoomDto;
import com.shb.web.dto.room.RoomInfoDto;
import com.shb.web.mobile.coupon.Coupon;
import com.shb.web.mobile.order.ShbOrderInfo;
import com.shb.web.mobile.room.ReservationRoom;
import com.shb.web.mobile.room.RoomPriceCalendar;

@Service
public class ReservationRoomServiceImpl implements ReservationRoomService {

	@Autowired
	private RoomInfoDao roomInfoDao;

	@Autowired
	private CouponDao couponDao;

	@Autowired
	private ShbOrderInfoDao shbOrderInfoDao;

	@Override
	public ReservationRoomDto queryReservationRoomInfo(RoomInfoDto roomInfoDto) {

		ReservationRoomDto reservationRoomDto = null;
		
		List<Coupon> normalCoupon = null;

		String str[] = new String[] { "当天", "前一天", "前两天", "前三天", "前四天", "前五天", "前六天", "前七天" };

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		Calendar c = Calendar.getInstance();

		String startTime = null;

		String endTime = null;

		Integer Overnight = 2;

		Integer nums = 0;

		ReservationRoom reservationRoom = null;

		RoomPriceCalendar RoomPriceCalendar = null;

		Double total = 0.0;

		Integer checkNumber = 0;

		String refundAgreement = "";

		Integer reserveNumber = 0;

		Date da = null;

		try {

			reservationRoomDto = new ReservationRoomDto();

			reservationRoom = roomInfoDao.queryReservationRoom(roomInfoDto.getSriId());

			if (roomInfoDto.getSoiId() != null && roomInfoDto.getSoiId() != 0) {

				ShbOrderInfo shbOrderInfo = new ShbOrderInfo();

				shbOrderInfo.setSoiId(roomInfoDto.getSoiId());

				Map<String, Object> map = shbOrderInfoDao.findOrderInfo(shbOrderInfo);

				startTime = map.get("startTime").toString();

				endTime = map.get("endTime").toString();

				Integer checkNumbers = Integer.valueOf(map.get("checkNumber").toString());

				if (map.get("reserveNumber") != null) {

					reserveNumber = Integer.valueOf(map.get("reserveNumber").toString());

				}

				reservationRoomDto.setDefaultCheckNumber(checkNumbers);

				reservationRoomDto.setDefaultNums(reserveNumber);

				Double toPrice = Double.valueOf(map.get("priceTotal").toString());

				total = toPrice;

				reservationRoomDto.setName(map.get("name").toString());

				reservationRoomDto.setPhone(map.get("phone").toString());

			}

			if (roomInfoDto.getSoiId() == null || roomInfoDto.getSoiId() == 0) {

				if (reservationRoom != null && reservationRoom.getPrice() != null) {

					total = reservationRoom.getPrice() * roomInfoDto.getDefaultNums();

				}

			}

			if (roomInfoDto.getDefaultNums() != null) {

				reserveNumber = roomInfoDto.getDefaultNums();

				reservationRoomDto.setDefaultNums(reserveNumber);
			}

			if (reservationRoom.getCheckNumber() != null) {

				checkNumber = reservationRoom.getCheckNumber();

			}

			if (reservationRoom.getRoomUpDay() != null) {

				refundAgreement = str[reservationRoom.getRoomUpDay()];

			}

			reservationRoomDto.setReservationRoom(reservationRoom);

			if (roomInfoDto.getStartTime() != null && !"".equals(roomInfoDto.getStartTime())) {

				if (reservationRoom.getWhetherOvernight() != null && reservationRoom.getWhetherOvernight() == 1) {

					startTime = roomInfoDto.getStartTime();

					endTime = roomInfoDto.getEndTime();

					Overnight = 1;

					RoomPriceCalendar = new RoomPriceCalendar();

					RoomPriceCalendar.setOvernight(Overnight);

					RoomPriceCalendar.setStartTime(startTime);

					RoomPriceCalendar.setEndTime(endTime);

					RoomPriceCalendar.setSriRid(roomInfoDto.getSriId());

					RoomPriceCalendar roomPriceCalendarTotal = roomInfoDao
							.queryRoomPriceCalendarTotal(RoomPriceCalendar);

					if (roomPriceCalendarTotal != null) {

						if (roomPriceCalendarTotal.getPrice() != null) {

							total = roomPriceCalendarTotal.getPrice() * roomInfoDto.getDefaultNums();

						}
					}

				} else {

					startTime = roomInfoDto.getStartTime();

					endTime = roomInfoDto.getEndTime();

					Overnight = 2;

					RoomPriceCalendar = new RoomPriceCalendar();

					RoomPriceCalendar.setStartTime(startTime);

					RoomPriceCalendar.setOvernight(Overnight);

					RoomPriceCalendar.setEndTime(endTime);

					RoomPriceCalendar.setSriRid(roomInfoDto.getSriId());

					RoomPriceCalendar roomPriceCalendarTotal = roomInfoDao
							.queryRoomPriceCalendarTotal(RoomPriceCalendar);

					if (roomPriceCalendarTotal.getPrice() != null) {

						total = roomPriceCalendarTotal.getPrice() * roomInfoDto.getDefaultNums();

					}
				}

			} else if (roomInfoDto.getSoiId() == null || roomInfoDto.getSoiId() == 0) {

				List<RoomPriceCalendar> roomPriceCalendarList = roomInfoDao
						.queryRoomPriceCalendarTime(roomInfoDto.getSriId());

				if (roomPriceCalendarList != null && roomPriceCalendarList.size() > 0) {

					startTime = roomPriceCalendarList.get(0).getTime();

					endTime = startTime;

					da = sdf.parse(endTime);

					c.setTime(da);

					int day = c.get(Calendar.DATE);

					c.set(Calendar.DATE, day + 1);

					endTime = sdf.format(c.getTime());

				} else {

					startTime = sdf.format(new Date());

					int day = c.get(Calendar.DATE);

					c.set(Calendar.DATE, day + 1);

					endTime = sdf.format(c.getTime());

					System.out.println(endTime);
				}

			}

			if (roomInfoDto.getStartTime() == null || "".equals(roomInfoDto.getStartTime())) {

				if (reservationRoom.getWhetherOvernight() != null && reservationRoom.getWhetherOvernight() == 1) {

					Overnight = 1;

					RoomPriceCalendar = new RoomPriceCalendar();

					RoomPriceCalendar.setOvernight(Overnight);

					RoomPriceCalendar.setStartTime(startTime);

					RoomPriceCalendar.setEndTime(endTime);

					RoomPriceCalendar.setSriRid(roomInfoDto.getSriId());

					RoomPriceCalendar roomPriceCalendarNums = roomInfoDao.queryRoomPriceCalendarNums(RoomPriceCalendar);

					if (roomPriceCalendarNums != null) {

						nums = roomPriceCalendarNums.getNums();
					}

				} else if (reservationRoom.getWhetherOvernight() == 0) {

					endTime = startTime;

					Overnight = 2;

					RoomPriceCalendar = new RoomPriceCalendar();

					RoomPriceCalendar.setStartTime(startTime);

					RoomPriceCalendar.setEndTime(endTime);

					RoomPriceCalendar.setOvernight(Overnight);

					RoomPriceCalendar.setSriRid(roomInfoDto.getSriId());

					RoomPriceCalendar roomPriceCalendarNums = roomInfoDao.queryRoomPriceCalendarNums(RoomPriceCalendar);

					if (roomPriceCalendarNums != null) {

						nums = roomPriceCalendarNums.getNums();

					}

				}

			} else {

				if (reservationRoom.getWhetherOvernight() != null && reservationRoom.getWhetherOvernight() == 1) {

					Overnight = 1;

					RoomPriceCalendar = new RoomPriceCalendar();

					RoomPriceCalendar.setOvernight(Overnight);

					RoomPriceCalendar.setStartTime(startTime);

					RoomPriceCalendar.setEndTime(endTime);

					RoomPriceCalendar.setSriRid(roomInfoDto.getSriId());

					RoomPriceCalendar roomPriceCalendarNums = roomInfoDao.queryRoomPriceCalendarNums(RoomPriceCalendar);

					if (roomPriceCalendarNums != null) {

						nums = roomPriceCalendarNums.getNums();
					}

				} else if (reservationRoom.getWhetherOvernight() == 0) {

					endTime = roomInfoDto.getEndTime();

					Overnight = 2;

					RoomPriceCalendar = new RoomPriceCalendar();

					RoomPriceCalendar.setStartTime(startTime);

					RoomPriceCalendar.setEndTime(endTime);

					RoomPriceCalendar.setOvernight(Overnight);

					RoomPriceCalendar.setSriRid(roomInfoDto.getSriId());

					RoomPriceCalendar roomPriceCalendarNums = roomInfoDao.queryRoomPriceCalendarNums(RoomPriceCalendar);

					if (roomPriceCalendarNums != null) {

						nums = roomPriceCalendarNums.getNums();

					}

				}

			}

			reservationRoomDto.setStartTime(startTime);

			reservationRoomDto.setEndTime(endTime);

			reservationRoomDto.setNums(nums);

			reservationRoomDto.setTotalPrice(total);

			reservationRoomDto.setCheckNumber(checkNumber);

			reservationRoomDto.setRefundAgreement(refundAgreement);

			if (roomInfoDto.getUsername() != null) {
				
				normalCoupon = new ArrayList<Coupon>();

				Coupon coupon = new Coupon();

				coupon.setUsername(roomInfoDto.getUsername());

				coupon.setFalg(2);

				coupon.setCouponType(1);

				List<Coupon> list = couponDao.queryCouponInfo(coupon);

				if (list != null && list.size() > 0) {

					reservationRoomDto.setScId(list.get(0).getScId());

					reservationRoomDto.setSrc(list.get(0).getSrc());

					reservationRoomDto.setPrice(list.get(0).getPrice());

					normalCoupon.add(list.get(0));
					
				} else {

					coupon.setFalg(1);

					List<Coupon> couponList = couponDao.queryCouponInfo(coupon);

					if (couponList != null && couponList.size() > 0) {

						for (Coupon st : couponList) {

							if (total >= 200 && total < 368 && (st.getPrice() - 20) == 0) {

								reservationRoomDto.setScId(st.getScId());

								reservationRoomDto.setSrc(st.getSrc());

								reservationRoomDto.setPrice(st.getPrice());
								
								normalCoupon.add(st);

							} else if (total >= 368 && total < 618 && (st.getPrice() - 30) == 0) {

								reservationRoomDto.setScId(st.getScId());

								reservationRoomDto.setSrc(st.getSrc());

								reservationRoomDto.setPrice(st.getPrice());
								
								normalCoupon.add(st);

							} else if (total > 618) {

								reservationRoomDto.setScId(st.getScId());

								reservationRoomDto.setSrc(st.getSrc());

								reservationRoomDto.setPrice(st.getPrice());
								
								normalCoupon.add(st);

							}

						}

					}

				}
				
				reservationRoomDto.setNormalCoupon(normalCoupon);

			}

		} catch (Exception ex) {

			ex.printStackTrace();

			return reservationRoomDto;

		}

		return reservationRoomDto;

	}

}