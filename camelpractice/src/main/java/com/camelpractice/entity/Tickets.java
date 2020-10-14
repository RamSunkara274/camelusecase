package com.camelpractice.entity;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tickets")
public class Tickets {

	@Id
	@Column(name = "ticket_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long ticketId;
	private String source;
	private String destination;
	private int ticketPrice;
	private Date date;
	private Timestamp BeginFromPlatform;
	private int availableTickets;

	public Long getTicketId() {
		return ticketId;
	}

	public void setTicketId(Long ticketId) {
		this.ticketId = ticketId;
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Timestamp getBeginFromPlatform() {
		return BeginFromPlatform;
	}

	public void setBeginFromPlatform(Timestamp beginFromPlatform) {
		BeginFromPlatform = beginFromPlatform;
	}

	public int getAvailableTickets() {
		return availableTickets;
	}

	public void setAvailableTickets(int availableTickets) {
		this.availableTickets = availableTickets;
	}

	public int getTicketPrice() {
		return ticketPrice;
	}

	public void setTicketPrice(int ticketPrice) {
		this.ticketPrice = ticketPrice;
	}

	@Override
	public String toString() {
		return "Tickets [ticketId=" + ticketId + ", source=" + source + ", destination=" + destination
				+ ", ticketPrice=" + ticketPrice + ", date=" + date + ", BeginFromPlatform=" + BeginFromPlatform
				+ ", availableTickets=" + availableTickets + "]";
	}

}
