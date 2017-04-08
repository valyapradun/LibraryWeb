<%@ page language="java" contentType="text/html; charset=utf8"
    pageEncoding="utf8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf8">
<title>User page</title>
<link rel="stylesheet" type="text/css" href="css.css">
</head>
<body>
<div id="container">
<header>Welcome to the page of best-sellers!</header>

<table>
<c:forEach items="${books}" var="i">
	<tr>
	<td><img src= <c:out value="${i.getSrc()}" />></td>
	<td>
		<h3><c:out value="${i.getTitle()}" /></h3>
		<div><c:out value="${i.getAuthor()}" /></div>
		<div class="price"><c:out value="${i.getPrice()}" /> BYN</div>
	</td>

	</tr>
	</c:forEach>
	</table>
	<div id="clear"></div>
</div>
		<footer>&copy; 2017</footer>
</body>
</html>