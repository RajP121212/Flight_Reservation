<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Flights</title>
</head>
<body>
<h2>Flights:</h2>
	<table>
		<tr>
			<th>Operating Airlines:</th>
			<th>Departure City:</th>
			<th>Arrival City:</th>
			<th>Estimated Departure Time:</th>
		</tr>
		<c:forEach items="${flights}" var="flight">
			<tr>
				<td>${flight.operatingAirlines}</td>
				<td>${flight.departureCity}</td>
				<td>${flight.arrivalCity}</td>
				<td>${flight.estimatedDepartureTime}</td>
				
				<!-- showCompleteReservation is the JSP page, and on that page we will need to pass the 
				flightId in order to get the complete reservation details of that flight.
				So here we used the expression language to pass that flightId to the Next Page -->
				
				<td><a href="showCompleteReservation?flightId=${flight.id}">Select</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>