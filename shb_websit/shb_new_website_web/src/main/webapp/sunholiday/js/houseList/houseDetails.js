var sriRid;
var username;
var datailName;
$(function(){
	sriRid = getQueryString("datailId");
	username = getQueryString("datailUser");
	datailName = getQueryString("datailName");
	$('.datailName').text('酒店民宿公寓' + datailName);
	$.ajax({
		type: "GET",
		url: "/roomInfoController/queryRoomInfoById",
		dataType: 'json',
		data:{
			"sriRid": sriRid,
			"username": username
		},
		success: function(data){
			if(data.messcode == "001"){
				if(data.roomDtos != null || data.roomDtos != ''){
					var data = data.roomDtos;
					$('.roomTitle').text(data.roomInfo.roomTitle);
					document.title = data.roomInfo.roomTitle;
					//console.log(data);
					//轮播图
					if(data.roomPictureList.length != 0){
						$('.houseMaxBan').find('.swiper-wrapper').empty();
						var roomPictureListStr = '';
						for(var i in data.roomPictureList){
							if(i == 0){
								roomPictureListStr += '<div class="swiper-slide swiper-slide-center none-effect"><a><img src="'+ data.roomPictureList[i].picSrc +'" class="'+i+'"></a></div>';
							}else{
								roomPictureListStr += '<div class="swiper-slide"><a><img src="'+ data.roomPictureList[i].picSrc +'" class="'+i+'"></a></div>';
							}
						}
						$('.houseMaxBan').find('.swiper-wrapper').append(roomPictureListStr);
						initSwiper(data.roomPictureList);
						$('.button').width($('.pc-bannerWrap .swiper-pagination').width()+716)
					}
					
				}
			}
		}
	});
});

function initSwiper(roomPictureList) {
	var str = [];
	for(var i in roomPictureList){
		str.push(roomPictureList[i].picSrc);
	}
    var swiper = new Swiper('.swiper-container',{
        //autoplay:3000,
        //speed:1000,
        //autoplayDisableOnInteraction : false,
        loop:true,
        centeredSlides : true,
        slidesPerView:2,
        pagination : '.swiper-pagination',
        paginationClickable:true,
        prevButton:'.swiper-button-prev',
        nextButton:'.swiper-button-next',
        /*onInit:function(swiper){
            swiper.slides[2].className="swiper-slide swiper-slide-active";//第一次打开不要动画
        },*/
        breakpoints: {
            50: {
                slidesPerView: 1
            }
        },
        paginationType : 'progress',
        paginationProgressRender: function (swiper, progressbarClass) {
        	var progressbarClass = '';
        	for(var i in str){
        		if(i == 0){
        			progressbarClass += '<img src="'+str[i]+'" class="minImgSel" id="'+i+'">';
        		}else{
        			progressbarClass += '<img src="'+str[i]+'" id="'+i+'">';
        		}
        	}
            return progressbarClass;
        }
    });
    //缩略图点击
    $('.swiper-pagination').on('click','img',function(){
    	//swiper.slideTo(this.id, 500, false);
    	//$(this).addClass('minImgSel').siblings().removeClass('minImgSel');
    });
    var count = 0;
    //上一个
    $('.swiper-button-prev').on('click',function(){
    	count--;
    	if(count == -1){
    		count =  $('.pc-bannerWrap .swiper-pagination img').length -1;
    		if($('.pc-bannerWrap .swiper-pagination').width() <= 1248){
    			$('.pc-bannerWrap .swiper-pagination img').animate({left: '+0'}, "fast");
    		}else{
    			$('.pc-bannerWrap .swiper-pagination img').animate({left: '-100%'}, "fast");
    		}
    	}else{
    		$('.pc-bannerWrap .swiper-pagination img').animate({left: '+0'}, "fast");
    	}
    	$('.swiper-pagination').find('img').each(function(){
    		if($(this).attr('id') == count){
    			$(this).addClass('minImgSel').siblings().removeClass('minImgSel');
    		}
    	});
    });
    //下一个
    $('.swiper-button-next').on('click',function(){
    	var minIndex = $('.swiper-slide-active').find('img').attr('id');
    	count++;
    	if(count == $('.pc-bannerWrap .swiper-pagination img').length){
    		count = 0;
    		$('.pc-bannerWrap .swiper-pagination img').animate({left: '+0'}, "fast");
    	}else{
    		if($('.pc-bannerWrap .swiper-pagination').width() <= 1248){
    			$('.pc-bannerWrap .swiper-pagination img').animate({left: '+0'}, "fast");
    		}else{
    			$('.pc-bannerWrap .swiper-pagination img').animate({left: '-208px'}, "fast");
    		}
    	}
    	$('.swiper-pagination').find('img').each(function(){
    		if($(this).attr('id') == count){
    			$(this).addClass('minImgSel').siblings().removeClass('minImgSel');
    		}
    	});
    });
}

