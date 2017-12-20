<%@ page language = "java" pageEncoding="gb2312"%>
	<%@ page import = "java.util.* "%>
		<html>
			<head>
				<title>session demo</title>
			</head>
			<body>
				<%
					String sessionID = session.getId();
				%>
				<h3>
					Sessionid: <%=sessionID%>
				</h3>
				<br>
				Created time
				<%=new Date(session.getCreationTime())%><br>
				<h3>
				OldMaxInactiveInterval=<%=session.getMaxInactiveInterval()%>
				</h3>
				<br>
				LastAccessedtime=<%=new Date(session.getLastAccessedTime())%>
				<br>
				Session new ? <%=session.isNew()%>
				<br>
				content = "session example"
				<%session.setAttribute("content","session example");%>
				<br>
				content = <%=session.getAttribute("content") %>
				<br>
				New MaxInactiveInterval=10
				<%session.setMaxInactiveInterval(10);%>
			</body>
			</html>
