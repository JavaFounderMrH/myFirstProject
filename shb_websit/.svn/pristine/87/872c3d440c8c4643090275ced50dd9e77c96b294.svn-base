package com.shb.web.web.user;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RestController;

import com.shb.web.api.redis.RedisService;
import com.shb.web.api.user.NewsPushService;
import com.shb.web.api.user.UserLogService;
import com.shb.web.api.user.UserService;
import com.shb.web.dto.user.UserInfoDto;
import com.shb.web.mobile.user.BaseUserLog;
import com.shb.web.mobile.user.NewsPush;
import com.shb.web.mobile.user.User;
import com.shb.web.mobile.user.UserIpAdress;
import com.shb.web.web.util.Client;
import com.shb.web.web.util.CouponType;
import com.shb.web.web.util.Md5;
import com.shb.web.web.util.RandomCode;
import com.shb.web.web.util.ValidateCodeUtil;
import com.shb.web.web.util.ValidateCodeUtil.Validate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/userLoginController")
public class UserLoginController {

	@Autowired
	private UserService userService;

	@Autowired
	private UserLogService userLogService;

	@Autowired
	private NewsPushService newsPushService;

	@Autowired
	private RedisService redisService;

	/**
	 * 账号密码登陆
	 * 
	 */
	@RequestMapping(value = "/login")

