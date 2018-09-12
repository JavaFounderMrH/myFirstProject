//导航滑动
var swiper1 = new Swiper('#nav', {
    slidesPerView: 'auto',
    onTransitionEnd: function(swiper){
    	  if(swiper.progress==1){
    		  swiper.activeIndex=swiper.slides.length-1
    	  }
      },
    loopedSlides :6,
    setWrapperSize :true,
    observer: true,//修改swiper自己或子元素时，自动初始化swiper
    observeParents: true,//修改swiper的父元素时，自动初始化swiper
    grabCursor: true,
});
