var userName;
if(localStorage.getItem("username")){
	userName = localStorage.getItem("username");
	//保存一月之后注销
}else if(sessionStorage.getItem("username")){
	userName = sessionStorage.getItem("username");
}
if(userName == null){
	$('#login').text('登录').addClass('LoginHover');
	$('#register').text('注册').addClass('LoginHover');
}else{
	$('#login').text('我的山海边').removeClass('LoginHover');
	$('#register').text('【退出】').removeClass('LoginHover');
}
//登录注册找回密码取消
$('#lofinQuit').on('click',function(){
	//当你在iframe页面关闭自身时
	var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
	parent.layer.close(index); //再执行关闭   
});
//登录
$('#login').on('click', function(){
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
		    content: 'sunholiday/html/layerLevel/login.html'    
		});
		parent.layer.close(index);
	}
});
//注册
$('#register').on('click', function(){
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
		    content: 'sunholiday/html/layerLevel/register.html'
		});
		parent.layer.close(index);
	}else if($(this).text() == '【退出】'){
		localStorage.removeItem('username');
		sessionStorage.removeItem('username');
		$('#login').text('登录').addClass('LoginHover');
		$('#register').text('注册').addClass('LoginHover');
	}
});
//立即注册//
$('#registerLogin').on('click', function(){
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
	    content: 'sunholiday/html/layerLevel/register.html'
	});
	parent.layer.close(index);
});
//立即登录
$('#loginNow').on('click', function(){
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
	    content: 'sunholiday/html/layerLevel/login.html'    
	});
	parent.layer.close(index);
});
//忘记密码
$('#forgerPage').on('click', function(){
	var username = $('#login_user1').val();
	var phoneReg = /^(0|86|17951)?(13[0-9]|15[012356789]|17[0-9]|18[0-9]|14[57])[0-9]{8}$/;
	if(username != '' && phoneReg.test(username)){
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
		    content: 'sunholiday/html/layerLevel/forgetPage.html?forgetUsername='+username+''
		});
		parent.layer.close(index);
	}else{
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
		    content: 'sunholiday/html/layerLevel/forgetPage.html'
		});
		parent.layer.close(index);
	}
});
//关于我们
$('.guanyuWomen').on("mouseenter", function () {
    $('.head_r .head_nav').slideDown(550);
}).on("mouseleave", function () {
	$('.head_r .head_nav').stop().slideUp(550);
	$('.head_r .head_nav').on("mouseenter", function () {
	    $('.head_r .head_nav').stop().slideDown(550);
	}).on("mouseleave", function () {
		$('.head_r .head_nav').stop().slideUp(550);
	});
});
//悬浮框
window.onscroll = function(){
    var t = document.documentElement.scrollTop || document.body.scrollTop;
    if(t > 0){
        $('.subNav').show();
    }else{
        $('.subNav').hide();
    }
};
$('.fangyuan').on('click',function () {
    window.open('http://www.shanhaibian.com//shb_Landlord_new_web/views/login.html');
});
$('.sub_r li').each(function (i) {
	$(this).on('click',function(){
		if(i == 0){
			$('.sub_l_img').slideDown("slow");
			$('.sub_l_tel').hide();
			$('.sub_l_yijian').hide();
	    }else if(i == 1){
	    	$('.sub_l_tel').slideDown("slow");
	    	$('.sub_l_img').hide();
	    	$('.sub_l_yijian').hide();
	    }else if(i == 3){
	    	$('.sub_l_yijian').slideDown("slow");
	    	$('.sub_l_tel').hide();
	    	$('.sub_l_img').hide();
	    }
    });
});
$('.subQuit').on('click',function(){
	if($(this).attr('data-num') == 0){
		$('.sub_l_img').slideUp("slow");
	}else if($(this).attr('data-num') == 1){
		$('.sub_l_tel').slideUp("slow");
	}else if($(this).attr('data-num') == 3){
		$('.sub_l_yijian').slideUp("slow");
	}
});
//意见反馈
$('#yijianSubmit').on('click',function(){
	var yijianTxt = $('#yijianTxt').val();
	var yijianTel = $('#yijianTel').val();
	if(yijianTxt == ''){
		$('#yijianTip').show().text('请发表对山海边的任何意见');
		return;
	}
	if(yijianTel == ''){
		$('#yijianTip').show().text('联系方式不能为空');
		return;
	}
	$('#yijianTip').hide();
	$.ajax({
		type: "GET",
		url: "/newWebsiteController/insertUserFeedback",
		dataType: 'json',
		data: {
			"visitSyn": yijianTxt,
			"phone": yijianTel
		},
		success: function(data){
			if(data.messcode == "001"){
				$('.sub_l_yijian').hide();
				$('.sub_l_fankui').show();
				$('#fankuiBtn').on('click',function(){
					$('.sub_l_fankui').slideUp("slow");
					$('#yijianTxt').val('');
					$('#yijianTel').val('');
				});
			}else{
				layer.msg(data.message);
			}
		}
	});
});