	private Map<String, Object> login(@RequestParam(value = "username", required = false) String username,
			@RequestParam(value = "password", required = false) String password,
			@RequestParam(value = "platform", required = false) String platform,
			@RequestParam(value = "alias", required = false) String alias, HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();

		try {

			User user = new User();

			if (username != null) {

				user.setUsername(username);

				User users = userService.queryUser(user);

				if (users != null) {

					if (username.equals(users.getUsername()) && Md5.encode(password).equals(users.getPassword())) {

						if (platform != null && alias != null) {

							BaseUserLog baseUserLog = new BaseUserLog();

							baseUserLog.setAction(0);

							baseUserLog.setCreate_time(new Date());

							baseUserLog.setDevice_no(alias);

							baseUserLog.setPlatform(platform);

							baseUserLog.setUser_id(users.getUserId());

							userLogService.insertUserLog(baseUserLog);

						}

						map.put("message", "登陆成功!");

						users.setPassword(password);

						// 登录成功之后将用户信息放在redis中存一个月

						redisService.set("LOGIN_USER_" + username, username, 30 * 24 * 60 * 60L);

						map.put("messcode", "001");

						map.put("users", users);

						return map;

					} else {

						map.put("message", "账号或密码错误!!");

						map.put("messcode", "002");

						return map;

					}

				} else {

					map.put("message", "该账号不存在!");

					map.put("messcode", "004");

					return map;

				}

			} else {

				map.put("message", "系统异常!");

				map.put("messcode", "003");

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
	 * 用户注册
	 * 
	 * @param request
	 * @return
	 */

	@RequestMapping(value = "/insertUser")
	private Map<String, Object> addUser(HttpServletRequest request, @ModelAttribute("User") User user) {

		Map<String, Object> map = new HashMap<String, Object>();

		try {

			User users = userService.queryUser(user);

			if (users != null) {

				map.put("message", "对不起，该账号已注册!");

				map.put("messcode", "002");

				return map;

			}

			// //格式化时间
			SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");

			Date date = new Date();

			user.setPassword(Md5.encode(user.getPassword())); // 加密

			user.setResIp(UserIpAdress.getCientIp(request));

			user.setCreateTime(dateFormater.format(date));

			user.setUserStatus(1);

			user.setModifyTime(dateFormater.format(date));

			user.setNickname("shb" + new Date().getTime());

			user.setResTime(dateFormater.format(date));

			int in = userService.insertSelective(user);

			if (in > 0) {

				/**
				 * 注册就送200优惠卷
				 * 
				 * 
				 */

				boolean bo = CouponType.resCoupon(user.getUserId());

				if (bo) {

				} else {

					map.put("message", "系统异常!");

					map.put("messcode", "003");

					return map;

				}

				NewsPush NewsPush = new NewsPush();

				NewsPush.setSuiRid(user.getUserId());

				NewsPush.setCreateTime(dateFormater.format(new Date()));

				NewsPush.setContent("注册成功！200元代金券已发送至您的账户，赶快去【我的--我的优惠券】中查看使用吧！");

				NewsPush.setType(3);

				newsPushService.insertSelective(NewsPush);

				map.put("message", "成功!");

				map.put("messcode", "001");

				map.put("username", user.getUsername()); // 用户名

				return map;

			} else {

				map.put("message", "系统异常!");

				map.put("messcode", "003");

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
	 * 判断该账号是否已经注册
	 */
	@RequestMapping(value = "/checkUserName")
	public Map<String, Object> checkUserName(

			@RequestParam(value = "username", required = false)

			String username) {

		Map<String, Object> map = new HashMap<String, Object>();

		try {

			User user = new User();

			user.setUsername(username);

			User users = userService.queryUser(user);

			if (users == null) {

				map.put("message", "该账号可注册!");

				map.put("messcode", "001");

				return map;

			} else {

				map.put("message", "对不起，该账号已注册!");

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

	@RequestMapping(value = "/sendOutCode")
	private Map<String, Object> sendOutCode(HttpServletRequest request, HttpSession session,
			@RequestParam(value = "username", required = false) String username) {

		Map<String, Object> map = new HashMap<String, Object>();

		try {

			String codes = (String) redisService.get("PC_CODE" + username);

			if (codes != null) {

				map.put("message", "访问太过频繁,请稍后!");

				map.put("messcode", "004");

				return map;

			}

			RandomCode randomCode = new RandomCode();

			String sendcode = randomCode.random();

			String code = "";

			code = Md5.encode(sendcode);

			Client.mdsmssend(username, "验证码为：" + sendcode + "," + "5分钟后失效，切勿随意泄露，谨防诈骗" + "【山海边】");

			map.put("code", code);

			map.put("messcode", "001");

			map.put("sendcode", sendcode);

			redisService.set("PC_CODE" + username, sendcode, 30L);

			return map;

		} catch (Exception ex) {

			ex.printStackTrace();

			map.put("message", "系统异常!");

			map.put("messcode", "003");

			return map;

		}

	}

	@RequestMapping(value = "/fastLogin")
	private Map<String, Object> fastLogin(HttpServletRequest request, HttpSession session,
			@RequestParam(value = "username", required = false) String username,
			@RequestParam(value = "platform", required = false) String platform,
			@RequestParam(value = "alias", required = false) String alias) {

		Map<String, Object> map = new HashMap<String, Object>();

		try {

			User user = new User();

			user.setUsername(username);

			User users = userService.queryUser(user);

			if (users != null) {

				if (platform != null && alias != null) {

					BaseUserLog baseUserLog = new BaseUserLog();

					baseUserLog.setAction(0);

					baseUserLog.setCreate_time(new Date());

					baseUserLog.setDevice_no(alias);

					baseUserLog.setPlatform(platform);

					baseUserLog.setUser_id(users.getUserId());

					userLogService.insertUserLog(baseUserLog);

				}

				// 登录成功之后将用户信息放在redis中存30天

				redisService.set("LOGIN_USER_" + username, username, 30 * 24 * 60 * 60L);

				map.put("message", "登陆成功!!");

				map.put("messcode", "001");

				map.put("users", users);

				return map;

			} else {

				SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

				Date date = new Date();

				user.setResIp(UserIpAdress.getCientIp(request));

				user.setCreateTime(dateFormater.format(date));

				user.setUserStatus(1);

				user.setNickname("shb" + new Date().getTime());

				user.setModifyTime(dateFormater.format(date));

				user.setResTime(dateFormater.format(date));

				int in = userService.insertSelective(user);

				if (in > 0) {

					/**
					 * 注册就送200优惠卷
					 * 
					 * 
					 */

					boolean bo = CouponType.resCoupon(user.getUserId());

					if (bo) {

					} else {

						map.put("message", "系统异常!");

						map.put("messcode", "003");

						return map;

					}

					NewsPush NewsPush = new NewsPush();

					NewsPush.setSuiRid(user.getUserId());

					NewsPush.setCreateTime(dateFormater.format(new Date()));

					NewsPush.setContent("注册成功！200元代金券已发送至您的账户，赶快去【我的--我的优惠券】中查看使用吧！");

					NewsPush.setType(3);

					newsPushService.insertSelective(NewsPush);

					User us = userService.queryUser(user);

					// 登录成功之后将用户信息放在redis中存30天

					redisService.set("LOGIN_USER_" + username, username, 30 * 24 * 60 * 60L);

					map.put("message", "成功!");

					map.put("messcode", "001");

					map.put("users", us);

					return map;

				} else {

					map.put("message", "系统异常!");

					map.put("messcode", "003");

					return map;

				}

			}

		} catch (Exception ex) {

			ex.printStackTrace();

			map.put("message", "系统异常!");

			map.put("messcode", "003");

			return map;

		}

	}

	/**
	 * 判断用户是否登录
	 */

	@RequestMapping("loginState")
	private Map<String, Object> loginState(String username) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {

			String use = (String) redisService.get("LOGIN_USER_" + username);

			if (use == null || "".equals(use)) {

				map.put("messcode", "002");

				map.put("message", "登录失效已过期请重新登陆!");

				return map;

			} else {

				redisService.set("LOGIN_USER_" + username, username, 30 * 24 * 60 * 60L);

				map.put("messcode", "001");

				map.put("message", "已登陆");

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
	 * 根据用户名判断用户是否存在
	 * 
	 * @param username
	 * @return
	 */

	@RequestMapping(value = "/queryUserInfoByName")
	private Map<String, Object> queryUserInfoByName(
			@RequestParam(value = "username", required = false) String username) {

		Map<String, Object> map = new HashMap<String, Object>();

		try {

			UserInfoDto userInfoDto = null;

			userInfoDto = userService.queryUserInfoByName(username);

			if (userInfoDto != null) {

				map.put("message", "查询成功!");

				map.put("messcode", "001");

				map.put("userInfoDto", userInfoDto);

				return map;

			} else {

				map.put("message", "账号可注册!");

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
	 * 返回数字验证码
	 * 
	 * @param username
	 * @return
	 */

	@RequestMapping(value = "/queryCode")
	private Map<String, Object> queryCode(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException {

		Map<String, Object> map = new HashMap<String, Object>();

		try {

			//PictureCodeUtil test2 = new PictureCodeUtil();
	    	
	    	//String randomCode = test2.images(request, response);
			
			Validate pictureCode = ValidateCodeUtil.getRandomCode();
	    	
			map.put("message", "查询成功!");

			map.put("messcode", "001");

			map.put("pictureCode", pictureCode);

			return map;

		} catch (Exception ex) {

			ex.printStackTrace();

			map.put("message", "系统异常!");

			map.put("messcode", "003");

			return map;

		}

	}

}
