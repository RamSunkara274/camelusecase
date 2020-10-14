package com.camelpractice.serviceimpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.camel.language.Bean;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.camelpractice.dto.BookingDto;
import com.camelpractice.dto.BookingHistory;
import com.camelpractice.dto.ResponseDto;
import com.camelpractice.entity.Product;
import com.camelpractice.entity.Tickets;
import com.camelpractice.entity.TicketsHistory;
import com.camelpractice.repository.ProductRepo;
import com.camelpractice.repository.TicketHistoryRepository;
import com.camelpractice.repository.TicketRepository;
import com.camelpractice.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepo productRepo;

	@Autowired
	TicketRepository ticketRepo;

	@Autowired
	TicketHistoryRepository ticketHistoryRepo;

	ModelMapper modelMapper = new ModelMapper();

	@Override
	public List<Product> getAllProducts() {
		return productRepo.findAll();
	}

	@Override
	public List<Tickets> getTicketsBySearch(String source, String destination, Date date) {

		return ticketRepo.findBySourceAndDestinationAndDate(source, destination, date);
	}

	@Override
	public ResponseDto mappingTicketDetailsToDB(BookingDto BookingDTo) {

		TicketsHistory history = new TicketsHistory();
		BeanUtils.copyProperties(BookingDTo, history);
		ticketHistoryRepo.save(history);
		ResponseDto response = new ResponseDto();
		response.setMessage("Congrats ! your tickets booking completed sucessfully");
		response.setStatusCode(9081);
		return response;

	}

	@Override
	public List<BookingHistory> getBookingHistory(Long userId) {

		List<TicketsHistory> userHistory = ticketHistoryRepo.findByUserId(userId);
		List<BookingHistory> listOfHistory = new ArrayList<BookingHistory>();
		for (TicketsHistory ticketHistory : userHistory) {
			BookingHistory history = modelMapper.map(ticketHistory, BookingHistory.class);
			listOfHistory.add(history);

		}

		System.out.println(listOfHistory);
		return listOfHistory;

	}

}