//快速找房
$('.fastSearch1').focus(function(){
	$('.cityWrap').slideDown("slow");
	if($(this).val() != ''){
		query = $(this).val();
		$.ajax({
			type : 'GET',
			url : "/roomInfoController/queryCityInfo",
			dataType:'json',
			data:{
				"query": query
			},
			success : function(data) {
				if(data.messcode == '001'){
					var dataBaidu = data.lendReco.baiduCoordinate;
					if(data.lendReco.baiduCoordinate.length != 0){
						$('.cityWrap').hide();
						$('.geoPositionNot').hide();
						$('.geoPositionWrap').slideDown("slow");
						$('#geoPosition').empty();
						var geoPositionStr = '';
						for(var i in dataBaidu){
							//lat,lng
							geoPositionStr += '<a>';
								if(dataBaidu[i].name.indexOf(query) != -1){
									geoPositionStr += '<span>'+dataBaidu[i].name.replace(query, '<i>'+query+'</i>')+'</span>';
								}else{
									geoPositionStr += '<span>'+dataBaidu[i].name+'</span>';
								}
									geoPositionStr += '<span>'+dataBaidu[i].cityDistrict+'</span>'
										+'</a>';
						}
						$('#geoPosition').append(geoPositionStr);
						$('#geoPosition').find('a').each(function(){
							$(this).on('click',function(){
								$('.fastSearch1').val($(this).children('span:nth-child(1)').text());
								$('.geoPositionWrap').slideUp("slow");
							});
						});
					}else{
						$('.cityWrap').hide();
						$('.geoPositionWrap').hide();
						$('.geoPositionNot').slideDown("slow");
					}
				}else{
					layer.msg(data.message);
				}
			}
		});
	}else{
		query = '';
		cityList();
	}
});
$(".fastSearch1").blur(function(){
	$('.cityWrap').slideUp("slow");
	$('.geoPositionWrap').slideUp("slow");
	query = '';
	/*if($(this).attr('custom') == 2){
		$('.fastSearch1').val('北京');
	}*/
});
//地理位置
$(".fastSearch1").bind("input propertychange",function () {
	if($(this).attr('custom') == 2){
		//房源列表
		if($(this).val() != ''){
			query = $(this).val();
			$.ajax({
				type : 'GET',
				url : "/roomInfoController/queryCityInfo",
				dataType:'json',
				data:{
					"query": query
				},
				success : function(data) {
					if(data.messcode == '001'){
						var dataBaidu = data.lendReco.baiduCoordinate;
						var dataLandlord = data.lendReco.landlord;
						var dataRoomInfoTitle = data.lendReco.roomInfoTitle;
						if(data.lendReco.baiduCoordinate.length != 0){
							$('.cityWrap').hide();
							$('.geoPositionNot').hide();
							$('.geoPositionWrap').slideDown("slow");
							//百度地理位置
							$('#geoPosition').empty();
							var geoPositionStr = '';
							for(var i in dataBaidu){
								//lat,lng
								geoPositionStr += '<a>';
									if(dataBaidu[i].name.indexOf(query) != -1){
										geoPositionStr += '<span>'+dataBaidu[i].name.replace(query, '<i>'+query+'</i>')+'</span>';
									}else{
										geoPositionStr += '<span>'+dataBaidu[i].name+'</span>';
									}
										geoPositionStr += '<span>'+dataBaidu[i].cityDistrict+'</span>'
											+'</a>';
							}
							$('#geoPosition').append(geoPositionStr);
							$('#geoPosition').find('a').each(function(){
								$(this).on('click',function(){
									$('.fastSearch1').val($(this).children('span:nth-child(1)').text());
									$('.geoPositionWrap').slideUp("slow");
								});
							});
							//房东昵称
							$('#geoPositionLan').empty();
							if(data.lendReco.landlord.length != 0){
								var geoPositionLanStr = '<h3>房东昵称</h3>'
													+'<nav>';
								for(var i in dataLandlord){
									//sliId
									//username
									geoPositionLanStr += '<a>';
										if(dataLandlord[i].nickName.indexOf(query) != -1){
											geoPositionLanStr += '<span>'+dataLandlord[i].nickName.replace(query, '<i>'+query+'</i>')+'</span>';
										}else{
											geoPositionLanStr += '<span>'+dataLandlord[i].nickName+'</span>';
										}
											geoPositionLanStr += '<p></p>'
												+'</a>';
								}
								geoPositionLanStr += '</nav>';
								$('#geoPositionLan').append(geoPositionLanStr);
								$('#geoPositionLan').find('a').each(function(){
									$(this).on('click',function(){
										$('.fastSearch1').val($(this).children('span:nth-child(1)').text());
										$('.geoPositionWrap').slideUp("slow");
									});
								});
							}
							//房源标题
							$('#geoPositionRoom').empty();
							if(data.lendReco.roomInfoTitle.length != 0){
								var dataRoomInfoTitleStr = '<h3>房源标题</h3>'
													+'<nav>';
								for(var i in dataRoomInfoTitle){
									//sriId
									dataRoomInfoTitleStr += '<a>';
										if(dataRoomInfoTitle[i].roomTitle.indexOf(query) != -1){
											dataRoomInfoTitleStr += '<span>'+dataRoomInfoTitle[i].roomTitle.replace(query, '<i>'+query+'</i>')+'</span>';
										}else{
											dataRoomInfoTitleStr += '<span>'+dataRoomInfoTitle[i].roomTitle+'</span>';
										}
										dataRoomInfoTitleStr += '<p></p>'
												+'</a>';
								}
								dataRoomInfoTitleStr += '</nav>';
								$('#geoPositionRoom').append(dataRoomInfoTitleStr);
								$('#geoPositionRoom').find('a').each(function(){
									$(this).on('click',function(){
										$('.fastSearch1').val($(this).children('span:nth-child(1)').text());
										$('.geoPositionWrap').slideUp("slow");
									});
								});
							}
						}else{
							$('.cityWrap').hide();
							$('.geoPositionWrap').hide();
							$('.geoPositionNot').slideDown("slow");
						}
					}else{
						layer.msg(data.message);
					}
				}
			});
		}else{
			query = '';
			$('.cityWrap').slideDown("slow");
			cityList();
		}
	}else{
		//首页
		if($(this).val() != ''){
			query = $(this).val();
			$.ajax({
				type : 'GET',
				url : "/roomInfoController/queryCityInfo",
				dataType:'json',
				data:{
					"query": query
				},
				success : function(data) {
					if(data.messcode == '001'){
						var dataBaidu = data.lendReco.baiduCoordinate;
						if(data.lendReco.baiduCoordinate.length != 0){
							$('.cityWrap').hide();
							$('.geoPositionNot').hide();
							$('.geoPositionWrap').slideDown("slow");
							$('#geoPosition').empty();
							var geoPositionStr = '';
							for(var i in dataBaidu){
								//lat,lng
								geoPositionStr += '<a>';
									if(dataBaidu[i].name.indexOf(query) != -1){
										geoPositionStr += '<span>'+dataBaidu[i].name.replace(query, '<i>'+query+'</i>')+'</span>';
									}else{
										geoPositionStr += '<span>'+dataBaidu[i].name+'</span>';
									}
										geoPositionStr += '<span>'+dataBaidu[i].cityDistrict+'</span>'
											+'</a>';
							}
							$('#geoPosition').append(geoPositionStr);
							$('#geoPosition').find('a').each(function(){
								$(this).on('click',function(){
									$('.fastSearch1').val($(this).children('span:nth-child(1)').text());
									$('.geoPositionWrap').slideUp("slow");
								});
							});
						}else{
							$('.cityWrap').hide();
							$('.geoPositionWrap').hide();
							$('.geoPositionNot').slideDown("slow");
						}
					}else{
						layer.msg(data.message);
					}
				}
			});
		}else{
			query = '';
			$('.cityWrap').slideDown("slow");
			cityList();
		}
	}
});
//城市信息
function cityList(){
	$.ajax({
		type : 'GET',
		url : "/roomInfoController/queryCityInfo",
		dataType:'json',
		data:{
			"query": query
		},
		success : function(data) {
			if(data.messcode == '001'){
				var dataHot = data.cityDtos.hotcityInfoList;
				var dataCity = data.cityDtos.cityList;
				$('.geoPositionWrap').hide();
				$('.geoPositionNot').hide();
				$('#hot').empty();
				$('#city').empty();
				var hotStr = '';
				var cityStr = '';
				for(var i in dataHot){
					hotStr += '<a class="columnCenter" alt="'+dataHot[i].areaCode+'" title="'+dataHot[i].name+'">'
					+'<img src="'+dataHot[i].cityIcon+'">'
					+'<span>'+dataHot[i].name+'</span>'
					+'</a>';
				}
				for(var j in dataCity){
					cityStr += '<a alt="'+dataCity[j].areaCode+'" title="'+dataCity[j].cityName+'">'+dataCity[j].cityName+'</a>';
				}
				$('#hot').append(hotStr);
				$('#city').append(cityStr);
				$('.cityWrap').find('a').each(function(){
					$(this).on('click',function(){
						$('.fastSearch1').val($(this).text());
						$('.cityWrap').slideUp("slow");
					});
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
//日历
layui.use('laydate', function(){
	var laydate = layui.laydate;
	laydate.render({
		elem: '#calanderFast',
		ready: function(date){
			$('.laydate-btns-clear').text('清空日期');
			$('.layui-laydate-content').find('th').each(function(){
				if($(this).text() == '六' || $(this).text() == '日'){
					$(this).css('color','#40d8d7');
				}
			})
		},
		range: '至',
		zIndex: 6666,
		min: 0,
		theme: '#40d8d7',
		max: 157,
		btns: ['clear','now'],
		change: function(value, date, endDate){
			if(endDate){
				$('#calanderFast').val(value);
				setTimeout(function(){
					$(".layui-laydate").remove();
				},800);
			}
	    },
	    done: function(value, date, endDate){
	    	//清空日期
	    	localStorage.removeItem("date", date);
	    }
	});
	
});
//获取路径中的值
function getQueryString(name) {
	var reg = new RegExp('(^|&)' + name + '=([^&]*)(&|$)', 'i');
	var r = window.location.search.substr(1).match(reg);
	if (r != null) {
		return decodeURI(r[2]);
	}
	return null;
}