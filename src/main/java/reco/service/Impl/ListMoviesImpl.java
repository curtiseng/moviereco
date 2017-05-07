package reco.service.Impl;

import org.springframework.stereotype.Service;
import reco.dao.MovieDao;
import reco.entity.Movie;
import reco.service.ListMovies;
import reco.util.Pagination;
import reco.util.ResultForJson;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 *
 * Created by yangzifeng on 2017/5/5.
 */
@Service
public class ListMoviesImpl implements ListMovies {
    @Resource(name = "movieDao")
    private MovieDao movieDao;
    @Resource(name = "pagination")
    private Pagination pagination;

    @Override
    public ResultForJson findAllMovie(int pageNo) {

        int totalSize = movieDao.selectMovieCount();

        Map<String, Integer> map = pagination.pageResult(totalSize, pageNo);

        List<Movie> movies = movieDao.getMovies(map);


        return new ResultForJson.Builder<List<Movie>>().data(movies).msg("success").resultStatus(0).build();
    }
}
