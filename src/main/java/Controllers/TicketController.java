package Controllers;

import RequestDTOs.BookTicketRequest;
import Services.TicketService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("ticket")
public class TicketController {

    @Autowired
    TicketService ticketService;

    @PostMapping("/bookTicket")
    public String bookTicket(@RequestBody BookTicketRequest bookTicketRequest){
        String ans=ticketService.bookTicket(bookTicketRequest);
        return ans;
    }
}
