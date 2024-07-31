package com.chandra.service;

import com.chandra.entity.Ticket;
import com.chandra.request.Passanger;

public interface TicketService {

    public Ticket bookTicket(Passanger passanger);
    public Ticket getTicket(Integer ticketNum);
}
