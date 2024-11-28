package com.and_sopt.cdsp.api.ticket.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@Entity
@Table(name="ticket")
@AllArgsConstructor
@NoArgsConstructor
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="ticket_count")
    private int ticketCount;

    public Long getId() {
        return id;
    }

    public int getTicketCount() {
        return ticketCount;
    }
}
