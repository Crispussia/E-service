<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% String page_title=(String)request.getAttribute("titre");
request.setAttribute("titre", page_title);

%>
<jsp:include page="Template.jsp" />

</body>
</html>