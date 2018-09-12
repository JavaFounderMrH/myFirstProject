package com.shb.web.web.user;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.github.pagehelper.PageInfo;
import com.shb.web.api.city.CityService;
import com.shb.web.api.order.ShbOrderInfoService;
import com.shb.web.api.user.LandlordInfoService;
import com.shb.web.api.user.RegionalPartnerService;
import com.shb.web.api.user.UserService;
import com.shb.web.dto.city.CityInfoDto;
import com.shb.web.dto.order.ShbOrderInfoDto;
import com.shb.web.dto.user.UserInfoDto;
import com.shb.web.mobile.user.LandlordInfo;
import com.shb.web.mobile.user.RegionalPartner;
import com.shb.web.mobile.user.User;
import com.shb.web.web.util.Md5;

@RestController
@RequestMapping("personalInfoController")
public class PersonalInfoController {

	@Autowired
	private UserService userService;

	@Autowired
	private LandlordInfoService landlordInfoService;

	@Autowired
	private RegionalPartnerService regionalPartnerService;

	@Autowired
	private ShbOrderInfoService shbOrderInfoService;
	
	@Autowired
	private CityService cityService;

	@Autowired
	RestTemplate restTemplate;

	private static String ul = "http://www.shanhaibian.com/shb_weixin";
	// private static String ul = "http://192.168.3.106/shb_weixin";

	@RequestMapping(value = "/queryUserInfoByUsername")
	private Map<String, Object> queryUserInfoByUsername(
			@RequestParam(value = "username", required = false) String username) {

		Map<String, Object> map = new HashMap<String, Object>();

		try {

			UserInfoDto userInfoDto = null;

			ShbOrderInfoDto shbOrderInfoDto = null;

			User user = null;

			userInfoDto = userService.queryUserInfoByName(username);

			if (userInfoDto != null) {

				shbOrderInfoDto = new ShbOrderInfoDto();

				shbOrderInfoDto.setUsername(username);

				PageInfo<ShbOrderInfoDto> orderList = shbOrderInfoService.queryShbOrderInfo(shbOrderInfoDto, 10,
						null);

				user = userService.selectByPrimaryKey(userInfoDto.getUserId());

				map.put("message", "查询成功!");

				map.put("messcode", "001");

				map.put("userInfoDto", userInfoDto);

				map.put("orderList", orderList);

				map.put("user", user);

				return map;

			} else {

				map.put("message", "账号信息有误!");

				map.put("messcode", "002");

				return map;

			}

		} catch (Exception ex) {

			ex.printStackTrace();

			map.put("message", "系统异常!");

			map.put("messcode", "003");

			return map;

		}

	}

