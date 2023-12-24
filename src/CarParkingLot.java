import controller.BillController;
import controller.TicketController;
import dto.IssueTicketRequestDTO;
import dto.IssueTicketResponseDTO;
import models.ParkingLot;
import models.constants.VehicleType;
import repository.*;
import service.BillService;
import service.InitialisationService;
import service.TicketService;

public class CarParkingLot {
    private InitialisationService initialisationService;
    private static TicketController ticketController;
    private static BillController billController;

    public CarParkingLot() {
        ParkingLotRepository parkingLotRepository = new ParkingLotRepository();
        TicketRepository ticketRepository = new TicketRepository();
        GateRepository gateRepository = new GateRepository();
        ParkingFloorRepository parkingFloorRepository = new ParkingFloorRepository();
        ParkingSpotRepository parkingSpotRepository = new ParkingSpotRepository();
        this.initialisationService = new InitialisationService(gateRepository, parkingSpotRepository, parkingFloorRepository, parkingLotRepository);
        ticketController = new TicketController(new TicketService(ticketRepository, parkingLotRepository, gateRepository));
        // Initialize billController before using it
        billController = new BillController(new BillService());
    }

    public static void main(String[] args) {
        CarParkingLot carParkingLot = new CarParkingLot();
        ParkingLot parkingLot = carParkingLot.initialisationService.initialise();
        IssueTicketRequestDTO issueTicketRequestDTO = new IssueTicketRequestDTO(VehicleType.Four_Wheeler, "ABCD1234", "Black", "Hyundai", 1);
        IssueTicketResponseDTO responseDTO = CarParkingLot.ticketController.getTicket(issueTicketRequestDTO);
        System.out.println(responseDTO);
        System.out.println(CarParkingLot.billController.getBill(responseDTO));
    }
}

// TODO: Bill Generation, Given - Ticket and Exit Gate ID, Generate a Bill