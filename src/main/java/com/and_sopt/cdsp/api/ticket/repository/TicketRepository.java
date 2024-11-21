package com.and_sopt.cdsp.api.ticket.repository;

import com.and_sopt.cdsp.api.ticket.domain.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket,Long> {
}
