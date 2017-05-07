package reco.entity;


/**
 *
 * Created by yangzifeng on 2017/5/4.
 */
public class Movie {

    private String id;
    private double averageRating;
    private String genres;
    private String title;
    private String small;
    private String medium;
    private String large;
    private String year;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getAverage_rating() {
        return averageRating;
    }

    public void setAverage_rating(double average_rating) {
        this.averageRating = average_rating;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSamll() {
        return small;
    }

    public void setSamll(String samll) {
        this.small = samll;
    }

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }

    public String getLarge() {
        return large;
    }

    public void setLarge(String large) {
        this.large = large;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id='" + id + '\'' +
                ", averageRating=" + averageRating +
                ", genres='" + genres + '\'' +
                ", title='" + title + '\'' +
                ", small='" + small + '\'' +
                ", medium='" + medium + '\'' +
                ", large='" + large + '\'' +
                ", year='" + year + '\'' +
                '}';
    }
}