//百度地图API功能
var map = new BMap.Map("allmap");    // 创建Map实例
map.centerAndZoom(new BMap.Point(116.404, 39.915), 11);  // 初始化地图,设置中心点坐标和地图级别
//添加地图类型控件
map.addControl(new BMap.MapTypeControl({
	mapTypes:[
        BMAP_NORMAL_MAP,
        BMAP_HYBRID_MAP
    ]}));	  
map.setCurrentCity("北京");          // 设置地图显示的城市 此项是必须设置的
map.enableScrollWheelZoom(true);     //开启鼠标滚轮缩放

//页面滚动事件
window.onscroll = function(){
    var t = document.documentElement.scrollTop || document.body.scrollTop;
    //console.log(t)
    if(t > 1180 && t < 2161){
        $('.detailsHeader').show();
        $('.detailsHeader .head_r').children('a:nth-child(1)').addClass('detailsHeaderASel');
    	$('.detailsHeader .head_r').children('a:nth-child(1)').siblings().removeClass('detailsHeaderASel');
    }else if(t > 2162 && t < 2754){
    	$('.detailsHeader .head_r').children('a:nth-child(2)').addClass('detailsHeaderASel');
    	$('.detailsHeader .head_r').children('a:nth-child(2)').siblings().removeClass('detailsHeaderASel');
    }else if(t > 2755 && t < 3635){
    	$('.detailsHeader .head_r').children('a:nth-child(3)').addClass('detailsHeaderASel');
    	$('.detailsHeader .head_r').children('a:nth-child(3)').siblings().removeClass('detailsHeaderASel');
    }else if(t > 3636){
    	$('.detailsHeader .head_r').children('a:nth-child(4)').addClass('detailsHeaderASel');
    	$('.detailsHeader .head_r').children('a:nth-child(4)').siblings().removeClass('detailsHeaderASel');
    }else if(t < 1180 && t == 0){
        $('.detailsHeader').hide();
    }
};
$('.details_l_tit').children('a').each(function(){
	$(this).on('click',function(){
		$(this).addClass('details_l_tit_on');
		$(this).siblings().removeClass('details_l_tit_on');
	});
});
/*锚点动效*/
$('a[href*=#],area[href*=#]').click(function() {
   if (location.pathname.replace(/^\//, '') == this.pathname.replace(/^\//, '') && location.hostname == this.hostname) {
      var $target = $(this.hash);
      $target = $target.length && $target || $('[name=' + this.hash.slice(1) + ']');
      if ($target.length) {
         var targetOffset = $target.offset().top;
         $('html,body').animate({
               scrollTop: targetOffset
            },
            1000);
         return false;
      }
   }
});
//详情页登录
$('#loginDe').on('click', function(){
	if($(this).text() == '登录'){
		var index=parent.layer.getFrameIndex(window.name);
		parent.window.layer.open({
		    type: 2,
		    title: false,
		    resize: false,
		    shade: 0.5,
		    scrollbar: false,
		    maxmin: false,
		    shadeClose: true, //点击遮罩关闭层
		    closeBtn: 0,
		    area: ['750px', '420px'],
		    maxHeight : '475px',
		    content: '../../html/layerLevel/login.html'    
		});
		parent.layer.close(index);
	}
});
//详情页注册
$('#registerDe').on('click', function(){
	if($(this).text() == '注册'){
		var index=parent.layer.getFrameIndex(window.name);
		parent.window.layer.open({
		    type: 2,
		    title: false,
		    resize: false,
		    shade: 0.5,
		    scrollbar: false,
		    maxmin: false,
		    shadeClose: true, //点击遮罩关闭层
		    closeBtn: 0,
		    area: ['750px', '475px'],
		    content: '../../html/layerLevel/register.html'
		});
		parent.layer.close(index);
	}else if($(this).text() == '【退出】'){
		localStorage.removeItem('username');
		sessionStorage.removeItem('username');
		$('#login').text('登录').addClass('LoginHover');
		$('#register').text('注册').addClass('LoginHover');
	}
});