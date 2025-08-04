package low_level_design.bookmyshow.main;

import low_level_design.bookmyshow.services.BookingService;

public class BookMyShow {
    public static void main(String[] args) {
        BookingService bookService = BookingService.getInstance(); //Use a Singleton Pattern
        bookService.initialize();
        bookService.startBookingSession();
    }
}
