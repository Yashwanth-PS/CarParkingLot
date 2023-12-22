package service;

import models.*;
import repository.BillRepository;
import repository.TicketRepository;

public class BillService {
    private BillRepository billRepository;
    private TicketRepository ticketRepository;

    public BillService(BillRepository billRepository, TicketRepository ticketRepository) {
        this.billRepository = billRepository;
        this.ticketRepository = ticketRepository;
    }
    public Bill getBill(){
        Bill bill = new Bill();
        return bill;
    }
}
