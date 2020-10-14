package com.camelpractice.camelrouter;

import org.apache.camel.BeanInject;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.apache.camel.model.rest.RestParamType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import com.camelpractice.camelprocessor.ProductProcessor;
import com.camelpractice.camelprocessor.TicketBookingProcessor;
import com.camelpractice.dto.BookingDto;
import com.camelpractice.dto.BookingHistory;
import com.camelpractice.entity.TicketsHistory;
import com.camelpractice.service.ProductService;

import io.swagger.models.Response;

@Component
public class ApplicationResource extends RouteBuilder {

	/*
	 * @Autowired ProductServiceImpl productServiceImpl;
	 */

	@Autowired
	ProductService productService;

	@BeanInject
	ProductProcessor productProcessor;

	@BeanInject
	TicketBookingProcessor ticketBookingProcessor;

	@Override
	public void configure() throws Exception {

		restConfiguration().component("servlet").port(9090).host("localhost").bindingMode(RestBindingMode.json);

		rest().get("/products").produces(MediaType.APPLICATION_JSON_VALUE).route()
				.setBody(() -> productService.getAllProducts()).endRest();

		/*
		 * rest().get("/users/{userId}").
		 * description("getting user booking tickets history based on userId").
		 * param()
		 * .name("userId").description("userId").type(RestParamType.path).
		 * dataType("Long").endParam()
		 * .produces(MediaType.APPLICATION_JSON_VALUE).route().bean(
		 * ProductService.class, "getBookingHistory") .endRest();
		 */

		rest().get("/{id}").description("getting user booking tickets history based on userId")
				.outType(TicketsHistory.class).param().name("id").type(RestParamType.header)
				.description("The id of the user").dataType("Long").endParam().responseMessage().code(200)
				.message("The requested user history").endResponseMessage().responseMessage().code(404)
				.message("user not found").endResponseMessage()
				.to("bean:productServiceImpl?method=getBookingHistory(${header.id})");

		rest().get("/{source}/{destination}/{timeStamp}").description("getting user search details")
				.outType(TicketsHistory.class).param().name("source").name("destination").name("timeStamp")
				.type(RestParamType.header).description("user search details").dataType("String").dataType("String")
				.dataType("Timestamp").endParam().responseMessage().code(200).message("The requested user history")
				.endResponseMessage().responseMessage().code(404).message("user not found").endResponseMessage()
				.to("bean:productServiceImpl?method=getTicketsBySearch(${header.source},${header.destination},${header.timeStamp})");

		/*
		 * rest().get("/{id}").
		 * description("getting user booking tickets history based on userId")
		 * .outType(TicketsHistory.class).param().name("id").type(RestParamType.
		 * path) .description("The id of the user").dataType("Long").endParam().
		 * responseMessage().code(200)
		 * .message("The requested user history").endResponseMessage().
		 * responseMessage().code(404)
		 * .message("user not found").endResponseMessage()
		 * .to("bean:ProductServiceImpl?method=getBookingHistory(${header.id})")
		 * ;
		 */

		rest().post("/tickets").consumes(MediaType.APPLICATION_CBOR_VALUE).type(BookingDto.class)
				.produces(MediaType.APPLICATION_JSON_VALUE).outType(Response.class).route()
				.process(ticketBookingProcessor).endRest();

		// rest().get("/tickets/{source}/{destination}/{timestamp}").consumes(MediaType.APPLICATION_JSON_VALUE).pro

	}

}
