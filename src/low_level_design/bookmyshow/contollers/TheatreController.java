package low_level_design.bookmyshow.contollers;

import low_level_design.bookmyshow.enums.City;
import low_level_design.bookmyshow.models.movies.Movie;
import low_level_design.bookmyshow.models.theatre.Show;
import low_level_design.bookmyshow.models.theatre.Theatre;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TheatreController {
    Map<City, List<Theatre>> cityVsTheatre;
    List<Theatre> allTheatres;

    public TheatreController() {
        cityVsTheatre = new HashMap<>();
        allTheatres = new ArrayList<>();
    }

    public void addTheatre(Theatre theatre, City city) {
        allTheatres.add(theatre);
        List<Theatre> theatres = cityVsTheatre.getOrDefault(city, new ArrayList<>());
        theatres.add(theatre);
        cityVsTheatre.put(city, theatres);
    }

    public Map<Theatre, List<Show>> getAllShow(Movie movie, City city) {
        Map<Theatre, List<Show>> theatreVsShows = new HashMap<>();
        List<Theatre> theatres = cityVsTheatre.get(city);

        //filter theatre which run this movie
        for (Theatre theatre : theatres) {
            List<Show> givenMovieShows = new ArrayList<>();
            List<Show> shows = theatre.getShows();
            for (Show show : shows) {
                if (show.getMovie().getMovieId() == movie.getMovieId()) {
                    givenMovieShows.add(show);
                }
            }
            if (!givenMovieShows.isEmpty()) {
                theatreVsShows.put(theatre, givenMovieShows);
            }
        }
        return theatreVsShows;

    }


}
