package com.shb.web.web.room;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SuppressWarnings("unchecked")
@RestController
@RequestMapping("/tradearea")
public class TradeareaController {

	@Autowired
	RestTemplate restTemplate;

	// 线上
	private static String ul = "http://www.shanhaibian.com/shb_weixin";
	// private static String ul = "http://192.168.3.128/shb_weixin";

	@RequestMapping(value = "/queryTradeareaTwo")
	private Map<String, Object> queryTradeareaTwo(Long stoRid) {

		Map<String, Object> map = new HashMap<String, Object>();

		String url = ul + "/tradearea/queryTradeareaTwo?stoRid=" + stoRid;

		map = restTemplate.getForEntity(url, Map.class).getBody();

		return map;

	}

	@RequestMapping(value = "/queryTradeareaThree")
	private Map<String, Object> queryTradeareaThree(Long sttRid) {

		Map<String, Object> map = new HashMap<String, Object>();

		String url = ul + "/tradearea/queryTradeareaThree?sttRid=" + sttRid;

		map = restTemplate.getForEntity(url, Map.class).getBody();

		return map;

	}

}
