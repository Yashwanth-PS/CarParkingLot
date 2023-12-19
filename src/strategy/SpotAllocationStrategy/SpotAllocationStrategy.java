package strategy.SpotAllocationStrategy;

import models.Gate;
import models.ParkingSpot;
import models.constants.VehicleType;

public interface SpotAllocationStrategy {
    ParkingSpot getSpot(VehicleType vehicleType, Gate gate);
}