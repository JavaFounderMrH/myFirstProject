/* product */
/* ziyingBanner */
var swiper1 = new Swiper ('#ziyingBanner', {
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
var swiper2 = new Swiper('#fengcai', {
    autoplay:2000,
    speed:1000,
    autoplayDisableOnInteraction : false,
    loop:true,
    slidesPerView: 'auto',
    observer: true,//修改swiper自己或子元素时，自动初始化swiper
    observeParents: true,//修改swiper的父元素时，自动初始化swiper
    grabCursor: true,
    pagination : '.swiper-pagination'
});
/* news */

/* lianxi */

/* productList */
var type = window.location.href.split('?type=')[1];
if(type != null){
	$.ajax({
		type : 'GET',
		url : "/touristRouteApi/querytouristRouteInfoByLineId",
		dataType:'json',
		data:{
			"lineId": type
		},
		success : function(data) {
			if(data.messcode == '001'){
				var str = '';
				str = '<img src="'+data.tourismLine.lineDetailsSrc+'">';
				$('.productList').append(str);
			}else{
				console.log(data);
			}
		},
		error:function(data) {
			console.log(data);
		}
	});
}

