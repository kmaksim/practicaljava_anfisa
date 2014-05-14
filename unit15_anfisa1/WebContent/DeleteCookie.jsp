<%@ page import="StockServer.*"%>
<%@ page language="java" import="java.util.*"%>

<html>
<head>
<title>Delete cookie</title>
</head>

<body>

	<%--
	  out.println(StockServer.getYahooQuote("AAPL"));
	--%>

	It's a supplimentary jsp for StockQuote.jsp to delete cookie

	
	<%@ page errorPage="StockServerError.jsp"%>

	<%
	  String cookieName = "haveJustVisited";
	  Cookie cookies[] = request.getCookies();
	  Cookie myCookie = null;
	  if (cookies != null) {
	    for (int i = 0; i < cookies.length; i++) {
	      if (cookies[i].getName().equals(cookieName)) {
	        myCookie = cookies[i];
	        break;
	      }
	    }
	  }
	%>


	<%
	  if (myCookie == null) {

	    String haveJustVisited = "yes";
	    Cookie cookie = new Cookie("haveJustVisited", haveJustVisited);
	    cookie.setMaxAge(1);
	    response.addCookie(cookie);

	  } else {
	    Cookie cookie = new Cookie("haveJustVisited", "");
	    cookie.setMaxAge(0);
	    response.addCookie(cookie);
	    out.println("<p>You've been here!!!:");

	  }
	%>



</body>
</html>