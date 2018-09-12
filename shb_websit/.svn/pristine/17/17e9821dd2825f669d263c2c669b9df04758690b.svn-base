//密码可见
$('.seePassword').on('click',function(){
	if($('#login_password').prop('type') == 'text'){
		$('#login_password').prop('type','password');
		$(this).css('background','url(../../image/layerLevel/login_see1.png) no-repeat');
	}else{
		$(this).css('background','url(../../image/layerLevel/login_see2.png) no-repeat');
		$('#login_password').prop('type','text');
	}
});
//换图片验证码显示按钮
$('.login_l_inputWrapYzImg a img').hover(function(){
	$('.login_l_inputWrapYzImg a span').show();
}).mouseout(function(){
	$('.login_l_inputWrapYzImg a span').stop().hide();
	$('.login_l_inputWrapYzImg a span').on("mouseenter", function () {
		$('.login_l_inputWrapYzImg a span').stop().show();
	}).on("mouseleave", function () {
		$('.login_l_inputWrapYzImg a span').stop().hide();
	});
});
//记住密码  —— 服务协议是否选择
$('.login_l_doth div').on('click',function(){
	if($(this).find('input').prop('checked') == false){
		$(this).css({'background':'url(../../image/layerLevel/login_check1.png) no-repeat','background-position':'1px'});
	}else{
		$(this).css({'background':'url(../../image/layerLevel/login_check2.png) no-repeat','background-position':'1px'});
	}
});
//定时器
var wait = 60;
function time() {
	codeType = 0;
	if(wait == 0) {
		$("#hqYzm").text('获取动态验证码');
		$("#hqYzm").css({"background": "#fff","color":"#40d8d7"});
		wait = 60;
		$('#login_user2').removeAttr('disabled').css('background','#fff');
		$('#yzmImg').removeAttr('disabled').css('background','#fff');
	}else {
		codeType = 1;
		$("#hqYzm").css({"background": "#40d8d7","color":"#fff"});
		$("#hqYzm").text("" + wait + "S后重发") ;
		$('#login_user2').attr('disabled','disabled').css('background','#fff');
		$('#yzmImg').attr('disabled','disabled').css('background','#fff');
		wait--;
		setTimeout(function() {
			time();
		}, 1000)
	}
}
//倒计时不可点击
$('#hqYzm').on('click',function(){
	if($('#login_user2').attr('disabled') == 'disabled'){
		 layer.msg('验证码已发送，请稍候');
	}
});
$('#codeImgTab').on('click',function(){
	codeImg();
});

