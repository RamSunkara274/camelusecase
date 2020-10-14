package com.camelpractice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.camelpractice.entity.TicketsHistory;

@Repository
public interface TicketHistoryRepository extends JpaRepository<TicketsHistory, Long> {

	List<TicketsHistory> findByUserId(Long userId);

}
