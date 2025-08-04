package low_level_design.bookmyshow.utility;

import low_level_design.bookmyshow.contollers.MovieController;
import low_level_design.bookmyshow.contollers.TheatreController;
import low_level_design.bookmyshow.enums.City;
import low_level_design.bookmyshow.models.movies.Movie;
import low_level_design.bookmyshow.models.movies.MovieFactory;
import low_level_design.bookmyshow.models.theatre.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BookingDataFactory {

    public static List<Screen> createScreens() {
        List<Screen> screens = new ArrayList<>();
        Screen screen1 = new Screen();
        screen1.setScreenId(1);
        screen1.setSeats(createSeats());
        screens.add(screen1);
        return screens;
    }

    public static Show createShow(int showId, Movie movie, int showStartTime) {
        Show show = new Show();
        show.setShowId(showId);
        show.setMovie(movie);
        show.setShowStartTime(showStartTime);
        return show;
    }

    public static List<Seat> createSeats() {
        List<Seat> seats = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            Seat seat = new Seat();
            seat.setSeatId(i);
            seats.add(seat);
        }
        return seats;
    }

    public static List<Movie> createMovies(MovieController movieController) {
        Movie barbie = MovieFactory.createMovie(1, "BARBIE", 128);
        Movie oppenheimer = MovieFactory.createMovie(2, "OPPENHEIMER", 180);

        movieController.addMovies(barbie, City.Bangalore);
        movieController.addMovies(barbie, City.Delhi);
        movieController.addMovies(oppenheimer, City.Bangalore);
        movieController.addMovies(oppenheimer, City.Delhi);

        return Arrays.asList(barbie, oppenheimer);
    }

    public static void createTheatres(MovieController movieController, TheatreController theatreController) {
        Movie barbie = movieController.getMovieByName("BARBIE");
        Movie oppenheimer = movieController.getMovieByName("OPPENHEIMER");

        Theatre inox = TheatreFactory.createTheatre(
                1, "INOX", City.Bangalore,
                Arrays.asList(
                        createShow(1, barbie, 10),
                        createShow(2, oppenheimer, 18)
                )
        );

        Theatre pvr = TheatreFactory.createTheatre(
                2, "PVR", City.Delhi,
                Arrays.asList(
                        createShow(3, barbie, 14),
                        createShow(4, oppenheimer, 20)
                )
        );

        theatreController.addTheatre(inox, City.Bangalore);
        theatreController.addTheatre(pvr, City.Delhi);
    }

}