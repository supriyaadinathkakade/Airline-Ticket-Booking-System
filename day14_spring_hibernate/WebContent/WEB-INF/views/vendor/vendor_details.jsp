<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h4>${sessionScope.message}</h4>
<h5>Vendor Details : ${sessionScope.user_details} </h5>
<%--invalidate  session --%>
${pageContext.session.invalidate()}
</body>
</html>