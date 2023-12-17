package dto;

import models.Ticket;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class IssueTicketResponseDTO {
    private ResponseStatus responseStatus;
    private String failureReason;
    private Ticket ticket;

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

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    @Override
    public String toString() {
        Map<String, String> ticketData = new HashMap<>();
        ticketData.put("Response", responseStatus.toString());
        if(responseStatus.equals(ResponseStatus.FAILURE))
            ticketData.put("Failure Message", failureReason);
        ticketData.put("Ticket ID", String.valueOf(ticket.getId()));
        //ticketData.put("Entry Time", ticket.getEntryTime().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME).toString());
        ticketData.put("Vehicle Number", ticket.getVehicle().getNumber());
        ticketData.put("Vehicle Make", ticket.getVehicle().getMake());
        ticketData.put("Parking Lot", String.valueOf(ticket.getParkingSpot().getNumber()));

        LocalDateTime entryDateTime = ticket.getEntryTime();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm:ss");
        ticketData.put("Entry Time", entryDateTime.format(dateTimeFormatter));

        return ticketData.toString();
    }
}
