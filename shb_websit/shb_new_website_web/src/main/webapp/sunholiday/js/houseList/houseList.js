//搜索参数
var cityName;
var startTime;
var endTime;
var bedroomNumber = 0;
var houseType;
var supString = '';
var sort  = 0;
var latitude;
var longitude;
//首页参数
var houseName;
var houseDate;
var bingPage;

var datailName;

//搜索条件input样式
$('.huxingWrap div').find('input').each(function(){
	$(this).on('click',function(){
		if($('input:radio[name="huxing"]:checked')){
			$(this).parent('label').css({'background':'#40D8D7 url(sunholiday/image/houseList/inputSel_bg.png) no-repeat 10px 5px','color':'#fff'});
			$(this).parent('label').siblings('label').css({'background':'#fff url(sunholiday/image/houseList/input_bg.png) no-repeat 10px 5px','color':'#999'});
			bedroomNumber = $(this).val();
			houseList(1);
		}
	});
});
$('.fangxingWrap div').find('input').each(function(){
	$(this).on('click',function(){
		if($('input:radio[name="fangxing"]:checked')){
			$(this).parent('label').css({'background':'#40D8D7 url(sunholiday/image/houseList/inputSel_bg.png) no-repeat 10px 5px','color':'#fff'});
			$(this).parent('label').siblings('label').css({'background':'#fff url(sunholiday/image/houseList/input_bg.png) no-repeat 10px 5px','color':'#999'});
			houseType = $(this).val();
			houseList(1);
		}
	});
});
var peizhiArr = [];
$('.peizhiWrap div').find('input').each(function(){
	$(this).on('click',function(){
		if($(this).prop('checked')){
			$(this).parent('label').css({'background':'#40D8D7 url(sunholiday/image/houseList/inputSel_bg.png) no-repeat 10px 5px','color':'#fff'});
			peizhiArr.push($(this).val());
		}else{
			$(this).parent('label').css({'background':'#fff url(sunholiday/image/houseList/input_bg.png) no-repeat 10px 5px','color':'#999'});
			Array.prototype.remove = function(val) {
				var index = this.indexOf(val); 
				if (index > -1) {
					this.splice(index, 1); 
				} 
			};
			peizhiArr.remove($(this).val());
		}
		supString = peizhiArr.join(',');
		houseList(1);
	});
});
//排序
$('.sortWrap').children('span').each(function(){
	$(this).on('click',function(){
		if($(this).text() == '评分'){
			sort = 5;
		}else if($(this).text() == '价格'){
			if($(this).css('background').indexOf('down') > -1){
				$(this).css('background','url(sunholiday/image/houseList/h_jiantou_up.png) no-repeat left 2px');
				sort = 1;
			}else{
				$(this).css('background','url(sunholiday/image/houseList/h_jiantou_down.png) no-repeat left 2px');
				sort = 2;
			}
		}else{
			sort = 0;
		}
		houseList(1);
	});
});
$(function(){
	if(localStorage.getItem("houseName") != null && localStorage.getItem("houseName") != '' && localStorage.getItem("houseName") != 'null'){
		houseName = localStorage.getItem("houseName");
	}else if(localStorage.getItem("cityName") != null && localStorage.getItem("cityName") != '' || localStorage.getItem("cityName") != 'null'){
		houseName = localStorage.getItem("cityName");
	}
	if(localStorage.getItem("houseName") == null && localStorage.getItem("cityName") == null){
		houseName = '北京';
	}
	if(localStorage.getItem("houseDate") != null){
		houseDate = localStorage.getItem("houseDate");
		startTime = houseDate.split(' 至 ')[0];
		endTime = houseDate.split(' 至 ')[1];
	}
	$('.fastSearch1').val(houseName);
	$('.fastSearch2').val(houseDate);
	//面包屑
	$('.houseTwoleName').text(' • '+houseName);
	houseList(1);
});
//房源列表
function houseList(bingPage){
	$.ajax({
		type : 'GET',
		url : "/roomInfoController/queryRoomInfoDtos",
		dataType:'json',
		async: false,
		data: {
			"cityName": houseName,
			"startTime": startTime,
			"endTime": endTime,
			"bingPage": bingPage,
			"bedroomNumber": bedroomNumber,
			"houseType": houseType,
			"supString": supString,
			"sort": sort,
			"latitude": latitude,
			"longitude": longitude
		},
		success : function(data) {
			//console.log(data)
			//地理位置--一级
			$('.weizhiList').empty();
			var weizhiListStr = '';
			for(var i in data.queryTradeareaOne){
				weizhiListStr += '<a id="'+data.queryTradeareaOne[i].stoId+'">'+data.queryTradeareaOne[i].tradeareaOne+'<img src="sunholiday/image/houseList/weizhi_down.png"></a>';
			}
			$('.weizhiList').append(weizhiListStr);
			diliTwo();
			//自营广告位图
			$('.houseListZImg').empty();
			var dataZiying = '<img src="'+data.shbRecommendedBitList[0].ziyingAdvertisementImg+'">';
			$('.houseListZImg').append(dataZiying);
			//列表
			if(data.roomList.length != 0){
				if(bingPage > data.pags) return;
				var leaseType = '';
				var dataStr = '';
				$('.fangyuanliebiao').show();
				$('.fangyuanNotWrap').hide();
				$('#houseList').empty();
				datailName = $('.houseTwoleName').text();
	            for(var i in data.roomList){
	            	leaseType = data.roomList[i].leaseType==1?'整套出租':data.roomList[i].leaseType==2?'单间出租':data.roomList[i].leaseType==3?'床位出租':data.roomList[i].leaseType==4?'沙发出租':'';
	            	dataStr += '<li id="'+data.roomList[i].sriId+'" class="'+data.roomList[i].landlordNickname+'">'
						+'<div class="h_img">'
							+'<a href="sunholiday/html/houseList/houseDetails.html?datailId='+data.roomList[i].sriId+'&datailUser='+data.roomList[i].landlordNickname+'&datailName='+datailName+'" target="_blank"><img src="'+data.roomList[i].picSrc+'"></a>'
							+'<p class="moreImg">查看更多房源图片</p>'
						+'</div>' 
						+'<a class="h_info" href="sunholiday/html/houseList/houseDetails.html?datailId='+data.roomList[i].sriId+'&datailUser='+data.roomList[i].landlordNickname+'&datailName='+datailName+'" target="_blank">'
							+'<p class="h_info_tit">'
								+'<span>'+data.roomList[i].roomTitle+'</span>'
								+'<span>¥'+data.roomList[i].price+'</span>'
							+'</p>'
							+'<p class="h_info_type">'
								+'<span>'+ leaseType +'</span>／<span>'+data.roomList[i].bedroomNumber+'室'+data.roomList[i].livingRoomNumber+'厅'+data.roomList[i].toiletNumber+'卫'+data.roomList[i].kitchenNumber+'厨'+data.roomList[i].balconyNumber+'阳</span>／<span>'+data.roomList[i].badNums +'床</span>／<span>宜住'+data.roomList[i].checkNumber +'人</span>'
							+'</p>'
							+'<p class="h_info_pos">'
								+'<span>丰台区</span>'
								+'<span>距离搜索位置980M</span>'
							+'</p>'
							+'<div class="h_info_peo">'
								+'<p>'
									+'<img src="'+data.roomList[i].portraitSrc+'">'
									+'<span>'+data.roomList[i].landlordNickname+'</span>'
								+'</p>'
								+'<nav>'
									+'<img title="山海边在线担保，无需支付押金" src="sunholiday/image/houseList/colT1.png">';
	            	if(data.roomList[i].whetherCheckTrue == 1){
	            		dataStr += '<img title="山海边摄像师上门实拍，百分百展示房源" src="sunholiday/image/houseList/colT2.png">'
	            					+'<img title="山海边实地考察，保证房源真实性" src="sunholiday/image/houseList/colT3.png">';
	            	}
	            	if(data.roomList[i].score == 5){
	            		dataStr += '<img title="入住房客全5分好评，品质好房" src="sunholiday/image/houseList/colT4.png">';
	            	}			
					dataStr += '</nav>'
							+'</div>'
						+'</a>'
					+'</li>';
	            }
	            if(dataStr){
	                $('#houseList').html(dataStr);
	                houseListMoreImg();
	            }
	            //初始化分页
	            initPageNum(bingPage,data.pags);
	            $('#pagination4').find('a').each(function () {
	                if($(this).text() == '首页' || $(this).text() == '尾页'){
	                    
	                }else if($(this).text() == '下一页'){
	                    $(this).text('下一页');
	                }else if($(this).text() == '上一页'){
	                    $(this).text('上一页');
	                }
	            });
			}else{
				//该地理位置房源开发中，换其他地方试试吧~~
				$('.fangyuanliebiao').hide();
				$('.fangyuanNotWrap').show();
				$('.fangyuanNot').empty();
				var fangyuanNot = '';
				if(data.queryTradeareaOne.length == 0){
					fangyuanNot = '<p>该地理位置房源开发中，换其他地方试试吧~~</p>'
						+'<img src="sunholiday/image/houseList/notFind1.png">';
				}else{
					if(bedroomNumber  == 0 || houseType == undefined || supString == ''){
						fangyuanNot = '<p>未找到相关内容，输入其他内容试试~~</p>'
									+'<img src="sunholiday/image/houseList/notFind2.png">';
					}
				}
				$('.fangyuanNot').append(fangyuanNot);
			}
		},
		error:function(data) {
			console.log(data);
		}
	});
}
//图片放大展示
function houseListMoreImg(){
	$('#houseList').children('li').each(function(){
		$(this).mouseover(function(){
			$(this).children('div').children('.moreImg').show();
		}).mouseout(function(){
			$(this).children('div').children('.moreImg').hide();
		});
		$(this).children('div').children('.moreImg').on('click',function(){
			var id = $(this).parents('li').attr('id');
			parent.window.layer.open({
			    type: 2,
			    title: false,
			    resize: false,
			    shade: 0.5,
			    scrollbar: false,
			    maxmin: false,
			    shadeClose: true, //点击遮罩关闭层
			    closeBtn: 0,
			    area: ['1000px', '733px'],
			    content: 'sunholiday/html/layerLevel/houseListMoreImg.html?sriRid='+id+''    
			});
		});
	});
}
//分页
function initPageNum(current,page){
    $("#pagination4").pagination({
        currentPage: current,
        totalPage: page,
        isShow: true,
        count: 4,
        homePageText: "首页",
        endPageText: "尾页",
        prevPageText: "上一页",
        nextPageText: "下一页",
        callback: function(current) {
        	houseList(current);
        }
    });
    //$('.ui-pagination-container').css({"display":"flex","flex-direction":"row","justify-content":"center","align-items":"center"})
}
//地理位置--二级--三级
function diliTwo(){
	//地理位置--二级
	$('.weizhiList').children('a').each(function(){
		$(this).mouseover(function(){
			$('.weizhiData').show();
			$('.weizhiDataTwo').hide().empty();
			var stoRid = $(this).attr('id');
			$.ajax({
				type: "GET",
				url: "/tradearea/queryTradeareaTwo",
				dataType: 'json',
				data: {
					"stoRid": stoRid
				},
				success: function(data){
					if(data.messcode == "001"){
						var data = data.tradeareaTwoList;
						$('.weizhiDataOne').empty();
						var weizhiDataOne = '';
						if(data.length != 0){
							for(var i in data){
								weizhiDataOne += '<a latitude="'+data[i].latitude+'" longitude="'+data[i].longitude+'" id="'+data[i].sttId+'" title="'+data[i].tradeareaTwo+'"><span>'+data[i].tradeareaTwo+'</span></a>';
							}
							$('.weizhiDataOne').append(weizhiDataOne);
							//地理位置--三级
							$('.weizhiDataOne').find('a').each(function(){
								$(this).children('span').on('click',function(){
									$(this).addClass('weizhiDataSel');
									$(this).parent('a').siblings().children('span').removeClass('weizhiDataSel');
									var sttRid = $(this).parent('a').attr('id');
									var weizhiDataOneTxt = $(this).text();
									latitude = $(this).parent('a').attr('latitude');
									longitude = $(this).parent('a').attr('longitude');
									$.ajax({
										type: "GET",
										url: "/tradearea/queryTradeareaThree",
										dataType: 'json',
										data: {
											"sttRid": sttRid
										},
										success: function(data){
											if(data.messcode == "001"){
												console.log(data)
												var data = data.tradeareaThreeList;
												$('.weizhiDataTwo').show().empty();
												var weizhiDataTwo = '';
												for(var i in data){
													weizhiDataTwo += '<a latitude="'+data[i].latitude+'" longitude="'+data[i].longitude+'" title="'+data[i].tradeareaThree+'"><span>'+data[i].tradeareaThree+'</span></a>';
												}
												$('.weizhiDataTwo').append(weizhiDataTwo);
												$('.weizhiDataTwo').find('a').each(function(){
													$(this).children('span').on('click',function(){
														$(this).addClass('weizhiDataSel');
														$(this).parent('a').siblings().children('span').removeClass('weizhiDataSel');
														weizhiDataOneTxt = $(this).text();
														houseName = weizhiDataOneTxt;
														$('.diliName').text(' • '+houseName);
														latitude = $(this).parent('a').attr('latitude');
														longitude = $(this).parent('a').attr('longitude');
														houseList(1);
														
													});
												});
											}else{
												houseName = weizhiDataOneTxt;
												$('.diliName').text(' • '+houseName);
												houseList(1);
											}
										}
									});
								});
							});
						}
					}else{
						layer.msg(data.message);
					}
				}
			});
		}).mouseout(function(){
			$('.weizhiData').stop().hide();
			$('.weizhiData').mouseover(function(){
				$('.weizhiData').stop().show();
			}).mouseout(function(){
				$('.weizhiData').stop().hide();
			});
		});
	});
}
//搜索
$('.submit').on('click',function(){
	if($('.geoPositionNot').css('display') == 'block'){
		return;
	}else if($('.fastSearch1').val() == ''){
		$('.cityWrap').slideDown("slow");
		return;
	}
	houseName = $('.fastSearch1').val();
	startTime = $('.fastSearch2').val().split(' 至 ')[0];
	endTime = $('.fastSearch2').val().split(' 至 ')[1];
	$('.houseTwoleName').text(' • '+houseName);
	localStorage.setItem("houseName",houseName);
	localStorage.setItem("houseDate",$('.fastSearch2').val());
	houseList(1);
});


