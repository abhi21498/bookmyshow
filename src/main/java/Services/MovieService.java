package Services;

import Models.Movie;
import Repositories.MovieRepository;
import RequestDTOs.AddMovieRequest;
import Transformers.MovieTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;
    public String addMovie(AddMovieRequest addMovieRequest) throws Exception {


            Movie movie = MovieTransformer.convertAddMovieReqToMovie(addMovieRequest);

            movieRepository.save(movie);

            return "Movie has been added to the DB successfully";


    }
}
