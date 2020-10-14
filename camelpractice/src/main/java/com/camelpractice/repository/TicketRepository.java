package com.camelpractice.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.camelpractice.entity.Tickets;

@Repository
public interface TicketRepository extends JpaRepository<Tickets, Long> {

	public List<Tickets> findBySourceAndDestinationAndDate(String source, String destination, Date date);

}
