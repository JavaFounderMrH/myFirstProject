$(function(){
	xianlu();
});
var swiper1 = new Swiper ('#homeBanner', {
    loop: true,
    autoplay: 5000,//可选选项，自动滑动
    speed:600,
    autoplayDisableOnInteraction : false,//点击事件之后不会停止自动播放
    setWrapperSize :true,//对sweiper支持不太好的时候用得上
    effect : 'fade',//淡入
    fade: {
        crossFade: true
    },
    // 分页器
    pagination: '.swiper-pagination',
    paginationClickable: true
});
var swiper2 = new Swiper('#fangxingBanner', {
    slidesPerView: 'auto',
    observer: true,//修改swiper自己或子元素时，自动初始化swiper
    observeParents: true,//修改swiper的父元素时，自动初始化swiper
    grabCursor: true
});
function xianlu(){
	$.ajax({
		type : 'GET',
		url : "/touristRouteApi/querytouristRouteInfo",
		dataType:'json',
		success : function(data) {
			if(data.messcode == '001'){
				console.log(data);
				var str = '';
				var list = data.tourismLineList;
				for(var i in list){
					str += '<a class="swiper-slide" href="app/html/productList.html?type='+list[i].lineId+'"><img src="'+list[i].lineListSrc+'"></a>';
				}
				$('#chanpinBanner .swiper-wrapper').append(str);
				var swiper3 = new Swiper('#chanpinBanner', {
					loop: true,
				    autoplay: 1800,//可选选项，自动滑动
				    spped: 600,
				    autoplayDisableOnInteraction : false,//点击事件之后不会停止自动播放
				    setWrapperSize :true,//对sweiper支持不太好的时候用得上
				    slidesPerView: 'auto',
				    loopedSlides: list.length,
				    observer: true,//修改swiper自己或子元素时，自动初始化swiper
				    observeParents: true,//修改swiper的父元素时，自动初始化swiper
				    grabCursor: true
				});
			}else{
				console.log(data);
			}
		},
		error:function(data) {
			console.log(data);
		}
	});
}
