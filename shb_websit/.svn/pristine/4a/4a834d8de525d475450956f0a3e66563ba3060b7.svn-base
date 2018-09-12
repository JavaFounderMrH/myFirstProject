var forgetUsername;
forgetUsername = getQueryString("forgetUsername");
if(forgetUsername != null){
	$('#login_user1').val(forgetUsername);
	$(document).on('input propertychange','#login_password',function (e) {
	    if (e.type === "input" || e.orignalEvent.propertyName === "value") {
	    	if(this.value.length >= 6){
	    		$('#submitP').css('background','#27CDCC');
	    	}else{
	    		$('#submitP').css('background','#F0F0F0');
	    	}
	    }
	});
}
//登录——登录方式切换
$('.loginTab').find('a').each(function(){
	$(this).on('click',function(){
		$(this).css({'color': '#40D8D7','border-bottom': '2px solid #40D8D7'});
		$(this).siblings('a').css({'color': '#333','border-bottom': 'none'});
		if($(this).text() == '普通登录'){
			$('.login_l_putong').show();
			$('.login_l_kuaijie').hide();
		}else if($(this).text() == '验证码快捷登录'){
			$('.login_l_putong').hide();
			$('.login_l_kuaijie').show();
			codeImg();
		}
	});
});
//图片验证码
var codeImgStr = '';
function codeImg(){
	$.ajax({
		type: "GET",
		url: "/userLoginController/queryCode",
		dataType: 'json',
		success: function(data){
			if(data.messcode == "001"){
				codeImgStr = data.pictureCode.value;
				codeImgStr.toUpperCase();
				codeImgStr.toLowerCase();
				$("#codeImg").attr("src", "data:image/gif;base64," + data.pictureCode.base64Str);
			}
		}
	});
}
//普通登录提交
$(document).on('input propertychange','#login_user1',function (e) {
    if (e.type === "input" || e.orignalEvent.propertyName === "value") {
    	if(this.value.length == 11){
    		$(document).on('input propertychange','#login_password',function (e) {
    		    if (e.type === "input" || e.orignalEvent.propertyName === "value") {
    		    	if(this.value.length >= 6){
    		    		$('#submitP').css('background','#27CDCC');
    		    	}else{
    		    		$('#submitP').css('background','#F0F0F0');
    		    	}
    		    }
    		});
    	}
    }
});
$('#submitP').on('click',function(){
	var username = $('#login_user1').val();
	var password = $('#login_password').val();
    if($(this).css('background').indexOf('rgb(39, 205, 204)') > -1){
    	//判断是否已注册
    	var phoneReg = /^(0|86|17951)?(13[0-9]|15[012356789]|17[0-9]|18[0-9]|14[57])[0-9]{8}$/;
		if(!phoneReg.test(username)){
			$(".loginPrompt1").text('手机号或密码错误').show('slow');
			return;
		}
    	$.ajax({
            type:"GET",
            url:"/userLoginController/login",
            data:{
            	"username": username,
            	"password": password
            },
            dataType:"json",
            success:function(data){
                if(data.messcode == "001"){
                    if($('#rememberUser').is(':checked') == true){
                    	localStorage.setItem("username", username);
                    }else{
                    	sessionStorage.setItem("username", username);
                    }
                    layer.msg('密码登录成功');
                	setTimeout(function(){
                		var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
                		parent.layer.close(index); //再执行关闭 
                		window.parent.location.reload();
                	},1500);
                }else{
                	$(".loginPrompt1").text(data.message).show('slow');
                }
            }
        });
    }
});
//验证码登录提交
$(document).on('input propertychange','#login_user2',function (e) {
    if (e.type === "input" || e.orignalEvent.propertyName === "value") {
    	if(this.value.length == 11){
    		$(document).on('input propertychange','#yzmImg',function (e) {
    		    if (e.type === "input" || e.orignalEvent.propertyName === "value") {
    		    	if(this.value.length == 4){
    		    		$('#hqYzm').css({'background':'#40d8d7','color':'#fff'});
    		    		$(document).on('input propertychange','#yzmDt',function (e) {
    		    		    if (e.type === "input" || e.orignalEvent.propertyName === "value") {
    		    		    	if(this.value.length == 4){
    		    		    		$('#submitY').css('background','#27CDCC');
    		    		    	}else{
    		    		    		$('#submitY').css('background','#F0F0F0');
    		    		    	}
    		    		    }
    		    		});
    		    	}
    		    }
    		});
    	}
    }
});
//获取动态验证码
var getYanzhengma = '';
$('#hqYzm').on('click',function(){
	var username = $('#login_user2').val();
	var yzmImg = $('#yzmImg').val();
	var phoneReg = /^(0|86|17951)?(13[0-9]|15[012356789]|17[0-9]|18[0-9]|14[57])[0-9]{8}$/;
	if(username == ''){
		$(".loginPrompt2").text('手机号不能为空').show('slow');
		return;
	}else if(!phoneReg.test(username)){
		$(".loginPrompt2").text('手机号错误').show('slow');
		return;
	}
	codeImgStr = codeImgStr.toLowerCase();
	yzmImg = yzmImg.toLowerCase();
	if(yzmImg == ''){
		$(".loginPrompt2").text('图片验证码不能为空').show('slow');
		return;
	}else if(yzmImg != codeImgStr){
		$(".loginPrompt2").text('图片验证码错误').show('slow');
		return;
	}
	$(".loginPrompt2").hide('slow');
	$.ajax({
        type:"GET",
        url:"/userLoginController/sendOutCode",
        data:{
        	"username": username
        },
        dataType:"json",
        success:function(data){
            if(data.messcode == "001"){
            	layer.msg('动态验证码已发送');
				$("#smscode").val(data.sendcode);
				getYanzhengma = data.sendcode;
				time();
            }else{
            	$(".loginPrompt1").text(data.message).show('slow');
            }
        }
    });
});
//验证码登录
$('#submitY').on('click',function(){
	var username = $('#login_user2').val();
	var yzmImg = $('#yzmImg').val();
	var yzmDt = $('#yzmDt').val();
    if($(this).css('background').indexOf('rgb(39, 205, 204)') > -1){
    	//判断是否已注册
    	var phoneReg = /^(0|86|17951)?(13[0-9]|15[012356789]|17[0-9]|18[0-9]|14[57])[0-9]{8}$/;
		if(!phoneReg.test(username)){
			$(".loginPrompt2").text('手机号错误').show('slow');
			return;
		}
		if(yzmDt != getYanzhengma){
			$(".loginPrompt2").text('动态验证码错误').show('slow');
			return;
		}
    	$.ajax({
            type:"GET",
            url:"/userLoginController/fastLogin",
            data:{
            	"username": username,
            	"password": yzmDt
            },
            dataType:"json",
            success:function(data){
                if(data.messcode == "001"){
                	sessionStorage.setItem("username", username);
                    layer.msg('快捷登录成功');
                	setTimeout(function(){
                		var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
                		parent.layer.close(index); //再执行关闭 
                		window.parent.location.reload();
                	},1500);
                }else{
                	$(".loginPrompt2").text(data.message).show('slow');
                }
            }
        });
    }
});


