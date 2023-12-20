package strategy.FeeCalculationStrategy;

import models.Ticket;

public interface FeeCalculationStrategy {
    long getFeeAmount(Ticket ticket);
}
