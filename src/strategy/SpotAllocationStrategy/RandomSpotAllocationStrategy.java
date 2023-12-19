package strategy.SpotAllocationStrategy;

import exception.ParkingSpotNotFoundException;
import models.Gate;
import models.ParkingFloor;
import models.ParkingLot;
import models.ParkingSpot;
import models.constants.Status;
import models.constants.VehicleType;
import repository.ParkingLotRepository;

public class RandomSpotAllocationStrategy implements SpotAllocationStrategy{
    private ParkingLotRepository parkingLotRepository;

    public RandomSpotAllocationStrategy(ParkingLotRepository parkingLotRepository) {
        this.parkingLotRepository = parkingLotRepository;
    }

    @Override
    public ParkingSpot getSpot(VehicleType vehicleType, Gate gate) {
        ParkingLot parkingLot = parkingLotRepository.getParkingLotFromGate(gate);
        int currentFloor = gate.getFloorNumber();

        ParkingFloor parkingFloor = parkingLot.getParkingFloors().get(currentFloor - 1);
        for(ParkingSpot parkingSpot : parkingFloor.getParkingSpots()){
            if(parkingSpot.getSupportedVehicleType().equals(vehicleType) && parkingSpot.getStatus().equals(Status.AVAILABLE)){
                return parkingSpot;
            }
        }

        for(ParkingFloor floor : parkingLot.getParkingFloors()) {
            for(ParkingSpot parkingSpot : floor.getParkingSpots()) {
                if(parkingSpot.getSupportedVehicleType().equals(vehicleType) && parkingSpot.getStatus().equals(Status.AVAILABLE)) {
                    return parkingSpot;
                }
            }
        }

        throw new ParkingSpotNotFoundException("No Parking Spot Available for this vehicle type" + vehicleType.name());
    }
}