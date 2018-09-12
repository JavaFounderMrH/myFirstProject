package com.shb.web.web.room;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/roomCollection")
public class RoomCollectionController {

	@Autowired
	RestTemplate restTemplate;

	// 线上
	//private static String ul = "http://www.shanhaibian.com/shb_weixin";

	private static String ul = "http://192.168.3.106/shb_weixin";

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/insertRoomCollection")
	private Map<String, Object> insertRoomCollection(@RequestParam(value = "srId", required = false) Long srId,
			@RequestParam(value = "username", required = false) String username) {

		Map<String, Object> map = new HashMap<String, Object>();

		String url = ul + "/roomCollection/insertRoomCollection?srId="+srId+"&username="+username;

		map = restTemplate.getForEntity(url, Map.class).getBody();

		return map;
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/deleteRoomCollection")
	private Map<String, Object> deleteRoomCollection(Long srcId) {

		Map<String, Object> map = new HashMap<String, Object>();

		String url = ul + "/roomCollection/deleteRoomCollection?srcId="+srcId;

		map = restTemplate.getForEntity(url, Map.class).getBody();

		return map;

	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/queryRoomCollectionInfo")
	private Map<String, Object> queryRoomCollectionInfo(String username, Integer bingPage) {

		Map<String, Object> map = new HashMap<String, Object>();

		String url = ul + "/roomCollection/queryRoomCollectionInfo?username="+username+"&bingPage="+bingPage;

		map = restTemplate.getForEntity(url, Map.class).getBody();

		return map;

	}

}
