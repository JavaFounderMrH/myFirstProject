package com.shb.web.web.indexPage;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.shb.web.api.activity.ShbRecommendedBitServcie;
import com.shb.web.api.user.UserService;
import com.shb.web.mobile.activity.ShbPcHotCity;
import com.shb.web.mobile.activity.ShbRecommendedBit;
import com.shb.web.mobile.user.Recruit;
import com.shb.web.web.util.BaiduMapUtil;

@SuppressWarnings("unchecked")
@RestController
@RequestMapping("/newWebsiteController")
public class NewWebsiteController {

	@Autowired
	private ShbRecommendedBitServcie shbRecommendedBitServcie;

	@Autowired
	private UserService userService;

	@Autowired
	RestTemplate restTemplate;

	private static String ul = "http://www.shanhaibian.com/shb_weixin";
	// private static String ul = "http://192.168.3.106/shb_weixin";

	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	@RequestMapping(value = "/querynewWebsitePage")
	public Map<String, Object> querynewWebsitePage(String ip) {

		Map<String, Object> map = new HashMap<String, Object>();

		Map<String, Object> tourismLineList = null;

		List<ShbRecommendedBit> shbRecommendedBitList = null;

		List<ShbPcHotCity> shbPcHotCityList = null;

		String cityName = "";

		try {

			cityName = BaiduMapUtil.getBaiduMapsApiIp(ip);

			String url = ul + "/tourismLineController/selectTourismLineList";

			ShbRecommendedBit shbRecommendedBit = new ShbRecommendedBit();

			shbRecommendedBitList = shbRecommendedBitServcie.queryShbRecommendedBitList(shbRecommendedBit);

			shbPcHotCityList = shbRecommendedBitServcie.queryShbPcHotCityList();

			tourismLineList = restTemplate.getForEntity(url, Map.class).getBody();

			map.put("message", "查询成功！");

			map.put("messcode", "001");

			map.put("shbRecommendedBitList", shbRecommendedBitList);

			map.put("shbPcHotCityList", shbPcHotCityList);

			map.put("TourismLineList", tourismLineList);

			map.put("cityName", cityName);

			return map;

		} catch (Exception e) {

			e.printStackTrace();

			map.put("message", "系统异常！");

			map.put("messcode", "003");

			return map;

		}

	}

	@RequestMapping(value = "/insertUserFeedback")
	public Map<String, Object> insertUserFeedback(Recruit recruit) {

		Map<String, Object> map = new HashMap<String, Object>();

		try {

			recruit.setCreateTime(sdf.format(new Date()));

			int i = userService.insertUserFeedback(recruit);

			if (i > 0) {

				map.put("message", "添加成功！");

				map.put("messcode", "001");

			} else {

				map.put("message", "添加失败！");

				map.put("messcode", "002");

			}

		} catch (Exception e) {

			e.printStackTrace();

			map.put("message", "系统异常！");

			map.put("messcode", "003");

		}

		return map;

	}

}