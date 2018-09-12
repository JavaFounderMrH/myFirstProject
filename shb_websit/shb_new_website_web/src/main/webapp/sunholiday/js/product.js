var windowWidth = $(window).width();
var windowHeight = $(window).height();
$(window).scroll(function(){
    var t = document.documentElement.scrollTop || document.body.scrollTop;
    if(t > 0){
        $('.subNav').show();
    }else{
        $('.subNav').hide();
    }
    if($(window).scrollTop() > (windowWidth*1.4 - windowHeight)){
        $('.product ul li:nth-child(1) a:nth-child(1)').show().animate({left: '+21.3%'}, 1800);
        $('.product ul li:nth-child(1) a:nth-child(2)').show().animate({right: '+20.4%'}, 1800);
    }
    if($(window).scrollTop()> (windowWidth*1.65 - windowHeight)){
        $('.product ul li:nth-child(2) a:nth-child(1)').show().animate({left: '+21.3%'}, 1800);
        $('.product ul li:nth-child(2) a:nth-child(2)').show().animate({right: '+20.4%'}, 1500);
    }
    if($(window).scrollTop()> (windowWidth*2 - windowHeight)){
        $('.product ul li:nth-child(3) a:nth-child(1)').show().animate({left: '+21.3%'}, 1800);
        $('.product ul li:nth-child(3) a:nth-child(2)').show().animate({right: '+20.4%'}, 1800);
    }
    if($(window).scrollTop()> (windowWidth*2.3 - windowHeight)){
        $('.product ul li:nth-child(4) a:nth-child(1)').show().animate({left: '+21.3%'}, 1800);
        $('.product ul li:nth-child(4) a:nth-child(2)').show().animate({right: '+20.4%'}, 1800);
    }
    if($(window).scrollTop()> (windowWidth*2.75 - windowHeight)){
        $('.product ul li:nth-child(5) a:nth-child(1)').show().animate({left: '+21.3%'}, 1800);
        $('.product ul li:nth-child(5) a:nth-child(2)').show().animate({right: '+20.4%'}, 1800);
    }
});
