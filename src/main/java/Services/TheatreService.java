package Services;

import Enums.SeatType;
import Models.Theatre;
import Models.TheatreSeat;
import Repositories.TheatreRepository;
import RequestDTOs.AddTheatreRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TheatreService {

    @Autowired
    TheatreRepository theatreRepository;
    public String addTheatre(AddTheatreRequest addTheatreRequest) {
        Theatre theater = Theatre.builder().name(addTheatreRequest.getName())
                .address(addTheatreRequest.getAddress())
                .city(addTheatreRequest.getCity())
                .build();

        //Create the theater Seats Entity
        createTheaterSeats(theater,addTheatreRequest);

        return "Theater and its seats have been saved to DB";
    }
    public void createTheaterSeats(Theatre theater,AddTheatreRequest addTheaterRequest){


        int noOfClassicSeats = addTheaterRequest.getNoOfClassicSeats();
        int noOfPremiumSeats = addTheaterRequest.getNoOfPremiumSeats();
        int seatsPerRow = addTheaterRequest.getNoOfSeatsPerRow();

        //Create the Primary Seat Entities
        List<TheatreSeat> theaterSeatList = new ArrayList<>();

        int row = 0;
        char ch = 'A';
        for(int i=1;i<=noOfClassicSeats;i++) {

            if(i%seatsPerRow==1) {
                row++;
                ch = 'A';
            }
            String seatNo = row+""+ch;
            ch++;

            TheatreSeat theaterSeat = TheatreSeat.builder()
                    .seatNo(seatNo)
                    .seatType(SeatType.Classic)
                    .theatre(theater) //Setting the FK also
                    .build();

            theaterSeatList.add(theaterSeat);
        }


        //Similar numbering I will do for the Premium Seats :
        ch = 'A';
        for(int i=1;i<=noOfPremiumSeats;i++){

            if(i%seatsPerRow==1) {
                row++;
                ch = 'A';
            }
            String seatNo = row+""+ch;
            ch = (char)(ch+1);

            TheatreSeat theaterSeat = TheatreSeat.builder()
                    .seatNo(seatNo)
                    .seatType(SeatType.Premium)
                    .theatre(theater) //Setting the FK also
                    .build();

            theaterSeatList.add(theaterSeat);
        }

        //This is done for bidirectional mapping
        theater.setTheatreSeatList(theaterSeatList);
        theatreRepository.save(theater);
    }
}
