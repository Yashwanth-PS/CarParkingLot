package dto;

import models.Ticket;
import models.constants.ResponseStatus;

public class BillResponseDTO {
    private long Amount;
    private ResponseStatus responseStatus;
    private String failureReason;

    public ResponseStatus getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(ResponseStatus responseStatus) {
        this.responseStatus = responseStatus;
    }

    public String getFailureReason() {
        return failureReason;
    }

    public void setFailureReason(String failureReason) {
        this.failureReason = failureReason;
    }

    public long getAmount() {
        return Amount;
    }

    public void setAmount(long amount) {
        Amount = amount;
    }

    @Override
    public String toString() {
        return "BillResponseDTO{" +
                "Amount=" + Amount +
                ", responseStatus=" + responseStatus +
                ", failureReason='" + failureReason + '\'' +
                '}';
    }
}
