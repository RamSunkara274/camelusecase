package com.camelpractice.dto;

public class BookingHistory {

	private Long id;
	private Long userId;
	private String source;
	private String destination;
	private String timeStamp;
	private int numberOfTicketsBoooked;
	private int ticketCost;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	public int getNumberOfTicketsBoooked() {
		return numberOfTicketsBoooked;
	}

	public void setNumberOfTicketsBoooked(int numberOfTicketsBoooked) {
		this.numberOfTicketsBoooked = numberOfTicketsBoooked;
	}

	public int getTicketCost() {
		return ticketCost;
	}

	public void setTicketCost(int ticketCost) {
		this.ticketCost = ticketCost;
	}

	@Override
	public String toString() {
		return "BookingHistory [id=" + id + ", userId=" + userId + ", source=" + source + ", destination=" + destination
				+ ", timeStamp=" + timeStamp + ", numberOfTicketsBoooked=" + numberOfTicketsBoooked + ", ticketCost="
				+ ticketCost + "]";
	}

}
