package service;

import models.Bill;
import models.Ticket;
import strategy.FeeCalculationStrategy.FeeCalculationStrategy;
import strategy.FeeCalculationStrategy.FeeCalculationStrategyFactory;

public class BillService {
    public Bill getBill(Ticket ticket) {
        FeeCalculationStrategy feeCalculationStrategy = FeeCalculationStrategyFactory.getFeeCalculationStrategy();
        Bill bill = new Bill();
        long Amount = feeCalculationStrategy.getFeeAmount(ticket);
        bill.setAmount(Amount);
        return bill;
    }
}
