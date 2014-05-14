<%@ page import="StockServer.*"%>
<%@ page language="java" import="java.util.*"%>

<html>
<head>
<title>Find a Quote</title>
</head>

<body>

	${header.host} Speaking ...
	<br> Enter quote name in the following form:

	<br> ( For example, "EPAM", "LXFT", "AAPL" or "IBM" )
	<form action=http://localhost:8080/unit15_anfisa1/StockQuote.jsp
		method=Post>
		<input type=Text name=symbol> <input type=Submit
			value="Search for quote">
	</form>

	<%@ page errorPage="StockServerError.jsp"%>
	
	<%@ taglib prefix="tagtest" tagdir="/WEB-INF/tags/" %>
	<tagtest:QuoteTag/>

</body>
</html>