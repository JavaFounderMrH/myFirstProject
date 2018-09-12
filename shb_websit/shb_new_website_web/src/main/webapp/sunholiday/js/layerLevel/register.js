$(function(){
	codeImg();
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
    		    		    		$(document).on('input propertychange','#login_password',function (e) {
    		    		    		    if (e.type === "input" || e.orignalEvent.propertyName === "value") {
    		    		    		    	if(this.value.length >= 6){
    		    		    		    		$('#submitRes').css('background','#27CDCC');
    		    		    		    	}else{
    		    		    		    		$('#submitRes').css('background','#F0F0F0');
    		    		    		    	}
    		    		    		    }
    		    		    		});
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
		$(".registerPrompt").text('手机号不能为空').show('slow');
		return;
	}else if(!phoneReg.test(username)){
		$(".registerPrompt").text('手机号错误').show('slow');
		return;
	}
	codeImgStr = codeImgStr.toLowerCase();
	yzmImg = yzmImg.toLowerCase();
	if(yzmImg == ''){
		$(".registerPrompt").text('图片验证码不能为空').show('slow');
		return;
	}else if(yzmImg != codeImgStr){
		$(".registerPrompt").text('图片验证码错误').show('slow');
		return;
	}
	$(".registerPrompt").hide('slow');
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
            	$(".registerPrompt").text(data.message).show('slow');
            }
        }
    });
});
//注册提交
$('#submitRes').on('click',function(){
	var username = $('#login_user2').val();
	var yzmImg = $('#yzmImg').val();
	var yzmDt = $('#yzmDt').val();
	var password = $('#login_password').val();
    if($(this).css('background').indexOf('rgb(39, 205, 204)') > -1){
    	var phoneReg = /^(0|86|17951)?(13[0-9]|15[012356789]|17[0-9]|18[0-9]|14[57])[0-9]{8}$/;
		if(!phoneReg.test(username)){
			$(".registerPrompt").text('手机号错误').show('slow');
			return;
		}
		if(yzmDt != getYanzhengma){
			$(".registerPrompt").text('动态验证码错误').show('slow');
			return;
		}
		if($('#rememberUser').is(':checked') == false){
			$('.register_l_doth').addClass('register_l_doth_dd');
			return;
	    }
    	$.ajax({
            type:"GET",
            url:"/userLoginController/insertUser",
            data:{
            	"username": username,
            	"password": password
            },
            dataType:"json",
            success:function(data){
                if(data.messcode == "001"){
                	sessionStorage.setItem("username", username);
                    layer.msg('注册成功，已登录');
                	setTimeout(function(){
                		var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
                		parent.layer.close(index); //再执行关闭 
                		window.parent.location.reload();
                	},1500);
                }else if(data.messcode == "002"){
                	$(".registerPrompt").text(data.message).show('slow');
                }else{
                	layer.msg(data.message);
                }
            }
        });
    }
});
