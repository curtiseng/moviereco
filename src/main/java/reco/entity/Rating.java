package reco.entity;

import java.util.Map;

/**
 *
 * Created by yangzifeng on 2017/5/6.
 */
public class Rating {
    private double userId;
    private double movieId;
    private double movieRating;
    private static Map<Double, Double> movieAndRating;

    public double getUserId() {
        return userId;
    }

    public void setUserId(double userId) {
        this.userId = userId;
    }

    public double getMovieId() {
        return movieId;
    }

    public void setMovieId(double movieId) {
        this.movieId = movieId;
    }

    public double getMovieRating() {
        return movieRating;
    }

    public void setMovieRating(double movieRating) {
        this.movieRating = movieRating;
    }

    public Map<Double,Double> getMovieAndRating(){
        movieAndRating.put(movieId,movieRating);
        return movieAndRating;
    }

    @Override
    public String toString() {
        return "Rating{" +
                "userId=" + userId +
                ", movieId=" + movieId +
                ", movieRating=" + movieRating +
                '}';
    }
}
