<%@ page import="static java.lang.System.out" %>
<%@ page import="org.omg.CORBA.Request" %>
<%--
  Created by IntelliJ IDEA.
  User: zl
  Date: 2018/11/6
  Time: 21:53
  Description jsp life cycle 生命周期
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%!
    private int initVar = 0;
    private int serviceVar = 0;
    private int destroyVar = 0;
%>

<%!
    public void jspInit() {
        initVar++;
        out.println("jspInit(): JSP被初始化了" + initVar + "次");
    }
    public void jspDestroy() {
        destroyVar++;
        out.println("jspDestroy(): JSP被销毁了" + destroyVar + "次");

    }
%>
<%!
    public void IpAddress(){
        out.println("你的 IP 地址 " + re.getRemoteAddr());
}
%>

<%
    serviceVar++;
    System.out.println("_jspService(): JSP共响应了" + serviceVar + "次请求");
    String content1 = "初始化次数 : " + initVar;
    String content2 = "响应客户请求次数 : " + serviceVar;
    String content3 = "销毁次数 : " + destroyVar;
%>






%>
<h1>菜鸟教程 JSP 测试实例</h1>
<p><%=content1 %>
</p>
<p><%=content2 %>
</p>
<p><%=content3 %>
</p>

</body>
</html>
