package Services;

import Models.*;
import Repositories.*;
import RequestDTOs.BookTicketRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {

    @Autowired
    private ShowRepository showRepository;

    @Autowired
    private TheatreRepository theaterRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TicketRepository ticketRepository;
    public String bookTicket(BookTicketRequest bookTicketRequest) {
        Show show = findRightShow(bookTicketRequest);
        //My steps are :
        List<ShowSeat> showSeatList = show.getShowSeatList();
        //Whatever are the requested seats : mark them as not available in show seats

        int totalPrice = 0;
        for(ShowSeat showSeat:showSeatList) {

            if(bookTicketRequest.getRequestedSeatNos().contains(showSeat.getSeatNo())) {
                showSeat.setAvailable(false);
                totalPrice = totalPrice + showSeat.getCost();
            }
        }

        User user = userRepository.findById(bookTicketRequest.getUserId()).get();

        Ticket ticket = Ticket.builder()
                .movieName(show.getMovie().getMovieName())
                .address(show.getTheatre().getAddress())
                .localDate(show.getShowDate())
                .localTime(show.getShowTime())
                .bookedSeats(bookTicketRequest.getRequestedSeatNos().toString())
                .user(user)
                .show(show)
                .totalPrice(totalPrice)
                .build();

        show.getTicketList().add(ticket);
        user.getTicketList().add(ticket);


        ticketRepository.save(ticket);


        return "Ticket has been booked";

    }
    private Show findRightShow(BookTicketRequest bookTicketRequest){

        Movie movie = movieRepository.findMovieByMovieName(bookTicketRequest.getMovieName());
        Theatre theater = theaterRepository.findById(bookTicketRequest.getTheaterId()).get();

        Show show = showRepository.findShowByShowDateAndShowTimeAndMovieAndTheatre(bookTicketRequest.getShowDate()
                ,bookTicketRequest.getShowTime(),
                movie,theater);


        return show;
    }
}
