package com.camelpractice.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.camelpractice.dto.BookingDto;
import com.camelpractice.dto.BookingHistory;
import com.camelpractice.dto.ResponseDto;
import com.camelpractice.entity.Product;
import com.camelpractice.entity.Tickets;

@Service
public interface ProductService {

	public List<Product> getAllProducts();

	public List<Tickets> getTicketsBySearch(String source, String destination, Date date);

	public ResponseDto mappingTicketDetailsToDB(BookingDto BookingDTo);

	public List<BookingHistory> getBookingHistory(Long userId);

}
