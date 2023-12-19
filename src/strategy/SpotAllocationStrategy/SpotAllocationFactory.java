package strategy.SpotAllocationStrategy;

import repository.ParkingLotRepository;

public class SpotAllocationFactory {
    public static SpotAllocationStrategy getspotAllocationStrategy(ParkingLotRepository parkingLotRepository){
        return new RandomSpotAllocationStrategy(parkingLotRepository);
    }
}
