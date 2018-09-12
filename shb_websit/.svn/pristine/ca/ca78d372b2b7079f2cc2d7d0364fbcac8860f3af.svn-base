package com.shb.web.web.util;


import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


@Component
public class ChanelInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
    	
    	//String str[] = new String[]{"queryRoomInfoPage","queryRoomInfoDtos","queryCityRoomInfo","queryRoomInfoById","queryRoomPriceCalendar","queryNewsPush","queryRoomPriceCalendarDetails","queryReservationRoomInfo","queryRoomInfoList"};
    	
    	//List<String> st = Arrays.asList(str);
    	
    	
    	// ModelAndView modelAndView = new ModelAndView();
    	
       System.out.println("============================拦截器启动==============================");
        
        request.setAttribute("starttime",System.currentTimeMillis());
        
        
        //RedisService redisService = (RedisService) SpringUtil.getBean("redisService");
        
		
        
        return true;
        
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object o, ModelAndView modelAndView) throws Exception {
    	System.out.println("===========================执行处理完毕=============================");
        long starttime = (long) request.getAttribute("starttime");
        request.removeAttribute("starttime");
        long endtime = System.currentTimeMillis();
        
        String strBackUrl = "http://" + request.getServerName() //服务器地址  
        + ":"   
        + request.getServerPort()           //端口号  
        + request.getContextPath()      //项目名称  
        + request.getServletPath()      //请求页面或其他地址  
        + "?" + (request.getQueryString()); //参数  
       
        //request.getRequestURI()
        
        String str = "============请求地址："+strBackUrl+"：处理时间："+"{"+(endtime-starttime)+"}"+"ms";
        
//        
        System.out.println(str);
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
    	System.out.println("============================拦截器关闭==============================");
    }
    
}