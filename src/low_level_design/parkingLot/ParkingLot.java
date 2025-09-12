package low_level_design.parkingLot;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class ParkingLot {
    private final ParkingManager parkingManager;
    private final FareCalculator fareCalculator;

    public ParkingLot(ParkingManager parkingManager, FareCalculator fareCalculator) {
        this.parkingManager = parkingManager;
        this.fareCalculator = fareCalculator;
    }

    public Ticket enterVehicle(Vehicle vehicle){
        ParkingSpot spot = parkingManager.parkVehicle(vehicle);
        if(spot != null){
            Ticket ticket = new Ticket(generateTicketId(), vehicle, spot, LocalDateTime.now());
            return ticket;
        }else{
            System.out.println("No avaialable spots for vehicle: " + vehicle.getLicencePlate());
        }
        return null;
    }

    private String generateTicketId() {
        return "TICKET-" + System.currentTimeMillis();
    }

    public void leaveVehicle(Ticket ticket){
        if(ticket != null && ticket.getExitTime() == null){
            ticket.setExitTime(LocalDateTime.now());
            parkingManager.unparkVehicle(ticket.getVehicle());
            BigDecimal fare = fareCalculator.calculateFare(ticket);
            System.out.println("Vehicle " + ticket.getVehicle().getLicencePlate() + " has left. Total fare: $" + fare);
        }else{
            System.out.println("Invalid ticket or already vehicle already exited.");
        }
    }
}
