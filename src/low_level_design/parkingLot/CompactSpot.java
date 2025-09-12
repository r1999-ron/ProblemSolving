package low_level_design.parkingLot;

public class CompactSpot implements ParkingSpot{
    private int spotNumber;
    private Vehicle vehicle;

    public CompactSpot(int spotNumber) {
        this.spotNumber = spotNumber;
        this.vehicle = null;
    }

    @Override
    public int getSpotNumber(){
        return spotNumber;
    }

    @Override
    public boolean isAvailable(){
        return vehicle == null;
    }

    @Override
    public void occupy(Vehicle vehicle){
        if(isAvailable()){
            this.vehicle = vehicle;
        }else{
            System.out.println("Spot is already occupied.");
        }
    }

    @Override
    public void vacate(){
        this.vehicle = null;
    }

    @Override
    public VehicleSize getSize(){
        return VehicleSize.SMALL;
    }
}
