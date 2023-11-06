package Controllers;

import Models.Movie;
import RequestDTOs.AddMovieRequest;
import Services.MovieService;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/movie")
public class MovieController {
    @Autowired
    MovieService movieService;

    @PostMapping("/addmovie")
    public ResponseEntity addMovie(@RequestBody AddMovieRequest addMovieRequest){
        try{
        String result=movieService.addMovie(addMovieRequest);
        return new ResponseEntity<>(result, HttpStatus.OK);
        }

        catch(Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
}
