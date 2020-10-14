package com.camelpractice.serviceimpl;

import static org.mockito.Mockito.mockitoSession;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.camelpractice.dto.BookingDto;
import com.camelpractice.dto.BookingHistory;
import com.camelpractice.dto.ResponseDto;
import com.camelpractice.entity.Tickets;
import com.camelpractice.entity.TicketsHistory;
import com.camelpractice.repository.TicketHistoryRepository;
import com.camelpractice.repository.TicketRepository;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceImplTest {

	@Mock
	TicketHistoryRepository ticketHistoryRepo;

	@InjectMocks
	ProductServiceImpl productServiceImpl;

	@Mock
	TicketRepository ticketRepo;

	ModelMapper modelMapper = new ModelMapper();

	@Test
	public void getTicketsBySearchTest() throws ParseException {
		String source = "HYD";
		String destination = "BGLR";
		Date dNow = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("yyyy-mm-dd");
		String currentDate = ft.format(dNow);

		SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-mm-dd");
		Date date = formatter1.parse(currentDate);

		List<Tickets> listOfTickets = new ArrayList<Tickets>();

		Tickets ticket = new Tickets();
		ticket.setTicketId(1l);
		ticket.setSource("HYD");
		ticket.setDestination("BGLR");

		listOfTickets.add(ticket);

		Mockito.when(ticketRepo.findBySourceAndDestinationAndDate(source, destination, date)).thenReturn(listOfTickets);

		Assert.assertEquals("HYD", listOfTickets.get(0));

		// List<Tickets> listOfDate =
		// productServiceImpl.getTicketsBySearch("HYD", "BGLR", date);

	}

	@Test
	public void getBookingHistoryTest() {

		List<TicketsHistory> list = new ArrayList<TicketsHistory>();
		TicketsHistory historyEntity = new TicketsHistory();
		historyEntity.setSource("HYD");
		historyEntity.setDestination("BGLR");
		historyEntity.setTicketCost(400);
		list.add(historyEntity);

		List<BookingHistory> listOfDtoBooking = new ArrayList<BookingHistory>();

		Mockito.when(ticketHistoryRepo.findByUserId(1l)).thenReturn(list);

		for (TicketsHistory ticketHistory : list) {
			BookingHistory history = modelMapper.map(ticketHistory, BookingHistory.class);
			listOfDtoBooking.add(history);

		}

		List<BookingHistory> listOfHistory = productServiceImpl.getBookingHistory(1l);

		Assert.assertEquals(listOfHistory.size(), list.size());

	}

	@Test
	public void mappingTicketDetailsToDBTest() {
		BookingDto bookingdto = new BookingDto();

		bookingdto.setSource("HYD");
		bookingdto.setDestination("BGLR");
		TicketsHistory history = new TicketsHistory();
		BeanUtils.copyProperties(bookingdto, history);

		ResponseDto response = new ResponseDto();

		// Mockito.when(ticketHistoryRepo.save(history)).thenRetur

	}

}
