<%@ page language="java" contentType="text/html" pageEncoding="gb2312"%>
<html>
  <head>
    <title>显示request中传送的参数</title>
  </head>
  <body>
    <%request.setCharacterEncoding("gb2312");%>
    得到一下传送参数：<p>
    <font color=red>
      姓名：<%=request.getParameter("name").toString()%><p>
      性别：<%=request.getParameter("sex").toString()%><p>
      年龄：<%=request.getParameter("age").toString()%><p>
    </font>
    获取按钮标记名：
    <font color=blue>
      <%=request.getParameter("submit").toString()%>
    </font>
  </body>
</html>
