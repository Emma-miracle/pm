layui.define(['jquery'], function(exports){
    var $ = layui.jquery;
    var obj = {
        ajax: function (url, type, dataType, data, callback) {
            $.ajax({
                url: url,
                type: type,
                dataType: dataType,
                data: data,
                success: callback
            });
        }
    };
    //输出接口
    exports('common', obj);
});


$(function  () {
    /*
    layui.use('form', function(){
      var form = layui.form();
      //监听提交
      form.on('submit(login)', function(data){
        layer.msg(JSON.stringify(data.field),function(){
            location.href='home.jsp'
        });
        return false;
      });
    });
    */

    layui.use(['form'],
        function() {
            //$ = layui.jquery;//此$符号会影响ajax的$符号
            var form = layui.form(),
                layer = layui.layer;
            $('button').click(function(event) {
                //操作
                event.preventDefault();//阻止其默认行为
            });

            //监听提交
            form.on('submit(login)',
                function(data) {
                    console.log(data);
                    /*layer.alert(JSON.stringify(data.field), {
                        title: '管理员登录!'
                    },function() {*/
                    var param=$("form").serialize();
                    $.ajax({
                        url:path+"/admin/adminLogin",
                        data:param,
                        type:"POST",
                        dataType:"json",
                        success: function(data){
                            if(data.res=="success"){
                                location.href=path+"/admins/home.jsp";
                            }else {
                                layer.msg("用户名或密码不正确!");
                                //layer.alert("用户名或密码不正确!");
                            }
                        }
                    });
                    /*});*/
                    return false;//这个地方一定要变为false，否则没有用的
                });
        });

});