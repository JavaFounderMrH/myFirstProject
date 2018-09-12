$(document).ready(function(){
	//新闻中心
    setNews(1);
});
/*新闻中心分页*/
function setNews(page){
    $.ajax({
        url:'sunholiday/js/news.json?page='+page,
        type:'GET',
        dataType:'json',
        success:function(resData){
            if(page > resData.pageNum) return;
            var data = resData.items.slice((page-1)*5,page*5);
            var dataStr = '';
            var length = data.length;
            for(var i = 0; i < length; i++){
                dataStr += '<a href='+data[i].link+' target="_blank" class="newslist-sub rowCenter"> <img alt="" title="" src="'+data[i].img+'"> <dl> <dt>'+data[i].title+'</dt> <dd>'+data[i].desc+'</dd><span>查看详情</span></dl> </a>';
            }
            if(dataStr){
                $('.newslist').html(dataStr);
            }else{
                $('.newslist').html('<p style="width:100%;height:100px;line-height:100px;text-align:center">当前暂无新闻发布</p>');
            }
            //初始化分页
            initPageNum(page,resData.pageNum);
            $('#pagination3').find('a').each(function () {
                if($(this).text() == '首页' || $(this).text() == '尾页'){
                    $(this).css({
                       'background':'#37dddf',
                       'color':'#fff',
                        'padding':'12px 26px',
                        'border-radius':'40px'
                    });
                }else if($(this).text() == '下一页'){
                    $(this).text('下一页');
                }else if($(this).text() == '上一页'){
                    $(this).text('上一页');
                }
            });
        },
        error:function(error){
            console.log(error)
        }
    })
}
function initPageNum(current,page){
    $("#pagination3").pagination({
        currentPage: current,
        totalPage: page,
        isShow: true,
        count: 7,
        homePageText: "首页",
        endPageText: "尾页",
        prevPageText: "上一页",
        nextPageText: "下一页",
        callback: function(current) {
            setNews(current);
        }
    });
    //$('.ui-pagination-container').css({"display":"flex","flex-direction":"row","justify-content":"center","align-items":"center"})
}
