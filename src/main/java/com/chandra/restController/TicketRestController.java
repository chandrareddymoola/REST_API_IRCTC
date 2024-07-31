package com.chandra.restController;

import com.chandra.entity.Ticket;
import com.chandra.request.Passanger;
import com.chandra.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TicketRestController {
    @Autowired
    private TicketService ticketService;
@PostMapping(value = "/ticket",
        consumes = "application/json",
         produces="application/json")

    public ResponseEntity<Ticket> BookTicket(@RequestBody Passanger passanger){
      Ticket ticket=  ticketService.bookTicket(passanger);

      return new ResponseEntity<>(ticket, HttpStatus.CREATED);
    }
@GetMapping(value = "/ticket/{ticketNum}",produces = "application/json")
    public ResponseEntity<Ticket> getTicket(@PathVariable ("ticketNum") Integer ticketNum){
    Ticket ticket=ticketService.getTicket(ticketNum);

    return new ResponseEntity<>(ticket,HttpStatus.OK);
    }

}
