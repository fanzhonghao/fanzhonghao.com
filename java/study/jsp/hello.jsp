<%@ page contentType="text/html;charset=GBK"%>
<html>
  <head>
    <title>Hello,World</title>
  </head>
  <body>
    <%response.setHeader("Refresh","5");%>

    <center><h2>
      Hello,everyone!<br>
      现在时间是:<%=new java.util.Date()%></h2>
    </center>
  </body>
</html>
