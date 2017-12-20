<%@ page  contentType="text/html" pageEncoding="gb2312" isErrorPage="true"%>
<%@page import="java.io.*"%>
<html>
  <body>
    Error Page.<br>
    <%exception.printStackTrace(new PrintWriter(out));
    %>
  </body>
</html>
