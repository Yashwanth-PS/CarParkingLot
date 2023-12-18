package service;

import models.Gate;
import models.ParkingFloor;
import models.ParkingLot;
import models.ParkingSpot;
import models.constants.GateType;
import models.constants.Status;
import models.constants.VehicleType;
import repository.GateRepository;
import repository.ParkingFloorRepository;
import repository.ParkingLotRepository;
import repository.ParkingSpotRepository;

import java.util.ArrayList;
import java.util.List;

public class InitialisationService {
    private GateRepository gateRepository;
    private ParkingSpotRepository parkingSpotRepository;
    private ParkingFloorRepository parkingFloorRepository;
    private ParkingLotRepository parkingLotRepository;

    public InitialisationService(GateRepository gateRepository, ParkingSpotRepository parkingSpotRepository, ParkingFloorRepository parkingFloorRepository, ParkingLotRepository parkingLotRepository) {
        this.gateRepository = gateRepository;
        this.parkingSpotRepository = parkingSpotRepository;
        this.parkingFloorRepository = parkingFloorRepository;
        this.parkingLotRepository = parkingLotRepository;
    }

    // This will create a parking lot with 10 Floors
    // And each floor having 10 Spots and returns Parking Lot Object
    public ParkingLot initialise(){
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setId(1);
        parkingLot.setStatus(Status.ACTIVE);
        parkingLot.setAddress("Road A, City C, State S");
        parkingLot.setCapacity(100);

        Gate entryGate = new Gate();
        entryGate.setId(1);
        entryGate.setOperator("Yash");
        entryGate.setGateNumber(1);
        entryGate.setGateType(GateType.ENTRY);
        entryGate.setFloorNumber(1);
        entryGate.setStatus(Status.ACTIVE);
        entryGate.setParkingLotId(1);

        Gate exitGate = new Gate();
        exitGate.setId(2);
        exitGate.setOperator("Nik");
        exitGate.setGateNumber(2);
        exitGate.setGateType(GateType.EXIT);
        exitGate.setFloorNumber(1);
        exitGate.setStatus(Status.ACTIVE);
        exitGate.setParkingLotId(1);

        parkingLot.setGates(List.of(exitGate, entryGate));
        gateRepository.put(entryGate);
        gateRepository.put(exitGate);

        List<ParkingFloor> parkingFloors = new ArrayList<>();
        for(int i = 1; i <= 10; i++){   // Creates Parking Floor
            ParkingFloor parkingFloor = new ParkingFloor();
            parkingFloor.setId(100 + i);
            parkingFloor.setStatus(Status.ACTIVE);
            parkingFloor.setFloorNumber(i);
            List<ParkingSpot> parkingSpots = new ArrayList<>();
            for(int j = 1; j <= 10; j++) {  // For each floor - Creates Parking Spot
                ParkingSpot parkingSpot = new ParkingSpot();
                parkingSpot.setId(1000 + j);
                parkingSpot.setNumber(i * 100 + j);
                if(j % 2 == 0){
                    parkingSpot.setSupportedVehicleType(VehicleType.Two_Wheeler);
                } else{
                    parkingSpot.setSupportedVehicleType(VehicleType.Four_Wheeler);
                }
                parkingSpot.setStatus(Status.AVAILABLE);
                parkingSpots.add(parkingSpot);
                parkingSpotRepository.put(parkingSpot);
            }
            parkingFloor.setParkingSpots(parkingSpots);
            parkingFloorRepository.put(parkingFloor);
            parkingFloors.add(parkingFloor);
        }
        parkingLot.setParkingFloors(parkingFloors);
        parkingLotRepository.put(parkingLot);
        return parkingLot;
    }
}
