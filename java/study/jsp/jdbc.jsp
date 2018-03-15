<%@ page contentType="text/html;charset=GBK"%>
<%@page import="java.sql.* "%>
<html>
  <body>
    <%
    Connection con;
    try {
      con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","******");
      if (con != null) out.println("Connected");
    }catch (Exception e) {
      e.printStackTrace();
      out.println("Failed");
    }
    %>
  </body>
</html>
