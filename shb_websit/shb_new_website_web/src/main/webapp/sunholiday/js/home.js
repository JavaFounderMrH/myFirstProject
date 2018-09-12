var query;
var cityName = '';
var city;
var date;
//ie老版本浏览器判断
(function(window) {
    var theUA = window.navigator.userAgent.toLowerCase();
    if ((theUA.match(/msie\s\d+/) && theUA.match(/msie\s\d+/)[0]) || (theUA.match(/trident\s?\d+/) && theUA.match(/trident\s?\d+/)[0])) {
        var ieVersion = theUA.match(/msie\s\d+/)[0].match(/\d+/)[0] || theUA.match(/trident\s?\d+/)[0];
        if (ieVersion <= 9) {
            var str = "你的浏览器版本太low了已经和时代脱轨了 :(";
            var str2 = "推荐使用:<a href='https://www.baidu.com/s?ie=UTF-8&wd=%E8%B0%B7%E6%AD%8C%E6%B5%8F%E8%A7%88%E5%99%A8' target='_blank' style='color:#cc0'>谷歌</a>,"
                + "<a href='https://www.baidu.com/s?ie=UTF-8&wd=%E7%81%AB%E7%8B%90%E6%B5%8F%E8%A7%88%E5%99%A8' target='_blank' style='color:#cc0'>火狐</a>,"
                + "<a href='https://www.baidu.com/s?ie=utf-8&f=8&rsv_bp=0&rsv_idx=1&tn=baidu&wd=%E6%AC%A7%E6%9C%8B%E6%B5%8F%E8%A7%88%E5%99%A8&rsv_pq=a57ccd0e000067d1&rsv_t=d6b46LOKJf%2BDmn2Jgya2Fb8QvnybcDS%2B2fNJY6n7trd95a5YYNw2RJQSTOU&rqlang=cn&rsv_enter=1&rsv_sug3=5&rsv_sug1=5&rsv_sug7=100' target='_blank' style='color:#cc0'>欧朋</a>,其他双核急速模式";
                document.writeln("<pre style='text-align:center;color:#fff;background-color:#0cc; height:100%;border:0;position:fixed;top:0;left:0;width:100%;z-index:1234'>" +
                "<h2 style='padding-top:200px;margin:0'><strong>" + str + "<br/></strong></h2><p>" +
                str2 + "</p><h2 style='margin:0'><strong>如果你使用的是双核浏览器,请切换到极速模式访问<br/></strong></h2></pre>");
                document.execCommand("Stop");
        }
    }
})(window);
$(document).ready(function(){
	//监听hash
    $(window).on('hashchange',function(){
        document.documentElement.scrollTop = 0;
        document.body.scrollTop = 0;
    });
    //获取地理位置
    var map = new BMap.Map("allmap");
	var point = new BMap.Point(116.331398,39.897445);
	map.centerAndZoom(point,12);
	function myFun(result){
		var cityName = result.name;
		//map.setCenter(cityName);
		cityName = cityName;
		localStorage.setItem("cityName", cityName);
	}
	var myCity = new BMap.LocalCity();
	myCity.get(myFun);
	//城市-日期
	if(localStorage.getItem("city")){
		city = localStorage.getItem("city");
		$('.fastSearch1').val(city);
	}
	if(localStorage.getItem("date")){
		date = localStorage.getItem("date");
		$('.fastSearch2').val(date);
	}
	
    homeImg();
    xianlu();
	/*首页banner轮播图*/
    initSwiper1();
});
//首页图片
function homeImg(){
	$.ajax({
		type : 'GET',
		url : "/newWebsiteController/querynewWebsitePage",
		dataType:'json',
		data: {
			"ip": cityName
		},
		success : function(data) {
			if(data.messcode == '001'){
				//console.log(data);
			}else{
				console.log(data);
			}
		},
		error:function(data) {
			console.log(data);
		}
	});
}
//xianlu
function xianlu(){
	$.ajax({
		type : 'GET',
		url : "/touristRouteApi/querytouristRouteInfo",
		dataType:'json',
		success : function(data) {
			if(data.messcode == '001'){
				var str = '';
				var list = data.tourismLineList;
				for(var i in list){
					str += '<a class="swiper-slide" target="_blank" href="http://www.shanhaibian.com/#/productList?lineId='+list[i].lineId+'">'
				                +'<img src="'+list[i].lineListSrc+'">'
				            +'</a>';
				}
				$('#swiper2 .swiper-wrapper').append(str);
				/*产品线路轮播图*/
			    initSwiper2();
			}else{
				console.log(data);
			}
		},
		error:function(data) {
			console.log(data);
		}
	});
}
/*首页banner轮播图*/
function initSwiper1(){
    var swiper1 = new Swiper ('#swiper1', {
        loop: true,
        autoplay: 5000,//可选选项，自动滑动
        speed:800,
        autoplayDisableOnInteraction : false,//点击事件之后不会停止自动播放
        setWrapperSize :true,//对sweiper支持不太好的时候用得上
        effect : 'fade',//淡入
        fade: {
            crossFade: true
        },
        // 分页器
        pagination: '.swiper-pagination',
        paginationClickable: true,
        prevButton:'.swiper-button-prev',
        nextButton:'.swiper-button-next'
    });
}
/*产品线路轮播图*/
function initSwiper2() {
    var swiper2 = new Swiper ('#swiper2', {
        autoplay:3000,
        speed:1000,
        autoplayDisableOnInteraction : false,//点击事件之后不会停止自动播放
        loop:true,
        loopAdditionalSlides:2,
        initialSlide :4,//初始化索引
        slidesPerView: 'auto',
        loopedSlides: 9,
        centeredSlides: true,
        paginationClickable: true,
        // 如果需要分页器
        pagination: '.swiper-pagination',
        paginationType : 'fraction',
        // 如果需要前进后退按钮
        nextButton: '.swiper-button-next',
        prevButton: '.swiper-button-prev',
        onTransitionEnd: function(swiper){
            if(swiper.progress==1){
                swiper.activeIndex=swiper.slides.length-1
            }
        }
    });
}
/*专题活动轮播图*/
initSwiper3();
function initSwiper3() {
    var swiper3 = new Swiper ('#swiper3', {
    	slidesPerView : 'auto',
    	autoplay:3000,
        speed:1000,
        loop: true,
        autoplayDisableOnInteraction : false,//点击事件之后不会停止自动播放
        initialSlide :0,//初始化索引
        centeredSlides : true,
        onTransitionEnd: function(swiper){
      	  if(swiper.progress==1){
      		  swiper.activeIndex=swiper.slides.length-1
      	  }
        }
    });
}
window.onscroll = function(){
    var t = document.documentElement.scrollTop || document.body.scrollTop;
    if(t > 0){
        $('.subNav').show();
        $('.home_head').css({
            'background': '#fff',
            'border-bottom':'1px solid #40d8d7'
        });
        $('.home_head .head_l').children('a:nth-child(1)').css({
            'background': 'url(sunholiday/image/home/logo_green.png) no-repeat',
            'background-size': 'contain'
        });
        $('.home_head .head_l').children('a:nth-child(2)').css({
            'background': 'url(sunholiday/image/home/logo_greenTxt.png) no-repeat',
            'background-size': 'contain'
        });
        $('.home_head .head_r>a').each(function () {
        	$(this).css('color','#666');
        });
        $('.home_head .head_user>a').each(function () {
            if($(this).css('color') == 'rgb(255, 255, 255)' && $(this).text() != '发布房源'){
                $(this).css('color','#666');
            }
        });
    }else{
        $('.subNav').hide();
        $('.home_head').css({
            'background': '-webkit-linear-gradient(top, rgba(0,0,0,0), rgba(0,0,0,0.6))',
            'background': '-o-linear-gradient(top, rgba(0,0,0,0), rgba(0,0,0,0.6))',
            'background': '-moz-linear-gradient(top, rgba(0,0,0,0), rgba(0,0,0,0.6))',
            'background': 'linear-gradient(to top, rgba(0,0,0,0), rgba(0,0,0,0.6))',
            'border-bottom':'none'
        });
        $('.home_head .head_l').children('a:nth-child(1)').css({
            'background': 'url(sunholiday/image/home/logo_white.png) no-repeat',
            'background-size': 'contain'
        });
        $('.home_head .head_l').children('a:nth-child(2)').css({
            'background': 'url(sunholiday/image/home/logo_whiteTxt.png) no-repeat',
            'background-size': 'contain'
        });
        $('.home_head .head_r>a').each(function () {
            if($(this).css('color') == 'rgb(102, 102, 102)'){
                $(this).css('color','#fff');
            }
        });
        $('.home_head .head_user>a').each(function () {
            if($(this).css('color') == 'rgb(102, 102, 102)'){
                $(this).css('color','#fff');
            }
        });
    }
};
