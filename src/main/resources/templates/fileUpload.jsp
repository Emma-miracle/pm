
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传</title>
</head>
<body>
    <form action="file/upload" method="post" enctype="multipart/form-data">
        文件1：<input type="file" name="files"><br>
        <%--文件2：<input type="file" name="files"><br>--%>
        <input type="submit" value="上传"><br>
    </form>


<div>

    <a href="file/download?fileName=0012.png">下载图片</a>
</div>

</body>
</html>
