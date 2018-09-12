angular.module("myview",['ui.router'])
	.run(['$location','$rootScope',function($location, $rootScope){  
	    $rootScope.$on('$stateChangeSuccess', function (event, toState, toParams, fromState, fromParams) {  
	      $rootScope.title = toState.title  
	    });  
	  }])
    .config(['$urlRouterProvider', '$stateProvider', function ($urlRouterProvider, $stateProvider) {
        $urlRouterProvider.otherwise("/home");
        $stateProvider
            .state('home', {
            	title: '山海边---游遍山与海，唯有山海边',
                url: '/home',
                templateUrl: 'sunholiday/html/home.html',
                controller: 'HomeController'
            })
            .state('product', {
                title: '产品介绍',
                url: '/product',
                templateUrl: 'sunholiday/html/product.html?v=1'
            })
            .state('ziying', {
                title: '自营品牌',
                url: '/ziying',
                templateUrl: 'sunholiday/html/ziying.html?v=1'
            })
            .state('gongsi', {
                title: '公司介绍',
                url: '/gongsi',
                templateUrl: 'sunholiday/html/gongsi.html?v=1'
            })
            .state('news', {
                title: '新闻中心',
                url: '/news',
                templateUrl: 'sunholiday/html/news.html?v=1'
            })
            .state('lianxiWomen', {
                title: '联系我们',
                url: '/lianxiWomen',
                templateUrl: 'sunholiday/html/lianxiWomen.html?v=1'
            })
            .state('luxian', {
			    title: '旅游产品',
			    url: '/productList',
			    templateUrl: 'sunholiday/html/productList.html?v=1'
			})
			.state('houseList', {
			    title: '房源列表',
			    url: '/houseList',
			    templateUrl: 'sunholiday/html/houseList/houseList.html',
			    controller: 'houseListController'
			})
			.state('houseDetails', {
			    title: '房源详情',
			    url: '/houseDetails',
			    templateUrl: 'sunholiday/html/houseDetails.html',
			    controller: 'houseDetailsController'
			})
    }])
	.controller('HomeController',function($state){
		//搜索
		$('.submit').on('click',function(){
			if($('.geoPositionNot').css('display') != 'block'){
				var city = $('.fastSearch1').val();
				var date = $('.fastSearch2').val();
				if(city == ''){
					$('.cityWrap').slideDown("slow");
					query = '';
					cityList();
				}else{
					$state.go('houseList');
					localStorage.setItem("city",city);
			    	localStorage.setItem("date",date);
					localStorage.setItem("houseName",city);
			    	localStorage.setItem("houseDate",date);
				}
			}
		});
		//城市探索更多
		$('.hotMore').on('click',function(){
			$state.go('houseList');
			localStorage.setItem("houseName",'北京');
		});
	})
	.controller('houseListController',function($scope){
		//详情页信息
        /*var houseTwoleName;
	 	$('#houseList').children('a').each(function(){
	 		$(this).find('.h_img').children('img').on('click',function(){
				houseTwoleName = $('.houseTwoleName').text();
				localStorage.setItem("datailId",$(this).parents('a').attr('id'));
				localStorage.setItem("datailUser",$(this).parents('a').attr('class'));
				localStorage.setItem("datailName",houseTwoleName);
				$state.go('houseDetails');
			});
	 		$(this).find('.h_info').on('click',function(){
				houseTwoleName = $('.houseTwoleName').text();
				localStorage.setItem("datailId",$(this).parents('a').attr('id'));
				localStorage.setItem("datailUser",$(this).parents('a').attr('class'));
				localStorage.setItem("datailName",houseTwoleName);
				$state.go('houseDetails');
			});
	 	});*/
    })
	.controller('houseDetailsController',function($stateParams, $scope,$state){
		$('.datailName').on('click',function(){
			console.log('aa')
			//$state.go('houseList');
		});
    })