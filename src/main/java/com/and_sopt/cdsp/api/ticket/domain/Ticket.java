package com.and_sopt.cdsp.api.ticket.domain;

import jakarta.persistence.*;

@Entity
@Table(name="ticket")
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
