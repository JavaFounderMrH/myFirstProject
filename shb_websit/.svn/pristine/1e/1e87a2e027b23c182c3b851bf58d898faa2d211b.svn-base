$(function(){
	var nums;
	nums = location.href.split('?lineId=')[1];
	xianlu(nums);
});
function xianlu(nums){
	if(nums != null){
		$.ajax({
			type : 'GET',
			url : "/touristRouteApi/querytouristRouteInfoByLineId",
			dataType:'json',
			data:{
				"lineId": nums
			},
			success : function(data) {
				if(data.messcode == '001'){
					$('.luxian_l').empty();
					$('.tuijian').empty();
					var luxian = '';
					luxian = '<img id="'+data.tourismLine.lineId+'" src="'+data.tourismLine.lineDetailsSrc+'">';
					$('.luxian_l').append(luxian);
					var list = data.selectTourismLineList;
					var tuijian = '';
					for(var i in list){
						tuijian += '<li><a id="'+list[i].lineId+'"><img src="'+list[i].lineListSrc+'"><span>'+list[i].lineTitle+'</span></a></li>';
					}
					$('.tuijian').append(tuijian);
					$('.tuijian li').each(function () {
					    $(this).children('a').on('click',function(){
					        nums = $(this).attr('id');
					        xianlu(nums);
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
}