	@RequestMapping(value = "/queryShbOrderInfo")
	private Map<String, Object> queryShbOrderInfo(ShbOrderInfoDto shbOrderInfoDto, Integer bingPage) {

		Map<String, Object> map = new HashMap<String, Object>();

		try {

			PageInfo<ShbOrderInfoDto> orderList = shbOrderInfoService.queryShbOrderInfo(shbOrderInfoDto, bingPage,
					null);

			if (orderList != null && orderList.getList() != null) {

				map.put("message", "查询成功!");

				map.put("messcode", "001");

				map.put("orderList", orderList);

				return map;

			} else {

				map.put("message", "暂无数据!");

				map.put("messcode", "002");

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
	 * ID 查询用户信息
	 */

	@RequestMapping(value = "/queryUserInfoById")
	private Map<String, Object> queryUserInfoById(@RequestParam(value = "userId", required = false) Long userId) {

		Map<String, Object> map = new HashMap<String, Object>();

		try {

			User user = userService.selectByPrimaryKey(userId);
			
			List<CityInfoDto> provinceList = null;
			
			List<CityInfoDto> cityList = null;

			if (user != null) {
				
				provinceList = cityService.queryCityProvince();
				
				if(user.getUserCity() != null && !"".equals(user.getUserCity())){
					
					cityList = cityService.queryCityArea(user.getUserCity().split("-")[0]);
					
				}

				map.put("message", "查询成功!");

				map.put("messcode", "001");

				map.put("user", user);
				
				map.put("provinceList", provinceList);
				
				map.put("cityList", cityList);

				return map;

			} else {

				map.put("message", "暂无数据!");

				map.put("messcode", "002");

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
	 * 根据省查询市
	 */

	@RequestMapping(value = "/queryCityArea")
	private Map<String, Object> queryCityArea(String province) {

		Map<String, Object> map = new HashMap<String, Object>();

		List<CityInfoDto> cityList = null;
		
		try {

			cityList = cityService.queryCityArea(province);
			
			if(cityList != null && cityList.size() > 0){

				map.put("message", "查询成功!");

				map.put("messcode", "001");
				
				map.put("cityList", cityList);

				return map;

			} else {

				map.put("message", "暂无数据!");

				map.put("messcode", "002");

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
	 * ID 编辑用户信息
	 */

	@RequestMapping(value = "/updateUserInfo")
	private Map<String, Object> updateUserInfo(@ModelAttribute("User") User user) {

		Map<String, Object> map = new HashMap<String, Object>();

		try {

			int lo = userService.updateByPrimaryKeySelective(user);

			if (lo > 0) {

				User us = userService.selectByPrimaryKey(user.getUserId());

				LandlordInfo landlordInfo = landlordInfoService.queryLandlordInfoByName(us.getUsername());

				if (landlordInfo != null) {

					LandlordInfo Landlord = new LandlordInfo();

					Landlord.setSliId(landlordInfo.getSliId());

					if (user.getName() != null) {

						Landlord.setName(user.getName());
					}
					if (user.getNickname() != null) {

						Landlord.setNickname(user.getNickname());

					}

					if (user.getHeadPortrait() != null) {

						Landlord.setPortraitSrc(user.getHeadPortrait());

					}

					landlordInfoService.updateByPrimaryKeySelective(Landlord);

				}

				RegionalPartner regionalPartner = regionalPartnerService.selectByPrimaryName(us.getUsername());

				if (regionalPartner != null) {

					RegionalPartner Regional = new RegionalPartner();

					Regional.setSrpId(regionalPartner.getSrpId());

					if (user.getName() != null) {

						Regional.setName(user.getName());
					}

					regionalPartnerService.updateByPrimaryKeySelective(Regional);
				}

				map.put("message", "编辑成功!!");

				map.put("messcode", "001");

				map.put("user", user);

				return map;

			} else {

				map.put("message", "暂无数据!");

				map.put("messcode", "002");

				return map;
			}

		} catch (Exception ex) {

			ex.printStackTrace();

			map.put("message", "系统异常!");

			map.put("messcode", "003");

			return map;

		}
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/queryNewsPush")
	private Map<String, Object> queryNewsPush(Integer bingPage, String username , Integer falg) {

		Map<String, Object> map = new HashMap<String, Object>();

		String url = ul + "/roomInfo/queryNewsPush?username="+username+"&falg="+falg+"&bingPage="+bingPage;
		
		map = restTemplate.getForEntity(url, Map.class).getBody();
		
		return map;
		
	}

	@RequestMapping(value = "/updatePassword")
	private Map<String, Object> updatePassword(@ModelAttribute("User") User user

	) {

		Map<String, Object> map = new HashMap<String, Object>();

		try {

			String password = user.getPassword();

			user.setPassword(Md5.encode(password));

			Long lo = userService.updateUserPassword(user);

			if (lo > 0) {

				map.put("message", "修改成功!");

				map.put("messcode", "001");

				return map;

			} else {

				map.put("message", "修改失败!");

				map.put("messcode", "002");

				return map;

			}

		} catch (Exception ex) {

			ex.printStackTrace();

			map.put("message", "系统异常!");

			map.put("messcode", "003");

			return map;

		}

	}

}