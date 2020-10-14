package com.camelpractice.camelprocessor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.camelpractice.dto.BookingDto;
import com.camelpractice.serviceimpl.ProductServiceImpl;

@Component
public class TicketBookingProcessor implements Processor {

	@Autowired
	private ProductServiceImpl productServiceImpl;

	@Override
	public void process(Exchange exchange) throws Exception {

		productServiceImpl.mappingTicketDetailsToDB(exchange.getIn().getBody(BookingDto.class));

	}

}
