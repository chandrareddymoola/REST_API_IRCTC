package com.chandra.service;

import com.chandra.entity.Ticket;
import com.chandra.repos.TicketRepo;
import com.chandra.request.Passanger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TicketServiceImpl implements  TicketService {
    @Autowired
    private TicketRepo ticketRepo;

    @Override
    public Ticket bookTicket(Passanger passanger) {
        Ticket ticket = new Ticket();
        BeanUtils.copyProperties(passanger, ticket); //here copy the passender details in2 ticket
        ticket.setPrice(1500.00);
        ticket.setTicketStatus("Confirmed");
        ticket = ticketRepo.save(ticket);
        return ticket;
    }

    @Override
    public Ticket getTicket(Integer ticketNum) {

        Optional<Ticket> findById = ticketRepo.findById(ticketNum);
        if (findById.isPresent()) {

            return findById.get();
        }
        return null;
    }
}
