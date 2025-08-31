package low_level_design.uberLLd;

import java.util.ArrayList;
import java.util.List;

class Location{
    double latitude;
    double longitude;

    public Location(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }
}

class RideType{
    String type;
    double basePriceperKm;

    public RideType(String type, double price){
        this.type = type;
        this.basePriceperKm = price;
    }
}

enum RideState{
    REQUESTED,
    ACCEPTED,
    STARTED,
    COMPLETED,
    CANCELED
}

enum DriverState{
    AVAILABLE,
    IN_RIDE,
    OFFLINE
}

class Vehicle{
    String number;
    String colour;
    int year;
    RideState state;

    public Vehicle(String number, String colour, int year){
        this.number = number;
        this.colour = colour;
        this.year = year;
        this.state = RideState.CANCELED;
    }
}

class Driver{
    String name;
    String mobile;
    Vehicle vehicle;
    DriverState state;

    public Driver(String name, String mobile, Vehicle vehicle){
        this.name = name;
        this.mobile = mobile;
        this.vehicle = vehicle;
        this.state = DriverState.AVAILABLE;
    }

    public void assignRide(){
        state = DriverState.IN_RIDE;
        vehicle.state = RideState.ACCEPTED;
    }

    public void startRide(){
        vehicle.state = RideState.STARTED;
    }

    public void completeRide(){
        state = DriverState.AVAILABLE;
        vehicle.state = RideState.COMPLETED;
    }

    public void goOffline() {
        state = DriverState.OFFLINE;
    }

    public void goOnline() {
        state = DriverState.AVAILABLE;
    }
}

interface PricingStrategy {
    double calculate(int distance, RideType type);
}

class NormalPricing implements PricingStrategy {
    @Override
    public double calculate(int distance, RideType type) {
        return distance * type.basePriceperKm;
    }
}

// SurgePricing class
class SurgePricing implements PricingStrategy {
    @Override
    public double calculate(int distance, RideType type) {
        return distance * type.basePriceperKm * 2;
    }
}

class Ride{
    int id;
    Location pickup;
    Location destination;
    RideState state;
    RideType type;
    Driver driver;

    public Ride(int id, Location pickup, Location destination, RideType type) {
        this.id = id;
        this.pickup = pickup;
        this.destination = destination;
        this.type = type;
        this.state = RideState.REQUESTED;
        this.driver = null;
    }

    public void assignDriver(Driver driver) {
        this.driver = driver;
        driver.assignRide();
        state = RideState.ACCEPTED;
    }

    public void startRide() {
        driver.startRide();
        state = RideState.STARTED;
    }

    public void completeRide() {
        driver.completeRide();
        state = RideState.COMPLETED;
    }
}

class RidesManager{
    List<Ride> rides = new ArrayList<>();
    List<Driver> drivers = new ArrayList<>();
    PricingStrategy ps;

    public RidesManager(PricingStrategy ps){
        this.ps = ps;
    }

    public Ride createRide(Location pickup, Location destination, RideType type){
        Ride ride = new Ride(rides.size()+1, pickup, destination, type);
        rides.add(ride);
        return ride;
    }

    public void requestRide(Ride ride){
        for(Driver driver : drivers){
            if(driver.state == DriverState.AVAILABLE){
                ride.assignDriver(driver);
                System.out.println("Driver " + driver.name + " assigned to ride " + ride.id);
                return;
            }
        }
        System.out.println("No drivers available for ride : " + ride.id);
    }

    public void startRide(Ride ride){
        if(ride.driver != null && ride.state == RideState.ACCEPTED){
            ride.startRide();
            System.out.println("Ride " + ride.id + " started.");
        } else {
            System.out.println("Cannot start ride " + ride.id);
        }
    }

    public void completeRide(Ride ride){
        if(ride.driver != null && ride.state == RideState.STARTED){
            ride.completeRide();
            System.out.println("Ride " + ride.id + " completed.");
            double fare = ps.calculate(10, ride.type); // Assume 10km
            System.out.println("Fare: ₹" + fare);
        } else {
            System.out.println("Cannot complete ride " + ride.id);
        }
    }
}
public class UberCabSystem {
    public static void main(String[] args) {
        // Create pricing strategy
        PricingStrategy ps = new NormalPricing();

        // Create rides manager
        RidesManager manager = new RidesManager(ps);

        // Create some drivers
        Vehicle car1 = new Vehicle("ABC123", "Red", 2020);
        Driver driver1 = new Driver("Vinay Kumar", "1234567890", car1);
        manager.drivers.add(driver1);

        Vehicle car2 = new Vehicle("XYZ789", "Blue", 2022);
        Driver driver2 = new Driver("Rahul Sharma", "0987654321", car2);
        manager.drivers.add(driver2);

        // Driver goes online
        driver1.goOnline();
        System.out.println("Driver " + driver1.name + " is now available.");

        // Create ride types
        RideType economy = new RideType("Economy", 15.0);
        RideType premium = new RideType("Premium", 20.0);

        // Create a ride
        Location pickup = new Location(37.7749, -122.4194);
        Location destination = new Location(37.7805, -122.4073);
        Ride ride = manager.createRide(pickup, destination, economy);

        // Request the ride
        manager.requestRide(ride);

        // Start the ride
        manager.startRide(ride);

        // Complete the ride
        manager.completeRide(ride);

        // Driver goes offline
        driver1.goOffline();
        System.out.println("Driver " + driver1.name + " is now offline.");
    }

}
