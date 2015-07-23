<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Submit Reservation Results</title>
<link href="styles/main.css" rel="stylesheet" type="text/css">
<%@page import="java.util.*" %>

</head>
<body>
<h1>Red Town Resort</h1>
<br>
<h2>Booking Results</h2>
<p>
<%
	String firstnameResults=(String)request.getAttribute("firstnameview");
	String lastnameResults=(String)request.getAttribute("lastnameview"); 
	String phonenumberResults=(String)request.getAttribute("phoneview");
	String roomTypeResults=(String)request.getAttribute("roomtypeview");
	String checkInDateResults=(String)request.getAttribute("checkindateview");
	String checkOutDateResults=(String)request.getAttribute("checkoutdateview");
	String emailResults=(String)request.getAttribute("emailview");
	String commentResults=(String)request.getAttribute("commentview");
	
	out.println("<br> "+"<h2>Firstname: "+firstnameResults +"</h2>");
	out.println("<h2>Lastname: " +lastnameResults +"</h2>");
	out.println("<h2>Phone Number: " +phonenumberResults +"</h2>");
	out.println("<h2>Room Type: " +roomTypeResults +"</h2>");
	out.println("<h2>Check-In-Date: " +checkInDateResults +"</h2>");
	out.println("<h2>Check-Out-Date: " +checkOutDateResults +"</h2>");
	out.println("<h2>Email: " +emailResults.toLowerCase() +"</h2>");
	System.out.println(emailResults.toLowerCase());
	out.println("<h2>Comments: " +commentResults +"</h2>");
%>
</p>
<form method=POST action="confirmpage">
<button type="submit" name="action" onclick="location.href='reservations.html'">Edit Results</button>

<button type="submit" name="action" value="ConfirmPageServlet" onclick="form.action="ConfirmPageServlet";>Submit</button>
</form>

	
</body>
</html>