<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Error page</title>
<link rel="stylesheet" type="text/css" href="css.css">
</head>
<body>
<div id="container">
<header>ERROR page</header>


<h1>ERROR: <c:out value="${ERROR}" /></h1>
	<div id="clear"></div>
	
</div>
	<footer>&copy; 2017</footer>
</body>
</body>
</html>