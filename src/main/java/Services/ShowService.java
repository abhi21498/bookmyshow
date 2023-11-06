package Services;

import Enums.SeatType;
import Models.*;
import Repositories.MovieRepository;
import Repositories.ShowRepository;
import Repositories.ShowSeatRepository;
import Repositories.TheatreRepository;
import RequestDTOs.AddShowRequest;
import RequestDTOs.AddShowSeatRequest;
import Transformers.ShowTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ShowService {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private TheatreRepository theaterRepository;

    @Autowired
    private ShowRepository showRepository;

    @Autowired
    private ShowSeatRepository showSeatRespository;
    public String addShow(AddShowRequest addShowRequest) {

        Show show = ShowTransformer.convertAddRequestToEntity(addShowRequest);
        Movie movie = movieRepository.findMovieByMovieName(addShowRequest.getMovieName());

        Optional<Theatre> optionalTheater = theaterRepository.findById(addShowRequest.getTheaterId());
        Theatre theater = optionalTheater.get();

        //Setting the FK values
        show.setMovie(movie);
        show.setTheatre(theater);

        //Setting the bidirectional mapping
        theater.getShowList().add(show);
        movie.getShowList().add(show);

        show = showRepository.save(show);

        return "Show has been saved to the DB with showId "+show.getShowId();

    }

    public String addShowSeats(AddShowSeatRequest addShowSeatRequest) {
        Show show = showRepository.findById(addShowSeatRequest.getShowId()).get();
        Theatre theater = show.getTheatre();
        List<TheatreSeat> theaterSeatList = theater.getTheatreSeatList();

        List<ShowSeat> showSeatList = new ArrayList<>();


        for(TheatreSeat theaterSeat:theaterSeatList) {

            ShowSeat showSeat = ShowSeat.builder()
                    .seatNo(theaterSeat.getSeatNo())
                    .seatType(theaterSeat.getSeatType())
                    .isAvailable(true)
                    .isFoodAttached(false)
                    .show(show)
                    .build();

            if(theaterSeat.getSeatType().equals(SeatType.Classic)){
                showSeat.setCost(addShowSeatRequest.getPriceOfClassicSeats());
            }
            else{
                showSeat.setCost(addShowSeatRequest.getPriceOfPremiumSeats());
            }

            showSeatList.add(showSeat);
        }

        show.setShowSeatList(showSeatList);


        showRepository.save(show);
        return "The show seats have been added";

    }
}
