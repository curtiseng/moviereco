package reco.pearson;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.stereotype.Component;
import reco.entity.Rating;

import java.util.*;
import java.util.stream.Collectors;

/**
 *
 * Created by yangzifeng on 2017/5/6.
 */
@Component
    public class DataModelImpl implements DataModel {


    @Override
    public Set<Double> getUserIDs(List<Rating> ratings) {

        return ratings.stream().map(Rating::getUserId).collect(Collectors.toSet());
    }

    @Override
    public double[] getMoviesByUser(double userId, List<Rating> ratings) {
        Set<Double> movies = ratings.stream().filter(rating -> userId == rating.getUserId()).map(Rating::getMovieId).collect(Collectors.toSet());

        Double[] userMovies = movies.toArray(new Double[movies.size()]);

        return ArrayUtils.toPrimitive(userMovies);
    }

    @Override
    public double[] getItemIDsFromUser(double userId, List<Rating> ratings) {

        Map<Double,Double> movieAndRatings = new TreeMap<>();
        ratings.stream().filter(rating -> rating.getUserId() == userId).forEach(rating -> {
            movieAndRatings.put(rating.getMovieId(), rating.getMovieRating());
        });

        Map<Double, Double> resultMap = sortMapByKey(movieAndRatings);

//        System.out.println(resultMap.toString());

        List<Double> ratingsList = new ArrayList<>(resultMap.values());

//        for (double d : resultMap.keySet()){
//
//            System.out.println(d + " " + resultMap.get(d));
//            ratingsList.add(resultMap.get(d));
//        }

//        System.out.println(ratingsList.toString());

        Double[] userRatings = ratingsList.toArray(new Double[ratingsList.size()]);

//        System.out.println(userRatings);

        return ArrayUtils.toPrimitive(userRatings);
    }



    private static Map<Double, Double> sortMapByKey(Map<Double, Double> map) {
        if (map == null || map.isEmpty()) {
            return null;
        }

        Map<Double, Double> sortMap = new TreeMap<>(
                new MapKeyComparator());

        sortMap.putAll(map);

        return sortMap;
    }


}

class MapKeyComparator implements Comparator<Double> {

    @Override
    public int compare(Double o1, Double o2) {

        return o1>o2?1:-1;
    }
}
