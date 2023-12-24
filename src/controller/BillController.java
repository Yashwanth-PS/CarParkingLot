package controller;

import dto.BillResponseDTO;
import dto.IssueTicketResponseDTO;
import exception.InvalidRequestDataException;
import models.Bill;
import models.constants.ResponseStatus;
import service.BillService;

public class BillController {
    private BillService billService;

    public BillController(BillService billService) {
        this.billService = billService;
    }

    public BillResponseDTO getBill(IssueTicketResponseDTO issueTicketResponseDTO) {
        BillResponseDTO billResponseDTO = new BillResponseDTO();
        Bill bill;
        try {
            if (issueTicketResponseDTO.getTicket().getVehicle() == null ||
                    issueTicketResponseDTO.getTicket().getVehicle().getVehicleType() == null ||
                    issueTicketResponseDTO.getTicket().getVehicle().getNumber() == null) {
                throw new InvalidRequestDataException("Bill generation data is Invalid");
            }
            bill = billService.getBill(issueTicketResponseDTO.getTicket());
            billResponseDTO.setAmount(bill.getAmount());
            billResponseDTO.setResponseStatus(ResponseStatus.SUCCESS);
        } catch (Exception e) {
            billResponseDTO.setResponseStatus(ResponseStatus.FAILURE);
            billResponseDTO.setFailureReason(e.getMessage());
        }
        return billResponseDTO;
    }
}
