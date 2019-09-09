$(function () {
    back_off();
});

function count() {
    //百度统计可去掉
    var _hmt = _hmt || [];
    (function() {
        var hm = document.createElement("script");
        hm.src = "https://hm.baidu.com/hm.js?b393d153aeb26b46e9431fabaf0f6190";
        var s = document.getElementsByTagName("script")[0];
        s.parentNode.insertBefore(hm, s);
    })();
}

function form_off() {
    var issubmit=false;
    function dosubmit(){
        if(issubmit==false){
            issubmit=true;
            return true;
        }else{
            return false;
        }

    }
}



 function back_off() {
     //防止页面后退
     history.pushState(null, null, document.URL);
     window.addEventListener('popstate', function () {
         history.pushState(null, null, document.URL);
     });
 }
