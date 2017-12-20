<%@ page  contentType="text/html" pageEncoding="gb2312"%>
<html>
  <head>
    <title>Bean的条件化创建</title>
  </head>
  <body>
    <jsp:useBean id="hello" class="com.ncst.HelloBean" scope="request" />
    <%
      String message = hello.getMessage();
    %>
    <p><%=message%></p>
  </body>
</html>
