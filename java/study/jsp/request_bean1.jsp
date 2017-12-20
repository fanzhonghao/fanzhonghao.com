<%@ page  contentType="text/html" pageEncoding="gb2312"%>
<html>
  <head>
    <title>Bean的条件化创建</title>
  </head>
  <body>
    <jsp:useBean id="hello" class="com.ncst.HelloBean" scope="request" />
    <%
      hello.setMessage("Hello JavaBean!");
    %>
    <jsp:include page="request_bean2.jsp" />
  </body>
</html>
