package low_level_design.parkingLot;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingManager {
    private final Map<VehicleSize, List<ParkingSpot>> availableSpots;
    private final Map<Vehicle, ParkingSpot> vehicleToSpotMap;
    private final Map<ParkingSpot, Vehicle> spotToVehicleMap;

    public ParkingManager(Map<VehicleSize, List<ParkingSpot>> availableSpots) {
        this.availableSpots = availableSpots;
        this.vehicleToSpotMap = new HashMap<>();
        this.spotToVehicleMap = new HashMap<>();
    }

    public ParkingSpot findSpotForVehicle(Vehicle vehicle){
        VehicleSize vehicleSize = vehicle.getSize();
        for(VehicleSize size : VehicleSize.values()){
            if(size.ordinal() >= vehicleSize.ordinal()){
                List<ParkingSpot> spots = availableSpots.get(size);
                for(ParkingSpot spot : spots){
                    if(spot.isAvailable()){
                        return spot;
                    }
                }
            }
        }
        return null;
    }

    public ParkingSpot parkVehicle(Vehicle vehicle){
        ParkingSpot spot = findSpotForVehicle(vehicle);
        if(spot != null){
            spot.occupy(vehicle);
            vehicleToSpotMap.put(vehicle, spot);
            spotToVehicleMap.put(spot, vehicle);
            availableSpots.get(spot.getSize()).remove(spot);
            return spot;
        }
        return null;
    }
    public void unparkVehicle(Vehicle vehicle){
        ParkingSpot spot = vehicleToSpotMap.remove(vehicle);
        if(spot != null){
            spotToVehicleMap.remove(spot);
            spot.vacate();
            availableSpots.get(spot.getSize()).add(spot);
        }
    }

    public ParkingSpot findVehicleBySpot(Vehicle vehicle){
        return vehicleToSpotMap.get(vehicle);
    }

    public ParkingSpot findSpotByVehicle(ParkingSpot parkingSpot){
        return vehicleToSpotMap.get(parkingSpot);
    }
}
