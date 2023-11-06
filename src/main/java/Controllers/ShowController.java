package Controllers;

import Models.Show;
import Models.ShowSeat;
import RequestDTOs.AddShowRequest;
import RequestDTOs.AddShowSeatRequest;
import Services.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/show")
public class ShowController {

    @Autowired
    ShowService showService;

    @PostMapping("/addShow")
    public ResponseEntity addShow(@RequestBody AddShowRequest addShowRequest){
       String ans= showService.addShow(addShowRequest);
       return new ResponseEntity<>(ans, HttpStatus.OK);
    }

    @PostMapping("/addShowSeats")
    public String addShowSeat(@RequestBody AddShowSeatRequest addShowSeatRequest){
        String ans=showService.addShowSeats(addShowSeatRequest);
        return ans;
    }

}
