<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Complete Reservation Details</title>
</head>
<body>
	<h2>Complete Reservation</h2>
	<!-- In the ReservationController we have set "flight" as the attribute -->
	Airline: ${flight.operatingAirlines}<br>
	Departure City: ${flight.departureCity}<br>
	Arrival City: ${flight.arrivalCity}<br>
	
	<form action="completeReservation" method="post">
		<pre>
			<h2>Passenger Details:</h2>
			First Name: <input type="text" name="passengerFirstName">
			Last Name: <input type="text" name="passengerLastName">
			Middle Name: <input type="text" name="passengerMiddleName">
			Email: <input type="text" name="passengerEmail">
			Phone: <input type="text" name="passengerPhone">
			
			<h2>Credit Card Details:</h2>
			Name on Card: <input type="text" name="nameOnCard">
			Card Number: <input type="text" name="cardNumber">
			Expiration Date: <input type="text" name="expirationDate">
			Security Code: <input type="text" name="securityCode">
			
			<br>
			<input type="hidden" name="flightId" value="${flight.id}">
			
			<br>
			<input type="submit" value="Confirm">
		</pre>
	</form>
</body>
</html>