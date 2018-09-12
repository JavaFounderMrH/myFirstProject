$(document).ready(function(){
    initSwiper1();
});
function initSwiper1(){
    var swiper1 = new Swiper ('#swiper1', {
        loop: true,
        autoplay: 5000,//可选选项，自动滑动
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
//手风琴动画效果
var _index7=0;
$(".ziyingPinpai ul li").mouseover(function(){
    _index7=$(this).index();
    $(this).stop().stop().animate({width:'16%'},500).siblings("li").stop().animate({width:'3%'},500);
    $(".imgCen").eq(_index7).css("display","block").siblings(".imgCen").css("display","none");
    $(".imgTop img").eq(_index7).addClass("tm").siblings(".imgTop img").removeClass("tm");
});
$(".ziyingPinpai ul li").mouseout(function(){
    $(".imgCen").css("display","none");
    $(this).children('ul li .imgCen').show();
});
