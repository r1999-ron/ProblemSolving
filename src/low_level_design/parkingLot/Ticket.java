package low_level_design.parkingLot;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Objects;

public class Ticket {
    private final String ticketId;
    private final Vehicle vehicle;

    private final ParkingSpot parkingSpot;
    private final LocalDateTime entryTime;

    private LocalDateTime exitTime;

    public Ticket(String ticketId, Vehicle vehicle, ParkingSpot parkingSpot, LocalDateTime entryTime) {
        this.ticketId = ticketId;
        this.vehicle = vehicle;
        this.parkingSpot = parkingSpot;
        this.entryTime = entryTime;
        this.exitTime = null;
    }

    public BigDecimal calculateParkingDuration(){
        return new BigDecimal(Duration.between(entryTime, Objects.requireNonNullElseGet(exitTime, LocalDateTime::now)).toMinutes());
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public LocalDateTime getExitTime() {
        return exitTime;
    }

    // ✅ Setter for exitTime
    public void setExitTime(LocalDateTime exitTime) {
        this.exitTime = exitTime;
    }
}
