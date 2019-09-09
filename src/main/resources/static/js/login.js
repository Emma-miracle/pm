$(function () {
	//初如化背景
	function bgint () {
    	if(localStorage.bglist){
            var arr = JSON.parse(localStorage.bglist);// 
            // console.log(arr);
            //全局背景统一
            if(arr['bgSrc']){
                $('body').css('background-image', 'url('+arr['bgSrc']+')');

                //初始化弹出层背景
            }
            //单个背景逻辑
            // if(arr[location.href]){
            //     $('body').css('background-image', 'url('+arr[location.href]+')');
            // }
    	}
    }

    bgint();

	//背景主题功能
	var changerlist = new Swiper('.changer-list', {
		initialSlide :5,
        effect: 'coverflow',
        grabCursor: true,
        centeredSlides: true,
        slidesPerView: 'auto',
        coverflow: {
            rotate: 50,
            stretch: -10,
            depth: 100,
            modifier: 1,
            slideShadows : false
        }
    });

	//背景主题设置展示
    is_show_change=true;
    $('#changer-set').click(function(event) {
    	if(is_show_change){
            $('.bg-out').show();
    		$('.bg-changer').animate({top: '0px'}, 500);
    		is_show_change=false;
    	}else{
    		$('.bg-changer').animate({top: '-110px'}, 500);
    		is_show_change=true;
    	}
    	
    });

    //背景主题切换
    $('.bg-changer img.item').click(function(event) {
    	if(!localStorage.bglist){
    		arr = {};
    	}else{
    		arr = JSON.parse(localStorage.bglist);
    	}
    	var src = $(this).attr('src');
    	$('body').css('background-image', 'url('+src+')');

    	url = location.href;

        // 单个背景逻辑
    	// arr[url]=src;
        
        // 全局背景统一
        arr['bgSrc'] = src;
        // console.log(arr);

    	localStorage.bglist = JSON.stringify(arr);

    });

    //背景初始化
    $('.reset').click(function  () {
        localStorage.clear();
        layer.msg('初如化成功',function(){});
    });


    //背景切换点击空白区域隐藏
    $('.bg-out').click(function  () {
        $('.bg-changer').animate({top: '-110px'}, 500);
            is_show_change=true;
        $(this).hide();
    });

    
});
