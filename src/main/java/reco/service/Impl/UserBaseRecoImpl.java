package reco.service.Impl;

import org.apache.commons.math3.exception.DimensionMismatchException;
import org.springframework.core.env.SystemEnvironmentPropertySource;
import org.springframework.stereotype.Service;
import reco.dao.MovieDao;
import reco.dao.RecoDao;
import reco.entity.Movie;
import reco.entity.Rating;
import reco.pearson.DataModel;
import reco.pearson.Pearson;
import reco.service.ListMovies;
import reco.service.UserBaseReco;
import reco.util.ResultForJson;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 *
 * Created by yangzifeng on 2017/5/6.
 */
@Service
public class UserBaseRecoImpl implements UserBaseReco{
    @Resource(name = "movieDao")
    private MovieDao movieDao;
    @Resource(name = "recoDao")
    private RecoDao recoDao;
    @Resource(name = "dataModelImpl")
    private DataModel dataModel;
    @Resource(name = "listMoviesImpl")
    private ListMovies listMovies;


    @Override
    public ResultForJson reco(String userId) {
        double x = 0;
        double temp = 0;
        double semblableId = 0;
        List<Movie> recoMovie = new ArrayList<>();

        List<Rating> ratings = recoDao.findRating();
        for (Rating rating:ratings){
            System.out.println(rating.toString());
        }

        Set<Double> userIds = dataModel.getUserIDs(ratings);
        userIds.forEach(System.out::println);


        double[] ownRating = dataModel.getItemIDsFromUser(Double.parseDouble(userId),ratings);
        System.out.println(Arrays.toString(ownRating));

        for(double id : userIds){
            if (id != Double.parseDouble(userId)){
                System.out.println(id);
                double[] otherRating = dataModel.getItemIDsFromUser(id,ratings);
                System.out.println(Arrays.toString(otherRating));
                try {
                    temp = Pearson.excute(ownRating,otherRating);
                }catch (DimensionMismatchException e){
                    System.out.print("数组维数不同" + e);
                }
                System.out.println(temp);
                if (x < temp) {
                    x = temp;
                    semblableId = id;

                }
            }
        }

        System.out.println(x + " semblableId:" + semblableId);

        if (x == 0){
            return listMovies.findAllMovie((int) semblableId);
        }else {
            for (double semblableMovie : dataModel.getMoviesByUser(Double.parseDouble(userId),ratings)) {
                for (double movie : dataModel.getMoviesByUser(semblableId,ratings)) {
                    if (semblableMovie != movie) {
                        recoMovie.add(movieDao.getMovieById(semblableMovie));
                    }
                }
            }
        }


        return new ResultForJson.Builder<List<Movie>>().data(recoMovie).msg("success").resultStatus(0).build();

    }
}
