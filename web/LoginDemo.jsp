<%--
  Created by IntelliJ IDEA.
  User: zl
  Date: 2018/11/5
  Time: 21:22
  DescripTtion:JavaScript的用法
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style type="text/css">
        #div1 {
            width: 200px;
            height: 200px;
            border: 1px solid red;
        }
    </style>
</head>
<body>

<form action="LoginServlet" method="get">
    用户名：<input type="text" name="username" value=""> <br/>
    密码：<input type="text" name="password" value=""> <br/>
    爱好:<br/>
    <input type="checkbox" name="fav" value="1"/>唱歌<br/>
    <input type="checkbox" name="fav" value="2"/>跳舞<br/>
    <input type="checkbox" name="fav" value="3"/>游泳<br/>
    <input type="submit" value="登陆"/><br/>
</form>

<%
    //servlet传递到另一个servlet
    Object msg = "";
    msg = request.getAttribute("error");

    if (msg != null) {
        //请求转发
        System.out.println(msg);
    }else {

    }
%>

</body>
</html>
