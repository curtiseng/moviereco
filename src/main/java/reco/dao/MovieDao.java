package reco.dao;

import org.springframework.stereotype.Repository;
import reco.entity.Movie;

import java.util.List;
import java.util.Map;

/**
 *
 * Created by yangzifeng on 2017/5/4.
 */
@Repository
public interface MovieDao {

    List<Movie> getMovies(Map<String,Integer> map);

    int selectMovieCount();

    Movie getMovieById(double movieId);
}
