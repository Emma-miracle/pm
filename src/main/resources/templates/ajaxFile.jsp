<%--
  Created by IntelliJ IDEA.
  User: luori
  Date: 2018/12/17
  Time: 16:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path=request.getContextPath();
%>
<html>
<head>
    <title>$Title$</title>
    <script src="static/js/jquery-3.3.1.js"></script>
    <script type="text/javascript">
        function doUpload() {
            var formData = new FormData($( "#uploadForm" )[0]);
            $.ajax({
                url: "<%=path%>/test" ,
                type: 'POST',
                data: formData,
                async: false,
                cache: false,
                contentType: false,
                processData: false,
                success: function (returndata) {
                    alert(returndata);
                },
                error: function (returndata) {
                    alert(returndata);
                }
            });
        }
    </script>
</head>
<body>
<form id= "uploadForm" enctype="multipart/form-data" method="post">
    <p >指定文件名： <input type="text" name="filename" value= ""/></p>
    <p >上传文件： <input type="file" name="file"/></p>
    <input type="button" value="上传" onclick="doUpload()" />
</form>
<hr>

<img src='<%=path+"/imgs/"+request.getSession().getAttribute("filename")%>'/>



</body>
</html>
