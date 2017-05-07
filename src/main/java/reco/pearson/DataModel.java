package reco.pearson;

import reco.entity.Rating;

import java.util.List;
import java.util.Set;

/**
 *
 * Created by yangzifeng on 2017/5/6.
 */
public interface DataModel {

    Set<Double> getUserIDs(List<Rating> ratings);

    double[] getItemIDsFromUser(double userId, List<Rating> ratings);

    double[] getMoviesByUser(double userId, List<Rating> ratings);
}
