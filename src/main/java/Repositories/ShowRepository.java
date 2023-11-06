package Repositories;

import Models.Movie;
import Models.Show;
import Models.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
@Repository
public interface ShowRepository extends JpaRepository<Show,Integer> {
    Show findShowByShowDateAndShowTimeAndMovieAndTheatre(LocalDate showDate, LocalTime showTime, Movie movie, Theatre theater);
}
