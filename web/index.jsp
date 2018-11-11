<%--
  Created by IntelliJ IDEA.
  User: zl
  Date: 2018/10/31
  Time: 22:41
  @description  script的四种引入方式
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>

    <%--外联式--%>
    <%--<script src = a.js>--%>
    <%--</script>--%>
    <style type="text/css">
      #div1{
        width: 200px;
        height: 200px;
        border: 1px solid red;
      }
    </style>
  </head>
  <body>

  <%--在html的标签中事件属性引入--%>
  <%--<div id="div1" onclick="alert('在html的标签属性事件属性引入')">--%>
  <%--</div>--%>


  <%--在a标签的href属性值中引入--%>
  <%--javascript必须小写--%>
  <a id="div1" href="javascript:alert('a标签的href属性值中引入')">点击弹出对话框</a>

  </body>
</html>
