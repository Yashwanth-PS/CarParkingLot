package models;

import java.time.LocalDateTime;

public class Bill extends BaseModel{
    private LocalDateTime exitTime;
    private long amount;
    private Ticket ticket;
    private Gate gate;

    public LocalDateTime getExitTime() {
        return exitTime;
    }

    public void setExitTime(LocalDateTime exitTime) {
        this.exitTime = exitTime;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public Gate getGate() {
        return gate;
    }

    public void setGate(Gate gate) {
        this.gate = gate;
    }

    public void setAmount(long feeAmount) {
    }

    @Override
    public String toString() {
        return "Bill{" +
                "exitTime=" + exitTime +
                ", amount=" + amount +
                ", ticket=" + ticket +
                ", gate=" + gate +
                '}';
    }
}
