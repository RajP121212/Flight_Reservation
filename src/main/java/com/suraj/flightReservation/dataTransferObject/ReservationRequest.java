package com.suraj.flightReservation.dataTransferObject;

//We will pass this onto the service layer
//That is why it is called Reservation Request

public class ReservationRequest {

	// Id is the hidden field on the showCompleteReservation.jsp
	private Long flightId;

	// Passenger detail values from showCompleteReservation.jsp
	// Variable names should be exactly the same as the "name" attribute within tags
	// in .jsp page
	private String passengerFirstName;
	private String passengerLastName;
	private String passengerMiddleName;
	private String passengerEmail;
	private String passengerPhone;

	// Card detail values from showCompleteReservation.jsp
	private String nameOnCard;
	private String cardNumber;
	private String expirationDate;
	private String securityCode;

	public Long getFlightId() {
		return flightId;
	}

	public void setFlightId(Long flightId) {
		this.flightId = flightId;
	}

	public String getPassengerFirstName() {
		return passengerFirstName;
	}

	public void setPassengerFirstName(String passengerFirstName) {
		this.passengerFirstName = passengerFirstName;
	}

	public String getPassengerLastName() {
		return passengerLastName;
	}

	public void setPassengerLastName(String passengerLastName) {
		this.passengerLastName = passengerLastName;
	}

	public String getPassengerMiddleName() {
		return passengerMiddleName;
	}

	public void setPassengerMiddleName(String passengerMiddleName) {
		this.passengerMiddleName = passengerMiddleName;
	}

	public String getPassengerEmail() {
		return passengerEmail;
	}

	public void setPassengerEmail(String passengerEmail) {
		this.passengerEmail = passengerEmail;
	}

	public String getPassengerPhone() {
		return passengerPhone;
	}

	public void setPassengerPhone(String passengerPhone) {
		this.passengerPhone = passengerPhone;
	}

	public String getNameOnCard() {
		return nameOnCard;
	}

	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}

	public String getSecurityCode() {
		return securityCode;
	}

	public void setSecurityCode(String securityCode) {
		this.securityCode = securityCode;
	}

	@Override
	public String toString() {
		return "ReservationRequest [flightId=" + flightId + ", passengerFirstName=" + passengerFirstName
				+ ", passengerLastName=" + passengerLastName + ", passengerEmail=" + passengerEmail
				+ ", passengerPhone=" + passengerPhone + ", nameOnCard=" + nameOnCard + ", cardNumber=" + cardNumber
				+ ", expirationDate=" + expirationDate + ", securityCode=" + securityCode + "]";
	}

}
